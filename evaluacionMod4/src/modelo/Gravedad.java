package modelo;

public class Gravedad {
	
	private int id_gravedad;
	private String nivel;
	
	
	
	public Gravedad(String nivel) {
		super();
		this.nivel = nivel;
	}


	public Gravedad(int id_gravedad, String nivel) {
		super();
		this.id_gravedad = id_gravedad;
		this.nivel = nivel;
	}


	public int getId_gravedad() {
		return id_gravedad;
	}


	public void setId_gravedad(int id_gravedad) {
		this.id_gravedad = id_gravedad;
	}


	public String getNivel() {
		return nivel;
	}


	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
	

}
