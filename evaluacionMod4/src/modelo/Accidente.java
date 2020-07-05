package modelo;

import java.sql.Date;
import java.sql.Time;


public class Accidente {

	
	private int id_accidente;
	private Time hora;
	private Date fecha;
	private String descripcion;
	private int id_gravedad;
	private int id_persona;
	private int id_asesoria;
	
	
	
	public Accidente(Time hora, Date fecha, String descripcion, int id_gravedad) {
		super();
		this.hora = hora;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.id_gravedad = id_gravedad;
		
	}


	public Accidente(int id_accidente, Time hora, Date fecha, String descripcion, int id_gravedad, int id_persona,
			int id_asesoria) {
		super();
		this.id_accidente = id_accidente;
		this.hora = hora;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.id_gravedad = id_gravedad;
		this.id_persona = id_persona;
		this.id_asesoria = id_asesoria;
	}


	public Accidente(int id_accidente, Time hora, Date fecha, String descripcion, int id_gravedad, int id_persona) {
		super();
		this.id_accidente = id_accidente;
		this.hora = hora;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.id_gravedad = id_gravedad;
		this.id_persona = id_persona;
	}


	public int getId_accidente() {
		return id_accidente;
	}


	public void setId_accidente(int id_accidente) {
		this.id_accidente = id_accidente;
	}


	public Time getHora() {
		return hora;
	}


	public void setHora(Time hora) {
		this.hora = hora;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getId_gravedad() {
		return id_gravedad;
	}


	public void setId_gravedad(int id_gravedad) {
		this.id_gravedad = id_gravedad;
	}


	public int getId_persona() {
		return id_persona;
	}


	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}


	public int getId_asesoria() {
		return id_asesoria;
	}


	public void setId_asesoria(int id_asesoria) {
		this.id_asesoria = id_asesoria;
	}
}
