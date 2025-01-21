package com.telusko.jdbclearning;
import java.sql.*;

import java.util.*;

public class LaunchApp1
{

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		
		//load and register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Establish the connection 
		
		String url="jdbc:mysql://localhost:3306/jdbclearning";
		String user="root";
		String password="9152591";
		Connection connect=DriverManager.getConnection(url,user,password);

		//create statement
		
		Statement statement=connect.createStatement();
		
		//execute query
		
		//String sql="INSERT INTO studentinfo(id,sname,sage,scity)VALUES(2,'Ashik',25,'Gaibandha');";
		
		//String sql="insert into studentinfo values(4,'Hasan',24,'Rajshahi');";
		
		Scanner scan = new Scanner(System.in);
		
		//String sql="insert into studentinfo values(?,?,?,?)";
		String sql="select * from studentinfo where id=?";
		
		PreparedStatement preparedStatement=connect.prepareStatement(sql);
		int id=1;
		
		preparedStatement.setInt(1,id);
		
		ResultSet rs = preparedStatement.executeQuery();
		
		while(rs.next()) {
			
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
			
		}
		
//		System.out.println("Enter the number of total student");
//		int n = scan.nextInt();
		
//		for(int i=0;i<n; i++) {
//			System.out.println("Enter student id :");
//			int id,age ;
//			String name , city ;
//			id= scan.nextInt();
//			scan.nextLine();
//			System.out.println("Enter student name:");
//			name=scan.nextLine();
//			System.out.println("Eneter student age : ");
//			age=scan.nextInt();
//			scan.nextLine();
//			System.out.println("Enter student city :");
//			city= scan.nextLine();
//			
//			preparedStatement.setInt(1, id);
//			preparedStatement.setString(2,name);
//			preparedStatement.setInt(3,age);
//			preparedStatement.setString(4,city);
//			
//			
//			
//			
//			int rf=preparedStatement.executeUpdate();
//			if(rf==0) {
//				System.out.println("data can't ber inserted");
//			}else {
//				System.out.println("Data inserted successfully");
//			}
//			
//			
//			
//		}
		
		
		
		
		
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
