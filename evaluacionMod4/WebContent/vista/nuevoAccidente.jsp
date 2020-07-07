<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Registrar Accidente (Cliente)</title>
		<link rel="stylesheet" href="./css/styleNeus.css">
		 <link rel="stylesheet" href="./css/panel.css">
		
	</head>
	<c:set value="${confirmacion}" var="confir"></c:set>
	<body onload="muestraConfirma(${confir})">
		<div class="header">
	        <div class="dflexLeft">
	            <img class="icono" src="./img/img_header.png" alt="Brand">
	        </div>
	        <div class="dflexRight">
	            <button class="btn-danger">Salir</button>
	        </div>
	    </div>
		<div class="contenedorPpl">
		<h3>Nuevo Accidente</h3>
			<form action="./ClienteServ?accion=creaAccidente" method="post">
				<div class="cont_uno">					
					<div class="inputs">
						<label for="nombre">Nombre: </label><br>
						<input type="text" id="nombre" name="nombre"required>
					</div>
					<div class="inputs">
						<label for="apellido">Apellido: </label><br>
						<input type="text" id="apellido" name="apellido"required>
					</div>
					<div class="inputs">
						<label for="edad">Edad: </label><br>
						<input type="number" id="edad" name="edad" required max="200">
					</div>					
				</div>
				<div class="cont_uno">
					<input type="radio" id="grave" name="nivel" value="1" required>
					<label for="grave">Grave: </label><br>
					<input type="radio" id="medio" name="nivel" value="2">
					<label for="medio">Medio: </label><br>
					<input type="radio" id="leve" name="nivel" value="3">
					<label for="leve">Leve: </label><br>
					
					<div class="date">
						<label for="hora">Hora: </label><br>
						<input type="time" id="hora" name="hora" required>						
					</div>
					<div class="date">
						<label for="fecha">Fecha: </label><br>
						<input type="date" id="fecha" name="fecha" required>	
					</div>												
				</div>
				<div class="contTextArea">
					<label for="descripcion">Descripción: </label><br>
					<textarea id="descripcion" name="descripcion" rows="5" cols="70" required></textarea>				
				</div>				
				<div class="btns">
					<button  class="aceptar">Aceptar</button>	
					<a onclick="limpiar()"><input type="button" value="Limpiar" class="limpiar"></a>				
				</div>
			</form>		
		</div>	
	<script type="text/javascript" src="./js/validaAccidente.js"></script>
	</body>
	
	 <div class="header txt-center">
        <h5>Copyright 2020</h5>
    </div>
	
</html>