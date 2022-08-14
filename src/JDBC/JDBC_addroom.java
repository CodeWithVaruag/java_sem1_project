package JDBC;

 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import library.room_library;

//import java.sql.ResultSet;

public class JDBC_addroom{
	
	public boolean room(room_library rm) {
		Connection conn;
		PreparedStatement pstat; //declare preparedStatement
		boolean  result = false;
		String sql= "INSERT INTO room(roomno,roomtype,rate,roomstatus) VALUES (?,?,?,?) ";    //query to insert values
//exception handling
		database d=new database();
		try {
			conn= d.connect();
			pstat = conn.prepareStatement(sql);		
			//create statement
			pstat.setInt(1, rm.getRoomno());
			pstat.setString(2, rm.getRoomtype());
			pstat.setInt(3, rm.getRate());
			pstat.setString(4, rm.getRoomstatus());
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
	
//////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	
	
	public boolean updateroom(room_library rm) {
		Connection conn;
		PreparedStatement pstat; //declare preparedStatement
		boolean  result = false;
		String sql= "update room set roomstatus=? where roomno=? ";    //query to insert values
//exception handling
		database d=new database();
		try {
			conn= d.connect();
			pstat = conn.prepareStatement(sql);		
			//create statement
			
			pstat.setString(1, rm.getRoomstatus());
			pstat.setInt(2, rm.getRoomno());
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
	
///////////////////////////////////////////////////////////////////////
	

	public ArrayList selectroom() {
		Connection conn;
		PreparedStatement pstat; //declare preparedStatement
		ResultSet rs;
		boolean  result = false;
		ArrayList<room_library>a2=new ArrayList();
		String sql= "SELECT * FROM room ";    //query to insert values
//exception handling
		database d=new database();
		try {
			conn= d.connect();
			pstat = conn.prepareStatement(sql);			//create statement
			rs=pstat.executeQuery();
			while(rs.next()) {
				room_library booking11=new room_library(
						    rs.getInt("roomno"),
						    rs.getString("roomtype"),
					        rs.getInt("rate"),
							rs.getString("roomstatus")
							
				);
				a2.add(booking11);
				
			}
			
			conn.close();
			
		}
		
		catch(Exception ex) {
			System.out.println("Error : "+ ex.getMessage());
		}
return a2;

	}
	
//////////////////////////////////////////////////////////
	
	public ArrayList selectroomb() {
		Connection conn;
		PreparedStatement pstat; //declare preparedStatement
		ResultSet rs;
	
		ArrayList<room_library>a2=new ArrayList();
		String sql= "SELECT * FROM room where roomstatus=?";    //query to insert values
//exception handling
		database d=new database();
		try {
			conn= d.connect();
			pstat = conn.prepareStatement(sql);	
			pstat.setString(1,"available");
			
			rs=pstat.executeQuery();
			while(rs.next()) {
				room_library booking11=new room_library(
						    rs.getInt("roomno"),
						    rs.getString("roomtype"),
					        rs.getInt("rate"),
							rs.getString("roomstatus")
							
				);
				a2.add(booking11);
				
			}
			
			conn.close();
			
		}
		
		catch(Exception ex) {
			System.out.println("Error : "+ ex.getMessage());
		}
return a2;
	}
}
