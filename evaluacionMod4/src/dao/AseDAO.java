package dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import javax.sql.DataSource;

import conexion.Conexion;
import modelo.Asesoria;

public class AseDAO {

	private Connection conn;
	private Conexion miConexion;
	private Asesoria asesoria;
	
	public AseDAO(DataSource datos) {
		 this.miConexion = new Conexion(datos);
	}
	
	public boolean guardarAsesoria(Asesoria a) throws SQLException{
		String sql = "INSERT INTO Asesoria (id_asesoria, tema, objetivo, "
				+" fecha_solicitud, cliente_id_cliente)\r\n VALUES "
				+ "(IDASESORIA.nextval, ?,?, CURRENT_DATE)";
		
		conn = miConexion.conectar();
		
		PreparedStatement preStm = conn.prepareStatement(sql);
		
		preStm.setString(1, a.getTema());
		preStm.setString(2, a.getObjetivo());
		preStm.setDate(3, (Date) a.getFecha_solicitud());
				
		boolean Guardar = preStm.executeUpdate() > 0;
		miConexion.desconectar(conn);
		
		return Guardar;	
	}

}