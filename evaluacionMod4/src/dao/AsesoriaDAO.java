package dao;

<<<<<<< HEAD
import java.util.List;

public class AsesoriaDAO implements ICR {
	private String hola;
	
	@Override
	public boolean guardar(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Object> listarTodo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object buscarPorID(int id) {
		// TODO Auto-generated method stub
		return null;
=======
import java.sql.*;
import java.sql.Date;
import java.util.*;

import javax.sql.DataSource;

import conexion.Conexion;
import modelo.Asesoria;

public class AsesoriaDAO implements ICR {
	
	private Connection con;
	private Conexion miConexion;
	private Asesoria asesoria;
	
	public AsesoriaDAO(DataSource datos) {
		 this.miConexion = new Conexion(datos);
	}
	
	@Override
	public boolean guardar(Object o) throws SQLException{
		Asesoria asesoria = (Asesoria)o;
		String sql = "INSERT INTO Asesoria VALUES(Id_asesoria.nextval, ?,?,?,?)";
		
		con = miConexion.conectar();
		
		PreparedStatement preStm = con.prepareStatement(sql);
		
		preStm.setInt(1, asesoria.getId_asesoria());
		preStm.setString(2, asesoria.getTema());
		preStm.setString(3, asesoria.getObjetivo());
		preStm.setDate(4, (Date) asesoria.getFecha_solicitud());
				
		boolean Guardar = preStm.executeUpdate() > 0;
		miConexion.desconectar(con);
		
		return Guardar;	
	}

	@Override
	public List<Object> listarTodo() throws SQLException{
		(List<Asesoria>)(Object)listaAsesoria = new ArrayList<Asesoria>(); 
		
		String sql = "SELECT * FROM ASESORIA";
		
		con = miConexion.conectar();
		
		Statement stm = con.createStatement();
		
		ResultSet res = stm.executeQuery(sql);
		
		while (res.next()) {
			asesoria = new Asesoria(res.getInt("id_asesoria"), res.getString("tema"), 
					res.getString("objetivo") , res.getDate("fecha_solicitud"));
			
			listaAsesoria.add(asesoria);
		}
		
		miConexion.desconectar(con);	
		return listaAsesoria;		
	}

	@Override
	public Object buscarPorID(int id) throws SQLException{
		Asesoria asesoria = null;
		
		String sql = "SELECT * FROM Asesoria WHERE id_asesoria = ?";
		con = miConexion.conectar();
		
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet res = statement.executeQuery();
		
		if (res.next()) {
			asesoria = new Asesoria(res.getInt("id_asesoria"), res.getString("tema"), 
					res.getString("objetivo") , res.getDate("fecha_solicitud"));
		}
		res.close();
		miConexion.desconectar(con);
		
		return asesoria;
>>>>>>> branch 'master' of https://github.com/dosiscode/ev_final_mod4.git
	}

}
