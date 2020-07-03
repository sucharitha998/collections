package com.jsfeb.assetmanagementsystem.services;

import java.util.List;

import com.jsfeb.assetmanagementsystem.bean.RequestInfoBeans;
import com.jsfeb.assetmanagementsystem.bean.UserInfoBeans;
import com.jsfeb.assetmanagementsystem.dao.UserDAO;
import com.jsfeb.assetmanagementsystem.dao.UserDAOImple;
import com.jsfeb.assetmanagementsystem.exception.AMSException;

public class UserServicesImple implements UserServices {

	private UserDAO dao = new UserDAOImple();

	
	public boolean registerUser(UserInfoBeans userBean) {
		if (userBean != null) {
			return dao.registerUser(userBean);
		} else {
			throw new AMSException("Enter the correct value");
		}
	}

	
	public boolean loginUser(String email, String password, String role) {
		if ((email != null) && (password != null) && (role != null)) {
			return dao.loginUser(email, password, role);
		} else {
			throw new AMSException("Enter the correct value");
		}
	}

	
	
	public boolean requestAsset(int userId, String assetName, int quantity) {
		if ((userId > 0) && (assetName != null) && (quantity > 0)) {
			return dao.requestAsset(userId, assetName, quantity);
		} else {
			throw new AMSException("Enter the correct value");
		}
	}

	
	public boolean removeAsset(String name) {
		if (name != null) {
			return dao.removeAsset(name);
		} else {
			throw new AMSException("Enter the correct value");
		}
	}


	public List<RequestInfoBeans> viewAllAssets(int id) {
		return dao.viewAllAssets(id);
	}

	
	public List<UserInfoBeans> viewDetails() {
		return dao.viewDetails();
	}

}
