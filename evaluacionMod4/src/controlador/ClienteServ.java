package controlador;



import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
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
		
		String nombre;  
		String apellido; 
		int edad; 
		int nivel; 
		String horaString; 
		Date fecha;
		String descripcion;
		
		if(accion.equals("entraCliente")) {
			request.getRequestDispatcher("/vista/nuevoAccidente.jsp").forward(request, response);			
		}
		
		if (accion.equals("creaAccidente")) {			
			
			int siCrea = 0; 
			//Se obtienen los datos del formulario
			 nombre = request.getParameter("nombre");
			 apellido = request.getParameter("apellido");
			 edad = Integer.parseInt(request.getParameter("edad"));			
			 nivel = Integer.parseInt(request.getParameter("nivel"));
			 horaString = request.getParameter("hora");
			 fecha = Date.valueOf(request.getParameter("fecha"));
			 descripcion = request.getParameter("descripcion");			 
			 
				
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
				
				siCrea = 1;				
				request.setAttribute("confirmacion", siCrea);
				request.getRequestDispatcher("/vista/nuevoAccidente.jsp").forward(request, response);
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				
				siCrea = 0;				
				request.setAttribute("confirmacion", siCrea);
				request.getRequestDispatcher("/vista/nuevoAccidente.jsp").forward(request, response);				
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
		
		if(accion.equals("enviarCliente")) {
			int idClienteSlect = Integer.parseInt(request.getParameter("idCliente"));
			
			System.out.println(idClienteSlect);
		}
	}	
}
