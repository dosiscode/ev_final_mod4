package modelo;

import java.util.*;

public class Asesoria {
	
	private int id_asesoria;
	private String tema;
	private String objetivo;
	private Date fecha_solicitud;
	
	public Asesoria(int id_asesoria, String tema, String objetivo, Date fecha_solicitud) {
		super();
		this.id_asesoria = id_asesoria;
		this.tema = tema;
		this.objetivo = objetivo;
		this.fecha_solicitud = fecha_solicitud;
	}

	public int getId_asesoria() {
		return id_asesoria;
	}

	public void setId_asesoria(int id_asesoria) {
		this.id_asesoria = id_asesoria;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
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
	
	
}
