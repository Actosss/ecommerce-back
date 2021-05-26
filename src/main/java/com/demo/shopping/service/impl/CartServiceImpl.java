package com.demo.shopping.service.impl;

import java.util.List;

import com.demo.shopping.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.shopping.model.Cart;
import com.demo.shopping.model.CartItem;
import com.demo.shopping.repository.CartItemRepository;
import com.demo.shopping.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartItemRepository cartItemRepository;
	@Autowired
	private CartRepository cartRepository;
	@Override
	public CartItem getByCartId(Long id) {
		return cartItemRepository.findByCartId(id);
	}
	@Override
	public CartItem addCartItem(CartItem cartItem) {
		return cartItemRepository.save(cartItem);
	}
	@Override
	public List<CartItem> getCartItemsByCartId(Long id) {
		return cartItemRepository.findAllByCartId(id);
	}
	@Override
	public Cart getCartByUserId(Long id) {
		return cartRepository.findByUserId(id);
	}
}
