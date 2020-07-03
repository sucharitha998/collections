package com.jsfeb.assetmanagenmentsystem.repository;

import java.util.ArrayList;
import java.util.List;

import com.jsfeb.assetmanagementsystem.bean.AssetInfoBeans;
import com.jsfeb.assetmanagementsystem.bean.RequestInfoBeans;
import com.jsfeb.assetmanagementsystem.bean.UserInfoBeans;

public class Repository {
	public static List<UserInfoBeans> userBeans = new ArrayList<UserInfoBeans>();
	public static List<AssetInfoBeans> assetBeans = new ArrayList<AssetInfoBeans>();
	public static List<RequestInfoBeans> requestBeans = new ArrayList<RequestInfoBeans>();
	
	public void addData() {
		
		UserInfoBeans userInfoBeans = new  UserInfoBeans();
		userInfoBeans.setUserId(50);
		userInfoBeans.setName("sucharitha");
		userInfoBeans.setEmail("suchi@gmail.com");
		userInfoBeans.setPassword("Suchi@1234");
		userInfoBeans.setRole("admin");
		userBeans.add(userInfoBeans);
		
		
			
		AssetInfoBeans assetInfoBeans = new AssetInfoBeans();
		assetInfoBeans.setAssetId(50);
		assetInfoBeans.setAssetName("chair");
		assetInfoBeans.setCompanyName("Royaloak");
		assetInfoBeans.setCategory("office chairs");
		assetInfoBeans.setPrice(30000.00);
		assetBeans.add(assetInfoBeans);
		
		
		RequestInfoBeans requestInfoBeans = new RequestInfoBeans();
		requestInfoBeans.setUserId(10);
		requestInfoBeans.setUserName("sucharitha@gmail.com");
		requestInfoBeans.setAssetId(12);
		requestInfoBeans.setAssetName("chairs");
		requestInfoBeans.setQuantity(32);
		requestInfoBeans.setStatus("sent");
		requestBeans.add(requestInfoBeans);
		
		
	}
}
