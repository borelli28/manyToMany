package com.armando.manyToMany.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.armando.manyToMany.models.Category;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {

	List<Category> findAll();
	
	Optional<Category> findById(Long id);
	
	void deleteById(Long id);
	
	Category save(Category category);
	
}
