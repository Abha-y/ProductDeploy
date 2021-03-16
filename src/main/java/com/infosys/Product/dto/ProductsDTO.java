package com.infosys.Product.dto;

import java.math.BigDecimal;

import com.infosys.Product.entity.Products;



public class ProductsDTO {

	private int prodid;

	private String brand;
	
	private String category;
	
	private String description;
	
	private String image;
	
	private double price;
	
	private String productname;
	
	private Integer rating;
	
	private int sellerid;
	
	private int stock;
	
	private String subcategory;

	
	public int getProdid() {
		return prodid;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public int getSellerid() {
		return sellerid;
	}

	public void setSellerid(int sellerid) {
		this.sellerid = sellerid;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public ProductsDTO(int prodid,String brand,String category,String description,String image,double price,String productname,int rating,int sellerid,int stock,String subcategory) {
		this();
		this.prodid=prodid;
		this.brand=brand;
		this.category=category;
		this.description=description;
		this.image=image;
		this.price=price;
		this.productname=productname;
		this.rating=rating;
		this.sellerid=sellerid;
		this.stock=stock;
		this.subcategory=subcategory;
	}
	public ProductsDTO() {
		super();
	}
	//converts DTO into Entity
	public Products createProduct() {
		Products product=new Products();
		
		product.setProdid(this.prodid);
		product.setBrand(this.brand);
		product.setCategory(this.category);
		product.setDescription(this.description);
		product.setImage(this.image);
		product.setPrice(this.price);
		product.setProductname(this.productname);
		product.setRating(this.rating);
		product.setSellerid(this.sellerid);
		product.setStock(this.stock);
		product.setSubcategory(this.subcategory);
		
		return product;
	}
	
	//converts Entity into DTO
	public static ProductsDTO valueof(Products product) {
		ProductsDTO productsDTO=new ProductsDTO();
		
		productsDTO.setProdid(product.getProdid());
		productsDTO.setBrand(product.getBrand());
		productsDTO.setCategory(product.getCategory());
		productsDTO.setDescription(product.getDescription());
		productsDTO.setImage(product.getImage());
		productsDTO.setPrice(product.getPrice());
		productsDTO.setProductname(product.getProductname());
		productsDTO.setRating(product.getRating());
		productsDTO.setSellerid(product.getSellerid());
		productsDTO.setStock(product.getStock());
		productsDTO.setSubcategory(product.getSubcategory());
		
		return productsDTO;
	}
	

}
