<%@page import="com.getafe.curso.ProductosFD"%>
<%@page import="com.getafe.curso.Producto"%>
<%@page import="com.getafe.curso.Util"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<link href="./css/almacen_modificar.css" rel="stylesheet" type="text/css">

<body>

<%
	if (Util.verificarUsuarioConectado(session, response) == true)
	{
		
		int idProducto = Integer.parseInt(request.getParameter("idModificar"));
		Producto producto = ProductosFD.instancia().getProductoById(idProducto);		
%>

	<jsp:include page="./cabecera.jsp" />

	<form action="ServletAlmacen">

		<input type="hidden" name="modIdProducto" value="<%= producto.getId() %>">

		<div class="divTable greyGridTable">
			<div class="divTableBody">
				<div class="divTableRow">
					<div class="divTableCell">Producto</div>
					<div class="divTableCell">
						<input type="text" name="modNombre" value="<%= producto.getNombre() %>">
					</div>
				</div>
				<div class="divTableRow">
					<div class="divTableCell">Precio</div>
					<div class="divTableCell">
						<input type="text" name="modPrecio" value="<%= producto.getPrecio() %>">
					</div>
				</div>
				<div class="divTableRow">
					<div class="divTableCell">Stock</div>
					<div class="divTableCell">
						<input type="text" name="modStock" value="<%= producto.getStock() %>">
					</div>
				</div>
				<div class="divTableRow">
					<div class="divTableCell"></div>
					<div class="divTableCell">
						<input type="submit" name="accion" value="Guardar..." />
					</div>
				</div>
			</div>
			
										
			
		</div>

	</form>

<%
	}
%>
</body>
</html>