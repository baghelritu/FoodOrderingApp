package com.food.service;

import java.util.List;

import com.food.entity.Cart;

public interface CartService {
	
	public boolean addToCart(Cart c);
	public boolean updateQuantity(String cartId, Integer quantity);
	public boolean deleteFoodItemFromCart(String cartId);
	public boolean clearMyCart(String customerId);
	
	public List<Cart> showMyCart(String customerId); 
	public List<Cart> showAllCart(); 
    public Cart getCartById(String cartId);
    public boolean checkFoodItem(String customerId, String foodId);
}
