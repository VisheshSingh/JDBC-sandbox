package com.jdbcdemo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class GetCountForDepartment {
	public static void main(String[] args) throws Exception {

		Connection myConn = null;
		CallableStatement myStmt = null;

		try {
			// Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hb_student_tracker", "hbstudent",
					"hbstudent");

			String theDepartment = "HR";

			// Prepare the stored procedure call
			myStmt = myConn.prepareCall("{call get_count_for_department(?,?)}");

			// Register and Set the parameters
			myStmt.setString(1, theDepartment);
			myStmt.registerOutParameter(2, Types.INTEGER);

			// Call stored procedure
			System.out.println("\n\nCalling stored procedure.  greet_the_department('" + theDepartment + "')");
			myStmt.execute();
			System.out.println("Finished calling stored procedure");

			int result = myStmt.getInt(2);
			System.out.println("The count = " + result);

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
