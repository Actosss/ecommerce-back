package com.demo.shopping.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name="cartItem")
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private int quantity;
	@Column
	private BigDecimal totalPrice;
	@OneToOne
	private Product product;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="cart_id")
	private Cart cart;
}
