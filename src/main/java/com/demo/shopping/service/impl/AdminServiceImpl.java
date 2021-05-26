package com.demo.shopping.service.impl;

import java.util.List;

import com.demo.shopping.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.shopping.model.Product;
import com.demo.shopping.model.User;
import com.demo.shopping.repository.ProductRepository;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private ProductRepository productRepository;
	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	@Override
	public Product getProductById(Long id) {
		return productRepository.getOne(id);
	}
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
