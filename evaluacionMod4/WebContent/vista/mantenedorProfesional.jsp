<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sistema - Mantenedor Profesional</title>
</head>
<body>
	<div>
		<h1>Profesionales</h1>
	</div>

	<div>
		
		<table border="1">
			<thead>
				<tr>
					<th>ID</th>
					<th>RUT</th>
					<th>NOMBRE</th>
					<th>APELLIDO</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dato" items="$(datos)">
				<tr>
					<th><c:out value="$(dato.getId_profesional())"></c:out></th>
					<th><c:out value="$(dato.getRut())"></c:out></th>
					<th><c:out value="$(dato.getNombre())"></c:out></th>
					<th><c:out value="$(dato.getApellido())"></c:out></th>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>