package com.jsfeb.assetmanagementsystem.dao;

import java.util.ArrayList;
import java.util.List;

import com.jsfeb.assetmanagementsystem.bean.AssetInfoBeans;
import com.jsfeb.assetmanagementsystem.bean.RequestInfoBeans;

public interface AdminDAO {

	public boolean addAsset(AssetInfoBeans asset);
	public boolean deleteAsset(int id);
	public ArrayList<AssetInfoBeans> searchAsset(int id);
	public List<AssetInfoBeans> getAllAssets();
	public List<RequestInfoBeans> requestDetails();
	public boolean acceptRequest(int id, String name);
}
