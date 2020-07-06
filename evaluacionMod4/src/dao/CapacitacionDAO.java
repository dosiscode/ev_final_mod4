package dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import javax.sql.DataSource;

import conexion.Conexion;
import modelo.Capacitacion;

public class CapacitacionDAO implements ICR {

	private Connection con;
	private Conexion miConexion;
	private Capacitacion capacitacion;
	
	public CapacitacionDAO(DataSource datos) {
		 this.miConexion = new Conexion(datos);
	}
	@Override
	public boolean guardar(Object o) throws SQLException {
		Capacitacion capacitacion = (Capacitacion)o;
		String sql = "INSERT INTO Capacitacion VALUES(Id_capacitacion.nextval, ?,?,?,?)";
		
		con = miConexion.conectar();
		
		PreparedStatement preStm = con.prepareStatement(sql);
		
		preStm.setInt(1, capacitacion.getId_capacitacion());
		preStm.setString(2, capacitacion.getDescripcion());
		preStm.setString(3, capacitacion.getObjetivo());
		preStm.setDate(4, (Date) capacitacion.getFecha_solicitud());
				
		boolean Guardar = preStm.executeUpdate() > 0;
		miConexion.desconectar(con);
		
		return Guardar;	
	}

	@Override
	public List<Capacitacion> listarTodo() throws SQLException{
		
		 List<Capacitacion> listaCapacitacion = new ArrayList<Capacitacion>();
		String sql = "SELECT * FROM Capacitacion";
		
		con = miConexion.conectar();
		
		Statement stm = con.createStatement();
		
		ResultSet res = stm.executeQuery(sql);
		
		while (res.next()) {
			capacitacion = new Capacitacion(res.getInt("id_asesoria"), res.getString("descripcion"), 
					res.getString("objetivo") , res.getDate("fecha_solicitud"));
			
			listaCapacitacion.add(capacitacion);
		}
		
		miConexion.desconectar(con);	
		return listaCapacitacion;		
	}

	@Override
	public Object buscarPorID(int id) throws SQLException {
		Capacitacion capacitacion = null;
		
		String sql = "SELECT * FROM Capacitacion WHERE id_capacitacion = ?";
		con = miConexion.conectar();
		
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet res = statement.executeQuery();
		
		if (res.next()) {
			capacitacion = new Capacitacion(res.getInt("id_capacitacion"), res.getString("descripcion"), 
					res.getString("objetivo") , res.getDate("fecha_solicitud"));
		}
		res.close();
		miConexion.desconectar(con);
		
		return capacitacion;
	}

}
