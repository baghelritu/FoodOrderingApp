package com.food.service;
 
import java.util.List;

import com.food.entity.Food;
 
public interface FoodService {

	public boolean addFood(Food f);
	public boolean updateFood(Food f);
	public boolean deleteFood(String FoodId);
	
	public Food getFoodById(String foodId);
	public List<Food> showAllFood();
	public List<Food> getFoodByCategory(String category);
	public List<Food> getFoodByType(String type);
	
}



