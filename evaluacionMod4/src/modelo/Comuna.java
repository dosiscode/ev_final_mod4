package modelo;

public class Comuna {
	private int id_comuna;
	private String comuna;
	private Region region;
	
	
	public Comuna(String comuna) {
		super();
		this.comuna = comuna;
	}
	public Comuna(int id) {
		super();
		this.id_comuna = id;
	}
	
	public int getId_comuna() {
		return id_comuna;
	}
	public void setId_comuna(int id_comuna) {
		this.id_comuna = id_comuna;
	}
	public String getComuna() {
		return comuna;
	}
	public void setComuna(String comuna) {
		this.comuna = comuna;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
}
