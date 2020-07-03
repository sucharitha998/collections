package com.jsfeb.assetmanagementsystem.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.jsfeb.assetmanagementsystem.bean.UserInfoBeans;
import com.jsfeb.assetmanagementsystem.exception.AMSException;
import com.jsfeb.assetmanagementsystem.services.UserServices;
import com.jsfeb.assetmanagementsystem.services.UserServicesImple;
import com.jsfeb.assetmanagementsystem.validations.Validation;
import com.jsfeb.assetmanagenmentsystem.repository.Repository;

public class LoginController {

	public static Scanner scan = new Scanner(System.in);

	public static final UserInfoBeans userInfo = new UserInfoBeans();
	public static final UserServices userServices = new UserServicesImple();
	public static final AdminController admin = new AdminController();
	public static final UserController user = new UserController();
	public static final Repository repo = new Repository();
	public static final Validation validation = new Validation();

	public static int checkChoice() {
		boolean flag = false;
		int select = 0;
		do {
			try {
				select = scan.nextInt();
				flag = true;
			} catch (InputMismatchException e) {
				flag = false;
				System.err.println("Invalid Choice, It Should Contain Only Digits");
				scan.next();
			}
		} while (!flag);
		return select;
	}

	public static int checkId() {
		boolean flag = false;
		int id = 0;
		do {
			try {
				id = scan.nextInt();
				validation.validateId(id);
				flag = true;
			} catch (InputMismatchException e) {
				flag = false;
				System.err.println("Id should Contain Only Digits");
				scan.next();
			} catch (AMSException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		} while (!flag);
		return id;
	}

	public static String checkName() {
		String name = null;
		boolean flag = false;
		do {
			try {
				name = scan.next();
				validation.validateName(name);
				flag = true;
			} catch (AMSException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		} while (!flag);
		return name;
	}

	public static String checkEmailId() {
		String emailId = null;
		boolean flag = false;
		do {
			try {
				emailId = scan.next();
				validation.validateEmail(emailId);
				flag = true;
			} catch (AMSException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		} while (!flag);
		return emailId;
	}

	public static String checkPassword() {
		String password = null;
		boolean flag = false;
		do {
			try {
				password = scan.next();
				validation.validatePassword(password);
				flag = true;
			} catch (AMSException e) {
				flag = false;
				System.err.println(e.getMessage());

			}
		} while (!flag);
		return password;
	}

	public static void loginController() {

		int select = 0;
		int id = 0;
		String name = null;
		String mail = null;
		String password = null;

		repo.addData();
		

		do {

			System.out.println("********Welcome to Asset Management System********");
			System.out.println("Press 1 if you are already registered");
			System.out.println("Press 2 if you are a new user");
			select = checkChoice();

			switch (select) {

			case 1:

				System.out.println("Enter your mailid");
				mail = checkEmailId();
				userInfo.setEmail(mail);

				System.out.println("Enter your password");
				password = checkPassword();
				userInfo.setPassword(password);

				System.out.println("Enter your role");
				String role = scan.next();
				userInfo.setRole(role);

				try {

					boolean login = userServices.loginUser(mail, password, role);

					if (login) {

						if (role.equalsIgnoreCase("admin")) {

							admin.adminController();
							break;

						} else if (role.equalsIgnoreCase("user")) {

							user.userController();
							break;

						} else {

							System.err.println("users or admins only can access data");

						}
					}

				} catch (AMSException e) {
					System.err.println(e.getMessage());
				}

				break;

			case 2:

				System.out.println("Enter your id");
				id = checkId();
				userInfo.setUserId(id);

				System.out.println("Enter your name");
				name = checkName();
				userInfo.setName(name);

				System.out.println("Enter your email");
				mail = checkEmailId();
				userInfo.setEmail(mail);

				System.out.println("Enter your password");
				password = checkPassword();
				userInfo.setPassword(password);

				System.out.println("Enter your role");
				role = scan.next();
				userInfo.setRole(role);

				try {

					boolean register = userServices.registerUser(userInfo);

					if (register) {
						System.out.println("!!!!!Registered successfully!!!!!");

					}

				} catch (AMSException e) {

					System.err.println(e.getMessage());

				}

			}

		} while (select != 0);

		scan.close();
	}

}
