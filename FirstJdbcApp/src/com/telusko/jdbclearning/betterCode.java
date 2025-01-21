package com.telusko.jdbclearning;
import java.sql.*;
import com.telusko.jdbclearning.JdbcUtil;

public class betterCode
{
	public static void main(String[] args) 
	{
		
		Connection connect=null;
		Statement statement=null;
		try {
			
		 connect=JdbcUtil.getConnection();		
		 statement=connect.createStatement();
		
		String sql="select * from studentinfo";
		
		ResultSet rs =statement.executeQuery(sql);
		
		while(rs.next()) {
			
			//System.out.println(rs.getInt(1) + " "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
			
			System.out.println(rs.getString("sname")+" "+rs.getInt("id")+" "+rs.getString("scity")+" "+rs.getInt("sage"));
			
		}
		
		
		
	} 
		catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		finally{
			try {
				JdbcUtil.closeConnection(connect, statement);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}

	}
	

}
