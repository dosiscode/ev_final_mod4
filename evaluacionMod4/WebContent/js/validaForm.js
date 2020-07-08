	let nombre = document.getElementById("nombre");
	let apellido = document.getElementById("apellido");
	let edad = document.getElementById("edad");
	let hora = document.getElementById("hora");
	let fecha = document.getElementById("fecha");
	let descripcion = document.getElementById("descripcion");	
	let objetivo = document.getElementById("objetivo");
	
	function limpiar(jsp) {
	
		if(jsp === 'capacitacion'){
			
			descripcion.value = "";
			objetivo.value = "";
		}
		
		if(jsp === 'accidente'){
			nombre.value = "";
			apellido.value = "";
			edad.value = null;
			descripcion.value = "";
			fecha.value = "";
			hora.value = "";
		}	
	}
	
	
	
	function muestraConfirma(confirma, jsp){
		
		if(jsp === "accidente"){
			if(confirma == 1){
			alert("Accidente agregado correctamente");
			}else if(confirma == 2){
				alert("Ocurrio un error inesperado");
			}			
		}
		
		if(jsp === "capacitacion"){
			if(confirma == 1){
			alert("Capacitacion agregada correctamente");
			}else if(confirma == 2){
				alert("Ocurrio un error inesperado");
			}			
		}
		
	}
	