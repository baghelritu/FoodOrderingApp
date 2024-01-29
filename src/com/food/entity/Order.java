package com.food.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

/*
 * we can have cartlist  in this class so as to know what has to be deliverd to each customer.
 * Mapping of list type collection with mysql is easy with hibernate. since we 
 */

public class Order {
	private String orderId;
	private LocalDate orderDate;
	private String dropLocation;
	private LocalDateTime expectedDelivery;
	private String customerId;
	private Double billingAmount;
	private String status;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String orderId, LocalDate orderDate, String dropLocation, LocalDateTime expectedDelivery,
			String customerId, Double billingAmount, String status) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.dropLocation = dropLocation;
		this.expectedDelivery = expectedDelivery;
		this.customerId = customerId;
		this.billingAmount = billingAmount;
		this.status = status;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public String getDropLocation() {
		return dropLocation;
	}
	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}
	public LocalDateTime getExpectedDelivery() {
		return expectedDelivery;
	}
	public void setExpectedDelivery(LocalDateTime expectedDelivery) {
		this.expectedDelivery = expectedDelivery;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Double getBillingAmount() {
		return billingAmount;
	}
	public void setBillingAmount(Double billingAmount) {
		this.billingAmount = billingAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
