package com.getafe.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploBBDD_Insert {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String CONNECTION_STRING = "jdbc:mysql://localhost/EMP";

	static final String USER = "root";
	static final String PASS = "adminadmin";

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;

		try {
			// Carga dinamica de clase
			// Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(CONNECTION_STRING, USER, PASS);

			System.out.println(conn.getClass());

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			// sql = "SELECT id, first, last, age FROM Employees";
			sql = "INSERT INTO productos (id, nombreprod, precio, stock) VALUES (?, ?, ?, ?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			System.out.println(pstmt.getClass());
			
			pstmt.setInt(1, 11);
			pstmt.setString(2, "Berenjena");
			pstmt.setDouble(3, 0.75);
			pstmt.setInt(4, 350);

			pstmt.executeUpdate();

			pstmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("ADIOS!");
	}// end main
}// end FirstExample