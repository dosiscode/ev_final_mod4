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
import modelo.Cliente;
import modelo.Persona;

public class PersonaDao {
	
	private Connection conn;
	private Conexion miConexion;
	private Persona persona;
	
	public PersonaDao(DataSource datos) {
		this.miConexion = new Conexion(datos);
	}
	
	
	//Guarda una persona en la BD
	public boolean guardaPersona(Persona p) throws SQLException {
		 
		String sql = "INSERT INTO PERSONA VALUES(IDPERSONA.nextval, ?,?,?)";
		
		conn = miConexion.conectar();
		
		PreparedStatement preStm = conn.prepareStatement(sql);
		
		preStm.setString(1, p.getNombre());
		preStm.setString(2, p.getApellido());
		preStm.setInt(3, p.getEdad());
				
		boolean siGuarda = preStm.executeUpdate() > 0;
		miConexion.desconectar(conn);
		
		return siGuarda;		
	}

	
	
	//devuelve la lista de personas de la BD
		public List<Persona> listarPersonas() throws SQLException{
			
			List<Persona>  listaPersona = new ArrayList<Persona>(); 
			
			String sql = "SELECT * FROM PERSONA";
			
			conn = miConexion.conectar();
			
			Statement stm = conn.createStatement();
			
			ResultSet res = stm.executeQuery(sql);
			
			while (res.next()) {
				persona = new Persona(res.getInt("id_persona"), res.getString("nombre"), 
						res.getString("apellido") , res.getInt("edad") );
				
				listaPersona.add(persona);
			}
			
			miConexion.desconectar(conn);			
			return listaPersona;
			
		}
		
		//devuelve el id la última persona registrada	
		public int idUltimaPersana() throws SQLException {
					
			String sqlUtimaPersona = "SELECT * FROM persona WHERE id_persona ="
					+ " (select max(id_persona) FROM persona)"; 
				
			conn = miConexion.conectar();
				
			Statement stm = conn.createStatement();
			ResultSet res = stm.executeQuery(sqlUtimaPersona);
			int idPersona = 0;
				
			while (res.next()) {
				idPersona = res.getInt("ID_PERSONA");
			}
				
			miConexion.desconectar(conn);
			return idPersona;		
		}
}
