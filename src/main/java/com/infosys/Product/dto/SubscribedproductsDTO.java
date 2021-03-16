package com.infosys.Product.dto;

import com.infosys.Product.entity.Subscribedproduct;

public class SubscribedproductsDTO {
	
	int subid;
	
	int buyerid;
	
	int prodid;
	
	int quantity;

	public int getSubid() {
		return subid;
	}

	public void setSubid(int subid) {
		this.subid = subid;
	}

	public int getBuyerid() {
		return buyerid;
	}

	public void setBuyerid(int buyerid) {
		this.buyerid = buyerid;
	}

	public int getProdid() {
		return prodid;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public SubscribedproductsDTO(int subid,int buyerid,int prodid,int quantity) {
		this();
		this.subid=subid;
		this.buyerid=buyerid;
		this.prodid=prodid;
		this.quantity=quantity;
		
	}
	public SubscribedproductsDTO() {
		super();
	}
	

	//entity to dto
	public static SubscribedproductsDTO valueof(Subscribedproduct subprod) {
		SubscribedproductsDTO subprodDTO= new SubscribedproductsDTO();
				
		subprodDTO.setSubid(subprod.getSubid());
		subprodDTO.setBuyerid(subprod.getBuyerid());
		subprodDTO.setProdid(subprod.getProdid());
		subprodDTO.setQuantity(subprod.getQuantity());
		
		return subprodDTO;
	}
	
	//dto to entity
	public Subscribedproduct createSubcribedProduct() {
		Subscribedproduct subscribedproduct=new Subscribedproduct();
		subscribedproduct.setSubid(this.getSubid());
		subscribedproduct.setBuyerid(this.getBuyerid());
		subscribedproduct.setProdid(this.getProdid());
		subscribedproduct.setQuantity(this.getQuantity());
		
		return subscribedproduct;
	}
	
}
