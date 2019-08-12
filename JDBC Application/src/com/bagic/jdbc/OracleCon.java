package com.bagic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleCon {
	public static void main(String[] args) {
		try{
			//1.load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.create the connection object.
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			
			//3.create the statement object
			Statement st=con.createStatement();
			
			//4.execute the query
			ResultSet rs=st.executeQuery("select * from emp");
			while(rs.next())
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			
			//5.close the connection
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}
		
	}

}
