package com.food.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.entity.Customer;
import com.food.entity.Food;
import com.food.utility.DBConnection;

public class CustomerServiceImpl implements CustomerService {
	
	  Connection con=null;
	    String sql=null;
	    PreparedStatement ps=null;
	    ResultSet rs=null;
		
		@Override
		public boolean addCustomer(Customer c) {
			try {
				con=DBConnection.makeConnection();
				sql="insert into customer_6370 values (?,?,?,?,?,?,?)";
				ps=con.prepareStatement(sql);
				ps.setString(1, c.getCustomerId());
				ps.setString(2, c.getCustName());
				ps.setString(4, c.getCustEmail());
				ps.setString(5, c.getContact());
				ps.setString(3, c.getPassword());
				ps.setString(6, c.getAddress());
				ps.setString(7, c.getDropLocation());
				
				int i=ps.executeUpdate();
				if(i>0)
					return true;
				
			}
			catch(Exception e) {
				
				e.printStackTrace();
			}
			finally {
				try {
					ps.close();
					con.close();
				}catch(SQLException e) {
					
					e.printStackTrace();
				}
			}
			return false;
		}
		@Override
		public boolean updateCustomer(Customer c) {
			con=DBConnection.makeConnection();
			sql="update customer_6370 set CustName=?, Password=?, CustEmail=?, Contact=?, Address=?, DropLocation=? where CustomerId=?";
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1, c.getCustomerId());
				ps.setString(2, c.getCustName());
				ps.setString(3, c.getPassword());
				ps.setString(4, c.getCustEmail());
				ps.setString(5, c.getContact());
				ps.setString(6, c.getAddress());
				ps.setString(7, c.getDropLocation());
				
				int i=ps.executeUpdate();
				if(i>0)
					return true;
				}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					ps.close();
					con.close();
				}catch(SQLException e) {
					
					e.printStackTrace();
				}
			}
			return false;
		}
		@Override
		public boolean deleteCustomer(String customerId) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public Customer showCustomerById(String customerId) {
			try {
				con=DBConnection.makeConnection();
				sql="select * from customer_6370 where CustomerId=?";
				
				ps=con.prepareStatement(sql);
				ps.setString(1, customerId);
				
				rs=ps.executeQuery();
				if(rs.next()) {
					Customer c=new Customer();
				    c.setCustomerId(rs.getString("CustomerId"));
					c.setCustName(rs.getString("CustName"));
					c.setPassword(rs.getString("Password"));
					c.setCustEmail(rs.getString("CustEmail"));
					c.setContact(rs.getString("Contact"));
					c.setAddress(rs.getString("Address"));
					c.setDropLocation(rs.getString("DropLocation"));
					
					return c;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
				
				ps.close();
				con.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			return null;
		}
		public List<Customer> showAllCustomer() {
			try {
				con=DBConnection.makeConnection();
				sql="select * from customer_6370";
				
				ps=con.prepareStatement(sql);
				
				rs=ps.executeQuery();
				List<Customer> clist=new ArrayList<Customer>();
				
				while(rs.next()) {
					
					Customer c=new Customer();
					c.setCustomerId(rs.getString("CustomerId"));
					c.setCustName(rs.getString("CustName"));
					c.setPassword(rs.getString("Password"));
					c.setCustEmail(rs.getString("CustEmail"));
					c.setContact(rs.getString("Contact"));
					c.setAddress(rs.getString("Address"));
					c.setDropLocation(rs.getString("DropLocation"));
					clist.add(c);
				}
				
				return clist;     
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					ps.close();
					con.close();
				}catch(SQLException e) {
					
					e.printStackTrace();
				}
			}
			return null;
		}
		@Override
		public Customer showCustomerByEmail(String email) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public List<Customer> getCustomerByContact(String contact) {
			// TODO Auto-generated method stub
			return null;
		}

	
}
	
	





