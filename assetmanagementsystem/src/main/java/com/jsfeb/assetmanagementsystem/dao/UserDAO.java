package com.jsfeb.assetmanagementsystem.dao;

import java.util.List;

import com.jsfeb.assetmanagementsystem.bean.RequestInfoBeans;
import com.jsfeb.assetmanagementsystem.bean.UserInfoBeans;

public interface UserDAO {

	public boolean registerUser(UserInfoBeans userBean);
	public boolean loginUser(String email, String password, String role);
	public boolean requestAsset(int userId, String assetName, int quantity);
	public boolean removeAsset(String name);
	public List<RequestInfoBeans> viewAllAssets(int id);
	public List<UserInfoBeans> viewDetails();
}
