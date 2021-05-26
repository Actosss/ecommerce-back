package com.demo.shopping.model;
import java.math.BigDecimal;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
}
