package com.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class NormalSearch{
	private String title,
                   classification,
                   keywords;
	
	private Connection conn;

	private Statement stmt;

	public BookInformation[] bi;

	private int index;

	private ArrayList<String> al;

	private PriorityQueue<BookInformation> pq;
	
	public NormalSearch(String wordsforsearching)
	{
		title = wordsforsearching;
	    classification = wordsforsearching;
		keywords = wordsforsearching;
		bi = new BookInformation[100];
		al = new ArrayList<String>(100);
		pq = new PriorityQueue<BookInformation>(100);
		index = 0;
		
		try
		{
			conn = DBConnection.GetConnection();
			stmt = conn.createStatement();
			getResult();
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
		executeSQL("(SELECT ITEM_ID, TITLE "
				+  "FROM LIBRARY_CATEGORY "
				+  "WHERE TITLE LIKE '%" + title + "%') "
				+  "UNION (SELECT ITEM_ID, TITLE "
				+  "FROM LIBRARY_CATEGORY NATURAL JOIN JOURNAL_ARTICLE "
				+  "WHERE ARTICLE_TITLE LIKE '%" + title + "%') ");
		
		executeSQL("SELECT ITEM_ID, TITLE FROM LIBRARY_CATEGORY WHERE CLASSIFICATION LIKE '%" + classification + "%'");
		
		executeSQL("(SELECT ITEM_ID, TITLE "
				 + "FROM BOOK NATURAL JOIN LIBRARY_CATEGORY "
				 + "WHERE KEY_WORD LIKE '%" + keywords + "%'" +") "
				 + "UNION (SELECT ITEM_ID, TITLE "
				 + "FROM JOURNAL_ARTICLE NATURAL JOIN LIBRARY_CATEGORY "
				 + "WHERE KEYWORD LIKE '%" + keywords + "%'" +") "
				 + "UNION (SELECT ITEM_ID, TITLE "
				 + "FROM TECHNICAL_REPORT NATURAL JOIN LIBRARY_CATEGORY "
				 + "WHERE KEYWORD LIKE '%" + keywords + "%'" +") "
				 + "UNION (SELECT ITEM_ID, TITLE "
				 + "FROM THESIS NATURAL JOIN LIBRARY_CATEGORY "
				 + "WHERE KEYWORD LIKE '%" + keywords + "%'" +") ");
		
		sort();
		
		try
		{
			stmt.close();
			DBConnection.Close(conn);
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	private void executeSQL(String sql)
	{
		try
		{
			ResultSet rset = stmt.executeQuery(sql);
			while(rset.next())
			{
				if (al.contains(rset.getString(1)))
				{
					bi[al.indexOf(rset.getString(1))].increaseMatches();
				}
				else
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
	
	private void sort()
	{
		for (BookInformation b : bi)
			pq.add(b);
		for (int i = 0; i < index; i++)
			bi[i++] = pq.poll();
	}
	
	public int getResultNumber()
	{
		return index;
	}	
}
