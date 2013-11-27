package com.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class AdvancedSearch {
	private String title,
	               author,
	               classification,
	               keywords;
	
	
	
	public BookInformation[] bi;
	
	private int index;
	
	private ArrayList<String> al;
	
	private PriorityQueue<BookInformation> pq;
	
	public AdvancedSearch(String title, String author, String classification, String keywords)
	{
		this.title = title;
		this.author = author;
		this.classification = classification;
		this.keywords = keywords;
		bi = new BookInformation[100];
		al = new ArrayList<String>(100);
		pq = new PriorityQueue<BookInformation>(100);
		index = 0;
		getResult();
//		try
//		{
//			
//			
//			getResult();
//		}catch (ClassNotFoundException e)
//		{
//			e.printStackTrace();
//		}catch (SQLException e)
//		{
//			e.printStackTrace();
//		}
	}
	
	public void getResult()
	{	
		if(!title.equals(""))
		{
			executeSQL("(SELECT ITEM_ID, TITLE "
					+  "FROM LIBRARY_CATEGORY "
					+  "WHERE TITLE LIKE '%" + title + "%') "
					+  "UNION (SELECT ITEM_ID, TITLE "
					+  "FROM LIBRARY_CATEGORY NATURAL JOIN JOURNAL_ARTICLE "
					+  "WHERE ARTICLE_TITLE LIKE '%" + title + "%') ");
		}
		
		if(!classification.equals(""))
		{
			executeSQL("SELECT ITEM_ID, TITLE "
					+  "FROM LIBRARY_CATEGORY "
					+  "WHERE CLASSIFICATION LIKE '%" + classification + "%'");
		}
		
		if(!author.equals(""))
		{
			executeSQL("(SELECT ITEM_ID, TITLE "
					 + "FROM AUTHOR NATURAL JOIN LIBRARY_CATEGORY "
					 + "WHERE FIRST_NAME LIKE '%" + author + "%'" + " OR LAST_NAME LIKE '%" + author + "%'" +") "
					 + "UNION (SELECT ITEM_ID, TITLE "
					 + "FROM JOURNAL_ARTICLE_AUTHOR NATURAL JOIN LIBRARY_CATEGORY "
					 + "WHERE FIRST_NAME LIKE '%" + author + "%'" + " OR LAST_NAME LIKE '%" + author + "%'" +") ");
		}
		
		if(!keywords.equals(""))
		{
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
		}
				
		sort();

//		try
//		{
//			stmt.close();
//			/*DBConnection.Close(conn);*/
//		}catch (SQLException e)
//		{
//			e.printStackTrace();
//		}
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
				swap (bi, k, k -1);
	}
	
	public static void swap (BookInformation [ ] x, int a, int b)
	{
		BookInformation t = x[a];
		x[a] = x[b];
		x[b] = t;
	}
	
	public int getResultNumber()
	{
		return index;
	}
	
	public static void main(String args[]){
		AdvancedSearch as = new AdvancedSearch("", "", "a", "");
		System.out.println(as.index);
		for (int i=0; i<as.index;i++)
		{
			System.out.println(as.bi[i].getTitle());
			//System.out.println(as.al.get(i));
		}
//		try
//		{
//			Connection conn = DBConnection.GetConnection();
//			Statement stmt = conn.createStatement();
//			ResultSet rset = stmt.executeQuery("(SELECT ITEM_ID, TITLE "
//					+  "FROM LIBRARY_CATEGORY "
//					+  "WHERE TITLE LIKE '%a%') "
//					+  "UNION (SELECT ITEM_ID, TITLE "
//					+  "FROM LIBRARY_CATEGORY NATURAL JOIN JOURNAL_ARTICLE "
//					+  "WHERE ARTICLE_TITLE LIKE '%a%') ");
//			while(rset.next())
//			System.out.println(rset.getString(1));
//		}catch(ClassNotFoundException e)
//		{
//			e.printStackTrace();
//		}catch (SQLException e)
//		{
//			e.printStackTrace();
//		}
		
	}
}

class BookInformation implements Comparable<BookInformation>
{
	private String title,
	               id;
	
	private int matches;
    
	public BookInformation(String id, String title)
	{
		this.title = title;
		this.id = id;
		matches = 1;
	}
	
	public int getMatches()
	{
		return matches;
	}
	
	public void increaseMatches()
	{
		matches++;
	}
	
	public int compareTo(BookInformation bi)
	{
		if(this.matches>bi.getMatches())
			return -1;
		else if(this.matches==bi.getMatches())
			return 0;
		else
			return 1;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getID()
	{
		return id;
	}
}
