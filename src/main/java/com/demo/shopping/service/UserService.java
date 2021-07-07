package com.demo.shopping.service;

import java.util.List;
import java.util.Optional;

import com.demo.shopping.model.Cart;
import com.demo.shopping.model.Product;
import com.demo.shopping.model.User;

public interface UserService {

	List<User> getAllUsers();
	Optional<User> getUserById(Long id);
	Cart getCartByUserId(Long id);

	User saveUser(User user);
    User findByUsername(String username);

	List<Product> getAllProducts();
	Product getProductById(Long id);
	User getUserByEmail(String email);
}
