package com.telusko.jdbclearning;

import com.telusko.jdbclearning.JdbcUtil;
import java.util.*;
import java.sql.*;

public class delete_preparedStatement 
{

	public static void main(String[] args) 
	{
		Connection connect = null;
		PreparedStatement pstmnt=null;
		try
		{
			connect=JdbcUtil.getConnection();
			String sql = "delete from studentinfo where id=?";
			pstmnt=connect.prepareStatement(sql);
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter the student id for delete: ");
			int id=scan.nextInt();
			
			
			pstmnt.setInt(1, id);
		
			
			int ra=pstmnt.executeUpdate();
			
			if(ra==0)
				System.out.println("deletion failed");
			else
				System.out.println("Successfully deleted");
			
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
