package com.crud.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
@Document
public class Product {

	public static List<Product> products = new ArrayList<Product>();

	@Id
	private String id;

	@NotEmpty(message = "product name must not be empty")
//	@Column(nullable = false)
	private String productName;

	@NotEmpty(message = "brand must not be empty")
//	@Column(nullable = false)
	private String brand;

	@Min(value = 1, message = "quantity must be equal or greater than {value}")
	@NotNull(message = "quantity must not be empty")
//	@Column(nullable = false)
	private int quantity;

	@Min(value = 100, message = "list price must be equal or greater than {value}")
	@NotNull(message = "list price must not be empty")
//	@Column(nullable = false)
	private double listPrice;

	@Min(value = 100, message = "our price must be equal or greater than {value}")
	@NotNull(message = "our price must not be empty")
//	@Column(nullable = false)
	private double ourPrice;

	@NotNull(message = "please select a category")
	private String category;

	@NotEmpty(message = "description must not be empty")
//	@Column(length = 10000)
	private String description;

	public Product() {

		this.id = UUID.randomUUID().toString();

	}

	public Product(String id, String pname, String brand, int quantity, double lprice, double oprice, String desc) {

		this.id = id;
		this.productName = pname;
		this.brand = brand;
		this.listPrice = lprice;
		this.ourPrice = lprice;
		this.description = desc;
		this.quantity = quantity;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getListPrice() {
		return listPrice;
	}

	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}

	public double getOurPrice() {
		return ourPrice;
	}

	public void setOurPrice(double ourPrice) {
		this.ourPrice = ourPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", brand=" + brand + ", quantity=" + quantity
				+ ", listPrice=" + listPrice + ", ourPrice=" + ourPrice + ", description=" + description + "]";
	}

}
