<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
if (session.getAttribute("usuarioConectado") == null)
{
	response.sendRedirect("index.jsp?error=2");
}
%>
¡¡¡¡¡¡¡¡¡ LOGIN CORRECTO !!!!!!!

<br>
Bienvenido:
<%=
	session.getAttribute("usuarioConectado")
%>
</body>
</html>