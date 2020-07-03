package com.jsfeb.assetmanagementsystem.services;

import java.util.ArrayList;
import java.util.List;

import com.jsfeb.assetmanagementsystem.bean.AssetInfoBeans;
import com.jsfeb.assetmanagementsystem.bean.RequestInfoBeans;
import com.jsfeb.assetmanagementsystem.dao.AdminDAO;
import com.jsfeb.assetmanagementsystem.dao.AdminDAOImple;
import com.jsfeb.assetmanagementsystem.exception.AMSException;
import com.jsfeb.assetmanagementsystem.validations.Validation;

public class AdminServicesImple implements AdminServices {
	private AdminDAO dao = new AdminDAOImple();
	Validation valid = new Validation();

	
    public boolean addAsset(AssetInfoBeans asset) {
		if (asset != null) {
			return dao.addAsset(asset);
		} else {
			throw new AMSException("Enter the correct value");
		}
	}

	
	public boolean deleteAsset(int id) {
		if (id > 0) {
			return dao.deleteAsset(id);
		} else {
			throw new AMSException("Enter the correct value");
		}
	}

	//@Override
	public ArrayList<AssetInfoBeans> searchAsset(int id) {
		if (id > 0) {
			return dao.searchAsset(id);
		} else {
			throw new AMSException("Enter the correct value");
		}
	}

	//@Override
	public List<AssetInfoBeans> getAllAssets() {
		return dao.getAllAssets();
	}

	//@Override
	public List<RequestInfoBeans> requestDetails() {
		return dao.requestDetails();
	}

	//@Override
	public boolean acceptRequest(int id, String name) {
		return dao.acceptRequest(id,name);
	}
		}
