package com.armando.manyToMany.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.armando.manyToMany.models.CategoryProduct;

@Repository
public interface CatProdRepo extends CrudRepository<CategoryProduct, Long> {

	CategoryProduct save(CategoryProduct catprod);
	
}
