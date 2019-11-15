package com.getafe.curso;

import java.util.HashMap;

public class CarritoCompra {

	private String usuario;
	
	// Contenido actual del carrito: Clave: idProducto
	private HashMap<Integer, ElementoPedido> elementosPedidos;

	public CarritoCompra(String usuario)
	{
		this.usuario = usuario;
		this.elementosPedidos = new HashMap<Integer, ElementoPedido>();
	}
	
	public ElementoPedido getElemento(Producto producto)
	{
		ElementoPedido elemento = elementosPedidos.get(producto.getId());
		
		if (elemento == null)
		{
			elemento = new ElementoPedido(producto);
		}
		
		return elemento;
	}
	
	public void addElemento(ElementoPedido elemento)
	{
		this.elementosPedidos.put(elemento.getProducto().getId(), elemento);
	}
	
	
}
