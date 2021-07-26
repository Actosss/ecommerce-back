package com.demo.shopping.controller;
import java.util.List;
import java.util.Optional;

import com.demo.shopping.service.CartService;
import com.demo.shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.demo.shopping.model.Cart;
import com.demo.shopping.model.CartItem;
import com.demo.shopping.model.Product;
import com.demo.shopping.model.User;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/user")
public class UserController {
	@Autowired
	private CartService cartService;
	@Autowired 
	private UserService userService;
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@RequestMapping(value = "/cart/{id}", method = RequestMethod.GET)
	public Cart getCartByUserId(@PathVariable Long id ) {
		return userService.getCartByUserId(id);
	}
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public Product getProductById(@PathVariable Long id ) {
		return userService.getProductById(id);
	}
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@RequestMapping(value = "/getCartByUserId/{id}", method = RequestMethod.GET)
	public Cart updateCart(@PathVariable Long id  ) {
		return cartService.getCartByUserId(id);
	}
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@RequestMapping(value = "/userProfile/{id}", method = RequestMethod.GET)
	public Optional<User> getUserById(@PathVariable Long id ) {
		return userService.getUserById(id);
	}
//	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@RequestMapping(value = "/addCartItem{cartId}{productId}", method = RequestMethod.POST	)
	public List<CartItem> addCartItem(@RequestParam Long cartId ,
									  @RequestParam Long productId) {
		return cartService.addCartItem(cartId ,productId);
	}
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@RequestMapping(value = "/deleteById/{cartId}/conf/{cartItemId}", method = RequestMethod.DELETE)
	public  Optional<Cart> deleteById(@PathVariable Long cartId, @PathVariable Long cartItemId) {
		return cartService.deleteById(cartId,cartItemId);
	}
}
