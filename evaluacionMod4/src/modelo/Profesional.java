/**
 * 
 */
package modelo;

/**
 * @author Alumno
 *
 */
public class Profesional {
	private int id_profesional;
	private String nombre;
	private String apellido;
	private String rut;
	
	public Profesional(int id_profesional, String nombre, String apellido, String rut) {
		super();
		this.id_profesional = id_profesional;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
	}
	public Profesional() {
		
	}
	public int getId_profesional() {
		return id_profesional;
	}
	public void setId_profesional(int id_profesional) {
		this.id_profesional = id_profesional;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	
	

}
