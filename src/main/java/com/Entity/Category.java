package com.Entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="type", nullable=false)
	private String type;
	
	@Column(name="company_name", nullable=false)
    private String companyName;
	
	@OneToMany(mappedBy="category", cascade=CascadeType.ALL)
	@JsonIgnoreProperties("category")
	private Set<Product> products;
	
	

	public Category() {
		super();
	}
	public Category(long id, String type, String companyName, Set<Product> products) {
		super();
		this.id = id;
		this.type = type;
		this.companyName = companyName;
		this.products = products;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getCompanyName() {
		return companyName;
	}
	public void setCompany_name(String companyName) {
		this.companyName = companyName;
	}

	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
}