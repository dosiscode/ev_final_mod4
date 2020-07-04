package modelo;

public class Cliente {
	
	private int id_cliente;
	private String nombre;
	private String rut;
	private String email;
	private String direccion;
	private int comuna_id_comuna;
	private int num_direccion;
	
	
	public Cliente(int id_cliente, String nombre, String rut, String email, String direccion, int comuna_id_comuna,
			int num_direccion) {
		super();
		this.id_cliente = id_cliente;
		this.nombre = nombre;
		this.rut = rut;
		this.email = email;
		this.direccion = direccion;
		this.comuna_id_comuna = comuna_id_comuna;
		this.num_direccion = num_direccion;
	}


	public int getId_cliente() {
		return id_cliente;
	}


	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getRut() {
		return rut;
	}


	public void setRut(String rut) {
		this.rut = rut;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public int getComuna_id_comuna() {
		return comuna_id_comuna;
	}


	public void setComuna_id_comuna(int comuna_id_comuna) {
		this.comuna_id_comuna = comuna_id_comuna;
	}


	public int getNum_direccion() {
		return num_direccion;
	}


	public void setNum_direccion(int num_direccion) {
		this.num_direccion = num_direccion;
	}
	
	

}
