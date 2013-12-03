package com.db;

import java.sql.*;
public class administration {
	
	private String itemID;


	
	public administration(String itemID)
	{
		this.itemID = itemID;
//		try
//		{
//			conn = DBConnection.GetConnection();
//			stmt = conn.createStatement();
//		}catch (ClassNotFoundException e)
//		{
//			e.printStackTrace();
//		}catch (SQLException e)
//		{
//			e.printStackTrace();
//		}		
	}
	
	
	
	//method for deleting the books
	public void deleting(){
		try
		{
			Connection conn = DBConnection.GetConnection();
			Statement stmt = conn.createStatement();
			stmt.executeQuery("DELETE FROM LIBRARY_CATEGORY "
							+ "WHERE ITEM_ID = '" + itemID + "'");	
			
		}catch (SQLException e)
		{
			e.printStackTrace();
		}	catch (ClassNotFoundException e)
	{
		e.printStackTrace();
	}	
	}
	
	//method for adding copies	
	public void addingCopy(){
		try
		{
			Connection conn = DBConnection.GetConnection();
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT MAX(COPY_ID) "
											 + "FROM(SELECT COPY_ID "
					                         + "FROM COPY "
					                         + "WHERE ITEM_ID='" + itemID+"')");
			String copy = "";
			while(rset.next())
				copy = rset.getString(1);
			Integer copyIndex= Integer.parseInt(copy);
			copyIndex += 1;
			copy = copyIndex.toString();
			stmt.executeQuery("INSERT INTO COPY "
						    + "VALUES('"+itemID+"', "+copy+", 1)");
		}catch (SQLException e)
		{
			e.printStackTrace();
		}catch (ClassNotFoundException e)
		{
		e.printStackTrace();
	}	
	}
	
	//method for deleting copies
	public void deletingCopy(){
		
		try
		{
			Connection conn = DBConnection.GetConnection();
			Statement stmt = conn.createStatement();
			stmt.executeQuery("DELETE FROM COPY "
							 +"WHERE COPY_ID = (SELECT MAX(COPY_ID) "
							 +"FROM COPY "
							 +"WHERE STATUS = 1 AND ITEM_ID ='" + itemID+"') AND ITEM_ID = '"+itemID+"'");
		}catch (SQLException e)
		{
			e.printStackTrace();
		}catch (ClassNotFoundException e)
		{
		e.printStackTrace();
	}	
		
	}
	

}
