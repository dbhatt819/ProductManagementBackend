package com.productmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productmanagement.model.Product;
import com.productmanagement.service.ProductService;

@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping(value="/getAllProducts", method=RequestMethod.GET)
	public List<Product> retrieveProducts(){
		return productService.getAllProducts();
	}
	
	@RequestMapping(value="/addProducts", method=RequestMethod.POST)
	public Product addProduct(@RequestParam(name="name",required=true) String name, @RequestParam(name="description",required=true) String description,@RequestParam(name="price",required=true) String price){
		Product product = new Product();
		product.setName(name);
		product.setDescription(description);
		product.setPrice(Double.parseDouble(price));
		return productService.addProduct(product);
	}
	
	@RequestMapping(value="/editProducts/{id}", method=RequestMethod.PUT)
	public Product editProduct(@PathVariable Long id, @RequestParam(name="name",required=true) String name, @RequestParam(name="description",required=true) String description,@RequestParam(name="price",required=true) String price){
		Product product = new Product();
		product.setName(name);
		product.setDescription(description);
		product.setPrice(Double.parseDouble(price));
		return productService.editProduct(product, id);
	}
	
}
