package com.demo.shopping.service;

import java.util.List;

import com.demo.shopping.model.Cart;
import com.demo.shopping.model.CartItem;

public interface CartService  {
	CartItem getByCartId(Long id);
	CartItem addCartItem(CartItem cartItem);
	List<CartItem> getCartItemsByCartId(Long id);
	Cart getCartByUserId(Long id);
}
