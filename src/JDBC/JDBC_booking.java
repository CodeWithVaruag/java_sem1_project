package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import library.Global;
import library.booking2_library;
import library.booking_library;
import library.registration_library;

public class JDBC_booking {
	
	
	final String Driver="com.mysql.cj.jdbc.Driver";		
	final String DBNAME="app";
	final String HOST="localhost";
	final int PORT =3306;
	final String URL="jdbc:mysql://"+HOST+":"+PORT+"/"+DBNAME;
	final String USER ="root";
	final String PASSWORD="";
	
	
	public Connection connect() {
		Connection conn = null;
		
		try {
			Class.forName(Driver);   //loading driver
			conn=DriverManager.getConnection(URL,USER, PASSWORD);
		
		}
		
		catch (Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return conn;
		
	}
	
	public booking_library bookin(booking_library book) {
		String sql="SELECT * FROM booking WHERE bookingid=?";
		try {
			Connection conn=connect();
			if(conn!=null) {
			PreparedStatement pstat=conn.prepareStatement(sql);
			pstat.setInt(1,book.getBookingid());
			
			ResultSet rs=pstat.executeQuery();
			
			while(rs.next()) {
				
				book.setBookingid(rs.getInt("bookingid"));
				book.setBookingtype(rs.getString("bookingtype"));
				book.setCheckin(rs.getString("checkin"));
				book.setCheckout(rs.getString("checkout"));
				book.setUserid(rs.getInt("userid"));
				book.setRoomno(rs.getInt("roomno"));
				book.setBookingstatus(rs.getString("booking_status"));
				
			}
			}
			
		}
		catch(Exception ex) {
			
			System.out.println("Error"+ex.getMessage());
		}
		return book;
	}



	
	
	
	

	public boolean booking(booking_library j) {
		Connection conn;
		PreparedStatement pstat; // declare preparedStatement
		boolean result = false;
		String sql = "INSERT INTO booking (bookingid,bookingtype,checkin,checkout,userid,booking_status)VALUES (?,?,?,?,?,?)"; // query
																																// to
																																// insert
																																// values
//exception handling
		database d = new database();
		try {
			conn = d.connect();
			pstat = conn.prepareStatement(sql); // create statement

			pstat.setInt(1, j.getBookingid());
			pstat.setString(2, j.getBookingtype());
			pstat.setString(3, j.getCheckin());
			pstat.setString(4, j.getCheckout());
			pstat.setInt(5, j.getUserid());
			pstat.setString(6, j.getBookingstatus());

			pstat.executeUpdate();

			pstat.close();
			conn.close();

			result = true;
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		return result;
	}

	public boolean updatebooking(booking_library j) {
		Connection conn;
		PreparedStatement pstat; // declare preparedStatement
		boolean result = false;
		String sql = "update booking set checkin=?,checkout=?, roomno=?,booking_status=? where bookingid=? "; // query
																																// to
																																// insert
																																// values
//exception handling
		database d = new database();
		try {
			conn = d.connect();
			pstat = conn.prepareStatement(sql); // create statement
			pstat.setString(1, j.getCheckin());
			pstat.setString(2, j.getCheckout());
			pstat.setInt(3,j.getRoomno());
			pstat.setString(4, j.getBookingstatus());
			pstat.setInt(5,j.getBookingid());
			

			pstat.executeUpdate();

			pstat.close();
			conn.close();

			result = true;
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		return result;
	}



	////////////////////////////////////////////////////////////////slect for reception table////////////////////////////////////////
	
	public ArrayList selectbooking() {
		Connection conn;
		PreparedStatement pstat; //declare preparedStatement
		ResultSet rs;
		ArrayList<booking2_library>a1=new ArrayList();
		String sql= "select registration.userid, registration.username, booking.bookingid, booking.bookingtype, booking.checkin, booking.checkout, booking.roomno, booking.booking_status from booking left join registration on booking.userid = registration.userid;";    //query to insert values
//exception handling
		database d=new database();
		try {
			conn= d.connect();
			pstat = conn.prepareStatement(sql);			//create statement
			rs=pstat.executeQuery();
			while(rs.next()) {
				booking2_library booking11=new booking2_library(
							
						    rs.getString("username"),  
						    rs.getInt("bookingid"),
							rs.getString("bookingtype"),
							rs.getString("checkin"),
							rs.getString("checkout"),
							rs.getInt("userid"),
							rs.getInt("roomno"),
							rs.getString("booking_status")
						    
				);
				a1.add(booking11);
				
			}
			
			conn.close();
			
		}
		
		catch(Exception ex) {
			System.out.println("Error : "+ ex.getMessage());
		}
return a1;
	}

	
	
	
	
	
	
	
	
	
	///////////////////////////////////////////////////////////////////// select for particular customer//////////////////////////////////////////

	public ArrayList selectbookingcust() {
		Connection conn;
		PreparedStatement pstat; //declare preparedStatement
		ResultSet rs;
		ArrayList<booking2_library>a1=new ArrayList();
		String sql= "select registration.userid, registration.username, booking.bookingid, booking.bookingtype, booking.checkin, booking.checkout, booking.roomno, booking.booking_status from booking left join registration on booking.userid = registration.userid where booking.userid=?;";    //query to insert values
//exception handling
		database d=new database();
		try {
			conn= d.connect();
			pstat = conn.prepareStatement(sql);			//create statement
			pstat.setInt(1, Global.currentUser.getUserid());
			
			rs = pstat.executeQuery();
			while (rs.next()) {
				booking2_library boo = new booking2_library(
						rs.getString("username"),  
					    rs.getInt("bookingid"),
						rs.getString("bookingtype"),
						rs.getString("checkin"),
						rs.getString("checkout"),
						rs.getInt("userid"),
						rs.getInt("roomno"),
						rs.getString("booking_status")
						);
					    	
				
				a1.add(boo);
				
			}
			
			conn.close();
			
		}
		
		catch(Exception ex) {
			System.out.println("Error : "+ ex.getMessage());
		}
return a1;
	}

	
	
	
	public boolean checkinupdate(booking_library j) {
		Connection conn;
		PreparedStatement pstat; // declare preparedStatement
		boolean result = false;
		String sql = "update booking set bookingstatus=? where bookingid=? "; // query
																																// to
																																// insert
																																// values
//exception handling\
		database d = new database();
		try {
			conn = d.connect();
			pstat = conn.prepareStatement(sql); // create statement
			
			pstat.setString(1, j.getBookingstatus());
			pstat.setInt(2,j.getBookingid());
			

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
