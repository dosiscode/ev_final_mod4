<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Registrar Accidente (Cliente)</title>
		<link rel="stylesheet" href="../css/styleNeus.css">
	</head>
	<body>
		<div class="contenedorPpl">
		<h3>Nuevo Accidente</h3>
			<form action="../ClienteServ?accion=creaAccidente" method="post">
				<div class="cont_uno">					
					<div class="inputs">
						<label for="nombre">Nombre: </label><br>
						<input type="text" id="nombre" name="nombre">
					</div>
					<div class="inputs">
						<label for="apellido">Apellido: </label><br>
						<input type="text" id="apellido" name="apellido">
					</div>
					<div class="inputs">
						<label for="nombre">Edad: </label><br>
						<input type="number" id="edad" name="edad">
					</div>					
				</div>
				<div class="cont_uno">
					<input type="radio" id="grave" name="nivel" value="1">
					<label for="grave">Grave: </label><br>
					<input type="radio" id="medio" name="nivel" value="2">
					<label for="medio">Medio: </label><br>
					<input type="radio" id="leve" name="nivel" value="3">
					<label for="leve">Leve: </label><br>
					
					<div class="date">
						<label for="hora">Hora: </label><br>
						<input type="time" id="hora" name="hora">						
					</div>
					<div class="date">
						<label for="fecha">Fecha: </label><br>
						<input type="date" id="fecha" name="fecha">	
					</div>												
				</div>
				<div class="contTextArea">
					<label for="descripcion">Descripción: </label><br>
					<textarea id="descripcion" name="descripcion" rows="5" cols="70"></textarea>				
				</div>				
				<div class="btns">
					<button class="aceptar">Aceptar</button>					
					<a href="nuevoAccidente.jsp"><input type="button" value="Limpiar" class="limpiar"></a>
					<a href="../index.jsp"><input type="button" value="Cancelar" class="cancelar" ></a>
				</div>
			</form>
		
		</div>
	
	</body>
</html>