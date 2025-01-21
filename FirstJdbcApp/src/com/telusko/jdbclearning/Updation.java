package com.telusko.jdbclearning;

import java.sql.*;

import java.util.*;

public class Updation 
{
	
	public static void main(String args[]) throws SQLException, ClassNotFoundException
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Establish the connection 
		
		String url="jdbc:mysql://localhost:3306/jdbclearning";
		String user="root";
		String password="9152591";
		Connection connect=DriverManager.getConnection(url,user,password);

		//create statement
		
		Statement statement=connect.createStatement();
		
		//execute query
		
		String sql="update studentinfo set sage=20 where id=2";
		
		int rf=statement.executeUpdate(sql);
		
		if(rf ==0)
			System.out.println("Updation faield");
		else
			System.out.println("Updation succesful");
		
		
		
//		int rowAffected=statement.executeUpdate(sql);
//		
//		if(rowAffected==0) {
//			System.out.println("unable to insert data");
//		}
//		else {
//			System.out.println("Data inserted successfully");
//		}
		
		//process the result
		
		//close the resources
		statement.close();
		connect.close();		
		
		
	}

}
