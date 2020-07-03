package com.jsfeb.assetmanagementsystem.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jsfeb.assetmanagementsystem.exception.AMSException;

public class Validation {
public boolean validateId(int id) throws AMSException {
		
		String idRegEx = "[0-9]{2}";
		boolean result = false;

		if (Pattern.matches(idRegEx, String.valueOf(id))) {
			result = true;
		} else {
			throw new AMSException("Please Enter valid Id, It Should Contain Exact 2 Digits");
		}
		return result;
	}

	public boolean validateName(String name) throws AMSException {
		
		String nameRegEx = "^[A-Za-z\\s]+$";
		boolean result = false;

		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(name);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new AMSException("Name Should Contains only Alphabets");
		}
		return result;
	}

	public boolean validateEmail(String emailId) throws AMSException {
		
		String emailRegEx = "^(.+)@(.+)$";
		boolean result = false;

		Pattern pattern = Pattern.compile(emailRegEx);
		Matcher matcher = pattern.matcher(emailId);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new AMSException("Enter The Proper Email ID");
		}
		return result;
	}

	public boolean validatePassword(String password) throws AMSException {
	
		String passwordRegEx = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{6,}$";
		boolean result = false;

		Pattern pattern = Pattern.compile(passwordRegEx);
		Matcher matcher = pattern.matcher(password);

		if (matcher.matches()) {
			result = true;
		} else {
			throw new AMSException(
					"Enter Valid Passsword with min 6 Characters, One Uppercase and Lowercase and a Symbol ");
		}
		return result;
	}
	
	public boolean validateCategory(String name) throws AMSException {
		String nameRegEx = "^[A-Za-z\\s]+$";
		boolean result = false;

		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(name);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new AMSException("Category Should Contains only Alphabets");
		}
		return result;
	}
	
	public boolean validateQuantity(int quantity) throws AMSException {
		
		String idRegEx = "^[0-9]+$";
		boolean result = false;

		if (Pattern.matches(idRegEx, String.valueOf(quantity))) {
			result = true;
		} else {
			throw new AMSException("Quantity should contain only number");
		}
		return result;
	}
	
	public boolean validatePrice(String price) throws AMSException {
		
		Pattern pattern = Pattern.compile("[0-9]+([,.][0-9]{1,2})?");
		Matcher matcher = pattern.matcher(price);
		
		if (matcher.matches()) {
			return true;
		}
		return false;
	}
}
