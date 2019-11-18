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
	width: 500px;
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

	<%
		if (session.getAttribute("usuarioConectado") == null) {
			response.sendRedirect("index.jsp?error=2");
		}
	%>

	<div class="divTable">
		<div class="divTableBody">
			<div class="divTableRow">
				<div class="divTableCell">Usuario conectado: <%=session.getAttribute("usuarioConectado")%></div>
				<div class="divTableCell"><a href="./frmProductos.jsp">Pedidos</a></div>
				<div class="divTableCell"><a href="./almacen.jsp">Almacén</a></div>
			</div>
		</div>
	</div>
	<hr>

</body>
</html>