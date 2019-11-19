package com.getafe.curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductosFD {

	// Singleton
	private static ProductosFD _instancia;

	public static ProductosFD instancia() {
		if (_instancia == null) {
			_instancia = new ProductosFD();
		}
		return _instancia;
	}

	private ProductosFD() {
	}

	private Producto nuevoProducto(ResultSet rs) throws SQLException {
		Producto p = new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getDouble("precio"), rs.getInt("stock"));

		return p;
	}

	public List<Producto> getProductos()
	{
		try
		{
			Connection cnn = GestorBD.getConnection();

			List<Producto> lstProductos = new ArrayList<Producto>();

			Statement stmt = cnn.createStatement();

			ResultSet rs = stmt.executeQuery("select * from productos");

			while (rs.next()) {
				Producto p = this.nuevoProducto(rs);

				lstProductos.add(p);
			}

			return lstProductos;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public Producto getProductoById(int idProducto)
	{
		try {
			Connection cnn = GestorBD.getConnection();

			PreparedStatement ps = cnn.prepareStatement("select * from productos where id = ?");

			ps.setInt(1, idProducto);

			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				throw new RuntimeException("Producto no encontrado: ID = " + idProducto);
			}

			Producto p = this.nuevoProducto(rs);

			return p;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void altaProducto(String nombre, double precio, int stock) {
		try {
			
			Connection cnn = GestorBD.getConnection();

			PreparedStatement ps = cnn.prepareStatement(
				"insert into productos(nombre, precio, stock) values (?, ?, ?)"	
			);

			ps.setString(1, nombre);
			ps.setDouble(2, precio);
			ps.setInt(3,  stock);
			
			int result = ps.executeUpdate();

		}
		catch (SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public void modificar(int idProducto, String nombre, double precio, int stock)
	{
		try
		{
			
			Connection cnn = GestorBD.getConnection();

			String senSql =
				"update productos p" +
				" set p.nombre = ?, p.precio = ?, p.stock = ?" +
				" where p.id = ?"
			;
			
			PreparedStatement ps = cnn.prepareStatement(senSql);					

			ps.setString(1, nombre);
			ps.setDouble(2, precio);
			ps.setInt(3,  stock);
			ps.setInt(4, idProducto);
			
			int result = ps.executeUpdate();

		}
		catch (SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}
	
	
	public void eliminarProducto(int idProducto)
	{
		try {
			
			Connection cnn = GestorBD.getConnection();

			PreparedStatement ps = cnn.prepareStatement(
				"delete from productos where id = ?"	
			);

			ps.setInt(1, idProducto);
			
			int result = ps.executeUpdate();

		}
		catch (SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

}
