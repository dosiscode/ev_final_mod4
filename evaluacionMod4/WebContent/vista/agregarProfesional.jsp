<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sistema - Nuevo Profesional</title>
<link rel="stylesheet" href="../css/panel.css">
</head>
<body>
    <div class="header">
        <div class="dflexLeft">
            <img class="" src="" alt="Brand">
        </div>
        <div class="dflexRight">
            <a href="../index.jsp"><button class="btn-danger">Salir</button></a>
        </div>
    </div>
	<form action="../AdminServlet" method="post">
		<label>RUT: </label>
		<input type="text" name="rut">		
		<label>Nombre: </label>
		<input type="text" name="nombre">
		<label>Apellido: </label>
		<input type="text" name="apellido">		
		<input type="submit" name="accion" value="Guardar">
	</form>
	
	    <div class="header txt-center">
        <h5>Copyright 2020</h5>
    </div>

</body>
</html>