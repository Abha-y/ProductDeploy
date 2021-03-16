package com.infosys.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.infosys.product.dto.ProductsDTO;
import com.infosys.product.dto.SubscribedproductsDTO;
import com.infosys.product.entity.Products;
import com.infosys.product.entity.Subscribedproduct;
import com.infosys.product.repository.ProductsRepository;
import com.infosys.product.repository.SubscribedproductsRepository;
import com.infosys.product.service.ProductsService;

@SpringBootTest

public class ProductApplicationTests {
	@Mock
	ProductsRepository productsRepo;
	
	@Mock
	SubscribedproductsRepository subRepo;
	
	@InjectMocks
	ProductsService productsService=new ProductsService();
	

	@Test
	public void authenticateAddProductValidCredentials() throws Exception {
		ProductsDTO productsDTO=new ProductsDTO();
		productsDTO.setProdid(20);
		productsDTO.setBrand("Alisha");
		productsDTO.setCategory("Clothing");
		productsDTO.setDescription("Key Features of Alisha Solid Women\'s Cycling Shorts Cotton Lycra Navy, Red, Navy,Specifications of Alisha Solid Women\'s Cycling Shorts Shorts");
		productsDTO.setImage("\"http://img5a.flixcart.com/image/short/u/4/a/altht-3p-21-alisha-38-original-imaeh2d5vm5zbtgg.jpeg\"");
		productsDTO.setPrice(600);
		productsDTO.setProductname("Alisha Solid Women\'s Cycling Shorts");
		productsDTO.setRating(null);
		productsDTO.setSellerid(7);
		productsDTO.setStock(60);
		productsDTO.setSubcategory("Women\'s Clothing");
		
		
		String actual=productsService.addProduct(productsDTO.getProdid(), productsDTO);
		Assertions.assertEquals("added sucsessfully",actual);
		
	}
	@Test
	public void authenticateAddProductInvalidCredentials() {
		ProductsDTO productsDTO=new ProductsDTO();
		productsDTO.setProdid(20);
		productsDTO.setBrand("Alisha");
		productsDTO.setCategory("Clothing");
		productsDTO.setDescription("Key Features of Alisha Solid Women\'s Cycling Shorts Cotton Lycra Navy, Red, Navy,Specifications of Alisha Solid Women\'s Cycling Shorts Shorts");
		productsDTO.setImage("\"http://img5a.flixcart.com/image/short/u/4/a/altht-3p-21-alisha-38-original-imaeh2d5vm5zbtgg.jpeg\"");
		productsDTO.setPrice(500);
		productsDTO.setProductname("                 ");
		productsDTO.setRating(null);
		productsDTO.setSellerid(7);
		productsDTO.setStock(60);
		productsDTO.setSubcategory("Women\'s Clothing");
		
		
		Exception exception=Assertions.assertThrows(Exception.class,()->productsService.addProduct(productsDTO.getProdid(), productsDTO));
		Assertions.assertEquals("Validator.INVALID_NAME",exception.getMessage());
		
	}
	
	
	
//	@Test
//	public void authenticateRemoveProductValidCredentials() throws Exception {
//		int prodid=20;
//		//Mockito.when(productsRepo.findById(prodid)).then();
//		
//		String actual=productsService.removeProduct(prodid);
//		Assertions.assertEquals("Product removed successfully!!",actual);
//	}
	@Test
	public void authenticateRemoveProductInvalidCredentials() throws Exception {
		int prodid=155;
		
		Exception exception=Assertions.assertThrows(Exception.class,()->productsService.removeProduct(prodid));
		Assertions.assertEquals("Product not found!!!",exception.getMessage());
	}
	
	
	@Test
	public void authenticateupdateProductInvalidCredentials() throws Exception {
		ProductsDTO productsDTO=new ProductsDTO();
		
		productsDTO.setProdid(20);
		productsDTO.setBrand("Alisha");
		productsDTO.setCategory("Clothing");
		productsDTO.setDescription("Key Features of Alisha Solid Women\'s Cycling Shorts Cotton Lycra Navy, Red, Navy,Specifications of Alisha Solid Women\'s Cycling Shorts Shorts");
		productsDTO.setImage("\"http://img5a.flixcart.com/image/short/u/4/a/altht-3p-21-alisha-38-original-imaeh2d5vm5zbtgg.jpeg\"");
		productsDTO.setPrice(500);
		productsDTO.setProductname("Alisha Solid Women\'s Cycling Shorts");
		productsDTO.setRating(null);
		productsDTO.setSellerid(7);
		productsDTO.setStock(6);
		productsDTO.setSubcategory("Women\'s Clothing");
		
		Exception exception=Assertions.assertThrows(Exception.class,()->productsService.updateProduct(productsDTO));
		Assertions.assertEquals("Minimum 10 quantity required",exception.getMessage());
	}
	
	@Test 
	public void  authenticategetSubProductForBuyerValidCredentials() throws Exception {
		List<Subscribedproduct> subscribedproductList=new ArrayList<>();
		Subscribedproduct subscribedproduct=new Subscribedproduct();
		subscribedproduct.setSubid(20);
		subscribedproduct.setBuyerid(20);
		subscribedproduct.setProdid(20);
		subscribedproduct.setQuantity(20);
		subscribedproductList.add(subscribedproduct);
		
		SubscribedproductsDTO subproddto=SubscribedproductsDTO.valueof(subscribedproduct);
		Mockito.when(subRepo.getByBuyerid(subscribedproduct.getBuyerid())).thenReturn(subscribedproductList);
		
		List<SubscribedproductsDTO> subproductsDTO=productsService.getSubProductForBuyer(subscribedproduct.getBuyerid());
		
		Assertions.assertEquals(subproddto.getSubid(),subproductsDTO.get(0).getSubid());
	}
	
}
