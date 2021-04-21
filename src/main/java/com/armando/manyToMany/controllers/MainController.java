package com.armando.manyToMany.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.armando.manyToMany.models.Category;
import com.armando.manyToMany.models.Product;
import com.armando.manyToMany.services.CategoryService;
import com.armando.manyToMany.services.ProductService;

@Controller
public class MainController {
	
	private final ProductService productService;
	private final CategoryService catService;
	
	public MainController(ProductService productService, CategoryService catService) {
		this.productService = productService;
		this.catService = catService;
	}
	
	// PRODUCT ROUTES
	
	@RequestMapping("/product")
	public String indexProduct(Model model) {
		List<Product> product = productService.allProducts();
		model.addAttribute("product", product);
		return "/Product/index.jsp";
	}
	
    @RequestMapping("/product/new")
    public String newProduct(Model model) {
    	model.addAttribute("product", new Product());
        return "/Product/new.jsp";
    }
    
    @RequestMapping(value="/product", method=RequestMethod.POST)
    public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
    	System.out.println("Inside createProduct()");
    	if (result.hasErrors()) {
    	  System.out.println("Erros encountered in creating product");
          return "/Product/new.jsp";
    	} else {
          productService.createProduct(product);
          System.out.println(product + " Created succesfully!");
          // get new product id to redirect to that product show page
          return "redirect:/product";
    	}
    }
  
    @RequestMapping("/product/{id}")
    public String showProduct(@PathVariable("id") Long id, Model model) {
	  Product product = productService.findProduct(id);
	  model.addAttribute("product", product);
	  
	  // get all product categories
	  List<Category> productCats = product.getCategories();
	  model.addAttribute("productCats", productCats);
	  
	  return "/Product/show.jsp";
    }
  
    // CATEGORY ROUTES
  
	@RequestMapping("/cat")
	public String indexCat(Model model) {
		List<Category> cat = catService.allCategories();
		model.addAttribute("cat", cat);
		return "/Category/index.jsp";
	}
	
	@RequestMapping("/cat/new")
	public String newCat(Model model) {
		model.addAttribute("cat", new Category());
		return "/Category/new.jsp";
	}
	  
	@RequestMapping(value="/cat", method=RequestMethod.POST)
	public String createCat(@Valid @ModelAttribute("cat") Category cat, BindingResult result) {
		if (result.hasErrors()) {
	        return "/Category/new.jsp";
	    } else {
	        catService.createCategory(cat);
	        return "redirect:/cat";
	    }
	}
	
	@RequestMapping("/cat/{id}")
	public String showCat(@PathVariable("id") Long id, Model model) {
		  Category cat = catService.findCategory(id);
		  model.addAttribute("cat", cat);
		  
		  // get all products
		  List<Product> products = productService.allProducts();
		  model.addAttribute("products", products);
		  
		  // get all products that are from this category
		  List<Product> myCatProducts = cat.getProducts();
		  model.addAttribute("myCatproducts", myCatProducts);
		  
		  return "/Category/show.jsp";
	}
	
	// CONNECT PRODUCT TO CATEGORY
	
	@RequestMapping(value="/product/addCat", method=RequestMethod.POST)
	public String addCat(
			@RequestParam(value="product_id") Long product_id, 
			@RequestParam(value="category_id") Long category_id) {
		return "redirect:/products";
	}

}
