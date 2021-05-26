package com.demo.shopping.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.shopping.model.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{

	List<Cart> getByUserId(Long id);
	Cart findByUserId(Long id);
}
