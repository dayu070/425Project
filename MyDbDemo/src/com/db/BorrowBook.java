package com.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BorrowBook {
	private String itemID,
			       user;
	
	private Connection conn;
	
	private Statement stmt;
	
	public BorrowBook(String user, String itemID)
	{
		this.user = user;
		this.itemID = itemID;
		try
		{
			conn = DBConnection.GetConnection();
			stmt = conn.createStatement();
		}catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}catch (SQLException e)
		{
			e.printStackTrace();
		}		
	}
	
	public boolean checkUserAmount()
	{
		try
		{
			ResultSet rset = stmt.executeQuery("SELECT COUNT(MEMBER_ID) "
					                         + "FROM BORROW "
					                         + "WHERE MEMBER_ID=" + user);	
			return Integer.parseInt(rset.getString(1))<20;
		}catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}		
	}
	
	public boolean bookIsAvailable()
	{
		try
		{
			ResultSet rset = stmt.executeQuery("SELECT COUNT(ITEM_ID) "
					                         + "FROM COPY "
					                         + "WHERE ITEM_ID=" + itemID + " AND STATUS=1");	
			return Integer.parseInt(rset.getString(1))>0;
		}catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}		
	}
	
	public void borrowBook()
	{
		try
		{
			ResultSet rset = stmt.executeQuery("SELECT COPY_ID "
					                         + "FROM COPY "
					                         + "WHERE ITEM_ID=" + itemID + " AND STATUS=1 AND ROWNUM=1");
			String copy = rset.getString(1);
			stmt.executeQuery("UPDATE COPY "
					        + "SET STATUS=0 "
					        + "WHERE ITEM_ID=" + itemID + " AND COPY_ID=" + copy);
			stmt.executeQuery("INSERT INTO BORROW "
					        + "VALUES('" + itemID + "', " + copy + ", '" + user + "', null, null)");
		}catch (SQLException e)
		{
			e.printStackTrace();
		}	
	}
	
}
