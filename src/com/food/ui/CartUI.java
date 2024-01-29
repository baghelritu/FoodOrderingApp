package com.food.ui;

import java.util.List;
import java.util.Scanner;
import com.food.service.*;
import com.food.entity.Cart;
import com.food.entity.Customer;
import com.food.entity.Food;
import com.food.service.FoodServiceImpl;


public class CartUI {

	public static void main(String[] args) {
		 String cartId;
		 String foodId;
		 String customerId;
		 Integer quantity;//the number of item added to cart
		 Double price;//price * quantity
		 Double subTotal;//food price
		 Food f;
		 int option;
		 Boolean flag;
		 String ans;
		 
		 Scanner sc=new Scanner(System.in);
		 Cart c=null;
		 CartService cimpl=new CartServiceImpl();
	     List<Cart> clist=null;
	     
		 
	     while(true) {
				System.out.println("\n\n****************Welcome to Anudip Food Ordering App****************");
				System.out.print("\nEnter your username i.e your id: ");
				String username=sc.nextLine().trim();
				
				System.out.print("Enter password: ");
				String password=sc.nextLine();
				
				String login=new LoginUI().login(username, password);
				
				if(login==null)
					System.out.println("Username or password given is wrong. Please login again");
				
				else if(login.equals("customer")) {
					/*
					 * fetching the customer object from the database by using the
					 * showCustomerById method of CustomerServiceImpl
					 */
					Customer cust=new CustomerServiceImpl().showCustomerById(username);
					
					System.out.println("Welcome to our website "+cust.getCustName());
					boolean logout=false;
					
					while(logout==false) {
						
						System.out.println("\nEnter the number as given in options..");
						System.out.println("Enter 1----> Add to cart");
						System.out.println("Enter 2----> Show my cart");
						System.out.println("Enter 3----> Update quantity of food item");
						System.out.println("Enter 4----> Delete food item from cart");
						System.out.println("Enter 5----> Clear my cart");
						System.out.println("Enter 6----> See order menu");
						System.out.println("Enter 7----> Logout");
						
						option=sc.nextInt();
						sc.nextLine();
		 
						switch(option) {
						case 1:
							
							int min = 100;  
							int max = 400; 				
							int b = (int)(Math.random()*(max-min+1)+min);
							
							cartId="CA"+b;
							
							
							List<Food> flist=new FoodServiceImpl().showAllFood();
							System.out.println("\nFood name and food id shown below...");
							for(Food f1:flist) {
								
								System.out.println(f1.getFoodName()+" : "+f1.getFoodId());
							}
							System.out.print("\nEnter the food id: ");
							foodId=sc.nextLine();
							
							customerId=username;
									
							flag=cimpl.checkFoodItem(customerId, foodId);
							
							if(flag)
								System.out.println("Item was already prsent in your cart."
							+"Quantity has been increased by 1");
							
							else {
							
							quantity=1;
							price=new FoodServiceImpl().getFoodById(foodId).getPrice();
							
							subTotal=quantity*price;
							
							c=new Cart(cartId, foodId, customerId, quantity, price, subTotal);
							
							flag=cimpl.addToCart(c);
							if(flag)
								System.out.println("Food item added to cart successfully!!!");
							else
								System.err.println("Error while adding food item to cart!!!");
							}
							break;
							
						case 2:
							
							customerId=username;
							clist=cimpl.showMyCart(customerId);
							
							if(clist!=null && clist.isEmpty()!=true) {
								System.out.println("*********Your cart details**********");
								
								Double grandTotal=0.0;
								
								for(Cart cart: clist)
										{
										System.out.println("Cart id: "+cart.getCartId());
										System.out.println("Item added: "+cart.getF().getFoodName());
										System.out.println("Quantity in cart: "+cart.getQuantity());
										System.out.println("Price of single item: "+cart.getPrice());
										System.out.println("SubTotal: "+cart.getSubTotal());
										
										grandTotal+=cart.getSubTotal();
								        System.out.println("___________________");
										}
										
								System.out.println("Grand Total= "+grandTotal);
								
								System.out.println("Do you want to go to order page? \n Answer in yes or no..");
								ans=sc.nextLine();
								
								if(ans.equalsIgnoreCase("yes")) {
									new OrderUI().OrderManu(customerId, clist);
								
								}
								else if(ans.equalsIgnoreCase("no")) 
									
									System.out.println("Thank you for you input. continue browsing...");
								else
									System.out.println("Please answer in yes or no only!! Going back to main manu");
					        }
							else
								System.out.println("Your cart is empty. Please add to cart first...");
							break;
							
							
						case 3:
							System.out.println("Enter the cart id: ");
							cartId=sc.nextLine();
							
							c=cimpl.getCartById(cartId);
							if(c!=null) {
								System.out.println("Cart id: "+c.getCartId());
								System.out.println("Item added: "+c.getF().getFoodName());
								System.out.println("Quantity in cart: "+c.getQuantity());
								System.out.println("Price of single item: "+c.getPrice());
								System.out.println("Subtotal: "+c.getSubTotal());
								
								System.out.println("Enter new quantity: ");
								quantity=sc.nextInt();
								sc.nextLine();
								
								if(quantity>0) {
									
								flag=cimpl.updateQuantity(cartId, quantity);
								
								if(flag)
									System.out.println("Quantity updated successfully!!!");
								else
									System.out.println("Error while changing quantity!!!");
								}
								else
									System.out.println("Please give a number greater than 0 for quantity!!!");
							}
							
							break;
							
						case 4:
							System.out.println("Enter cartId of item to be delete: ");
							cartId=sc.nextLine();
							
							System.out.println("Are you sure you want to delete this item?"+"\nAnswer in yes or no");
							ans=sc.nextLine();
							
							if(ans.equalsIgnoreCase("yes")) {
								
								flag=cimpl.deleteFoodItemFromCart(cartId);
								if(flag)
									System.out.println("Item delete from cart successfully");
								else
									System.out.println("Error while deleteing item.");
							}
							else if(ans.equalsIgnoreCase("no"))
								System.out.println("Thank you for input. please continue browsing...");
							else
								System.out.println("Answer in yes or no only. Going back to main manu...");
							break;
							
						case 5:
							customerId=username;
							
							System.out.println("Are you sure you want to  clear your cart?"+"\nAnswer in yes or no");
							ans=sc.nextLine();
							
							if(ans.equalsIgnoreCase("yes")) {
								
								flag=cimpl.clearMyCart(customerId);
								if(flag)
									System.out.println("Your cart is now empty!!!");
								else
									System.out.println("Error while clearing item.");
							}
							else if(ans.equalsIgnoreCase("no"))
								System.out.println("Thank you for input. please continue browsing...");
							else
								System.out.println("Answer in yes or no only. Going back to main manu...");
							break;
							
						case 7:
							logout=true;
							System.out.println("Thank you for using our service. Visit again soon!!!");
							break;
							
						case 6:	
							customerId=username;
							clist=cimpl.showMyCart(customerId);
							
							new OrderUI().OrderManu(customerId, clist);
							
							break;
							default:System.out.println("Please give input as per the options given");
						}
					}
				}
				else if(login.equals("admin")) {
					
					System.out.println("You have logged in as admin");
					
                    boolean logout=false;
					
					while(logout==false) {
					System.out.println("\nEnter the number as given in options....");
					System.out.println("Enter 1----> Show all cart items");
					System.out.println("Enter 2----> Show cart by id");
					System.out.println("Enter 3----> Logout");
					
					option=sc.nextInt();
					sc.nextLine();
					
					switch(option) {
					
					case 1:
						clist=cimpl.showAllCart();
						if(clist!=null && clist.isEmpty()!=true) {
							for(Cart cart: clist)
							{
							System.out.println("Cart id: "+cart.getCartId());
							System.out.println("Customer id:"+cart.getCustomerId());
							System.out.println("Item added: "+cart.getF().getFoodName());
							System.out.println("Quantity in cart: "+cart.getQuantity());
							System.out.println("Price of single item: "+cart.getPrice());
							System.out.println("Subtotal: "+cart.getSubTotal());
							
							
					        System.out.println("___________________");
							}
							
						}
						else 
							System.out.println("The cart is empty. No data available at this moment!!!");
						break;
						
					case 2:
						System.out.println("Enter the cart id: ");
						cartId=sc.nextLine();
						
						c=cimpl.getCartById(cartId);
						if(c!=null) {
							System.out.println("Cart id: "+c.getCartId());
							System.out.println("Customer id:"+c.getCustomerId());
							System.out.println("Item added: "+c.getF().getFoodName());
							System.out.println("Quantity in cart: "+c.getQuantity());
							System.out.println("Price of single item: "+c.getPrice());
							System.out.println("Subtotal: "+c.getSubTotal());
						}
						else 
							System.out.println("No cart with this id found");
						break;
						
					case 3:
						logout=true;
						System.out.println("Thank you for using our service. Visit again soon!!!");
						break;
						
						default:System.out.println("Please give inputs as per the options given");
					}//switch ends
					
				}//while ends
				
			}//else if ends
				
		}//outer while loop ends

	}//main method ends

}//class ends		 

	


