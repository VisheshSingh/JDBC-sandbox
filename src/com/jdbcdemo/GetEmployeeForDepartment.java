package com.jdbcdemo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetEmployeeForDepartment {

	public static void main(String[] args) throws Exception {

		Connection myConn = null;
		CallableStatement myStmt = null;

		try {
			// Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hb_student_tracker", "hbstudent",
					"hbstudent");

			String theDepartment = "Engineering";

			// Prepare the stored procedure call
			myStmt = myConn.prepareCall("{call get_employees_for_department(?)}");

			// Register and Set the parameters
			myStmt.setString(1, theDepartment);

			// Call stored procedure
			System.out.println("\n\nCalling stored procedure.  get_employees_for_department('" + theDepartment + "')");
			myStmt.execute();
			System.out.println("Finished calling stored procedure");

			ResultSet rs = myStmt.getResultSet();
			display(rs);

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	private static void display(ResultSet myRs) throws SQLException {
		while (myRs.next()) {
			String lastName = myRs.getString("last_name");
			String firstName = myRs.getString("first_name");
			double salary = myRs.getDouble("salary");
			String department = myRs.getString("department");

			System.out.printf("%s, %s, %.2f, %s\n", lastName, firstName, salary, department);
		}
	}
}
