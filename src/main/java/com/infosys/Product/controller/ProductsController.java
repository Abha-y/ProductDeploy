package com.infosys.Product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.Product.dto.ProductsDTO;
import com.infosys.Product.dto.SubscribedproductsDTO;
import com.infosys.Product.service.ProductsService;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@RestController
@CrossOrigin
public class ProductsController {
	
	@Autowired
	private ProductsService productsService;
	
	@Autowired
	Environment env;
	
	Logger logger=LogManager.getLogger(this.getClass());
	
	//get all listed products
		@GetMapping(value= "/products/", produces = MediaType.APPLICATION_JSON_VALUE)
		public List<ProductsDTO> getAllProducts(){
			logger.info("Getting listed products...");
			return productsService.getAllProducts();
		}
	
	
	//seller can add product. Integrated with User service
	@PostMapping(value = "/addproduct/{prodid}",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addProduct(@PathVariable int prodid, @RequestBody ProductsDTO productsDTO) {
		logger.info("adding product with id:"+prodid);
		String response;
		try {
			response = productsService.addProduct(prodid,productsDTO);
			return new ResponseEntity<>(response,HttpStatus.OK);
		} catch (Exception e) {
			response=env.getProperty(e.getMessage());
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		
		
	}
	// seller can remove product if present
	@DeleteMapping(value ="/removeproduct/{prodid}")
	public ResponseEntity<String> removeProduct(@PathVariable int prodid) {
		logger.info("Removing product :"+prodid);
		try {
			String response=productsService.removeProduct(prodid);
			return new ResponseEntity<String>(response,HttpStatus.OK);
			
		} catch (Exception e) {
			return  new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	//seller can update stock of product
	@PutMapping(value="/updateproduct")
	public ResponseEntity<String> updateProduct(@RequestBody ProductsDTO productDTO){
		logger.info("Updating stock  of product ID:"+productDTO.getProdid());
		try {
			String response=productsService.updateProduct(productDTO);
			return new ResponseEntity<String>(response,HttpStatus.OK);
		}
		catch(Exception e) {
			return  new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	//subscribed products for given buyerid
	@GetMapping(value="/api/subscriptions/{buyerid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SubscribedproductsDTO> getSubProductForBuyer(@PathVariable int buyerid) {
		logger.info("Getting list of subscribed products for buyer ID:"+buyerid);
		return productsService.getSubProductForBuyer(buyerid);
	}
	
	//buyer can subscribe to products
	@PostMapping(value="/api/subscriptions/add/")
	public ResponseEntity<String> addSubscription(@RequestBody SubscribedproductsDTO subProductdto){
		logger.info("adding subscription for buyer...");
		String response=productsService.addSubscription(subProductdto);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	

}
