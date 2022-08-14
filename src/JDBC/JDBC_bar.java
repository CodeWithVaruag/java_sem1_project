package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import library.bar2_library;
import library.bar_library;
import library.food_library;

public class JDBC_bar {

	

	public boolean bar(bar_library j) {
		Connection conn;
		PreparedStatement pstat; // declare preparedStatement
		boolean Result = false;
		String sql = "INSERT INTO bar (bookingid,drinks,drinksquantity,drinksrate,drinksstatus)VALUES (?,?,?,?,?)"; // query
		database d = new database();
		try {
			conn = d.connect();
			pstat = conn.prepareStatement(sql); // create statement
		
			pstat.setInt(1, j.getBookingid());
			pstat.setString(2, j.getDrinks());
	    	pstat.setInt(3, j.getDrinksquantity());
			pstat.setInt(4, j.getDrinksrate());
			pstat.setString(5, j.getDrinksstatus());
			pstat.executeUpdate();

			pstat.close();
			conn.close();

			Result = true;
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		return Result;
	}
    
	public ArrayList drinkselect() {
		Connection conn;
		PreparedStatement pstat; //declare preparedStatement
		ResultSet rs;
		ArrayList<bar2_library>a1=new ArrayList();
		String sql= "select registration.username, bar.barorderid, booking.bookingid, bar.drinks, bar.drinksquantity, bar.drinksrate,bar.drinksstatus from booking join bar join registration where bar.bookingid = booking.bookingid and booking.userid = registration.userid;";    //query to insert values
//exception handling
		database d=new database();
		try {
			conn= d.connect();
			pstat = conn.prepareStatement(sql);			//create statement
			rs=pstat.executeQuery();
			while(rs.next()) {
				bar2_library drinky=new bar2_library(
							
						    rs.getString("username"),  
						    rs.getInt("barorderid"),
						    rs.getInt("bookingid"),
						    rs.getString("drinks"),
						    rs.getInt("drinksquantity"),
						    rs.getInt("drinksrate"),
						    rs.getString("drinksstatus")
						    
				);
				a1.add(drinky);
				
			}
			
			conn.close();
			
		}
		
		catch(Exception ex) {
			System.out.println("Error : "+ ex.getMessage());
		}
return a1;
	}

	public boolean confirmdrinks(bar_library rm) {
		Connection conn;
		PreparedStatement pstat; //declare preparedStatement
		boolean  result = false;
		String sql= "update bar set drinksstatus=? where barorderid=? ";    //query to insert values
//exception handling
		database d=new database();
		try {
			conn= d.connect();
			pstat = conn.prepareStatement(sql);		
			//create statement
			
			pstat.setString(1, rm.getDrinksstatus());
			pstat.setInt(2, rm.getBarorderid());
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
