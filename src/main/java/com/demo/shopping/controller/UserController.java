package com.demo.shopping.controller;
import java.util.List;

import com.demo.shopping.service.CartService;
import com.demo.shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.demo.shopping.model.Cart;
import com.demo.shopping.model.CartItem;
import com.demo.shopping.model.Product;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/user")
public class UserController {
	@Autowired
	private CartService cartService;
	@Autowired 
	private UserService userService;
	@PreAuthorize("hasRole('USER')")
	@RequestMapping(value = "/cart/{id}", method = RequestMethod.GET)
	public Cart getCartByUserId(@PathVariable Long id ) {
		return userService.getCartByUserId(id);
	}
	@PreAuthorize("hasRole('USER')")
	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	public CartItem addCartItem(@RequestBody CartItem cartItem) { 
		return cartService.addCartItem(cartItem);
	} 
	@PreAuthorize("	hasRole('ADMIN')")
	@RequestMapping(value = "/allCartItemsByCartId/{id}", method = RequestMethod.GET)
	public List<CartItem> getCartItemsByCartId(@PathVariable Long id) {
		return cartService.getCartItemsByCartId(id);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/getCartByUserId/{id}", method = RequestMethod.GET)
	public Cart updateCart(@PathVariable Long id  ) {
		return cartService.getCartByUserId(id);
	}
	@PreAuthorize("hasRole('USER')")
	@RequestMapping(value = "/cartItem/{id}", method = RequestMethod.GET)
	public CartItem getCartItemByCartId(@PathVariable Long id ) {
		return cartService.getByCartId(id);
	}
	@PreAuthorize("hasRole('USER')")
	@RequestMapping(value = "/allProducts", method = RequestMethod.GET)
	public List<Product> getAllProducts() {
		return userService.getAllProducts();
	}
	@PreAuthorize("hasRole('USER')")
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public Product getProductById(@PathVariable Long id ) {
		return userService.getProductById(id);
	}
}
