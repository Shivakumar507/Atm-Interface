package com.atmapp.model;

public class Customer {
	int Customer_id;
    String Customer_name;
    String Pin;
    
    
	public Customer(int customer_id, String customer_name, String pin) {
		super();
		this.Customer_id = customer_id;
		this.Customer_name = customer_name;
		this.Pin = pin;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCustomer_id() {
		return Customer_id;
	}
	public void setCustomer_id(int customer_id) {
		Customer_id = customer_id;
	}
	public String getCustomer_name() {
		return Customer_name;
	}
	public void setCustomer_name(String customer_name) {
		Customer_name = customer_name;
	}
	public String getPin() {
		return Pin;
	}
	public void setPin(String pin) {
		Pin = pin;
	}
    
    
    
    
}
