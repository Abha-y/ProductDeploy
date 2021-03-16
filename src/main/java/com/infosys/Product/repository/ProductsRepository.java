package com.infosys.Product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.Product.entity.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer>{

}
