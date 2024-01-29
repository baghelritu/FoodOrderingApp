package com.food.entity;

public class Cart {
	
	private String cartId;
	private String foodId;
	private String customerId;
	private Integer quantity;//the number of item added to cart
	private Double price;//price * quantity
	private Double subTotal;//food price
	private Food f;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(String cartId, String foodId, String customerId, Integer quantity, Double price, Double subTotal) {
		super();
		this.cartId = cartId;
		this.foodId = foodId;
		this.customerId = customerId;
		this.quantity = quantity;
		this.price = price;
		this.subTotal = subTotal;
		this.f=f;
	}
	
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", foodId=" + foodId + ", customerId=" + customerId + ", quantity="
				+ quantity + ", price=" + price + ", subTotal=" + subTotal + ", f=" + f + "]";
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public String getFoodId() {
		return foodId;
	}

	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Food getF() {
		return f;
	}

	public void setF(Food f) {
		this.f = f;
	}
	
       
}
	


