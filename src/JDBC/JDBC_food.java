package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import library.food2_library;
import library.food_library;
import library.room_library;

public class JDBC_food {


		public boolean fooding(food_library j) {
			Connection conn;
			PreparedStatement pstat; // declare preparedStatement
			boolean result = false;
			String sql = "INSERT INTO food (bookingid,food,foodquantity,foodrate,foodstatus)VALUES (?,?,?,?,?)"; // query
			database d = new database();
			try {
				conn = d.connect();
				pstat = conn.prepareStatement(sql); // create statement
			
				pstat.setInt(1, j.getBookingid());
				pstat.setString(2, j.getFood());
				pstat.setInt(3, j.getFoodquantity());
				pstat.setInt(4, j.getFoodrate());
				pstat.setString(5, j.getFoodstatus());
				pstat.executeUpdate();

				pstat.close();
				conn.close();

				result = true;
			} catch (Exception ex) {
				System.out.println("Error : " + ex.getMessage());
			}
			return result;
		}
	
		public ArrayList foodselect() {
			Connection conn;
			PreparedStatement pstat; //declare preparedStatement
			ResultSet rs;
			ArrayList<food2_library>a1=new ArrayList();
			String sql= "select registration.username, food.orderid, booking.bookingid, food.food, food.foodquantity, food.foodrate,food.foodstatus from booking join food join registration where food.bookingid = booking.bookingid and booking.userid = registration.userid; ";    //query to insert values
	//exception handling
			database d=new database();
			try {
				conn= d.connect();
				pstat = conn.prepareStatement(sql);			//create statement
				rs=pstat.executeQuery();
				while(rs.next()) {
					food2_library foody=new food2_library(
								
							    rs.getString("username"),  
							    rs.getInt("orderid"),
							    rs.getInt("bookingid"),
							    rs.getString("food"),
							    rs.getInt("foodquantity"),
							    rs.getInt("foodrate"),
							    rs.getString("foodstatus")
							    
					);
					a1.add(foody);
					
				}
				
				conn.close();
				
			}
			
			catch(Exception ex) {
				System.out.println("Error : "+ ex.getMessage());
			}
	return a1;
		}
		
		
		
		
		public boolean confirmfood(food_library rm) {
			Connection conn;
			PreparedStatement pstat; //declare preparedStatement
			boolean  result = false;
			String sql= "update food set foodstatus=? where orderid=? ";    //query to insert values
	//exception handling
			database d=new database();
			try {
				conn= d.connect();
				pstat = conn.prepareStatement(sql);		
				//create statement
				
				pstat.setString(1, rm.getFoodstatus());
				pstat.setInt(2, rm.getOrderid());
				pstat.executeUpdate();
				
				
				
				pstat.close();
				conn.close();
				
				result =  true;
			}
			catch(Exception ex) {
				System.out.println("Error : "+ ex.getMessage());
			}
			return result;
		}
}
