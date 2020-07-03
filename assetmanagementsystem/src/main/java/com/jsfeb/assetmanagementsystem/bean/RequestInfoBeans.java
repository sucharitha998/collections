package com.jsfeb.assetmanagementsystem.bean;

import java.io.Serializable;
@SuppressWarnings("serial")

public class RequestInfoBeans implements Serializable {

	private int userId;
	private String userName;
	private int assetId;
	private String assetName;
	private int quantity;
	private String status;
	
	
	public RequestInfoBeans() {
		
	}

	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getAssetId() {
		return assetId;
	}


	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}


	public String getAssetName() {
		return assetName;
	}


	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
