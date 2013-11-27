package com.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BorrowBook {
	private String itemID,
			       user;
	

	
	public BorrowBook(String user, String itemID)
	{
		this.user = user;
		this.itemID = itemID;

	}
	
	public boolean checkUserAmount()
	{
		try
		{
			int temp = 0;
			Connection conn = DBConnection.GetConnection();
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT COUNT(MEMBER_ID) "
					                         + "FROM BORROW "
					                         + "WHERE MEMBER_ID='" + user + "'");	
			while (rset.next())
				temp = Integer.parseInt(rset.getString(1));
			DBConnection.Close(conn);
			stmt.close();
			return temp<20;
		}catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			return false;
		}		
	}
	
	public boolean bookIsAvailable()
	{
		try
		{
			int temp = 0;
			Connection conn = DBConnection.GetConnection();
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT COUNT(ITEM_ID) "
					                         + "FROM COPY "
					                         + "WHERE ITEM_ID='" + itemID + "' AND STATUS=1");
			while (rset.next())
				temp = Integer.parseInt(rset.getString(1));
			DBConnection.Close(conn);
			stmt.close();
			return temp>0;
		}catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public void borrowBook()
	{
		try
		{
			Date d=new Date();   
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String startDate = df.format(d);
			String dueDate = df.format(new Date(d.getTime() + 20 * 24 * 60 * 60 * 1000 + 10 * 24 * 60 * 60 * 1000));
			String copy = "";
			Connection conn = DBConnection.GetConnection();
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT COPY_ID "
					                         + "FROM COPY "
					                         + "WHERE ITEM_ID='" + itemID + "' AND STATUS=1 AND ROWNUM=1");
			while (rset.next())
				copy = rset.getString(1);
			
  		    stmt.executeQuery("INSERT INTO BORROW "
					        + "VALUES('" + itemID + "', " + copy + ", '" + user + "', TO_DATE('" + dueDate + "','YYYY-MM-DD HH24:MI:SS'), TO_DATE('" + startDate + "','YYYY-MM-DD HH24:MI:SS'))");
			stmt.executeQuery("UPDATE COPY "
			        + "SET STATUS=0 "
			        + "WHERE ITEM_ID='" + itemID + "' AND COPY_ID=" + copy);
			DBConnection.Close(conn);
			stmt.close();
		}catch (SQLException e)
		{
			e.printStackTrace();
		}catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
}
