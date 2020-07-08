<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	
	<div class="dflexRight btnAgregar">
	<a href="./vista/agregarCliente.jsp"><input type="button"  value="Nuevo Cliente"></a>
	</div>
	
		<table class="tablaListar">
		  <thead>
		    <tr>
		      <th>Razon Social</th>
		      <th>Rut</th>
		      <th>Dirección</th>
		      <th>Correo</th>
		      <th>Acción</th>
		    </tr>
		  </thead>
		  <tbody>
		    <c:forEach  var="cliente" items="${lista}">
			    <tr>
			      <td>${cliente.getNombre()}</td>
			      <td>${cliente.getRut()}</td>
			      <td>${cliente.getDireccion()} ${cliente.getNum_direccion()}, ${cliente.getCom().getComuna()}</td>
			      <td>${cliente.getEmail()}</td>
			      <td>
			      	<a href="./AdminServlet?accion=buscarCliente&id=${cliente.getId_cliente()}"><input type="button" value="Editar"></a>
			      	<a href="./AdminServlet?accion=eliminarCliente&id=${cliente.getId_cliente()}"><input type="button" value="Eliminar"></a>
			      	<a href="./vista/editarCliente.jsp"><input type="button"  value="Calcular Accidentabilidad"></a>
			      </td>
			    </tr>
		    </c:forEach>
		    
		  </tbody>
		</table>
	<div class="header txt-center">
        <h5>Copyright 2020</h5>
    </div>
</body>
</html>