package com.getafe.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploBBDD {

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
			sql = "SELECT id, nombreprod, precio, stock FROM productos";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				/*
				 * int age = rs.getInt("age"); String first = rs.getString("first"); String last
				 * = rs.getString("last");
				 */
				String nombreProd = rs.getString("nombreprod");
				double precio = rs.getDouble("precio");
				int stock = rs.getInt("stock");

				// Display values
				System.out.print("ID: " + id);
				/*
				 * System.out.print(", Age: " + age); System.out.print(", First: " + first);
				 * System.out.println(", Last: " + last);
				 */
				System.out.print(", Producto: " + nombreProd);
				System.out.print(", Precio: " + precio);
				System.out.println(", Stock: " + stock);
			}

			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
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