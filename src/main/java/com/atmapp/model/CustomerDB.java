package com.atmapp.model;

public class CustomerDB {
	 int CustomerId;
	    String CustomerName;
	    String address;
	    double availableBalance;
	    String Pin;
	    
		public CustomerDB(String customerId, String customerName, String address, double availableBalance, String pin) {
			super();
			this.address = customerId;
			this.CustomerName = customerName;
			this.address = address;
			this.availableBalance = availableBalance;
			this.Pin = pin;
		}
		public CustomerDB() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getCustomerId() {
			return CustomerId;
		}
		public void setCustomerId(int customerId) {
			CustomerId = customerId;
		}
		public String getCustomerName() {
			return CustomerName;
		}
		public void setCustomerName(String customerName) {
			CustomerName = customerName;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public double getAvailableBalance() {
			return availableBalance;
		}
		public void setAvailableBalance(double availableBalance) {
			this.availableBalance = availableBalance;
		}
		public String getPin() {
			return Pin;
		}
		public void setPin(String pin) {
			Pin = pin;
		}
	    
	    
	    
	    
}
