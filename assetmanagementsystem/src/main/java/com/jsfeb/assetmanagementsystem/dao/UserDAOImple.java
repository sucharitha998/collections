package com.jsfeb.assetmanagementsystem.dao;

import java.util.ArrayList;
import java.util.List;

import com.jsfeb.assetmanagementsystem.bean.AssetInfoBeans;
import com.jsfeb.assetmanagementsystem.bean.RequestInfoBeans;
import com.jsfeb.assetmanagementsystem.bean.UserInfoBeans;
import com.jsfeb.assetmanagementsystem.exception.AMSException;
import com.jsfeb.assetmanagenmentsystem.repository.Repository;

public class UserDAOImple implements UserDAO {

	
	public boolean registerUser(UserInfoBeans userBean) {

		for (UserInfoBeans beans : Repository.userBeans) {
			if (beans.getUserId() == userBean.getUserId() || beans.getEmail().contentEquals(userBean.getEmail())) {
				throw new AMSException("Can't register, user id is already present");
			}
		}
		Repository.userBeans.add(userBean);
		return true;
	}

	
	public boolean loginUser(String email, String password, String role) {

		for (UserInfoBeans beans : Repository.userBeans) {
			if ((beans.getEmail().equalsIgnoreCase(email)) 
					&& (beans.getPassword().equals(password))
					&& (beans.getRole().contentEquals(role))) {
				return true;
			}
		}
		throw new AMSException("Enter email, password and role correctly");

	}

	
	public boolean requestAsset(int userId, String assetName, int quantity) {

		RequestInfoBeans requestInfo = new RequestInfoBeans();
		for (UserInfoBeans userBean : Repository.userBeans) {
			if (userId == userBean.getUserId()) {
				for (AssetInfoBeans assetBean : Repository.assetBeans) {
					if (assetBean.getAssetName().contentEquals(assetName)) {
						requestInfo.setUserId(userId);
						requestInfo.setAssetName(assetName);
						requestInfo.setQuantity(quantity);
						Repository.requestBeans.add(requestInfo);
						return true;
					}
				}
			}
		}
		throw new AMSException("Request is not sent");
	}

	
	public boolean removeAsset(String name) {
		for (RequestInfoBeans beans : Repository.requestBeans) {
			if (beans.getAssetName().equals(name)) {
				Repository.requestBeans.remove(beans);
				return true;
			}
		}
		throw new AMSException("No such asset present...");
	}

	
	public List<RequestInfoBeans> viewAllAssets(int id) {

		List<RequestInfoBeans> allAssets = new ArrayList<RequestInfoBeans>();

		for (RequestInfoBeans requestBean : Repository.requestBeans) {

			requestBean.getAssetName();

			requestBean.getQuantity();
			if (requestBean.getUserId() == id) {
				allAssets.add(requestBean);
			}
		}
		return allAssets;
	}

	
	public List<UserInfoBeans> viewDetails() {

		List<UserInfoBeans> allAssets = new ArrayList<UserInfoBeans>();

		for (UserInfoBeans userBean : Repository.userBeans) {

			userBean.getName();
			userBean.getEmail();
			userBean.getPassword();
			userBean.getUserId();

			if (userBean.getRole().equals("user")) {
				allAssets.add(userBean);
			}
		}

		return allAssets;
	}
}
