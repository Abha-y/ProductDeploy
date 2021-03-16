package com.infosys.Product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.Product.entity.Products;
import com.infosys.Product.entity.Subscribedproduct;

public interface SubscribedproductsRepository extends JpaRepository<Subscribedproduct, Integer>{

	List<Subscribedproduct> getByBuyerid(int buyerid);

}
