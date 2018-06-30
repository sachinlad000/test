package com.exl.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.hssf.usermodel.HSSFRow;

import com.exl.util.GetConnection;

public class Test 
{
//public static void main(String[] args) {
	
	private String sqlquery=null;
	private String header_name=null;
	private String column_name=null;
	private String[] header=null;
	private String[] column=null;
	
	
	public String getSqlquery() {
		return sqlquery;
	}
		
	public String[] getHeader() {
		return header;
	}
	
	public String[] getColumn() {
		return column;
	}

	public void getData()
	{
	System.out.println("2");
	try {
	Connection con=new GetConnection().getDbConnection();
	String selectSQL = "SELECT * FROM sqlconfig WHERE id = ?";
	PreparedStatement preparedStatement;

		preparedStatement = con.prepareStatement(selectSQL);
		preparedStatement.setString(1, "2");
		ResultSet rs = preparedStatement.executeQuery();
	
	while (rs.next()) {
		 sqlquery = rs.getString("query");
		 header_name = rs.getString("header");	
		 column_name = rs.getString("cloumn");	
		
		
	}
	
	 header = header_name.split("\\|");
	 column = column_name.split("\\|");

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

//}
	

	
	
}
