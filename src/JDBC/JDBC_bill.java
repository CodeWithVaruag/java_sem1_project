package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import library.bill1_library;
import library.bill2_library;

public class JDBC_bill {


	
	
	
	
	public ArrayList bill() {
		Connection conn;
		PreparedStatement pstat; //declare preparedStatement
		ResultSet rs;
		ArrayList<bill1_library>a1=new ArrayList();
		String sql= " \r\n"
				+ "select booking.bookingid, booking.checkin, booking.checkout, registration.username, bar.drinksrate, food.foodrate, service.serviceprice, booking.roomno, room.rate,registration.position from booking join registration\r\n"
				+ "join bar join food join service join room where booking.userid=registration.userid and booking.roomno=room.roomno and bar.bookingid=booking.bookingid and food.bookingid=booking.bookingid and \r\n"
				+ "food.bookingid = booking.bookingid and service.bookingid=booking.bookingid; ";    //query to insert values
//exception handling
		database d=new database();
		try {
			conn= d.connect();
			pstat = conn.prepareStatement(sql);			//create statement
			rs=pstat.executeQuery();
			while(rs.next()) {
				bill1_library drinky=new bill1_library(
							
						    rs.getInt("bookingid"),  
						    rs.getString("checkin"),
						    rs.getString("checkout"),
						    rs.getString("username"),
						    rs.getInt("drinksrate"),
						    rs.getInt("foodrate"),
						    rs.getInt("serviceprice"),
						    rs.getInt("roomno"),
						    rs.getInt("rate"),
						    rs.getString("position")
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

	
	public boolean insertintobill(bill2_library j) {
		Connection conn;
		PreparedStatement pstat; // declare preparedStatement
		boolean result = false;
		String sql = "INSERT INTO bill (bookingid,roomrate,drinksrate,foodrate,serviceprice,totalprice,cardno,billstatus)VALUES (?,?,?,?,?,?,?,?)"; // query
		database d = new database();
		try {
			conn = d.connect();
			pstat = conn.prepareStatement(sql); // create statement
		
			pstat.setInt(1, j.getBookingid());
			pstat.setInt(2, j.getRoomrate());
			pstat.setInt(3, j.getDrinksrate());
			pstat.setInt(4, j.getFoodrate());
			pstat.setInt(5, j.getServiceprice());
			pstat.setDouble(6, j.getTotalprice());
			pstat.setString(7, j.getCardno());
			pstat.setString(8, j.getBillstatus());
			pstat.executeUpdate();

			pstat.close();
			conn.close();

			result = true;
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
}
