package com.db;

import java.sql.*;
public class journalArticle {

	private Connection conn;
	private Statement stmt;
	public journalArticle(){

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
	public void adding(String item_id, String publisher, String editor, String title, String classification, String position, String keyword, String article_title){
		try
		{	stmt.executeQuery("INSERT INTO LIBRARY_CATEGORY"
							+ "VALUE('"+ item_id+"','"+publisher+"','"+editor+"','"+title+"','"+classification+"','"+position+"'");
			stmt.executeQuery("INSERT INTO MANAZINE"
							+ "VALUE('" + item_id +"','"+keyword+"',"+article_title);	
		}catch (SQLException e)
		{
			e.printStackTrace();
		}		
	}
	public void modifying(String item_id, String publisher, String editor, String title, String classification, String position, String keyword, String article_title){
		try
		{
			stmt.executeQuery("UPDATE LIBRARY_CATEGORY"
							+"SET PUBLISHER ='"+publisher+"'"
							+"SET EDITOR = '"+editor+"'"
							+"SET TITLE = '"+title+"'"
							+"SET CLASSIFICATION = '"+classification+"'"
							+"SET POSITION = '"+position +"'"
							+"WHERE ITEM_ID = '"+item_id+"'");
			stmt.executeQuery("UPDATE BOOK"
							+"SET KEYWORD = '"+keyword+"'"
							+"SET ARTICLE_TITLE = "+article_title
							+"WHERE ITEM_ID = '"+item_id+"'");
		}catch (SQLException e)
		{
			e.printStackTrace();
		}	
	}
}
