package com.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetadata {

	public static void main(String[] args) {
		Connection myConn = null;
		ResultSet myRs = null;

		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hb_student_tracker", "hbstudent",
					"hbstudent");
			Statement myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("Select * from employees");

			// Metadata info
			ResultSetMetaData rsmd = myRs.getMetaData();

			System.out.println("Column Count: " + rsmd.getColumnCount());
			int count = rsmd.getColumnCount();
			for (int i = 1; i <= count; i++) {
				System.out.println("Column Name:" + rsmd.getColumnName(i));
				System.out.println("Column Type:" + rsmd.getColumnTypeName(i));
				System.out.println("Is Nullable:" + rsmd.isNullable(i));
				System.out.println("Auto increment:" + rsmd.isAutoIncrement(i) + "\n");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
