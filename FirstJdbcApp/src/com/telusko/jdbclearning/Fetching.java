package com.telusko.jdbclearning;

import java.sql.*;


public class Fetching
{
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/jdbclearning";
		String user="root";
		String password="9152591";
		
		Connection connect=DriverManager.getConnection(url,user,password);
		
		Statement statement=connect.createStatement();
		
		String sql="select * from studentinfo";
		
		ResultSet rs =statement.executeQuery(sql);
		
		while(rs.next()) {
			
			//System.out.println(rs.getInt(1) + " "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
			
			System.out.println(rs.getString("sname")+" "+rs.getInt("id")+" "+rs.getString("scity")+" "+rs.getInt("sage"));
			
		}
		
		statement.close();
		connect.close();
		
		
		
		
	}
	
	

}
