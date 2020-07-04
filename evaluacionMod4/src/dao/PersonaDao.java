package dao;

import java.sql.Connection;
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
			
}
