package com.exl.impl;
import  java.io.*;  
import  java.sql.*;
import  org.apache.poi.hssf.usermodel.HSSFSheet;  
import  org.apache.poi.hssf.usermodel.HSSFWorkbook; 
import  org.apache.poi.hssf.usermodel.HSSFRow;
import  org.apache.poi.hssf.usermodel.HSSFCell;  
import com.exl.impl.*;
import com.exl.util.GetConnection;


public class CreateReport 
{

	public static void main(String[] args) 
	{
		
		
		GetConnection gn=new GetConnection();
		Test t=new Test();
		Connection con=null;
		String[] header=null;
		String[] column=null;
		System.out.println("1");
		t.getData();
		header=t.getHeader();
		column=t.getColumn();
		System.out.println("4");
		try {
		String filename="E:/L2Support_Person2/CMSS/oxy-eclipse-workspace/rep/data.xls" ;
		HSSFWorkbook hwb=new HSSFWorkbook();
		HSSFSheet sheet =  hwb.createSheet("new sheet");
		
		
		HSSFRow rowhead=   sheet.createRow((short)0);
		for(int i=0;i<=header.length-1;i++)
		{
			rowhead.createCell((short) i).setCellValue(header[i]);
		}
		con=gn.getDbConnection();
		System.out.println("5");
		Statement st;
		st = con.createStatement();
		
		ResultSet rs=st.executeQuery(t.getSqlquery());
		System.out.println("6");
		int i=1;
		while(rs.next())
		{
		HSSFRow row=   sheet.createRow((short)i);
		//row.createCell((short) 0).setCellValue(Integer.toString(rs.getInt("SNo")));
			for(int z=0;z<=column.length-1;z++)
			{
				row.createCell((short) z).setCellValue(rs.getString(column[z]));
			}
		i++;
		}
		FileOutputStream fileOut =  new FileOutputStream(filename);
		hwb.write(fileOut);
		fileOut.close();
		System.out.println("Your excel file has been generated!");
		
		} catch (SQLException | IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
}

