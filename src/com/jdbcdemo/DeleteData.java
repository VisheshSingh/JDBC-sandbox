package com.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteData {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/hb_student_tracker";
		String username = "hbstudent";
		String pwd = "hbstudent";
		try {
			// 1. Get a connection to DB
			Connection myConn = DriverManager.getConnection(url, username, pwd);

			// 2. Create a Statement object
			Statement myStmt = myConn.createStatement();

			// 3. Execute the SQL query
			String sql = "DELETE FROM student where last_name='Kotlin'";

			int i = myStmt.executeUpdate(sql);

			// 4. Process the result set
			System.out.println(i + " Record deleted.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
