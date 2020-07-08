package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import conexion.Conexion;
import modelo.Usuario;

public class UsuarioDAO {
	
	private Usuario u;
	private Connection conn;
	private Conexion miConexion;
	
	private PreparedStatement ps;
	private ResultSet rs;
	
	public UsuarioDAO(DataSource datos) {
		super();
		this.miConexion = new Conexion(datos);
	}

	public Usuario buscarPorID(int id) throws SQLException {
		String sql = "select * from USUARIO where ROL_ID_ROL= "+id;
		
		try {
			conn = miConexion.conectar();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				u.setId_usuario(rs.getInt("ID_USUARIO"));
				u.setUsuario(rs.getString("USUARIO"));
				u.setContrasenia(rs.getString("CONTRASENIA"));
				u.setId_rol(rs.getInt("ROL_ID_ROL"));
			}
			miConexion.desconectar(conn);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return u;
	}

}
