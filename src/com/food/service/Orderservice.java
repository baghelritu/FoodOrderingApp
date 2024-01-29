package com.food.service;

import java.util.List;

import com.food.entity.Order;

public interface Orderservice {
	
	public Order placeOrder(Order o);
	public boolean cancelOrder(String orderId);
	
	public List<Order> showMyOrderHistory(String customerId);
	public Order showOrderById(String oderId);

}
