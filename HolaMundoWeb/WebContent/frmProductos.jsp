<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOLA MUNDO</title>
</head>

<!-- <body onload="alert('HOLA')">  -->

<style>
	table	{ border: 1px solid black }
	tr	 	{ border: 1px dotted black }	
</style>

<body>

<%@ page import="java.util.List" %>
<%@ page import="com.getafe.curso.Producto" %>
<%@ page import="com.getafe.curso.ProductosFD" %>
<%@ page import="com.getafe.curso.Util" %>
<%@page import="com.getafe.curso.ElementoPedido"%>
<%@page import="com.getafe.curso.CarritoCompra"%>

 
 
<%
if (Util.verificarUsuarioConectado(session, response) == true)
{
%>

	<jsp:include page="cabecera.jsp" />	 
	
	<form action="ServletPedido">
	
	<table style="">
	
	<tr>
		<th>Producto</th>
		<th>Precio</th>
		<th>Stock</th>
		<th>Cantidad a pedir</th>
		<th>Total</th>
		<th></th>
	</tr>

<%
	// Recuperar lista actual de productos (se refresca el stock)
	List<Producto> lstProductos = ProductosFD.instancia().getProductos();

	// Recuperar / inicializar carrito de la compra
	CarritoCompra carrito = Util.getCarritoCompra(session);
	for (Producto producto : lstProductos)
	{
		if (carrito == null)
		System.out.println("**************************");
		

		// Recuperar / generar elemento del pedido
		ElementoPedido elemento = carrito.getElemento(producto);
		
		
		/*
		Object atr = session.getAttribute("cant" + p.getId());
		
		String paramCant = (atr == null)? "0" : atr.toString();
		*/
	%>
	
	<tr>
		<td><%= producto.getNombre() %></td>
		<td><%= producto.getPrecio() %></td>
		<td><%= producto.getStock() %></td>
		<td>
			<input
				type="text"
				name="cant<%= producto.getId() %>"
				value="<%= elemento.getCantidadPedida() %>"
				style="background-color:LightYellow"
			>
		</td>
		<td><%= elemento.getTotal() %></td>
		<td>
<%
	
		if (elemento != null)
		{
			if(elemento.getCantidadPedida() > producto.getStock())
			{
%>
			<div style="color: red">Stock insuficiente</div>
<%
			}
		}
%>
		</td>
	</tr>
	
	
<%		
	}	
}

%>

</table>
<input type="submit" value="Realizar pedido">
</form>

</body>


