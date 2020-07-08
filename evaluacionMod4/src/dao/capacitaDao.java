package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import conexion.Conexion;
import modelo.Capacitacion;
import modelo.Persona;

public class capacitaDao {
	
	private Connection conn;
	private Conexion miConexion;
	private Capacitacion capacitacion;
	
	public capacitaDao(DataSource datos) {
		this.miConexion = new Conexion(datos);
	}
	

	//Guarda una persona en la BD
		public boolean guardaCapacitacion(Capacitacion c) throws SQLException {
			 
		String sql = "INSERT INTO capacitacion (id_capacitacion, descripcion,"
				+ " objetivo,fecha_solicitud, cliente_id_cliente)\r\n" + 
					"VALUES(IDCAPACITACION.nextval , ? , ? , CURRENT_DATE, ?)";
			
			conn = miConexion.conectar();
			
			PreparedStatement preStm = conn.prepareStatement(sql);
			
			preStm.setString(1, c.getDescripcion());
			preStm.setString(2, c.getObjetivo());
			preStm.setInt(3, c.getId_cliente());
					
			boolean siGuarda = preStm.executeUpdate() > 0;
			miConexion.desconectar(conn);
			
			return siGuarda;		
		}
		
		//devuelve la id de la ultima capacitacion
		public int idUltimaCapacitacion() throws SQLException {
			
			String sqlUtimaPersona = "SELECT * FROM capacitacion "
					+ "WHERE id_capacitacion = (select max(id_capacitacion) FROM capacitacion)"; 
				
			conn = miConexion.conectar();
				
			Statement stm = conn.createStatement();
			ResultSet res = stm.executeQuery(sqlUtimaPersona);
			int idPersona = 0;
				
			while (res.next()) {
				idPersona = res.getInt("id_capacitacion");
			}
				
			miConexion.desconectar(conn);
			return idPersona;		
		}
}
