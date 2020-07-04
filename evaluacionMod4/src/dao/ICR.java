package dao;

import java.util.List;

public interface ICR {

	public boolean guardar(Object o);
	public List<Object> listarTodo();
	public Object buscarPorID(int id);
}
