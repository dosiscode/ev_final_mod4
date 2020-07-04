package conexion;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class Conexion {
	
	private DataSource datosConexion;
	
	public Conexion(DataSource datos) {
		this.datosConexion = datos;
	}
	
	//Crea la conexcion a BD
	public Connection conectar() throws SQLException {
		return datosConexion.getConnection();
	}
	
	public void desconectar(Connection conn) throws SQLException {
		conn.close();
	}
}
