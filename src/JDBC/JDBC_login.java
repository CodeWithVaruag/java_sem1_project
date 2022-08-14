package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import library.registration_library;

public class JDBC_login {
	
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
	
	public registration_library login(registration_library user) {
		String sql="SELECT * FROM registration WHERE username=? AND password=?";
		try {
			Connection conn=connect();
			if(conn!=null) {
			PreparedStatement pstat=conn.prepareStatement(sql);
			pstat.setString(1,user.getUsername());
			pstat.setString(2, user.getPassword());
			ResultSet rs=pstat.executeQuery();
			
			while(rs.next()) {
				
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setAddress(rs.getString("address"));
				user.setContact(rs.getString("contact"));
				user.setEmail(rs.getString("email"));
				user.setEmail(rs.getString("Email"));
				user.setPosition(rs.getString("position"));
				user.setPassword(rs.getString("password"));
			}
			}
			
		}
		catch(Exception ex) {
			
			System.out.println("Error"+ex.getMessage());
		}
		return user;
	}

}
