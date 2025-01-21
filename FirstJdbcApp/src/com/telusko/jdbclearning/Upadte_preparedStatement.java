package com.telusko.jdbclearning;
import java.sql.SQLException;

import com.telusko.jdbclearning.JdbcUtil;
import java.sql.*;
import java.util.*;

public class Upadte_preparedStatement
{
	
	public static void main(String args[])
	{
		Connection connect = null;
		PreparedStatement pstmnt=null;
		try
		{
			connect=JdbcUtil.getConnection();
			String sql = "update studentinfo set sage=? where id=?";
			pstmnt=connect.prepareStatement(sql);
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter the student id for update age: ");
			int id=scan.nextInt();
			System.out.println("Enter the age of the student : ");
			int age = scan.nextInt();
			
			pstmnt.setInt(1, age);
			pstmnt.setInt(2, id);
			
			int ra=pstmnt.executeUpdate();
			
			if(ra==0)
				System.out.println("Updation failed");
			else
				System.out.println("Successfully updated");
			
//			sql="insert into studentinfo values (?,?,?,?)";
//			pstmnt = connect.prepareStatement(sql);
//			pstmnt.setInt(1, 2);
//			pstmnt.setString(2,"Hello");
//			pstmnt.setInt(3, 18);
//			pstmnt.setString(4, "dhaka");
//			
//			ra=pstmnt.executeUpdate();
//			if(ra==0)
//				System.out.println("can't inserted");
//			else
//				System.out.println("Successfully inserted");
			
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		finally{
			try {
				JdbcUtil.closeConnection(connect, pstmnt);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
	}
	
	

}
