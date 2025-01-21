package com.telusko.jdbclearning;

import java.sql.*;

public class exceptionHandling 
{

	public static void main(String[] args) 
	{
		
		Connection connect=null;
		Statement statement=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		String url="jdbc:mysql://localhost:3306/jdbclearning";
		String user="root";
		String password="9152591";
		
		 connect=DriverManager.getConnection(url,user,password);
		
		 statement=connect.createStatement();
		
		String sql="select * from studentinfo";
		
		ResultSet rs =statement.executeQuery(sql);
		
		while(rs.next()) {
			
			//System.out.println(rs.getInt(1) + " "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
			
			System.out.println(rs.getString("sname")+" "+rs.getInt("id")+" "+rs.getString("scity")+" "+rs.getInt("sage"));
			
		}
		
		
		
	} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		finally{
			try {
				statement.close();
				connect.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}

	}

}
