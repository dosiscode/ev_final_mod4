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



public class ClienteDAO {

	private Connection conn;
	private Conexion miConexion;
	private Cliente cliente;
	
	
	public ClienteDAO(DataSource datos) {
		this.miConexion = new Conexion(datos);
	}
	
	
	//devuelve la lista de clientes de la BD
	public List<Cliente> listarClientes() throws SQLException{
			
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		
		String sql = "SELECT nombre, rut, correo_electronico, region, comuna, "
				+ "direccion, numero_direccion FROM cliente "
				+ "INNER JOIN comuna on cliente.comuna_id_comuna = comuna.id_comuna\r\n" + 
				"INNER JOIN region on comuna.region_id_region = region.id_region";
		
		conn = miConexion.conectar();
		
		Statement stm = conn.createStatement();
		
		ResultSet res = stm.executeQuery(sql);
		
		while (res.next()) {
			cliente = new Cliente( res.getString("nombre"), res.getString("rut") , 
					res.getString("correo_electronico"), res.getString("direccion"),
					res.getString("region"), res.getString("comuna"), res.getInt("numero_direccion"));
			
			listaCliente.add(cliente);
		}
		
		miConexion.desconectar(conn);
		return listaCliente;	
		
	}
	
	
	
}
