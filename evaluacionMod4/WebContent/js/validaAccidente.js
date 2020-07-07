	let nombre = document.getElementById("nombre");
	let apellido = document.getElementById("apellido");
	let edad = document.getElementById("edad");
	let hora = document.getElementById("hora");
	let fecha = document.getElementById("fecha");
	let descripcion = document.getElementById("descripcion");
	
	function limpiar() {
	
		nombre.value = "";
		apellido.value = "";
		edad.value = null;
		descripcion.value = "";
		fecha.value = "";
		hora.value = "";
		
	
	}
	
	function muestraConfirma(confirma){
		
		if(confirma == 1){
			alert("Accidente agregado correctamente");
		}else if(confirma == 2){
			alert("Ocurrio un error inesperado");
		}
	}
	