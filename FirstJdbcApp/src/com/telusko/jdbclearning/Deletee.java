package com.telusko.jdbclearning;

import java.sql.*;

public class Deletee 
{
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/jdbclearning";
		String user="root";
		String password="9152591";
		Connection connect=DriverManager.getConnection(url,user,password);
		Statement statement=connect.createStatement();
		
		String sql="delete from studentinfo where id=2;";
		
		int ra=statement.executeUpdate(sql);
		
		if(ra ==0)
			System.out.println("deletion failed");
		else
			System.out.println("deleted successfully");
		
		statement.close();
		connect.close();
		
	}

}
