package com.getafe.curso;

public class ElementoPedido {
	private Producto producto;
	private int cantidadPedida;
	private double total;
	
	
	public ElementoPedido(Producto producto)
	{
		super();
		this.producto = producto;
		this.cantidadPedida = 0;
		this.total = 0.0;
	}

	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidadPedida() {
		return cantidadPedida;
	}
	public void setCantidadPedida(int cantidadPedida) {
		this.cantidadPedida = cantidadPedida;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}	
	
}
