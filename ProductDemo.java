package com.trigger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ProductDemo {

	public static void main(String[] args) {
		
		try 
		{
			//establish a connection
			String url ="jdbc:mysql://localhost:3306/triggerdemo1";
			String username = "root";
			String password = "Mishra12345#";
			
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
            
			//Insert a new product
			String insertProduct = "Insert into products(product_name, price) Values(?,?)";
			PreparedStatement pstmt = con.prepareStatement(insertProduct);
			
			//product name
            pstmt.setString(1, "Laptop"); 
            pstmt.setBigDecimal(2, new java.math.BigDecimal(45000.20));
            
			System.out.println("Product inserted successfully.");
			con.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
