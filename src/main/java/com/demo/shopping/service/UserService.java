package com.demo.shopping.service;

import java.util.List;

import com.demo.shopping.model.Cart;
import com.demo.shopping.model.Product;
import com.demo.shopping.model.User;

public interface UserService {
	//Admin Service
	List<User> getAllUsers();
	User getUserById(Long id);
	Cart getCartByUserId(Long id);
	//Authentication Service
	User saveUser(User user);
    User findByUsername(String username);
    //Products
	List<Product> getAllProducts();
	Product getProductById(Long id);
}
