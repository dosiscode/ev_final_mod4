<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sistema - Panel de Administrador</title>
    <link rel="stylesheet" href="../css/panel.css">
</head>

<body>
    <div class="header">
        <div class="dflexLeft">
            <img class="" src="" alt="Brand">
        </div>
        <div class="dflexRight">
            <a href="../index.jsp"><button class="btn-danger">Salir</button></a>
        </div>
    </div>

    <div class="dflexSpace">
    
    	<a href="../AdminServlet?acc=ListarTodo">
    	<input class="btnSeleccionar" type="submit" value="Mantenedor Profesional">
    	</a>
		<a href="../AdminServlet?accion=listarClientes">
		<input type="button" class="btnSeleccionar" value="Mantenedor Clientes">
		</a>

    </div>


    <div class="header txt-center">
        <h5>Copyright 2020</h5>
    </div>

</body>
</html>