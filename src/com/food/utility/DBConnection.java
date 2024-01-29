package com.food.utility;

import java.sql.Connection;
import java.sql.DriverManager;
/*
 * This class is exclusively made to create the connection objects.
 * All our tables are made in the same database so again and we will have to write the same code
 * for all methods in Serviceimpl class.
 * Instead of repeating same code we have written it once in the makeConnection method.
 * 
 * Whenever we want to create connection to this database we can simply call this method
 * form DBConnection class.
 * 
 * We have made the makeConnection method as static so that we can directly call this method from
 * anywhere just by the class name.
 */

public class DBConnection {
	
	public static Connection makeConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/FoodProject6370?user=root&password=Ritu@9599");
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return con;
	}
	
	public static void main(String[] args) {
		Connection con=makeConnection();
		if(con!=null)
			System.out.println("Connection made successfully");
		else
			System.out.println("Error");
	}
}
	