<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/styleClienteCRUD.css">
<link rel="stylesheet" href="css/styleClienteCRUD.css">
</head>
<body>
	<div class="header">
       	<div class="dflexLeft">
            <img class="" src="" alt="Brand">
        </div>
        <div class="dflexRight">
            <button class="btn-danger">Salir</button>
        </div>
	</div>
	<div class="formulario">
	<c:set value="${idCap}" var="idCap"></c:set>
	<form action="../ProfesionalServlet?accion=agregarVisita&id=${idCap}&tipo=capacitacion" method="post">
		<table>
			<tr>
				<td colspan="2">Datos de la visita</td>
			</tr>
			<tr>
				<td>Fecha</td>
				<td>Hora</td>
			</tr>
			<tr>
				<td><input type="date"  id="txtFecha" name="txtFecha" value="2020-07-07"></td>
				<td><input type="time"  id="txtHora" name="txtHora" ></td>
			</tr>
			<tr>
				<td colspan="2">Duracion visita</td>
			</tr>
			<tr>
				<td><input type="text"  id="txtDuracion" name="txtDuracion" ></td>
			</tr>
			
		</table>
		</br>
		<%
		    if(null!=request.getAttribute("msg"))
		    {
		    	out.println(request.getAttribute("msg"));
		    }
		%>
		</br>
		<input type="submit" value="Agendar visita"> 
	</form>
		
	</div>
	<div class="header txt-center">
        <h5>Copyright 2020</h5>
    </div>
</body>
</html>