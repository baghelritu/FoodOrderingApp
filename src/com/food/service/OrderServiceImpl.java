package com.food.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.food.entity.Order;
import com.food.utility.DBConnection;

public class OrderServiceImpl implements Orderservice {
	
	Connection con=null;
	String sql=null;
	PreparedStatement ps=null;
	ResultSet rs=null;


	@Override
	public Order placeOrder(Order o) {
		try { 
			con=DBConnection.makeConnection();
			sql="insert into Order_6370 values (?, ?, ?, ?, ?,  ?, ?)";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, o.getOrderId());
			/*
			 * Converting java LocalDate type to sql data type
			 */
			ps.setDate(2, Date.valueOf(o.getOrderDate()));
			ps.setString(3, o.getDropLocation());
			
			/*
			 * Converting java LocalDataTime type to sql Timestamp type to store date and time
			 */
			ps.setTimestamp(4, Timestamp.valueOf(o.getExpectedDelivery()));
			ps.setString(5, o.getCustomerId());
			ps.setDouble(6, o.getBillingAmount());
			ps.setString(7, o.getStatus());
			
			int i=ps.executeUpdate();
			if(i>0)
			{
				
				new CartServiceImpl().clearMyCart(o.getCustomerId());
				return o;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}

	@Override
	public boolean cancelOrder(String orderId) {
		try { 
			
			con=DBConnection.makeConnection();
			sql="update Order_6370 set status='Cancelled' where orderId=?";
			
			ps=con.prepareStatement(sql);
		    ps.setString(1, orderId);
		    
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public List<Order> showMyOrderHistory(String customerId) {
		try {
			
			con=DBConnection.makeConnection();
			sql="select * form order_6370 where customerId=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, customerId);
			
			rs=ps.executeQuery();
			List<Order> olist=new ArrayList<>();
			while(rs.next()) {
				Order o=new Order();
				o.setOrderId(rs.getString("orderId"));
				o.setOrderDate(rs.getDate("orderDate").toLocalDate());
				o.setDropLocation(rs.getString("dropLocation"));
				o.setExpectedDelivery(rs.getTimestamp("expectedDlivery").toLocalDateTime());
				o.setCustomerId(rs.getString("customer"));
				o.setBillingAmount(rs.getDouble("billingAmount"));
				o.setStatus(rs.getString("status"));
				
				olist.add(o);
			}
			
			return olist;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Order showOrderById(String oderId) {
		try {
			
			con=DBConnection.makeConnection();
			sql="select * form order_6370 where orderId=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, oderId);
			
			rs=ps.executeQuery();
			if(rs.next());
			
			Order o=new Order();
			
			o.setOrderId(rs.getString("orderId"));
			o.setOrderDate(rs.getDate("orderDate").toLocalDate());
			o.setDropLocation(rs.getString("dropLocation"));
			o.setExpectedDelivery(rs.getTimestamp("expectedDlivery").toLocalDateTime());
			o.setCustomerId(rs.getString("customer"));
			o.setBillingAmount(rs.getDouble("billingAmount"));
			o.setStatus(rs.getString("status"));
			
			return o;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
