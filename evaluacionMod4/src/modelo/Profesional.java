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
	private String rut;
	private String nombre;
	private String apellido;
	
	public Profesional(int id_profesional, String rut, String nombre, String apellido) {
		super();
		this.id_profesional = id_profesional;
		this.rut = rut;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Profesional(String rut, String nombre, String apellido) {
		super();
		this.rut = rut;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public int getId_profesional() {
		return id_profesional;
	}

	public void setId_profesional(int id_profesional) {
		this.id_profesional = id_profesional;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
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

	
	

}
