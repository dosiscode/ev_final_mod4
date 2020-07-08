<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sistema - Editar Profesional</title>
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
	<form action="../AdminServlet" method="get">
		<c:forEach var="prof" items="${profDAO}">
			<input type="hidden" name="txtId" value="${prof.getId_profesional()}">
			<label>RUT: </label>
			<input type="text" name="rut" value="${prof.getRut()}">	
			<label>Nombre: </label>
			<input type="text" name="nombre" value="${prof.getNombre()}">
			<label>Apellido: </label>
			<input type="text" name="apellido" value="${prof.getApellido()}">		

			<input type="submit" name="accion" value="Actualizar">			
		</c:forEach>	
	</form>
	    <div class="header txt-center">
        <h5>Copyright 2020</h5>
    </div>

</body>
</html>