package com.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReturnDoc {
	private String itemID,
			       copyID;
	public ReturnDoc(String copyID, String itemID)
	{
		this.copyID = copyID;
		this.itemID = itemID;

	}
	public void returnBook()
	{
		try
		{
			Connection conn = DBConnection.GetConnection();
			Statement stmt = conn.createStatement();
/*			String copy = "";
			System.out.println(copy);
			ResultSet rset = stmt.executeQuery("SELECT COPY_ID "
                    + "FROM BORROW "
                    + "WHERE ITEM_ID='" + itemID + "' AND MEMBER_ID='"+user+"' ");
			while (rset.next())
				copy = rset.getString(1);*/
			stmt.executeQuery("DELETE "
			        + "FROM BORROW "
			        + "WHERE ITEM_ID='" + itemID + "' AND COPY_ID="+copyID+" ");
			stmt.executeQuery("UPDATE COPY "
			        + "SET STATUS = 1 "
			        + "WHERE ITEM_ID='" + itemID + "' AND COPY_ID="+copyID);
//			DBConnection.Close(conn);
//			stmt.close();
		}catch (SQLException e)
		{
			e.printStackTrace();
		}catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
}
