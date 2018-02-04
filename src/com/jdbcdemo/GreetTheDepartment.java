package com.jdbcdemo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class GreetTheDepartment {

	public static void main(String[] args) throws Exception {

		Connection myConn = null;
		CallableStatement myStmt = null;

		try {
			// Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hb_student_tracker", "hbstudent",
					"hbstudent");

			String theDepartment = "Legal";

			// Prepare the stored procedure call
			myStmt = myConn.prepareCall("{call greet_the_department(?)}");

			// Register and Set the parameters
			myStmt.registerOutParameter(1, Types.VARCHAR);
			myStmt.setString(1, theDepartment);

			// Call stored procedure
			System.out.println("\n\nCalling stored procedure.  greet_the_department('" + theDepartment + "')");
			myStmt.execute();
			System.out.println("Finished calling stored procedure");

			String result = myStmt.getString(1);
			System.out.println("The Result = " + result);

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
