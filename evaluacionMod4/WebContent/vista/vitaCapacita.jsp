<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Capacitación</title>
		<link rel="stylesheet" href="./css/styleNeus.css">
		 <link rel="stylesheet" href="./css/panel.css">
		
	</head>
	<c:set value="${confirmacion}" var="confir"></c:set>
	<body onload="muestraConfirma(${confir}, 'capacitacion')">
		<div class="header">
	        <div class="dflexLeft">
	            <img class="icono" src="./img/img_header.png" alt="Brand">
	        </div>
	        <div class="dflexRight">
	            <button class="btn-danger">Salir</button>
	        </div>
	    </div>
		<div class="contenedorPpl">
		<h3>Nueva Capacitación</h3>
			<form action="./ProfServ?accion=creaCapacitacion" method="post">
				<div class="cont_uno">		
				<div>	
					<label for="tabla">Selecciona un Cliente: </label>		
					<table id="tabla">
						<c:forEach  var="cliente" items="${listaClientes}">	
							<tr>
								<td>${cliente.getNombre()} / Rut: ${cliente.getRut()}</td>
								<td>
								<input type="radio" id="idCliente" name="idCliente" value=${cliente.getId_cliente() } required>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>					
				</div>
				<div class="contTextArea">
					<label for="descripcion">Descripción: </label><br>
					<textarea id="descripcion" name="descripcion" rows="5" cols="70" required></textarea>				
				</div>	
				
				<div class="contTextArea">
					<label for="objetivo">Objetivo: </label><br>
					<textarea id="objetivo" name="objetivo" rows="5" cols="70" required></textarea>				
				</div>				
				<div class="btns">
					<button  class="aceptar">Aceptar</button>	
					<a onclick="limpiar('capacitacion')"><input type="button" value="Limpiar" class="limpiar"></a>		
					<a href="vista/vistaProfesional.jsp"><input class="cancelar btn_input" type="button" value="volver"></a>		
				</div>
			</form>		
		</div>	
	<script type="text/javascript" src="./js/validaForm.js"></script>
	</body>
	
	 <div class="header txt-center">
        <h5>Copyright 2020</h5>
    </div>
	
</html>