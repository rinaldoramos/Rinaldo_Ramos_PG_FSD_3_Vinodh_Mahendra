package com.simplilearn.workshop;

import java.util.Date;

public class Report {
	
	private int id;
	private String category;
	private String brand;
	private String product_name;
	private double price;
	private Date purchase_date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}
	@Override
	public String toString() {
		return "Report [id=" + id + ", category=" + category + ", brand=" + brand + ", product_name=" + product_name
				+ ", price=" + price + ", purchase_date=" + purchase_date + "]";
	}
}
