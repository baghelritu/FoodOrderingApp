package com.food.service;

import java.util.ArrayList;
import java.util.List;
import com.food.entity.Food;
import com.food.utility.DBConnection;
import java.sql.*;

public class FoodServiceImpl implements FoodService {
	
	Connection con=null;
	String sql=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	@Override
	public boolean addFood(Food f) {
		try {
			con=DBConnection.makeConnection();
			sql="insert into food_6370 values(?, ?, ?, ?, ?, ?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, f.getFoodId());
			ps.setString(2, f.getFoodName());
			ps.setString(3, f.getType());
			ps.setString(4, f.getCategory());
			ps.setDouble(5, f.getPrice());
			ps.setInt(6, f.getQuantityInStock() );
			
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
	public boolean updateFood(Food f) {

		con=DBConnection.makeConnection();
		sql="update food_6370 set foodName=?, type=?, category=?, price=?, quantityInStock=? where foodId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(6, f.getFoodId());
			ps.setString(1, f.getFoodName());
			ps.setString(2, f.getType());
			ps.setString(3, f.getCategory());
			ps.setDouble(4, f.getPrice());
			ps.setInt(5, f.getQuantityInStock());
			
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
	public boolean deleteFood(String FoodId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Food getFoodById(String foodId) {
		con=DBConnection.makeConnection();
		sql="select * from food_6370 where foodId=?";
		
		try {
			
			ps=con.prepareStatement(sql);
			ps.setString(1, foodId);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				Food f=new Food();
				f.setFoodId(rs.getString("foodId"));
				f.setFoodName(rs.getString("foodName"));
				f.setCategory(rs.getString("category"));
				f.setType(rs.getString("type"));
				f.setPrice(rs.getDouble("price"));
				f.setQuantityInStock(rs.getInt("quantityInStock"));
				
				return f;
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
	public List<Food> showAllFood() {
		try {
			con=DBConnection.makeConnection();
			sql="select * from food_6370";
			
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			List<Food> flist=new ArrayList<Food>();
			
			while(rs.next()) {
				
				Food f=new Food();
				f.setFoodId(rs.getString("foodId"));
				f.setFoodName(rs.getString("foodName"));
				f.setCategory(rs.getString("category"));
				f.setType(rs.getString("type"));
				f.setPrice(rs.getDouble("price"));
				f.setQuantityInStock(rs.getInt("quantityInStock"));
				
				flist.add(f);
			}
			
			return flist;
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
	public List<Food> getFoodByCategory(String category) {
		//TODO Auto-genrated method stub
		return null;
	}

	@Override
	public List<Food> getFoodByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
