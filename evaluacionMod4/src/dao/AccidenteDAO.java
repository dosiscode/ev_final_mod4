package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import conexion.Conexion;
import modelo.Accidente;
import modelo.Persona;


public class AccidenteDAO {
	
	Accidente accidente;
	
	Connection conn;
	Conexion miConexion;
	
	
	public AccidenteDAO(DataSource datos) {
		 this.miConexion = new Conexion(datos);
	}
	
	
	//Guarda un accidente en la BD
		public boolean guardaAccidente(Accidente p) throws SQLException {
			 
			String sql = "INSERT INTO Accidente VALUES(idAccidente.nextval, ?,?,?,?,?)";
			
			conn = miConexion.conectar();
			
			PreparedStatement preStm = conn.prepareStatement(sql);
			
			preStm.setTime(1, p.getHora());
			preStm.setDate(2, (Date) p.getFecha());
			preStm.setString(3, p.getDescripcion());
			preStm.setInt(4, p.getId_gravedad());
			preStm.setInt(4, p.getId_persona());
					
			boolean siGuarda = preStm.executeUpdate() > 0;
			miConexion.desconectar(conn);
			
			return siGuarda;		
		}

	
	
	//devuelve la lista de clientes de la BD
		public List<Accidente> listarAccidente() throws SQLException{
			
			List<Accidente> listaAccidente = new ArrayList<Accidente>(); 
			
			String sql = "SELECT * FROM ACCIDENTE";
			
			conn = miConexion.conectar();
			
			Statement stm = conn.createStatement();
			
			ResultSet res = stm.executeQuery(sql);
			
			while (res.next()) {
								
				accidente = new Accidente(res.getInt("id_accidente"), res.getTime("hora"), 
						res.getDate("fecha"), res.getString("descripcion"), res.getInt("GRAVEDAD_ID_GRAVEDAD"),
						res.getInt("PERSONA_ID_PERSONA"), res.getInt("ASESORIA_ID_ASESORIA"));
				
				listaAccidente.add(accidente);
			}
			
			miConexion.desconectar(conn);
			
			return listaAccidente;			
		}

}
