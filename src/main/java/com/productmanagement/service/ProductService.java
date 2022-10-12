package com.productmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productmanagement.exception.ProductNotFoundException;
import com.productmanagement.model.Product;
import com.productmanagement.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product editProduct(Product product, Long id) {
		Product productData = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Could not find product by Id:" + id));
		productData.setName(product.getName());
		productData.setDescription(product.getDescription());
		productData.setPrice(product.getPrice());
		return productRepository.save(productData);
	}
}
