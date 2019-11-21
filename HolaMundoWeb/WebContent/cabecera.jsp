<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<style>
/* DivTable.com */
.divTable {
	display: table;
	width: 600px;
}

.divTableRow {
	display: table-row;
}

.divTableHeading {
	background-color: #EEE;
	display: table-header-group;
}

.divTableCell, .divTableHead {
	border: 0px solid #999999;
	display: table-cell;
	padding: 3px 10px;
}

.divTableHeading {
	background-color: #EEE;
	display: table-header-group;
	font-weight: bold;
}

.divTableFoot {
	background-color: #EEE;
	display: table-footer-group;
	font-weight: bold;
}

.divTableBody {
	display: table-row-group;
}
</style>

<body>


	

	<div class="divTable">
		<div class="divTableBody">
			<div class="divTableRow">
				<div class="divTableCell">Usuario conectado: <b><%=session.getAttribute("usuarioConectado")%></b></div>
				<div class="divTableCell"><a href="./frmProductos.jsp">Pedidos</a></div>
				<div class="divTableCell"><a href="./almacen.jsp">Almacén</a></div>
				<div class="divTableCell"><a href="./administracion.jsp">Administración</a></div>
				<div class="divTableCell"><a href="./desconectar.jsp">Desconectar</a></div>
			</div>
		</div>
	</div>
	<hr>

</body>
</html>