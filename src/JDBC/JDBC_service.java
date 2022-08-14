package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import library.Global;
import library.bar_library;
import library.booking2_library;
import library.service_library;



public class JDBC_service {
   
	
		
		public boolean service(service_library rm) {
			Connection conn;
			PreparedStatement pstat; //declare preparedStatement
			boolean  result = false;
			String sql= "INSERT INTO service(bookingid,serviceprice,services,servicestatus) VALUES (?,?,?,?) ";    //query to insert values
	//exception handling
			database d=new database();
			try {
				conn= d.connect();
				pstat = conn.prepareStatement(sql);		
				//create statement
				pstat.setInt(1, rm.getBookingid());
                pstat.setInt(2, rm.getServiceprice());
                pstat.setString(3, rm.getServices());
                pstat.setString(4, rm.getServicestatus());
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
	
	
		public ArrayList selectservice() {
			Connection conn;
			PreparedStatement pstat; //declare preparedStatement
			ResultSet rs;
			ArrayList<service_library>a1=new ArrayList();
			String sql= "select registration.username, service.serviceid, booking.bookingid, service.serviceprice,service.services,service.servicestatus from booking join service join registration where service.bookingid = booking.bookingid and booking.userid = registration.userid;";   //query to insert values
	//exception handling
			database d=new database();
			try {
				conn= d.connect();
				pstat = conn.prepareStatement(sql);			//create statement
			
				rs = pstat.executeQuery();
				while (rs.next()) {
					service_library boo = new service_library(
							rs.getString("username"),  
						    rs.getInt("serviceid"),
						    rs.getInt("bookingid"),
						    rs.getInt("serviceprice"),
						    rs.getString("services"), 
						    rs.getString("servicestatus")
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

		
		public boolean updateservice(service_library rm) {
			Connection conn;
			PreparedStatement pstat; //declare preparedStatement
			boolean  Result = false;
			String sql= "update service set servicestatus=? where serviceid=? ";    //query to insert values
	//exception handling
			database d=new database();
			try {
				conn= d.connect();
				pstat = conn.prepareStatement(sql);		
				//create statement
				
				pstat.setString(1, rm.getServicestatus());
				pstat.setInt(2, rm.getServiceid());
				pstat.executeUpdate();
				
				
				
				pstat.close();
				conn.close();
				
				Result =  true;
			}
			catch(Exception ex) {
				System.out.println("Error : "+ ex.getMessage());
			}
			return Result;
		}
		
	}

