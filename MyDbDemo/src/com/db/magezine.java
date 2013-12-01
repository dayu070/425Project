package com.db;
import java.sql.*;
public class magezine {

	public magezine(){
		
	}
	
	public void adding(String item_id, String publisher, String editor, String title, String classification, String position, double edition, String contributor,int magazine_year){
		try
		{	
			Connection conn = DBConnection.GetConnection();
			Statement stmt = conn.createStatement();
			stmt.executeQuery("INSERT INTO LIBRARY_CATEGORY"
							+ "VALUE('"+ item_id+"','"+publisher+"','"+editor+"','"+title+"','"+classification+"','"+position+"'");
			stmt.executeQuery("INSERT INTO MANAZINE"
							+ "VALUE('" + item_id +"',"+edition+",'"+contributor+"',"+magazine_year);	
		}catch (SQLException e)
		{
			e.printStackTrace();
		}catch (ClassNotFoundException e)
		{
		e.printStackTrace();
	}		
	}
	public void modifying(String item_id, String publisher, String editor, String title, String classification, String position, String edition, String contributor,String magazine_year){
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
			
			
			stmt.executeQuery("UPDATE MAGAZINE "
					+"SET EDITION = "+edition
					+" WHERE ITEM_ID = '"+item_id+"' ");
			stmt.executeQuery("UPDATE MAGAZINE"
			+" SET CONTRIBUTOR = '"+contributor+"' "
			+" WHERE ITEM_ID = '"+item_id+"' ");
			stmt.executeQuery("UPDATE MAGAZINE "
			+"SET MANAZINE_YEAR ="+magazine_year+" "
			+" WHERE ITEM_ID = '"+item_id+"' ");
		}catch (SQLException e)
		{
			e.printStackTrace();
		}		catch (ClassNotFoundException e)
		{
		e.printStackTrace();
		
	}

}
}
