package com.prdt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prdt.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
