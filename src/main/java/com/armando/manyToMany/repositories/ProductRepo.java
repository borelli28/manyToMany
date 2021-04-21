package com.armando.manyToMany.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.armando.manyToMany.models.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {

	List<Product> findAll();
	
	Optional<Product> findById(Long id);
	
	void deleteById(Long id);
	
	Product save(Product product);
	
}
