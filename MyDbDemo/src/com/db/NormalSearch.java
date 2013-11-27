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
		
		getResult();
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
		
		/*try
		{
			stmt.close();
			DBConnection.Close(conn);
		}catch (SQLException e)
		{
			e.printStackTrace();
		}*/
	}
	
	private void executeSQL(String sql)
	{
		try
		{
			Connection conn = DBConnection.GetConnection();
			Statement stmt = conn.createStatement();
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
			stmt.close();
		}catch (SQLException e)
		{
			e.printStackTrace();
		}catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}
	
	private void sort()
	{
		for (int i = 1; i < index; i++)
			for (int k = i; k > 0 && bi [k -1].compareTo(bi [k])>0 ; k--)
				AdvancedSearch.swap (bi, k, k -1);
	}
	
	public int getResultNumber()
	{
		return index;
	}	
	
	public static void main(String args[]){
		NormalSearch ns = new NormalSearch("Computer");
		System.out.println(ns.index);
		for (int i=0; i<ns.index;i++)
		{
			System.out.println(ns.bi[i].getTitle());
			//System.out.println(as.al.get(i));
		}
	}
}
