package com.demo.shopping.model;


import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private BigDecimal grandTotal;	
	@JsonManagedReference 
	@OneToMany(mappedBy="cart", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<CartItem> cartItem;	
	@JsonBackReference
	@OneToOne(mappedBy="cart", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private User user;	
 }
