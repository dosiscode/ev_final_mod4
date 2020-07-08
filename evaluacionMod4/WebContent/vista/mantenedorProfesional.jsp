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
		<a href="./vista/seleccionaMantenedor.jsp"><input type="button" name="accion" value="Volver"></a>
		<a href="./vista/agregarProfesional.jsp"><input type="button" value="Nuevo"></a>

		<table border="1">
			<thead>
				<tr>
					<th>ID</th>
					<th>RUT</th>
					<th>NOMBRE</th>
					<th>APELLIDO</th>
					<th>ACCIONES</th>
				</tr>
			</thead>
			<tbody>
			
				<c:forEach var="dato" items="${datos}">
				<tr>
					<th>${dato.getId_profesional()}</th>
					<th>${dato.getRut()}</th>
					<th>${dato.getNombre()}</th>
					<th>${dato.getApellido()}</th>
					<th>
					<input type="hidden" name="txtId" value="${dato.getId_profesional()}">
					<a href="AdminServlet?acc=Editar"><input type="button" value="Editar"></a>
					<a href="AdminServlet?acc=Eliminar&id=${dato.getId_profesional()}"><input type="button" value="Eliminar"></a>
					</th>
				</tr>
				</c:forEach>			
			
			</tbody>
		</table>

	</div>

</body>
</html>