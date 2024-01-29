package com.food.ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.food.entity.Cart;
import com.food.entity.Customer;
import com.food.entity.Order;
import com.food.service.CustomerServiceImpl;
import com.food.service.OrderServiceImpl;

public class OrderUI {
	private String orderId;
	private LocalDate orderDate;
	private String dropLocation;
	private LocalDateTime expectedDelivery;
	private String customerId;
	private Double billingAmount;
	private String status;
	boolean flag;
	String ans;
	
	Order o=null;
	OrderServiceImpl oimpl=new OrderServiceImpl();
	List<Order> olist=null;
	
	public void OrderManu(String customerId, List<Cart> clist) {
		
		Customer cust=new CustomerServiceImpl().showCustomerById(customerId);
		System.out.println("Welcome to the Order page"+cust.getCustName()+"!!!");
		
		int option;
		Scanner sc=new Scanner(System.in);
		String ans;
		
		Double grandTotal=0.0;
		if(clist!=null && clist.isEmpty()!=true) {
		for(Cart cart: clist)
				{
				System.out.println("Cart id: "+cart.getCartId());
				System.out.println("Item added: "+cart.getF().getFoodName());
				System.out.println("Price of single item: "+cart.getPrice());
				System.out.println("Quantity in cart: "+cart.getQuantity());
				System.out.println("Subtotal: "+cart.getSubTotal());
				
				grandTotal+=cart.getSubTotal();
		        System.out.println("___________________");
				}
				
		System.out.println("Grand Total= "+grandTotal);
		}
		else
		{
			System.out.println("Your cart is empty and so you weill not be able to place order.");
			System.out.println("Do you want to continue wioth the order manu??");
			
			ans=sc.nextLine();
			
			if(ans.equals("no"))
				return;
			
			else if(ans.equals("yes"))
				System.out.println("Thankyou for input. please do not place order. \nYou can check other options");
			
			else
			{
				
				System.out.println("Please enter yes or no only ....Returning to main manu");
				return;
			}
						
			
		}
		while(true) {
			
			System.out.println("Enter 1----> place Order ");
			System.out.println("Enter 2----> Cancel my order");
			System.out.println("Enter 3----> Show my order history");
			System.out.println("Enter 4----> Show order by id");
			System.out.println("Enter 5----> Go main manu");
			
			option=sc.nextInt();
			sc.nextLine();
			
			switch(option) {
			case 1:
				int min = 100;  
				int max = 400; 				
				int b = (int)(Math.random()*(max-min+1)+min);
				 
				orderId="OR"+b;
				
				orderDate=LocalDate.now();
				
				System.out.println("Do you want to deliver at the below given address??");
				System.out.println(cust.getAddress());
				System.out.println("\nAnswer in yes or no");
				
				ans=sc.nextLine();
				if(ans.equalsIgnoreCase("yes")) {
					
					dropLocation=cust.getAddress();
					
				}
				else if(ans.equalsIgnoreCase("no"))
				{
					System.out.println("Enter your drop location");
					dropLocation=sc.nextLine();
				}
				else
					System.out.println("Please answer in yes or no only!! Going back to main manu");
				
				expectedDelivery=LocalDateTime.now().plusHours(1);
				
				billingAmount=grandTotal;
				
				status="processing...";
				
				o=new Order( orderId,orderDate,dropLocation,expectedDelivery,customerId,billingAmount,status);
						
				Order order=oimpl.placeOrder(o);
				if(order!=null) {
					System.out.println("Your order has been placed. Details given below...");
					System.out.println("Order number: "+order.getOrderId());
					System.out.println("Drop location:"+order.getDropLocation());
					
					DateTimeFormatter pattern=DateTimeFormatter.ofPattern("dd-LLL-yyyy HH:mm");
					LocalDateTime delivery=order.getExpectedDelivery();
					
					System.out.println("Delivery by: "+delivery.format(pattern));
					
					System.out.println("Billing amount: "+order.getBillingAmount());
					System.out.println("Status: "+order.getStatus());
					return;
				}
				else
					System.out.println("Error while placing order");
				break;
				
			case 2:
				
				System.out.println("Enter the order id to be cancelled ");
				orderId=sc.nextLine();
				
				flag=oimpl.cancelOrder(orderId);
				
				if(flag)
					System.out.println("Your order has been cancelled!!!");
				else
					System.out.println("Error while cancelling your order. try again later...");
				
				
				break;
				
			case 3:
				
				olist=oimpl.showMyOrderHistory(customerId);
				if(olist!=null && olist.isEmpty()!=true) {
					
					for(Order o1:olist) {
						
						System.out.println("Your order has been placed. Details given below...");
						System.out.println("Order number: "+o1.getOrderId());
						System.out.println("Drop location:"+o1.getDropLocation());
						
						DateTimeFormatter pattern=DateTimeFormatter.ofPattern("dd-LLL-yyyy HH:mm");
						LocalDateTime delivery=o1.getExpectedDelivery();
						
						System.out.println("Delivery by: "+delivery.format(pattern));
						
						System.out.println("Billing amount: "+o1.getBillingAmount());
						System.out.println("Status: "+o1.getStatus());
						
						System.out.println("___________________________________________\n");
					}
				}
				break;
				
			case 4:

				System.out.println("Enter the order id ");
				orderId=sc.nextLine();
				
				o=oimpl.showOrderById(orderId);
				if(o!=null) {
					
					System.out.println("Order number: "+o.getOrderId());
					System.out.println("Drop location:"+o.getDropLocation());
					
					DateTimeFormatter pattern=DateTimeFormatter.ofPattern("dd-LLL-yyyy HH:mm");
					LocalDateTime delivery=o.getExpectedDelivery();
					
					System.out.println("Delivery by: "+delivery.format(pattern));
					
					System.out.println("Billing amount: "+o.getBillingAmount());
					System.out.println("Status: "+o.getStatus());
					
					System.out.println("___________________________________________\n");
				}
				else
					System.out.println("No order found with this id.");
			
				break;
				
			case 5:
				System.out.println("\nGoing  back to main manu....");
				return;
				
				default:System.out.println("Please enter the number as given in manu...");
			}
		}
	}

}
