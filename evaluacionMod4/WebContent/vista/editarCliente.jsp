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
	<form action="./AdminServlet?accion=editarCliente&id=${cliente.getId_cliente()}" method="post">
		<table>
			<tr>
				<td colspan="2">Razon Social</td>
			</tr>
			<tr>
				<td colspan="2"><input type="text"  id="txtRazonSocial" name="txtRazonSocial" value="${cliente.getNombre()} "></td>
			</tr>
			<tr>
				<td>RUT</td>
				<td>Correo Electronico</td>
			</tr>
			<tr>
				<td><input type="text"  id="txtRut" name="txtRut" value="${cliente.getRut()}"></td>
				<td><input type="text"  id="txtCorreo" name="txtCorreo" value="${cliente.getEmail()}"></td>
			</tr>
			<tr>
				<td>Direccion/Calle</td>
				<td>Numero</td>
			</tr>
			<tr>
				<td><input type="text"  id="txtCalle" name="txtCalle" value="${cliente.getDireccion()}"></td>
				<td><input type="text"  id="txtNum" name="txtNum" value="${cliente.getNum_direccion()}"></td>
			</tr>
			<tr>
				<td>Comuna</td>
				<td>Region</td>
			</tr>
			<tr>
				<td>
					<select name="slcComuna">
					<option value="1">Santiago</option> 
					</select>
				</td>
				<td>
					<select name="slcRegion">
					<option value="1">Meropolitana</option> 
					</select>
				</td>
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
		<a href="./AdminServlet?accion=listarClientes"><input type="button" value="Volver"></a>
		<input type="submit" value="Editar"> 
	</form>
		
	</div>
	<div class="header txt-center">
        <h5>Copyright 2020</h5>
    </div>
</body>
</html>