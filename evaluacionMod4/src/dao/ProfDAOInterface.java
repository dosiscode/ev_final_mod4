package dao;

import java.sql.SQLException;
import java.util.List;

import modelo.Profesional;

public interface ProfDAOInterface {

	public boolean guardar(Profesional o) throws SQLException;
	public List<Profesional> listarTodo() throws SQLException;
	public Profesional buscarPorID(int id) throws SQLException;
	public boolean editar(Profesional p) throws SQLException;
	public void eliminar(int id) throws SQLException;
	
}
