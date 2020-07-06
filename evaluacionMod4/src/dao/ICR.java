package dao;

<<<<<<< HEAD
import java.util.List;

public interface ICR {

	public boolean guardar(Object o);
	public List<Object> listarTodo();
	public Object buscarPorID(int id);
=======
import java.sql.SQLException;
import java.util.List;

public interface ICR {

	public boolean guardar(Object o) throws SQLException;
	public List<Object> listarTodo() throws SQLException;
	public Object buscarPorID(int id) throws SQLException;
>>>>>>> branch 'master' of https://github.com/dosiscode/ev_final_mod4.git
}
