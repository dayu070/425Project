package com.db;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class journal {

//	private Connection conn;
//	private Statement stmt;
	public journal(){


		
	}
	public void adding(String item_id, String publisher, String editor, String title, String classification, String position, String keyword, String journal_date){
		try
		{	Connection conn = DBConnection.GetConnection();
		Statement stmt = conn.createStatement();
			stmt.executeQuery("INSERT INTO LIBRARY_CATEGORY "
							+ "VALUE('"+ item_id+"','"+publisher+"','"+editor+"','"+title+"','"+classification+"','"+position+"' ");
			stmt.executeQuery("INSERT INTO MANAZINE "
							+ "VALUE('" + item_id +"','"+keyword+"',"+journal_date);	
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
		e.printStackTrace();
		}
	}
	public void modifying(String item_id, String publisher, String editor, String title, String classification, String position, String journal_date){
		try
		{
			Connection conn = DBConnection.GetConnection();
			Statement stmt = conn.createStatement();
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//Date d = new Date(journal_date + 20 * 24 * 60 * 60 * 1000 + 10 * 24 * 60 * 60 * 1000);
			
		 Date d = df.parse(journal_date);
			stmt.executeQuery("UPDATE LIBRARY_CATEGORY "
					+"SET PUBLISHER ='"+publisher+"' "
					+"WHERE ITEM_ID = '"+item_id+"' ");
			stmt.executeQuery("UPDATE LIBRARY_CATEGORY "
					+"SET EDITOR ='"+editor+"' "
					+"WHERE ITEM_ID = '"+item_id+"' ");
			stmt.executeQuery("UPDATE LIBRARY_CATEGORY "
					+"SET TITLE ='"+title+"' "
					+"WHERE ITEM_ID = '"+item_id+"' ");
			stmt.executeQuery("UPDATE LIBRARY_CATEGORY "
					+"SET CLASSIFICATION ='"+classification+"' "
					+"WHERE ITEM_ID = '"+item_id+"' ");
			stmt.executeQuery("UPDATE LIBRARY_CATEGORY "
					+"SET POSITION ='"+position+"' "
					+"WHERE ITEM_ID = '"+item_id+"' ");
			System.out.println(journal_date);
			System.out.println(d.toString());
			stmt.executeQuery("UPDATE JOURNAL " 
					+"SET JOURNAL_DATE = TO_DATE('" + journal_date.substring(0, 9) + "' ,'YYYY-MM-DD') "
					+"WHERE ITEM_ID = '"+item_id+"' ");
			
//			stmt.executeQuery("UPDATE BOOK"
//							+"SET KEYWORD = '"+keyword+"'"
//							+"SET JOURNAL_DATE = "+journal_date
//							+"WHERE ITEM_ID = '"+item_id+"'");
		}catch (SQLException e)
		{
			e.printStackTrace();
		}			
		catch (ClassNotFoundException e)
		{
		e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
