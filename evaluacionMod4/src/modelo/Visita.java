package modelo;

import java.sql.Time;
import java.sql.Date;

public class Visita {
	private int id_visita;
	private Date fecha;
	private Time hora;
	private String duracion;
	private Capacitacion capacitacion;
	private Asesoria asesoria;
	
	
	
	
	//Para guardar vista de una capacitacion
	public Visita(Date fecha, Time hora, String duracion, Capacitacion capacitacion) {
		super();
		this.id_visita = id_visita;
		this.fecha = fecha;
		this.hora = hora;
		this.duracion = duracion;
		this.capacitacion = capacitacion;
	}
	//para guardar una visita de asesoria
	public Visita(Date fecha, Time hora, String duracion, Asesoria asesoria) {
		super();
		this.id_visita = id_visita;
		this.fecha = fecha;
		this.hora = hora;
		this.duracion = duracion;
		this.asesoria = asesoria;
	}
	
	public int getId_visita() {
		return id_visita;
	}
	public void setId_visita(int id_visita) {
		this.id_visita = id_visita;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public Capacitacion getCapacitacion() {
		return capacitacion;
	}
	public void setCapacitacion(Capacitacion capacitacion) {
		this.capacitacion = capacitacion;
	}
	public Asesoria getAsesoria() {
		return asesoria;
	}
	public void setAsesoria(Asesoria asesoria) {
		this.asesoria = asesoria;
	}
	
	
}
