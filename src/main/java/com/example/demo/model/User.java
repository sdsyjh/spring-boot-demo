package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class User{
	private int id;
	private String name;
	private List<Order> orders=new ArrayList<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", orders=" + orders + "]";
	}

}
