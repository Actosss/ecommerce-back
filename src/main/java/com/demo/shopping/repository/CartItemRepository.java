package com.demo.shopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.shopping.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{

	CartItem findByCartId(Long id);
	List<CartItem> findAllByCartId(Long id);

}
