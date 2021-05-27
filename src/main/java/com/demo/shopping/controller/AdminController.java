package com.demo.shopping.controller;
import java.util.List;

import com.demo.shopping.service.AdminService;
import com.demo.shopping.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.shopping.model.Cart;
import com.demo.shopping.model.Product;
import com.demo.shopping.model.User;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired 
	private CartService cartService;
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public Product addProduct(@RequestBody Product product) {
		return adminService.addProduct(product);
	}
	@PreAuthorize("hasRole('ADMIN')") 
	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return adminService.getAllUsers();
	}
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable Long id ) {
		return adminService.getUserById(id);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/getCartByUserId/{id}", method = RequestMethod.GET)
	public Cart updateCart(@PathVariable Long id  ) {
		return cartService.getCartByUserId(id);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/allProducts", method = RequestMethod.GET)
	public List<Product> getAllProducts() { 
		return adminService.getAllProducts();
	}
}