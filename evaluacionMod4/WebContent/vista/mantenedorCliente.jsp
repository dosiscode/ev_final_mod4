<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/styleClienteCRUD.css">
</head>
<body>
	<form method="get" action="">
		<table class="GeneratedTable">
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
			      <td><button></button></td>
			    </tr>
		    </c:forEach>
		    
		  </tbody>
		</table>
	</form>
</body>
</html>