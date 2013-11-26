package com.db;

import java.sql.*;

public class GetDetails {
	private String itemID;
				   
	public String[] details;
	
	private Connection conn;
	
	private Statement stmt;
	
	public GetDetails(String itemID)
	{
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
		if(itemID.charAt(0) == 'B')
		{
			details = new String[10];
			getDetailsForBook();
		}else if(itemID.charAt(0) == 'M')
		{
			details = new String[9];
			getDetailsForMagazine();
		}else if(itemID.charAt(0) == 'T')
		{
			details = new String[9];
			getDetailsForThesis();
		}else if(itemID.charAt(0) == 'R')
		{
			details = new String[9];
			getDetailsForTechnicalReport();
		}else if(itemID.charAt(0) == 'J')
		{
			details = new String[7];
			getDetailsForJournal();
		}
		try
		{
			stmt.close();
			DBConnection.Close(conn);
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void getDetailsForBook()
	{
		executeSQL("SELECT ITEM_ID, TITLE, PUBLISHER, EDITOR, CLASSIFICATION, POSITION, LAST_NAME, KEY_WORD, EDITION, BOOK_YEAR "
				+  "FROM LIBRARY_CATEGORY NATURAL JOIN BOOK NATURAL JOIN AUTHOR "
				+  "WHERE ITEM_ID='" + itemID + "'");
	}
	
	public void getDetailsForMagazine()
	{
		executeSQL("SELECT ITEM_ID, TITLE, PUBLISHER, EDITOR, CLASSIFICATION, POSITION, CONTRIBUTOR, EDITION, MAGAZINE_YEAR "
				+  "FROM LIBRARY_CATEGORY NATURAL JOIN MAGAZINE "
				+  "WHERE ITEM_ID='" + itemID + "'");
	}
	
	public void getDetailsForThesis()
	{
		executeSQL("SELECT ITEM_ID, TITLE, PUBLISHER, EDITOR, CLASSIFICATION, POSITION, LAST_NAME, KEYWORD, THESIS_DATE "
				+  "FROM LIBRARY_CATEGORY NATURAL JOIN THESIS NATURAL JOIN AUTHOR "
				+  "WHERE ITEM_ID='" + itemID + "'");
	}
	
	public void getDetailsForTechnicalReport()
	{
		executeSQL("SELECT ITEM_ID, TITLE, PUBLISHER, EDITOR, CLASSIFICATION, POSITION, LAST_NAME, KEYWORD, REPORT_DATE "
				+  "FROM LIBRARY_CATEGORY NATURAL JOIN TECHTICAL_REPORT NATURAL JOIN AUTHOR "
				+  "WHERE ITEM_ID='" + itemID + "'");
	}
	
	public void getDetailsForJournal()
	{
		executeSQL("SELECT ITEM_ID, TITLE, PUBLISHER, EDITOR, CLASSIFICATION, POSITION, JOURNAL_DATE "
				+  "FROM LIBRARY_CATEGORY NATURAL JOIN JOURNAL "
				+  "WHERE ITEM_ID='" + itemID + "'");
	}
	
	public void executeSQL(String sql)
	{
		try
		{
			ResultSet rset = stmt.executeQuery(sql);
			for (int i=0; i<details.length;i++)
			{
				details[i] = rset.getString(i+1);
			}
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
