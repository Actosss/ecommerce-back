package com.demo.shopping.service.impl;
import java.util.List;

import com.demo.shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.shopping.model.Cart;
import com.demo.shopping.model.Product;
import com.demo.shopping.model.User;
import com.demo.shopping.repository.CartRepository;
import com.demo.shopping.repository.ProductRepository;
import com.demo.shopping.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
  	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ProductRepository productRepository;
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	@Override
	public User getUserById(Long id) {
		return userRepository.getOne(id);
	}
	@Override
	public Cart getCartByUserId(Long id) {
		return cartRepository.findByUserId(id);
	}
	@Override
	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username).orElse(null);
	}
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	@Override
	public Product getProductById(Long id) {
		return productRepository.getOne(id);
	}

}
