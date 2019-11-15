<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOLA MUNDO</title>
</head>

<!-- <body onload="alert('HOLA')">  -->
<body>
BIENVENIDO<br>

<form action="ServletLogin">
Usuario: <input type="text" name="usuario" /><br>
Password: <input type="password" name="mipass" /><br>
<input type="submit" value="enviar" />
</form>

<%
if(request.getParameter("error") != null)
{
	if(request.getParameter("error").equals("1"))
	{
	%>
	<br><font color="red">Datos de inicio de sesión incorrectos. Pruebe de nuevo.</font>
	<br><div style="color:red">(DIV) DATOS INCORRECTOS</div>
	<br> 
	<%
	}
	else if (request.getParameter("error").equals("2"))
	{
	%>
		<br><div style="color:red">(DIV) LA SESION HA CADUCADO</div>
	<%	
	}
}
%>


<a href="http://www.google.com">Ir a google</a>

<br>


<!--
<%
for (int i = 0; i < 10; i ++)
{
%>

Hola calavera <br>

<%

}
%>
-->


</body>
</html>