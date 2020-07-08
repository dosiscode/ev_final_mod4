package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import conexion.Conexion;
import modelo.Profesional;

public class ProfesionalDAO implements ProfDAOInterface{
	
	private Profesional p;
	private Connection conn;
	private Conexion miConexion;
	
	private PreparedStatement ps;
	private ResultSet rs;


	public ProfesionalDAO(DataSource datos) {
		super();
		this.miConexion = new Conexion(datos);
	}

	@Override
	public boolean guardar(Profesional o) throws SQLException {
		String sql ="insert into PROFESIONAL(ID_PROFESIONAL,RUT,NOMBRE,APELLIDO) values (idProfesional.nextval,?,?,?)";
		conn=miConexion.conectar();
		ps=conn.prepareStatement(sql);
		ps.setString(1, o.getRut());
		ps.setString(2, o.getNombre());
		ps.setString(3, o.getApellido());
		boolean guardado = ps.executeUpdate()>0;
		
		miConexion.desconectar(conn);

		return guardado;
	}

	@Override
	public List<Profesional> listarTodo() throws SQLException {
		List<Profesional> lista = new ArrayList<Profesional>();
		String sql = "select * from PROFESIONAL";
		
		try {
			conn = miConexion.conectar();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				p = new Profesional(rs.getInt("id_profesional"), rs.getString("RUT"), rs.getString("NOMBRE"), rs.getString("APELLIDO"));
				lista.add(p);
			}
			miConexion.desconectar(conn);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}


	@Override
	public Profesional buscarPorID(int id) throws SQLException {
		String sql = "select * from PROFESIONAL where ID_PROFESIONAL = "+id;
		
		try {
			conn = miConexion.conectar();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				p.setId_profesional(rs.getInt("id_profesional"));
				p.setRut(rs.getString("RUT"));
				p.setNombre(rs.getString("NOMBRE"));
				p.setApellido(rs.getString("APELLIDO"));
			}
			miConexion.desconectar(conn);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return p;
	}


	@Override
	public void eliminar(int id) throws SQLException {
		String sql = "DELETE FROM PROFESIONAL WHERE ID_PROFESIONAL = "+id;
		
		try {
			conn=miConexion.conectar();
			ps=conn.prepareStatement(sql);
			ps.execute();
			ps.close();
			miConexion.desconectar(conn);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public boolean editar(Profesional p) throws SQLException {
		boolean editado = false;
		String sql = "update profesional set rut='"+p.getRut()+"', nombre='"+p.getNombre()+"', apellido='"+p.getApellido()+"' where id_profesional="+p.getId_profesional();
		
		try {
			
			conn=miConexion.conectar();
			ps=conn.prepareStatement(sql);
			editado = ps.executeUpdate()>0;
			miConexion.desconectar(conn);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return editado;
	}
}
