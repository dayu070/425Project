package com.db;


import java.sql.*;

public class DBConnection {
	public static void JDBCExample() throws ClassNotFoundException
	{
	try { 
			Class.forName ("oracle.jdbc.driver.OracleDriver"); // load driver?
			Connection conn = DriverManager.getConnection( // connect to server 
			DBConfig.URL, DBConfig.USER, DBConfig.PASSWORD); 
			Statement stmt = conn.createStatement(); // create Statement object?
			PreparedStatement pstmt = null;
			ResultSet rset = stmt.executeQuery("SELECT ANAME FROM ANIMAL");
			while (rset.next())
			{
				System.out.println(rset.getString("aname"));
			}
			stmt.close(); // close Statement and release resources ??
			conn.close(); // close Connection and release resources
			
			}
			
			catch (SQLException sqle) { 
			
			System.out.println("SQLException : " + sqle);// handle exceptions
			
			}
	}
	
	public static void main(String args[]) throws ClassNotFoundException {
		JDBCExample();
	}
}
