package com.food.ui;

import java.util.Iterator;

import java.util.List;
import java.util.Scanner;

import com.food.entity.Food;
import com.food.service.FoodServiceImpl;
public class FoodUi {

	public static void main(String[] args) {
		
		 Scanner sc=new Scanner(System.in);
		 String foodId;
		 String foodName;
		 String type; // veg or non-veg 
		 String category;// breakfast, south Indian, desert, Chinese
		 Double price;
		 Integer quantityInStock;
		 Boolean flag;	
		 
		 Food f=null;
		 FoodServiceImpl fimpl=new FoodServiceImpl();
		 List<Food> flist=null;
		 
		System.out.println("*****Food Page********");
		while(true) {
			System.out.println("Enter the number as given in menu:-");
			System.out.println("Enter 1---> Add Food item");
			System.out.println("Enter 2---> Update Food item");
			System.out.println("Enter 3---> Delete Food item");
			System.out.println("Enter 4---> Show all Food items");
			System.out.println("Enter 5---> Search Food item on this basis of type");
			System.out.println("Enter 6---> Search Food item on the basis of category");
			
			Integer option =sc.nextInt();
			sc.nextLine();
			
			
			switch(option) {
			
			case 1:
				
				int min = 100;  
				int max = 400; 				
				int b = (int)(Math.random()*(max-min+1)+min);
				
				foodId="F"+b;
				
				
				System.out.print("Enter the food name: ");
				foodName=sc.nextLine();
				
				System.out.println("Provide type of this food item: ");
			    System.out.println("Enter v for veg or nv for non-veg");
			    String t=sc.nextLine();
			    
			    if(t.equalsIgnoreCase("v")) {
			    	type="veg";
			    }
			    else if(t.equalsIgnoreCase("nv")) {
			    	type="non-veg";
			    }
			    else {
			    	System.out.println("Please eneter v or nv as per the type");
			    	type="data unavailable";
			    }
			    System.out.println("Enter category: \n1: breakfast\n2: starters\n3: chinese\n4: desserts\n5: main course");
			    int choice=sc.nextInt();
			    sc.nextLine();
			    
			    switch(choice) {
			    case 1: category="breakfast";
			    break;
			    
			    case 2:category="starters";
			    break;
			    
			    case 3:category="chinese";
			    break;
			    
			    case 4:category="desserts";
			    break;
			    
			    case 5:category="main course";
			    break;
			    
			    default: System.out.println("Please enter only those numbers as given in"+ "category menu");
			    category="data unavailable";
			    } 
			    
			    System.out.print("Enter price: ");
			    price=sc.nextDouble();
			    sc.nextLine();
			    
			    System.out.print("Quantity in stock: ");
			    quantityInStock=sc.nextInt();
			    sc.nextLine();
			    
			    f=new Food(foodId, foodName, type, category, price, quantityInStock);
			    
			    flag=fimpl.addFood(f);
			    if(flag)
			    	System.out.println("Food details added to database");
			    else
			    	System.out.println("Error while adding food details..");
				break;
				
			case 2:
				System.out.print("Enter the id of food you want to update: ");
				foodId=sc.nextLine();
				
				f=fimpl.getFoodById(foodId);
				
				if(f!=null) {
					
					System.out.println(f);
					System.out.println("Are you sure you want to update this food item?"
						+ "\nAnsure in yes or no");
					
					String ans=sc.next();
					sc.nextLine();
					
					if(ans.equalsIgnoreCase("yes")){
						
						System.out.println("What do you want update?");
						System.out.println("Enter a---> update name");
						System.out.println("Enter b---> update type");
						System.out.println("Enter c---> update category");
						System.out.println("Enter d---> update price");
						System.out.println("Enter e---> update quantity");
						
						char choice2=sc.next().toLowerCase().charAt(0);
						sc.nextLine();
						
						switch(choice2) {
						case 'a':
							System.out.print("Enter name");
							foodName=sc.nextLine();
							f.setFoodName(foodName);
							
							flag=fimpl.updateFood(f);
							if(flag)
								System.out.println("Food name update successfully !!");
							else
								System.out.println("Error while updateing food name !!");
							break;
							
						case 'b':
							System.out.println("Provide type of this food item: ");
							System.out.println("Enter v for veg or nv for non-veg");
							t=sc.nextLine();
							
							if(t.equalsIgnoreCase("v")) {
								
								type="veg";
							}
							else if(t.equalsIgnoreCase("nv")) {
								type="non-veg";
							}
							else {
								System.out.println("Please enter v or nv as per the type");
								type="data unavailable";
							}
							f.setType(type);
							
							flag=fimpl.updateFood(f);
							if(flag)
								System.out.println("Food type updated successfully!!");
							else
								System.out.println("Error while updating food type!!");
							break;
							
						case 'c':
						    System.out.println("Enter category: \n1: breakfast\n2: starters\n3: chinese\n4: desserts\n5: main course");
						     choice=sc.nextInt();
						    sc.nextLine();
						    
						    switch(choice) {
						    case 1: category="breakfast";
						    break;
						    
						    case 2:category="starters";
						    break;
						    
						    case 3:category="chinese";
						    break;
						    
						    case 4:category="desserts";
						    break;
						    
						    case 5:category="main course";
						    break;
						    
						    default: System.out.println("Please enter only those numbers as given in"+ "category menu");
						    category="data unavailable";
						    } 
						    f.setCategory(category);
						    flag=fimpl.updateFood(f);
						    
						    if(flag)
						    	System.out.println("Food name update successfully !!");
							else
								System.out.println("Error while updateing food name !!");
							break;
							
						case 'd':
							System.out.print("Enter price: ");
							price=sc.nextDouble();
							sc.nextLine();
							
							f.setPrice(price);
							flag=fimpl.updateFood(f);
							
							if(flag)
								System.out.println("Food price updated successfully!!");
							else
								System.out.println("Error while updating food price!!");
							break;
							
						case 'e':
							System.out.print("Quantity in stock: ");
							quantityInStock=sc.nextInt();
							sc.nextLine();
							
							f.setQuantityInStock(quantityInStock);
							flag=fimpl.updateFood(f);
							
							if(flag)
								System.out.println("Food quantity updated successfully!!");
							else
								System.out.println("Error while updating food quantity!!");
							break;
							
							default:System.out.println("Please enter characters as mentioned in update menu");
							
						}
					}
					else if(ans.equalsIgnoreCase("no")) {}
					else
						System.out.println("Please answer in yes or no only. Going back to main menu");
				}
				else
					System.out.println("No food item with this id found. Please check id given....");
							break;
			case 3:
				System.out.println("Enter the foodID of the you want to delete: ");
				foodId=sc.nextLine();
				f=fimpl.getFoodById(foodId);
				
				if(f!=null) {
					System.out.println("***Food Details***");
					System.out.println(f);
					
					System.out.println("Are you sure you want to update this food item?"
						+ "\nAnsure in yes or no");
					
					String ans=sc.next();
					sc.nextLine();
					
					if(ans.equalsIgnoreCase("yes")) {
						flag=fimpl.deleteFood(foodId);
						
						if(flag)
							System.out.println("Food delete successfully");
						else
							System.out.println("Error while delteing food item");
						
					}
					else if(ans.contentEquals("no"))
						System.out.println("Thank you continue browsing...");
					else
						System.out.println("please answer in yes or no only!! Going back to main manu!!!");
				}
				else
					System.out.println("No food item with this id found!!");
				
				break;
				
			case 4:
				flist=fimpl.showAllFood();
				if(flist!=null && flist.isEmpty()!=true) {
					
					Iterator<Food> it=flist.iterator();
					
					while(it.hasNext()) {
						System.out.println(it.next());
						System.out.println("__________________________________________\n");
					}
				}
				else
				System.out.println("No data available for food details at this moment..");
				break;
				
				
			case 5:
				System.out.println("");
				break;
				
			case 6:
				System.out.println("");
				break;
				
			default:System.out.println("Please enter only those numbers as mentioned in start menu");
				
				
			
			}
		}
	}
}

