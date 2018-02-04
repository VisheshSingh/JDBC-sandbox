package com.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TransactionDemo {

	public static void main(String[] args) {
		Connection myConn = null;
		Statement myStmt = null;

		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hb_student_tracker", "hbstudent",
					"hbstudent");

			myConn.setAutoCommit(false);

			myStmt = myConn.createStatement();
			myStmt.executeUpdate("DELETE FROM employees WHERE department = 'HR'");
			myStmt.executeUpdate("UPDATE employees SET salary=300000 WHERE department='Engineering'");
			System.out.println(">> Transaction steps are ready");

			Scanner sc = new Scanner(System.in);
			System.out.println("Do you want to commit changes?");
			String input = sc.nextLine();

			if (input.equals("yes")) {
				myConn.commit();
				System.out.println("Transaction committed");

			} else {
				myConn.rollback();
				System.out.println("Transaction rolled back");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
