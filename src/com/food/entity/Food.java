package com.food.entity;

public class Food {

	private String foodId;
	private String foodName;
	private String type; // veg or non-veg 
	private String category;// breakfast, south Indian, desert, Chinese
	private Double price;
	private Integer quantityInStock;
	public Food() {
	
	}
	
	public Food(String foodId, String foodName, String type, String category, Double price, Integer quantityInStock) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.type = type;
		this.category = category;
		this.price = price;
		this.quantityInStock = quantityInStock;
	}


	public String getFoodId() {
		return foodId;
	}
	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(Integer quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", foodName=" + foodName + ", type=" + type + ", category=" + category
				+ ", price=" + price + ", quantityInStock=" + quantityInStock + "]";
	}
	
}
