package com.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.testng.annotations.Test;

public class MSaccessExample {

	
	@Test
	public void TestVerifyDB(){

		
		//Source - http://learn-automation.com/database-testing-using-selenium-webdriver/
		
		try {
		//	This will load the driver
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		System.out.println("Driver Loaded");
				
		//Specify the path of the database
		String dblocation= ".\\..\\POCdb.accdb";
		
		
		Connection  con=DriverManager.getConnection("jdbc:odbc:AscentAccess;DBQ="+dblocation);
		System.out.println("Connection created");
				
		// This will create statement  
		Statement smt=con.createStatement();
		
		System.out.println("Statement created");
		
		
		// Now execute the query, here T1  is the table which I have created in DB 
		ResultSet rs=smt.executeQuery("Select * from T1");
		
		System.out.println("Query Executed");
		
		//Iterate the resultset now
		while(rs.next()){
			String uname= rs.getString("Date1");
			String pass= rs.getString("Name1");
			
		System.out.println("Uname is "+uname+" password is "+pass);
		
		Statement st=con.createStatement();
        String productId="abc";
        st.executeUpdate("INSERT into T1(Name1) VALUES('"+productId+"')");
        st.close();
        System.out.println("Row is added");
		
		}
	}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
