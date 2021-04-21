package com.armando.manyToMany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.armando.manyToMany.models.Category;
import com.armando.manyToMany.models.CategoryProduct;
import com.armando.manyToMany.repositories.CatProdRepo;
import com.armando.manyToMany.repositories.CategoryRepo;

@Service
public class CategoryService {

	private final CategoryRepo catRepo;
	private final CatProdRepo catProdRepo;
	
	public CategoryService(CategoryRepo catRepo, CatProdRepo catProdRepo) {
		this.catRepo = catRepo;
		this.catProdRepo = catProdRepo;
	}
	
	// return all categories
	public List<Category> allCategories() {
		return catRepo.findAll();	
	}
	
	// create category
	public Category createCategory(Category b) {
		return catRepo.save(b);
	}
	
	// retrieve category
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = catRepo.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}
	
	// delete category
	public void deleteCategory(Long id) {
		catRepo.deleteById(id);
	}
	
	// CREATE RELATIONSHIP BETWEEN PRODUCT AND CAT
	
	public CategoryProduct saveRel(CategoryProduct catProd) {
		return catProdRepo.save(catProd);	
	}
	
}
