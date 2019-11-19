package com.getafe.curso;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletResponse;
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
	
	public static boolean verificarUsuarioConectado(HttpSession session, HttpServletResponse response) throws IOException
	{
		System.out.println("*** CABECERA...");
		System.out.println(session.getAttribute("usuarioConectado"));
	
		if (session.getAttribute("usuarioConectado") == null)
		{
			System.out.println(" + Redirigiendo a página de LOGIN con error de conexión...");
			response.sendRedirect("index.jsp?error=2");
			
			return false;
		}
		
		return true;
	}
	
}
