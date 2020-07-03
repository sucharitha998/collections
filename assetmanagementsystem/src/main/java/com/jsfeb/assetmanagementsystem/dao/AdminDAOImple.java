package com.jsfeb.assetmanagementsystem.dao;

import java.util.ArrayList;
import java.util.List;

import com.jsfeb.assetmanagementsystem.bean.AssetInfoBeans;
import com.jsfeb.assetmanagementsystem.bean.RequestInfoBeans;
import com.jsfeb.assetmanagementsystem.exception.AMSException;
import com.jsfeb.assetmanagenmentsystem.repository.Repository;

public class AdminDAOImple implements AdminDAO {

	
	public boolean addAsset(AssetInfoBeans asset) {
		
		for (AssetInfoBeans beans : Repository.assetBeans) {
		
			if (beans.getAssetId() == asset.getAssetId()) {
				throw new AMSException("Can't add asset, beacause asset id is already present");
			}
		}
		
		Repository.assetBeans.add(asset);
		return true;
	}


	public boolean deleteAsset(int id) {
		
		for (AssetInfoBeans beans : Repository.assetBeans) {
		
			if (beans.getAssetId() == id) {
				Repository.assetBeans.remove(beans);
				return true;
			}
		
		}
		throw new AMSException("Can't delete , No asset found");
	
	}

	
	public ArrayList<AssetInfoBeans> searchAsset(int id) {

		ArrayList<AssetInfoBeans> searchAsset = new ArrayList<AssetInfoBeans>();
		
		for (AssetInfoBeans beans : Repository.assetBeans) {
		
			if (beans.getAssetId() == id) {
				searchAsset.add(beans);
			}
		
		}
	
		if (searchAsset.size() == 0) {
		
			throw new AMSException("Assets not found");
		}
		
		return searchAsset;

	}


	public List<AssetInfoBeans> getAllAssets() {
	
		List<AssetInfoBeans> allAssets = new ArrayList<AssetInfoBeans>();
		
		for (AssetInfoBeans assetBean : Repository.assetBeans) {
		
			assetBean.getAssetId();
			assetBean.getAssetName();
			assetBean.getCategory();
			assetBean.getCompanyName();
			assetBean.getPrice();

			allAssets.add(assetBean);
		
		}
		
		return allAssets;
	}

	
	public List<RequestInfoBeans> requestDetails() {
		
		List<RequestInfoBeans> requests = new ArrayList<RequestInfoBeans>();
		
		for (RequestInfoBeans requestBeans : Repository.requestBeans) {
		
			requestBeans.getUserId();
			requestBeans.getUserName();
			requestBeans.getAssetId();
			requestBeans.getAssetName();
			requestBeans.getStatus();

			requests.add(requestBeans);
		
		}
		
		return requests;
	}

	
	public boolean acceptRequest(int id, String name) {
		
		RequestInfoBeans requestInfo = new RequestInfoBeans();
		
		for (RequestInfoBeans accept : Repository.requestBeans) {
		
			if (id == accept.getUserId()) {
			
				for (AssetInfoBeans assetBean : Repository.assetBeans) {
				
					if (assetBean.getAssetName().contentEquals(name)) {
					
						requestInfo.setUserId(id);
						requestInfo.setAssetName(name);
						String status = "true";
						requestInfo.setStatus(status);
						Repository.requestBeans.add(requestInfo);
						return true;
					
					}
				
				}
			
			}
		
		}

		throw new AMSException("Accept is not valid");
	}
	
}
