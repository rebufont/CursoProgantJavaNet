<%@page import="com.getafe.curso.Util"%>
<%@page import="com.getafe.curso.ProductosFD"%>
<%@page import="com.getafe.curso.Producto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<link href="./css/almacen.css" rel="stylesheet" type="text/css">
<!--  
<style>
div.minimalistBlack {
	border: 3px solid #000000;
	width: 500px;
	text-align: left;
	border-collapse: collapse;
}

.divTable.minimalistBlack .divTableCell, .divTable.minimalistBlack .divTableHead
	{
	border: 1px solid #000000;
	padding: 5px 4px;
}

.divTable.minimalistBlack .divTableBody .divTableCell {
	font-size: 18px;
}

.divTable.minimalistBlack .divTableHeading {
	background: #CFCFCF;
	background: -moz-linear-gradient(top, #dbdbdb 0%, #d3d3d3 66%, #CFCFCF 100%);
	background: -webkit-linear-gradient(top, #dbdbdb 0%, #d3d3d3 66%, #CFCFCF 100%);
	background: linear-gradient(to bottom, #dbdbdb 0%, #d3d3d3 66%, #CFCFCF 100%);
	border-bottom: 3px solid #000000;
}

.divTable.minimalistBlack .divTableHeading .divTableHead {
	font-size: 15px;
	font-weight: bold;
	color: #000000;
	text-align: left;
}

.minimalistBlack .tableFootStyle {
	font-size: 14px;
	font-weight: bold;
	color: #000000;
	border-top: 3px solid #000000;
}

.minimalistBlack .tableFootStyle {
	font-size: 14px;
}
/* DivTable.com */
.divTable {
	display: table;
}

.divTableRow {
	display: table-row;
}

.divTableHeading {
	display: table-header-group;
}

.divTableCell, .divTableHead {
	display: table-cell;
}

.divTableHeading {
	display: table-header-group;
}

.divTableFoot {
	display: table-footer-group;
}

.divTableBody {
	display: table-row-group;
}
</style>
-->

<body>

<%
if (Util.verificarUsuarioConectado(session, response) == true)
{
%>

	<jsp:include page="./cabecera.jsp" />


	<div class="divTable minimalistBlack">
		<div class="divTableHeading">
			<div class="divTableRow">
				<div class="divTableHead">Producto</div>
				<div class="divTableHead">Precio</div>
				<div class="divTableHead">Stock</div>
				<div class="divTableHead"></div>
				<div class="divTableHead"></div>
			</div>
		</div>

		<form action="ServletAlmacen" class="divTableBody">
		<!--  <div class="divTableBody"> -->
<%
				// Recuperar lista actual de productos (se refresca el stock)
				List<Producto> lstProductos = ProductosFD.instancia().getProductos();

				for (Producto producto : lstProductos)
				{
%>
					<div class="divTableRow">
						<div class="divTableCell"><%=producto.getNombre()%></div>
						<div class="divTableCell"><%=producto.getPrecio()%></div>
						<div class="divTableCell"><%=producto.getStock()%></div>
						<div class="divTableCell" style="text-align: center"><input type="checkbox" name="elim<%= producto.getId()%>" /> </div>
						<div class="divTableCell" style="text-align: center">
							
							<!--
							<input type="submit" name="accion" value="Modificar..." />
							<input type="hidden" name="idModificar" value="<%= producto.getId() %>">
							-->
							<input type="radio" name="idModificar" value="<%= producto.getId() %>" />
							
						</div>				
					</div>

		<!--  </div> -->

<%
				}
%>


			<div class="divTableRow">
				<div class="divTableCell"><input type="text" name="nombre"></div>
				<div class="divTableCell"><input type="text" name="precio"></div>
				<div class="divTableCell"><input type="text" name="stock"></div>
				<div class="divTableCell"></div>
				<div class="divTableCell"></div>
			</div>
			<div class="divTableRow">
				<div class="divTableCell" style="text-align: center">
					<input type="submit" name="accion" value="Nuevo" />
				</div>
				<div class="divTableCell"></div>
				<div class="divTableCell"></div>
				<div class="divTableCell" style="text-align: center">
					<input type="submit" name="accion" value="Eliminar" />
				</div>
				<div class="divTableCell">
					<input type="submit" name="accion" value="Modificar..." />
				</div>
			</div>
		</form>

	</div>
	
<%
}
%>	
	
</body>
</html>