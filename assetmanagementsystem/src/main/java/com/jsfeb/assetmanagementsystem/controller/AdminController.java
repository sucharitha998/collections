package com.jsfeb.assetmanagementsystem.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.jsfeb.assetmanagementsystem.bean.AssetInfoBeans;
import com.jsfeb.assetmanagementsystem.bean.RequestInfoBeans;
import com.jsfeb.assetmanagementsystem.dao.AdminDAOImple;
import com.jsfeb.assetmanagementsystem.exception.AMSException;
import com.jsfeb.assetmanagementsystem.services.AdminServices;
import com.jsfeb.assetmanagementsystem.services.AdminServicesImple;
import com.jsfeb.assetmanagementsystem.validations.Validation;

public class AdminController {

	public static Scanner scan = new Scanner(System.in);

	public static final LoginController control = new LoginController();
	public static final AssetInfoBeans assetsInfo = new AssetInfoBeans();
	public static final AdminServices adminServices = new AdminServicesImple();
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

	public static String checkCategory() {
		String category = null;
		boolean flag = false;
		do {
			try {
				category = scan.next();
				validation.validateName(category);
				flag = true;
			} catch (AMSException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		} while (!flag);
		return category;
	}
	
	public static int checkQuantity() {
		boolean flag = false;
		int quantity = 0;
		do {
			try {
				quantity = scan.nextInt();
				validation.validateQuantity(quantity);
				flag = true;
			} catch (InputMismatchException e) {
				flag = false;
				System.err.println("Quantity should Contain Only Digits");
				scan.next();
			} catch (AMSException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		} while (!flag);
		return quantity;
	}

	public static String checkPrice() {
		boolean flag = false;
		String price = null;
		do {
			try {
				price = scan.next();
				validation.validatePrice(price);
				flag = true;
			} catch (InputMismatchException e) {
				flag = false;
				System.err.println("Price should be in numbers only");
				scan.next();
			} catch (AMSException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		} while (!flag);
		return price;
	}
	
	public static void adminController() {

		
		int id = 0;
		int choice = 0;

		do {
			System.out.println("press 1 for Adding assets");
			System.out.println("press 2 for deleting assets");
			System.out.println("press 3 for searching assets");
			System.out.println("press 4 for get all assets details");
			System.out.println("Press 5 for getting request details of user");
			System.out.println("Press 6 to logout");

			choice = checkChoice();
			
			switch (choice) {

			case 1:

				System.out.println("Enter asset id");
				id = checkId();
				assetsInfo.setAssetId(id);

				System.out.println("Enter asset name");
				String name = checkName();
				assetsInfo.setAssetName(name);

				System.out.println("Enter asset category");
				String category = checkCategory();
				assetsInfo.setCategory(category);

				System.out.println("Enter asset company name");
				String companyName = checkName();
				assetsInfo.setCompanyName(companyName);

				System.out.println("Enter asset price");
				double price =  Double.parseDouble(checkPrice());
				assetsInfo.setPrice(price);

				try {

					boolean adding = adminServices.addAsset(assetsInfo);

					if (adding) {
						System.out.println("Added asset successfully");
					}

				} catch (AMSException e) {
					System.err.println(e.getMessage());
				}

				break;

			case 2:

				System.out.println("Enter id of the asset");
				id = checkId();
				
				try {
					boolean deleted = adminServices.deleteAsset(id);
					if (deleted) {
						System.out.println("deleted asset successfully");
					}
				} catch (AMSException e) {
					System.err.println(e.getMessage());
				}
				
				break;

			case 3:

				System.out.println("Search by id");
				id = checkId();
				
				try {
					
					ArrayList<AssetInfoBeans> search = adminServices.searchAsset(id);
					
					if (search != null) {
						for (AssetInfoBeans details : search) {
							System.out.println("Asset id = " + details.getAssetId());
							System.out.println("Asset name = " + details.getAssetName());
							System.out.println("Asset category = " + details.getCategory());
							System.out.println("Asset company name = " + details.getCompanyName());
							System.out.println("Asset price = " + details.getPrice());
						}
					
					}
				
				} catch (AMSException e) {
					
					System.err.println(e.getMessage());
				}

				break;

			case 4:

				System.out.println("Your assets are:");
				
				List<AssetInfoBeans> records = adminServices.getAllAssets();

				for (AssetInfoBeans details : records) {
					
					System.out.println("Asset id = " + details.getAssetId());
					System.out.println("Asset name = " + details.getAssetName());
					System.out.println("Asset category = " + details.getCategory());
					System.out.println("Asset company name = " + details.getCompanyName());
					System.out.println("Asset price = " + details.getPrice());

				}
				break;

			case 5:
				
				System.out.println("Requested User details are:");
				
				List<RequestInfoBeans> requests = adminServices.requestDetails();

				for (RequestInfoBeans details : requests) {
					System.out.println("User id = " + details.getUserId());
					System.out.println("User name = " + details.getUserName());
					System.out.println("Asset id = " + details.getAssetId());
					System.out.println("Asset name = " + details.getAssetName());
					System.out.println("Asset status = " + details.getStatus());

				}
				break;

			case 6:

				System.out.println("****Logged out successfully****");
				
				break;

			default:

				System.err.println("Invalid details......");
				
				break;
			}

		} while (choice != 6);

		control.loginController();

		scan.close();
	}
}
