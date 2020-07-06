package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import modelo.Profesional;

public class ProfesionalDAO implements ICRUD{
	
	private Profesional profesional;
	private Connection conn;
	private Conexion miConexion;
	
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public boolean guardar(Object o) throws SQLException {
		
		return false;
	}
	@Override
	public List<Object> listarTodo() throws SQLException {
		(List<Profesional>)(Object)lista = new ArrayList<Profesional>();
		String sql = "select * from PROFESIONAL";
		
		try {
			conn = miConexion.conectar();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				Profesional p=new Profesional();
				p.setId_profesional(rs.getString(1));
				p.setRut(rs.getString(2));
				p.setNombre(rs.getString(3));
				p.setApellido(rs.getString(4));
				lista.add(p);
			}
		} catch (Exception e) {
			
		}
		return lista;
	}
	@Override
	public Object buscarPorID(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void eliminar(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
