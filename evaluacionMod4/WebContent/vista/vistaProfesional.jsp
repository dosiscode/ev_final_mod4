<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Profesional</title>
		<link rel="stylesheet" href="../css/styleNeus.css">
		<link rel="stylesheet" href="../css/panel.css">
	</head>
	<body>
		<div class="header">
	        <div class="dflexLeft">
	            <img class="icono" src="../img/img_header.png" alt="Brand">
	        </div>
	        <div class="dflexRight">
	            <button class="btn-danger">Salir</button>
	        </div>
	    </div>
		<div class="divProfesional">
			<div>
				<form action="../ClienteServ?accion=listarCliente" method="post">
					<input class="aceptar btn_input" type="submit" value="Revisar Cliente">
				</form>
				<form action="../ClienteServ?accion=listarCliente" method="post">
					<input class="aceptar btn_input" type="submit" value="Capacitaciones">
				</form>
				<form action="../ClienteServ?accion=listarCliente" method="post">
					<input class="aceptar btn_input" type="submit" value="Asesorías">
				</form>
			</div>
			
			<div>
				<img alt="" src="../img/seguridad.jpg">
			</div>
		</div>	
		 <div class="header txt-center">
        <h5>Copyright 2020</h5>
    </div>
	</body>
</html>