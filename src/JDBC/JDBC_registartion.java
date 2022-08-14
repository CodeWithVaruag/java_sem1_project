package JDBC;

 

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mysql.cj.protocol.Resultset;

import library.registration_library;
//import java.sql.ResultSet;

public class JDBC_registartion{
	
	public boolean save(registration_library REGISTRATION) {
		Connection conn;
		PreparedStatement pstat; //declare preparedStatement
		boolean  result = false;
		String sql= "INSERT INTO registration (userid,username,address,contact,email,age,position,gender,password)VALUES (?,?,?,?,?,?,?,?,?)";    //query to insert values
//exception handling
		database d=new database();
		try {
			conn= d.connect();
			pstat = conn.prepareStatement(sql);			//create statement

			pstat.setInt(1, REGISTRATION.getUserid());
			pstat.setString(2, REGISTRATION.getUsername());
			pstat.setString(3, REGISTRATION.getAddress());
			pstat.setString(4, REGISTRATION.getContact());
			pstat.setString(5, REGISTRATION.getEmail());
			pstat.setInt(6, REGISTRATION.getAge());
			pstat.setString(7, REGISTRATION.getPosition());
			pstat.setString(8, REGISTRATION.getGender());
			pstat.setString(9, REGISTRATION.getPassword());
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
