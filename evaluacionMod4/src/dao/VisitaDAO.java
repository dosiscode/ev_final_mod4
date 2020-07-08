package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import conexion.Conexion;
import modelo.Asesoria;
import modelo.Capacitacion;
import modelo.Cliente;
import modelo.Visita;

public class VisitaDAO {
	private Connection conn;
	private Conexion miConexion;
	private Visita vista;
	private Asesoria asesoria;
	private Capacitacion capacitacion;
	
	public VisitaDAO(DataSource datos) {
		this.miConexion = new Conexion(datos);
	}
	
	public boolean guardar(Visita v, String tipo) throws SQLException {
		// TODO Auto-generated method stub
		
		conn = miConexion.conectar();
		PreparedStatement preStm=null;
		if(tipo.equalsIgnoreCase("asesoria")) {
			String sql = "INSERT INTO VISITA (ID_VISITA, FECHA_VISITA, HORA_VISITA,"
					+ " DURACION, ASESORIA_ID_ASESORIA) VALUES (idvisita_sequence.NEXTVAL, ?, ?, ?, ?)";
			preStm = conn.prepareStatement(sql);
			
			preStm.setDate(1, v.getFecha());
			preStm.setTime(2, v.getHora());
			preStm.setString(3, v.getDuracion());
			preStm.setInt(4, v.getAsesoria().getId_asesoria());
			
		}
		if(tipo.equalsIgnoreCase("capacitacion")) {
			String sql = "INSERT INTO VISITA (ID_VISITA, FECHA_VISITA, HORA_VISITA, "
					+ "DURACION, CAPACITACION_ID_CAPACITACION) VALUES (idvisita_sequence.NEXTVAL, ?, ?, ?, ?)";
			preStm = conn.prepareStatement(sql);
			
			preStm.setDate(1, v.getFecha());
			preStm.setTime(2, v.getHora());
			preStm.setString(3, v.getDuracion());
			preStm.setInt(4, v.getCapacitacion().getId_capacitacion());
		}

		
		boolean ok = preStm.executeUpdate() > 0;
		conn.close();
		return ok;
	}
}
