package com.infosys.Product.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Product")
public class Products {
	@Id
	@Column(length=255)
	private int prodid;
	@Column(nullable=false, length=255)
	private String brand;
	@Column(nullable=false, length=255)
	private String category;
	@Column(nullable=false, length=255)
	private String description;
	@Column(nullable=false, length=255)
	private String image;
	@Column(nullable=false,precision = 10,scale=2)
	private double price;
	@Column(nullable=false, length=255)
	private String productname;
	@Column(nullable=true)
	private Integer rating;// size required
	@Column(nullable=false)
	private int sellerid;// size
	@Column(nullable=false)
	private int stock;//size
	@Column(nullable=true, length = 255, columnDefinition = "varchar(255) default null")
	private String subcategory;//default value
	
	
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
	

	
}
