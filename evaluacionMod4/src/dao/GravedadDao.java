package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import conexion.Conexion;
import modelo.Gravedad;

public class GravedadDao {
	
	private Gravedad gravedad;
	private Connection conn;
	private Conexion miConexion;
	
	
	public GravedadDao(DataSource datos) {
		this.miConexion = new Conexion(datos);
	}
	
	//devuelve la lista de los tipos de gravedad
	public List<Gravedad> listarGravedad() throws SQLException {
		 List<Gravedad> listaGravedad = new ArrayList<Gravedad>();
		 
		 String sql = "SELECT * FROM GRAVEDAD";
		 
		 conn = miConexion.conectar();
		 
		 Statement stm = conn.createStatement();
		 
		 ResultSet res = stm.executeQuery(sql);
		 
		 while(res.next()) {
			 gravedad = new Gravedad(res.getString("nivel"));
			 
			 listaGravedad.add(gravedad);
		 }
		 
		 miConexion.desconectar(conn);
		 
		 return listaGravedad;
	}

}
