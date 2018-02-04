package com.jdbcdemo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MetaDataInfo {

	public static void main(String[] args) {
		Connection myConn = null;

		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hb_student_tracker", "hbstudent",
					"hbstudent");

			// Metadata info
			DatabaseMetaData DmD = myConn.getMetaData();

			System.out.println("Product Name: " + DmD.getDatabaseProductName());
			System.out.println("Product Version: " + DmD.getDatabaseProductVersion());

			System.out.println("JDBC Driver Name: " + DmD.getDriverName());
			System.out.println("JDBC Driver Version: " + DmD.getDriverVersion());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
