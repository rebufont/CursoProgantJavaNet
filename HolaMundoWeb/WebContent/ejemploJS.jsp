<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
	function alertCutre()
	{
		alert(document.getElementById("MyElemento").innerHTML);
	}
</script>
<body>
	<input type="button" onclick="alertCutre()" value="Botón" />
	<div id="MyElemento">Un div</div>
</body>
</html>