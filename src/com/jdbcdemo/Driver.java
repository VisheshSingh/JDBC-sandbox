package com.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Driver {

	public static void main(String[] args) {
		try {
			// 1. Get a connection to DB
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hb_student_tracker",
					"hbstudent", "hbstudent");

			// 2. Create a Statement object
			Statement myStmt = myConn.createStatement();

			// 3. Execute the SQL query
			ResultSet myRS = myStmt.executeQuery("SELECT * FROM student");

			// 4. Process the result set
			while (myRS.next()) {
				System.out.println(myRS.getString("first_name") + ", " + myRS.getString("last_name"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
