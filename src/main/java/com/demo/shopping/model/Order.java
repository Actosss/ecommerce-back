package com.demo.shopping.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "total_price")
    private Double totalPrice;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
