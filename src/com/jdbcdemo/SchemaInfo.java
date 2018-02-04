package com.jdbcdemo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SchemaInfo {

	public static void main(String[] args) {
		String catalog = null;
		String schemaPattern = null;
		String tableNamePattern = null;
		String columnNamePattern = null;
		String[] types = null;
		Connection myConn = null;
		ResultSet myRs = null;

		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hb_student_tracker", "hbstudent",
					"hbstudent");

			// Metadata info
			DatabaseMetaData DmD = myConn.getMetaData();

			System.out.println("List of Tables");
			System.out.println("--------------");

			myRs = DmD.getTables(catalog, schemaPattern, tableNamePattern, types);
			while (myRs.next()) {
				System.out.println(myRs.getString("TABLE_NAME"));
			}

			System.out.println("\nList of Columns");
			System.out.println("--------------");

			myRs = DmD.getColumns(catalog, schemaPattern, "student", columnNamePattern);
			while (myRs.next()) {
				System.out.println(myRs.getString("COLUMN_NAME"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
