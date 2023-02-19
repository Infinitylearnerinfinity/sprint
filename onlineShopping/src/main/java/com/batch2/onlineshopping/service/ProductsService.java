package com.batch2.onlineshopping.service;

import java.util.List;
import java.util.Optional;

import com.batch2.onlineshopping.entity.Products;

public interface ProductsService {
	Products addProducts(Products products);

	Optional<Products> getProducts(int id);

	Products updateProducts(Products products, int id);

	String deleteProducts(int id);

	List<Products> getProductsByCategory(String category);
	
	List<Products> getProducts();
	}
