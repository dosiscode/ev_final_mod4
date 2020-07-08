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
import modelo.Comuna;



public class ClienteDAO {

	private Connection conn;
	private Conexion miConexion;
	private Cliente cliente;
	
	private Comuna com;
	
	
	public ClienteDAO(DataSource datos) {
		this.miConexion = new Conexion(datos);
	}
	
	
		
	
		public boolean guardar(Cliente o) throws SQLException {
				// TODO Auto-generated method stub
				String sql = "INSERT INTO CLIENTE (ID_CLIENTE, NOMBRE, RUT, CORREO_ELECTRONICO, "
						+ "DIRECCION, COMUNA_ID_COMUNA, NUMERO_DIRECCION)"
						+ " VALUES (idcliente_sequence.NEXTVAL , ?, ?, ?, ?, ?, ?)";
				conn = miConexion.conectar();
				
				PreparedStatement preStm = conn.prepareStatement(sql);
				
				preStm.setString(1, o.getNombre());
				preStm.setString(2, o.getRut());
				preStm.setString(3, o.getEmail());
				preStm.setString(4, o.getDireccion());
				preStm.setInt(5, o.getCom().getId_comuna());
				preStm.setInt(6, o.getNum_direccion());
				
				boolean ok = preStm.executeUpdate() > 0;
				conn.close();
				return ok;
			}
		
		public List<Cliente> listarTodo() throws SQLException {
				// TODO Auto-generated method stub
				List<Cliente>  listaCliente = new ArrayList<Cliente>();
				
				String sql = "SELECT ID_CLIENTE, NOMBRE, RUT, CORREO_ELECTRONICO, DIRECCION, "
						+ "CO.COMUNA, NUMERO_DIRECCION FROM CLIENTE CLI "
						+ "INNER JOIN COMUNA CO ON CLI.COMUNA_ID_COMUNA=CO.ID_COMUNA";
				
				conn = miConexion.conectar();
				
				Statement stm = conn.createStatement();
				
				ResultSet res = stm.executeQuery(sql);
				
				while (res.next()) {
					com= new Comuna(res.getString("comuna"));
					cliente = new Cliente(res.getInt("id_cliente"),res.getString("nombre"), 
							res.getString("rut"), res.getString("correo_electronico"),
							res.getString("direccion"), res.getInt("numero_direccion"), com);
					
					listaCliente.add(cliente);
				}
				
				conn.close();
				
				return listaCliente;
			}
		
		public Cliente buscarPorID(int id) throws SQLException {
				
				String sql = "SELECT ID_CLIENTE, NOMBRE, RUT, CORREO_ELECTRONICO, DIRECCION, "
						+ "CO.COMUNA, NUMERO_DIRECCION FROM CLIENTE CLI "
						+ "INNER JOIN COMUNA CO ON CLI.COMUNA_ID_COMUNA=CO.ID_COMUNA WHERE ID_CLIENTE=?";
				conn = miConexion.conectar();
				PreparedStatement preStm = conn.prepareStatement(sql);
				preStm.setInt(1, id);
				
				ResultSet res = preStm.executeQuery();
				
				while (res.next()) {
					cliente = new Cliente(res.getInt("id_cliente"),res.getString("nombre"), 
							res.getString("rut"), res.getString("correo_electronico"),
							res.getString("direccion"), res.getInt("numero_direccion"), com);
				}
				conn.close();
				return cliente;
			}
	
		public boolean eliminar(int id) throws SQLException {
				// TODO Auto-generated method stub
				String sql = "DELETE CLIENTE WHERE ID_CLIENTE=?";
				conn = miConexion.conectar();
				PreparedStatement preStm = conn.prepareStatement(sql);
				preStm.setInt(1, id);
				boolean ok = preStm.executeUpdate() > 0;
				
				return ok;
			}
		
		public boolean editar(Cliente c) throws SQLException {
				// TODO Auto-generated method stub
				String sql = "UPDATE CLIENTE SET NOMBRE=?, RUT=?, CORREO_ELECTRONICO=?, DIRECCION=?, "
						+ "COMUNA_ID_COMUNA=?, NUMERO_DIRECCION=? WHERE ID_CLIENTE=?";
				conn = miConexion.conectar();
				
				PreparedStatement preStm = conn.prepareStatement(sql);
				
				preStm.setString(1, c.getNombre());
				preStm.setString(2, c.getRut());
				preStm.setString(3, c.getEmail());
				preStm.setString(4, c.getDireccion());
				preStm.setInt(5, c.getCom().getId_comuna());
				preStm.setInt(6, c.getNum_direccion());
				preStm.setInt(7, c.getId_cliente());
				
				boolean ok = preStm.executeUpdate() > 0;
				conn.close();
				return ok;
			}
	
	
	//devuelve la lista de clientes de la BD
	public List<Cliente> listarClientes() throws SQLException{
			
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		
		String sql = "SELECT id_cliente, nombre, rut, correo_electronico, region, comuna, "
				+ "direccion, numero_direccion FROM cliente \r\n" + 
				"INNER JOIN comuna on cliente.comuna_id_comuna = comuna.id_comuna\r\n" + 
				"INNER JOIN region on comuna.region_id_region = region.id_region ORDER BY id_cliente";
		
		conn = miConexion.conectar();
		
		Statement stm = conn.createStatement();
		
		ResultSet res = stm.executeQuery(sql);
		
		while (res.next()) {
			cliente = new Cliente(res.getString("nombre"), res.getString("rut") , 
					res.getString("correo_electronico"), res.getString("direccion"), 
					res.getString("region"), res.getString("comuna"), res.getInt("numero_direccion"),
					res.getInt("id_cliente"));
					
					
			listaCliente.add(cliente);
		}
		
		miConexion.desconectar(conn);
		return listaCliente;	
		
	}
	
	
	
}
