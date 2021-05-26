package com.demo.shopping.service;

import java.util.List;

import com.demo.shopping.model.Product;
import com.demo.shopping.model.User;

public interface AdminService {
	Product addProduct(Product product);
	List<Product> getAllProducts();
	Product getProductById(Long id);
	List<User> getAllUsers();
	User getUserById(Long id);
}
