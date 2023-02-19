package com.batch2.onlineshopping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.batch2.onlineshopping.entity.Products;
import com.batch2.onlineshopping.repository.ProductsRepository;
import com.batch2.onlineshopping.service.ProductsService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
public class ProductsController {
	@Autowired
	ProductsService productsService;

	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@PostMapping("/products")
	public Products addProducts(@RequestBody Products products) {
		return productsService.addProducts(products);
	}

	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value="hasRole('ROLE_ADMIN') || hasRole('ROLE_CUSTOMER')")
	@GetMapping("/products/{id}")
	public Optional<Products> getProducts(@PathVariable int id) {

		return productsService.getProducts(id);
	}
	
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@PutMapping("/products/{id}")
	public Products updateProducts(@RequestBody Products products, @PathVariable int id) {
		
		return productsService.updateProducts(products, id);
	}
	
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@DeleteMapping("/products/{id}")
	public String deleteProducts(@PathVariable int id) {
		
		return productsService.deleteProducts(id);
	}
	
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value="hasRole('ROLE_ADMIN') || hasRole('ROLE_CUSTOMER')")
	@GetMapping("/products")
	public List<Products> getProducts(){
		return productsService.getProducts();
	}
}



