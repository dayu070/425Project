package com.db;

import java.sql.*;
public class thesis {


	public thesis(){

		
	}
	public void adding(String item_id, String publisher, String editor, String title, String classification, String position, String first, String middle, String last, String keyword, String thesis_date){
		try
		{	
			Connection conn = DBConnection.GetConnection();
			Statement stmt = conn.createStatement();
			stmt.executeQuery("INSERT INTO LIBRARY_CATEGORY "
					+ "VALUES('" + item_id + "','" + publisher + "','" + editor + "','" + title + "','" + classification + "','" + position + "')");
			stmt.executeQuery("INSERT INTO AUTHOR VALUES('" + item_id + "','" + first + "','" + middle + "','" + last +"')");
			stmt.executeQuery("INSERT INTO THESIS VALUES('" + item_id + "','" + keyword + "',TO_DATE('" + thesis_date + "','YYYY-MM-DD HH24:MI:SS'))");
		}catch (SQLException e)
		{
			e.printStackTrace();
		}catch (ClassNotFoundException e)
		{
		e.printStackTrace();
		}
	}
	public void modifying(String item_id, String publisher, String editor, String title, String classification, String position, String keyword,String thesis_date){
		try
		{
			Connection conn = DBConnection.GetConnection();
			Statement stmt = conn.createStatement();
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
			
			
			stmt.executeQuery("UPDATE THESIS " 
							+"SET KEYWORD = '"+keyword+"' "
							+"WHERE ITEM_ID = '"+item_id+"' ");
//			stmt.executeQuery("UPDATE THESIS "
//					+"SET THESIS_DATE = '"+thesis_date+"' "
//					+"WHERE ITEM_ID = '"+item_id+"' ");

		}catch (SQLException e)
		{
			e.printStackTrace();
		}catch (ClassNotFoundException e)
		{
		e.printStackTrace();
		
	}	
		
	}

}
