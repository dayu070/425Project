package com.db;

import java.sql.*;
import java.util.ArrayList;

public class AdvancedSearch {
	private String title,
	               author,
	               classification,
	               keywords;
	
	private Statement stmt;
	
	public BookInformation[] bi;
	
	private int index;
	
	private ArrayList<String> al;
	
	public AdvancedSearch(String title, String author, String classification, String keywords)
	{
		this.title = title;
		this.author = author;
		this.classification = classification;
		this.keywords = keywords;
		bi = new BookInformation[100];
		al = new ArrayList<String>(100);
		index = 0;
		
		try
		{
			stmt = new DBConnection().GetConnection().createStatement();
		}catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void getResult()
	{	
		executeSQL("SELECT ITEM_ID, TITLE FROM LIBRARY_CATEGORY WHERE TITLE=" + title);
		
		executeSQL("SELECT ITEM_ID, TITLE FROM LIBRARY_CATEGORY WHERE CLASSIFICATION=" + classification);
		
		executeSQL("(SELECT ITEM_ID, TITLE "
				 + "FROM AUTHOR NATURAL JOIN LIBRARY_CATEGORY "
				 + "WHERE FIRST_NAME=" + author + " OR LAST_NAME=" + author +") "
				 + "UNION (SELECT ITEM_ID, TITLE "
				 + "FROM JOURNAL_ARTICLE_AUTHOR NATURAL JOIN LIBRARY_CATEGORY "
				 + "WHERE FIRST_NAME=" + author + " OR LAST_NAME=" + author +") ");
		
		executeSQL("(SELECT ITEM_ID, TITLE "
				 + "FROM BOOK NATURAL JOIN LIBRARY_CATEGORY "
				 + "WHERE KEY_WORD=" + keywords +") "
				 + "UNION (SELECT ITEM_ID, TITLE "
				 + "FROM JOURNAL_ARTICLE NATURAL JOIN LIBRARY_CATEGORY "
				 + "WHERE KEYWORD=" + keywords +") "
				 + "UNION (SELECT ITEM_ID, TITLE "
				 + "FROM TECHNICAL_REPORT NATURAL JOIN LIBRARY_CATEGORY "
				 + "WHERE KEYWORD=" + keywords +") "
				 + "UNION (SELECT ITEM_ID, TITLE "
				 + "FROM THESIS NATURAL JOIN LIBRARY_CATEGORY "
				 + "WHERE KEYWORD=" + keywords +") ");
	}
	
	public void executeSQL(String sql)
	{
		try
		{
			ResultSet rset = stmt.executeQuery(sql);
			while(rset.next())
			{
				if (al.contains(rset.getString(1)))
				{
					al.add(rset.getString(1));
					bi[index++] = new BookInformation(rset.getString(1), rset.getString(2));
				}
			}
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}

class BookInformation
{
	private String title,
	               id;
    
	public BookInformation(String title, String id)
	{
		this.title = title;
		this.id = id;
	}
}
