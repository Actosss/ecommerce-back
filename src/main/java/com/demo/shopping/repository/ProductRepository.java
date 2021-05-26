package com.demo.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.shopping.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
