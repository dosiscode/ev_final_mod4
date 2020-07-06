package controlador;

import java.io.IOException;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;


import java.time.LocalDate;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import dao.AccidenteDAO;
import dao.ClienteDAO;
import dao.PersonaDao;
import modelo.Accidente;
import modelo.Cliente;
import modelo.Persona;


/**
 * Servlet implementation class ClienteServ
 */
@WebServlet("/ClienteServ")
public class ClienteServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClienteDAO clienteDao;
	private PersonaDao personaDao;
	private AccidenteDAO accidenteDao;
	
	//se recupera los datos del context.xml 
	@Resource(name = "miConexion")
	private DataSource datosConexion;
	
	@Override
	public void init() throws ServletException {
		clienteDao = new ClienteDAO(datosConexion);
		personaDao = new PersonaDao(datosConexion);
		accidenteDao = new AccidenteDAO(datosConexion);
	}
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("accion");	
		
		
		if (accion.equals("creaAccidente")) {			
			
			//Se obtienen los datos del formulario
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			int edad = Integer.parseInt(request.getParameter("edad"));			
			int nivel = Integer.parseInt(request.getParameter("nivel"));
			String horaString = request.getParameter("hora");
			Date fecha = Date.valueOf(request.getParameter("fecha"));
			String descripcion = request.getParameter("descripcion");			 
				
			//se convierte la hora			
			LocalTime lt = LocalTime.parse(horaString);
			Time hora = Time.valueOf(lt);			 
			
			//se crea una nueva persona y su accidente
			Persona personaNueva = new Persona(nombre, apellido, edad);			
			Accidente accidenteNuevo = new Accidente(hora, fecha, descripcion, nivel);			
			
			try {
				//Se guarda la persona y el accidente.
				personaDao.guardaPersona(personaNueva);
				accidenteDao.guardaAccidente(accidenteNuevo);
				
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				
			} catch (SQLException e) {
				System.out.println(e.getErrorCode());				
			}				
		}
		
		if (accion.equals("listarCliente")) {
			
			List<Cliente> listaCliente;
			
			try {
				listaCliente = clienteDao.listarClientes();
				
				request.setAttribute("listaClientes", listaCliente);
				
				request.getRequestDispatcher("/vista/revisarCliente.jsp").forward(request, response);
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}			
		}
	}	
}
