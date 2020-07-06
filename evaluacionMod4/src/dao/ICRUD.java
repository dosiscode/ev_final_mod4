package dao;

import java.sql.SQLException;
import java.util.List;

public interface ICRUD {
	
	public boolean guardar(Object o) throws SQLException;
	public List<Object> listarTodo() throws SQLException;
	public Object buscarPorID(int id) throws SQLException;
	public void eliminar(int id) throws SQLException;
	
}
