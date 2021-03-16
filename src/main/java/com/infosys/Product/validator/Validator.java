package com.infosys.Product.validator;


import com.infosys.Product.dto.ProductsDTO;

public class Validator {
	public static void validateProduct(ProductsDTO productDTO) throws Exception {
		if(!validateName(productDTO.getProductname()))
			throw new Exception("Validator.INVALID_NAME");
		if(!validateDescription(productDTO.getDescription()))
			throw new Exception("Validator.INVALID_DESCRIPTION");
		if(!validatePrice(productDTO.getPrice()))
			throw new Exception("Validator.INVALID_PRICE");
		if(!validatestock(productDTO.getStock()))
			throw new Exception("Validator.INVALID_STOCK");
		if(!validateimage(productDTO.getImage()))
			throw new Exception("Validator.INVALID_IMAGE");
		
	}
	public static boolean validateName(String name) {
		String regx="^[a-zA-Z][a-zA-Z' ]{0,98}[a-zA-Z]$";
		if(name.matches(regx))
			return true;
		
		return false;
	}
	public static boolean validateDescription(String desc) {
		String regx=".{1,500}";
		if(desc.matches(regx))
			return true;
		
		return false;
	}
	public static boolean validatePrice(double price) {
		if(price>=200.0)
			return true;
		return false;
	}
	public static boolean validatestock(int stock) {
		if(stock>=10)
			return true;
		return false;
	}
	public static boolean validateimage(String img) {
		String regx=".+(jpeg\"|png\")$";
		if(img.matches(regx))
			return true;
		return false;
	}

}
