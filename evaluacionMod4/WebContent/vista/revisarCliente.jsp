<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Revisar Cliente</title>
		<link rel="stylesheet" href="./css/styleNeus.css">
		<link rel="stylesheet" href="./css/panel.css">
		
	</head>
	<body>
		<div class="header">
	        <div class="dflexLeft">
	            <img class="icono" src="./img/img_header.png" alt="Brand">
	        </div>
	        <div class="dflexRight">
	            <button class="btn-danger">Salir</button>
	        </div>
	    </div>
		<h1>Lista de clientes</h1>
		<div class="divRevisaCliente">
				<a href="vista/vistaProfesional.jsp"><input class="cancelar btn_input" type="button" value="volver"></a>
			<table>
					<tr>
						<th>Razón</th>
						<th>RUT</td>
						<th>Email</th>
						<th>Región</th>
						<th>Comuna</th>
						<th>Dirección</th>
						<th>Número</th>
					</tr>
					<c:forEach  var="cliente" items="${listaClientes}">		
			
				<tr>				
					<td>${cliente.getNombre()}</td>
					<td>${cliente.getRut()}</td>
					<td>${cliente.getEmail()}</td>
					<td>${cliente.getRegion()}</td>
					<td>${cliente.getComuna()}</td>
					<td>${cliente.getDireccion()}</td>
					<td>${cliente.getNum_direccion()}</td>
				</tr>		
			</c:forEach>	
				</table>
		</div>
		 <div class="header txt-center">
        <h5>Copyright 2020</h5>
    </div>
	</body>
</html>