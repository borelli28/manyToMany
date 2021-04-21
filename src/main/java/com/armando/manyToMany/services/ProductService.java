package com.armando.manyToMany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.armando.manyToMany.models.Product;
import com.armando.manyToMany.repositories.ProductRepo;

@Service
public class ProductService {
	
	private final ProductRepo productRepo;
	
	public ProductService(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}
	
	// return all products
	public List<Product> allProducts() {
		return productRepo.findAll();	
	}
	
	// create product
	public Product createProduct(Product b) {
		return productRepo.save(b);
	}
	
	// retrieve product
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}
	
	// delete product
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
	}
	
}
