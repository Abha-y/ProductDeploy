package com.infosys.Product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.Product.dto.SubscribedproductsDTO;
import com.infosys.Product.dto.ProductsDTO;
import com.infosys.Product.entity.Products;
import com.infosys.Product.entity.Subscribedproduct;
import com.infosys.Product.repository.ProductsRepository;
import com.infosys.Product.repository.SubscribedproductsRepository;
import com.infosys.Product.validator.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductsService {
	
	@Autowired
	private ProductsRepository productsrepo;
	@Autowired
	private SubscribedproductsRepository subrepo;
	
	
	public List<ProductsDTO> getAllProducts() {
		List<Products> products=productsrepo.findAll();
		List<ProductsDTO> productsDTOs=new ArrayList<>();
		
		for(Products product:products) {
			ProductsDTO productsDTO= ProductsDTO.valueof(product);
			productsDTOs.add(productsDTO);
		}
		return productsDTOs;

	}
	
	public String addProduct(int prodid, ProductsDTO productsDTO) throws Exception {
		try {
			Validator.validateProduct(productsDTO);
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		Products product=productsDTO.createProduct();
		productsrepo.save(product);
		return "added sucsessfully";

	}
	
	public String removeProduct(int prodid) throws Exception {
		Optional<Products> optproduct=productsrepo.findById(prodid);
		if(optproduct.isPresent()) {
			productsrepo.deleteById(prodid);
			return "Product removed successfully!!";
		}
		else {
			throw new Exception("Product not found!!!");
		}
		
	}
	
	public String updateProduct(ProductsDTO productDTO) throws Exception {
		if(!Validator.validatestock(productDTO.getStock())) {
			throw new Exception("Minimum 10 quantity required");
		}
		Products product=productsrepo.getOne(productDTO.getProdid());
		product.setStock(productDTO.getStock());
		productsrepo.save(product);
		return "Stock updated.";
		
	}
	
	
	public List<SubscribedproductsDTO> getSubProductForBuyer(int buyerid) {
		List<Subscribedproduct> subproducts=subrepo.getByBuyerid(buyerid);
		List<SubscribedproductsDTO> subproductsDTO=new ArrayList<>();
		for(Subscribedproduct subprod: subproducts) {
			SubscribedproductsDTO subprodDTO=SubscribedproductsDTO.valueof(subprod);
			subproductsDTO.add(subprodDTO);
		}
		
		return subproductsDTO;
	}
	
	public String addSubscription(SubscribedproductsDTO subProductdto) {
		Subscribedproduct subproduct=subProductdto.createSubcribedProduct();
		subrepo.save(subproduct);
		return "Subscription added successfully!";
	}

	

	
}
