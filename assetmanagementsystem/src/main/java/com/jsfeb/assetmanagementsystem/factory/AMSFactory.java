package com.jsfeb.assetmanagementsystem.factory;

import com.jsfeb.assetmanagementsystem.dao.AdminDAO;
import com.jsfeb.assetmanagementsystem.dao.AdminDAOImple;
import com.jsfeb.assetmanagementsystem.dao.UserDAO;
import com.jsfeb.assetmanagementsystem.dao.UserDAOImple;
import com.jsfeb.assetmanagementsystem.services.AdminServices;
import com.jsfeb.assetmanagementsystem.services.AdminServicesImple;
import com.jsfeb.assetmanagementsystem.services.UserServices;
import com.jsfeb.assetmanagementsystem.services.UserServicesImple;
import com.jsfeb.assetmanagementsystem.validations.Validation;

public class AMSFactory {

	private AMSFactory() {
		
	}
	public static AdminDAO getAdminDAOImpleInstance() {
		AdminDAO dao = new AdminDAOImple();
		return dao;
	}
	public static UserDAO getUserDAOImpleInstance() {
		UserDAO dao = new UserDAOImple();
		return dao;
		}
	public static AdminServices getAdminServicesImpleInstance() {
		AdminServices dao = new AdminServicesImple();
		return dao;
	}
	public static UserServices getUserServicesImpleInstance() {
		UserServices dao = new UserServicesImple();
		return dao;
	}
	public static Validation getValidationInstance() {
		Validation dao = new Validation();
		return dao;
	}
}