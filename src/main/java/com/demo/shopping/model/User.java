package com.demo.shopping.model;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable = false, updatable = false)
	private Long id;
	private String firstname;
	private String lastname;
	@Column(name="email", nullable = false, updatable = false)
	private String email;
	private String phone;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cart_id")
	@JsonBackReference 
	private Cart cart;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
							 inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	User() {
		
	}
	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
}
