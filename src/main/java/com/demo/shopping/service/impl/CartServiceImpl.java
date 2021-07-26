package com.demo.shopping.service.impl;

import java.util.List;
import java.util.Optional;

import com.demo.shopping.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.shopping.model.Cart;
import com.demo.shopping.model.CartItem;
import com.demo.shopping.model.Product;
import com.demo.shopping.repository.CartItemRepository;
import com.demo.shopping.repository.CartRepository;
import com.demo.shopping.repository.ProductRepository;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartItemRepository cartItemRepository;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ProductRepository productRepository;
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
	@Override
	public List<CartItem> addCartItem(Long cartId, Long productId) {
		CartItem cartItem= new CartItem();
		Cart cart = cartRepository.findById(cartId).get();
		Product product = productRepository.findById(productId).get();
		cartItem.setProduct(product);
		cartItem.setCart(cart);
		cartRepository.save(cartItem);
		cartItem.setQuantity(1);
		cartRepository.save(cartItem);
		return cartItemRepository.findAllByCartId(cartId);
	}
	@Override
	public Optional<Cart> deleteById(Long cartId,Long cartItemId) {
		cartItemRepository.deleteById(cartItemId);
		return cartRepository.findById(cartId);
	}
}
