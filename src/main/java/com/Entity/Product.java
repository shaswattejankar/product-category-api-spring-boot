package com.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name", nullable=false)
	private String name;
	@Column(name="price",nullable = false)
	private float price;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonIgnoreProperties("products")
	private Category category;


	public Product() {
		super();
	}
	public Product(long id, String name, float price, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
	}
	
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public float getPrice() {
		return price;
	}
	public Category getCategory() {
		return category;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}