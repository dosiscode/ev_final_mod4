package modelo;

import java.util.*;

public class Capacitacion {

	private int id_capacitacion;
	private String descripcion;
	private String objetivo;
	private Date fecha_solicitud;
	private int id_cliente;
	private int id_visita;
	
	
	
	
	
		
	//para agregar a BD
	public Capacitacion(String descripcion, String objetivo, int id_cliente) {
		super();
		this.descripcion = descripcion;
		this.objetivo = objetivo;
		this.id_cliente = id_cliente;
	}

	public Capacitacion(int id_capacitacion, String descripcion, String objetivo, Date fecha_solicitud) {
		super();
		this.id_capacitacion = id_capacitacion;
		this.descripcion = descripcion;
		this.objetivo = objetivo;
		this.fecha_solicitud = fecha_solicitud;
	}

	public int getId_capacitacion() {
		return id_capacitacion;
	}

	public void setId_capacitacion(int id_capacitacion) {
		this.id_capacitacion = id_capacitacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Date getFecha_solicitud() {
		return fecha_solicitud;
	}

	public void setFecha_solicitud(Date fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getId_visita() {
		return id_visita;
	}

	public void setId_visita(int id_visita) {
		this.id_visita = id_visita;
	}
	
	
	
}
