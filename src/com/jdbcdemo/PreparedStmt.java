package com.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStmt {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/hb_student_tracker";
		String username = "hbstudent";
		String pwd = "hbstudent";
		try {
			// 1. Get a connection to DB
			Connection myConn = DriverManager.getConnection(url, username, pwd);

			// 2. Create a Statement object and set parameters
			PreparedStatement myStmt = myConn
					.prepareStatement("Select * from employees where salary > ? and department= ?");

			myStmt.setDouble(1, 80000);
			myStmt.setString(2, "Legal");

			// 3. Execute the SQL query
			ResultSet myRS = myStmt.executeQuery();

			// 4. Process the result set
			display(myRS);

		} catch (Exception e) {
			e.printStackTrace();
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
