package com.atm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnecivity 
{
	private String databaseurl;
	private String userPassword;

	public Connection dbConnection()
{
     Connection conn=null;

  	String url="jdbc:mysql://localhost:3306/bankapp";
  	String username="root";
 	String password="mysql";

 	try {
		conn=DriverManager.getConnection(url, username, password);
		
	} 
	
	catch (SQLException e) {
		System.out.println("Server Problem!!");
	}
return conn;	

}

}
