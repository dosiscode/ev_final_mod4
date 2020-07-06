<!DOCTYPE html>
<html lang="en">
<head>
  <title>Ingresar Asesoria</title>
  <meta charset="utf-8"> 
  <link rel="stylesheet" href="../css/agregarAsesoria.css">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

  <button type="button"  data-toggle="modal" data-target="#test1">Capacitacion</button>

<div id="test1" class="modal fade" role="dialog" style="z-index: 1400;">
  <div class="modal-dialog">
    <div class="modal-content">
      
      <div class="modal-body">
       <p>Nueva Capacitación </p>
	 	<select class="clientes">
	 		<option value="">Seleccionar cliente</option>
	 	</select>
	<p>Fecha </p>
		<input type="date" class="fecha" name="fecha">
	<p>Descripcion </p>
		<textarea class="objetivo" name="objetivo"></textarea><br/><br/>
	<p>Objetivo </p>
		<textarea class="objetivo" name="objetivo"></textarea><br/><br/>
		
		
	<div class="botones">
		<button type="button" data-dismiss="modal">Cancelar</button>      
        <button type="button" data-toggle="modal" data-target="#test2">Agregar</button>
        
      </div>      
    </div>
  </div>
</div>

<div id="test2" class="modal fade" role="dialog" style="z-index: 1600;">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      
      <div class="modal-body">
        
        <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Capacitación ingresada</h4>
        </div>
        <div class="modal-body">
          <p>Los datos de la capacitación se han ingresado con exito.</p>
        
      </div>      
    </div>
  </div>
</div>
  

</body>
</html>