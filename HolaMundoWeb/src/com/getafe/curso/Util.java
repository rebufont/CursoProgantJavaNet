package com.getafe.curso;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;

public class Util {

	public static void logSesion(HttpSession session)
	{
		Enumeration<String> attributeNames = session.getAttributeNames();
		
		while (attributeNames.hasMoreElements())
		{
			String atr = attributeNames.nextElement();
			
			System.out.println("Atributo: " + atr + "; Valor = " + session.getAttribute(atr).toString());
		}
	}
	
	// Esto puede ir mejor en un servicio de apoyo
	public static CarritoCompra getCarritoCompra(HttpSession session)
	{
		Object objCarrito = session.getAttribute("carritoCompra");
		CarritoCompra carrito = null;
		if (objCarrito == null)
		{
			carrito = new CarritoCompra(session.getAttribute("usuarioConectado").toString());
		}
		else
		{
			carrito = (CarritoCompra)objCarrito;
		}
		
		return carrito;
		
	}
	
	
	
}
