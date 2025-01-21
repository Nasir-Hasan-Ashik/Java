package com.telusko.jdbclearning;
import com.telusko.jdbclearning.JdbcUtil;
import java.util.*;
import java.sql.*;

public class Batch_Update
{
	
	public static void main(String srgs[])
	{
		
		Connection connect = null;
		PreparedStatement pstmnt=null;
		try
		{
			connect=JdbcUtil.getConnection();
			String sql = "update studentinfo set sage=? where id=?";
			pstmnt=connect.prepareStatement(sql);
			
			
			pstmnt.setInt(1, 20);
			pstmnt.setInt(2, 1);
			pstmnt.addBatch();
			
			pstmnt.setInt(1, 30);
			pstmnt.setInt(2, 2);
			pstmnt.addBatch();
			
			pstmnt.executeBatch();
			
			System.out.println("See the database");
			
			
			
			

			
			
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
