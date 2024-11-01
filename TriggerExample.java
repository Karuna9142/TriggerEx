package com.trigger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class TriggerExample
{
	public void jdbc_trigger() 
	{
	try 
	{
		String url ="jdbc:mysql://localhost:3306/triggerdemo";
		String username = "root";
		String password = "Mishra12345#";
		
		Connection con = DriverManager.getConnection(url, username, password);
		Statement stmt = con.createStatement();

		// Define the SQL statement to create a trigger
		String createTriggerSQL= "CREATE TRIGGER update_timestamp " +
		"BEFORE INSERT ON Salary_Log " +
		"FOR EACH ROW " +
		"BEGIN " +
		" SET NEW.new_salary = NOW(); " +
		"END;";
		
		// Execute the SQL statement to create the trigger
		stmt.executeUpdate(createTriggerSQL);
		System.out.println("Trigger created successfully.");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


	public static void main(String[] args) throws SQLException 
	{
      TriggerExample t1 = new TriggerExample();
      t1.jdbc_trigger();
	}

}
