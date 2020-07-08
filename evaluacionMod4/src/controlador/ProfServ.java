package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import dao.ClienteDAO;
import dao.capacitaDao;

import modelo.Capacitacion;
import modelo.Cliente;

/**
 * Servlet implementation class ProfServ
 */
@WebServlet("/ProfServ")
public class ProfServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	private ClienteDAO clienteDao;
	private capacitaDao capaDao;
	private Capacitacion nuevaCapacitacion;
	
	
	//se recupera los datos del context.xml 
		@Resource(name = "miConexion")
		private DataSource datosConexion;
		
		@Override
		public void init() throws ServletException {
			clienteDao = new ClienteDAO(datosConexion);
			capaDao = new capacitaDao(datosConexion);
			
		}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfServ() {
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
		
		if(accion.equals("creaCapacita")) {
			
			mustraListaCliente(request, response);
			
						
		}
	
		if (accion.equals("creaCapacitacion")) {			
			
			int siCrea = 0; 
			//Se obtienen los datos del formulario
			 String descripcion = request.getParameter("descripcion");	
			 String objetivo = request.getParameter("objetivo");	
			 int id_cliente = Integer.parseInt(request.getParameter("idCliente"));
			 
			
					
			//se crea una nueva capacitacion
			 nuevaCapacitacion = new Capacitacion(descripcion, objetivo, id_cliente);
					
			
			try {
				//Se guarda la capacitacion.
				capaDao.guardaCapacitacion(nuevaCapacitacion);
				siCrea = 1;				
				request.setAttribute("confirmacion", siCrea);				
				mustraListaCliente(request, response);
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				
				siCrea = 0;				
				request.setAttribute("confirmacion", siCrea);
				mustraListaCliente(request, response);				
			}	
						
		}	
	}
	
	private void mustraListaCliente(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		List<Cliente> listaCliente;
		
		try {
			
			listaCliente = clienteDao.listarClientes();
			
			request.setAttribute("listaClientes", listaCliente);
			
			request.getRequestDispatcher("/vista/vitaCapacita.jsp").forward(request, response);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}			
	}

}
