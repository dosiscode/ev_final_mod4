package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import dao.ProfesionalDAO;
import modelo.Profesional;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ProfesionalDAO profesionalDao;
	private Profesional p;
	private DataSource datosConexion;
	
	@Resource(name="miConexion")
	private DataSource ds;
	public void init() throws ServletException {
		try {
			profesionalDao = new ProfesionalDAO(ds);
			clienteDAO = new ClienteDAO(datosConexion);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
    public AdminServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		
		try {
			String acc = request.getParameter("acc");
			switch (acc) {
			case "ListarTodo":
				List<Profesional> datos;
				datos = profesionalDao.listarTodo();
				request.setAttribute("datos", datos);
				request.getRequestDispatcher("vista/mantenedorProfesional.jsp").forward(request, response);
				break;
			case "Eliminar":
				int idEliminar = Integer.parseInt(request.getParameter("id"));
				try {
					profesionalDao.eliminar(idEliminar);
					System.out.println("PROFESIONAL ELIMINADO");
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				request.getRequestDispatcher("AdminServlet?acc=ListarTodo").forward(request, response);
				break;
			case "Editar":
				System.out.println("ESTOY EN EDITAR");
				int id_prof = Integer.parseInt((String)request.getParameter("txtId"));
				try {
					Profesional profID;
					profID = profesionalDao.buscarPorID(id_prof);
					request.setAttribute("profID", profID);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				request.getRequestDispatcher("vista/editarProfesional.jsp").forward(request, response);
				break;
			default:
				break;
			}
			//FER
			switch (accion) {
			case "listarClientes":			
				listarClientes(request, response);
				break;
			case "buscarCliente":
				buscarCliente(request, response);				
				break;
			case "eliminarCliente":
				eliminarCliente(request, response);				
				break;
			default:
				break;
			}
		} catch (Exception e) {
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String accion = request.getParameter("accion");
			switch (accion) {
			case "Listar":
				List<Profesional> datos;
				datos = profesionalDao.listarTodo();
				request.setAttribute("datos", datos);
				request.getRequestDispatcher("vista/mantenedorProfesional.jsp").forward(request, response);
				break;
			case "Guardar":
				String r = request.getParameter("rut");
				String n = request.getParameter("nombre");
				String a = request.getParameter("apellido");
				p=new Profesional(r,n,a);
				try {
					profesionalDao.guardar(p);
					request.getRequestDispatcher("AdminServlet?accion=Listar").forward(request, response);
				} catch (SQLException e) {
					System.out.println(e.getErrorCode());
					e.printStackTrace();
				}
				break;
			
			case "Actualizar":
				int id=Integer.parseInt(request.getParameter("txtId"));
				String rut = request.getParameter("rut");
				String nombre = request.getParameter("nombre");
				String apellido = request.getParameter("apellido");
				p=new Profesional(id,rut,nombre,apellido);
				try {
					profesionalDao.editar(p);
					request.getRequestDispatcher("AdminServlet?acc=ListarTodo").forward(request, response);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			//FER
			case "agregarCliente":
				guardarCliente(request, response);				
				break;
			
			case "editarCliente":
				editarCliente(request, response);				
				break;
			default:
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	//FER
	private void guardarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String razonSocial	=request.getParameter("txtRazonSocial");
		String rut			=request.getParameter("txtRut");
		String correo		=request.getParameter("txtCorreo");
		String calle		=request.getParameter("txtCalle");
		int numero			=Integer.parseInt(request.getParameter("txtNum"));
		int comuna			=Integer.parseInt(request.getParameter("slcComuna"));
		
		try {
			Comuna com=new Comuna(comuna);
			Cliente c= new Cliente(razonSocial, rut, correo, calle, numero, com);
			
			String msg="";
			if(clienteDAO.guardar(c)) {
				msg="Cliente se guardo con exito!";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("./vista/agregarCliente.jsp").forward(request, response);
			}else {
				System.out.println("no se guardo :c");
			}
			
			
				
		} catch (SQLException e) {					
			System.out.println(e.getMessage());
		}
		
	}

	private void listarClientes(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<Cliente> listClient;
		try {
			listClient = clienteDAO.listarTodo();
			
			request.setAttribute("lista", listClient);
			
			request.getRequestDispatcher("/vista/mantenedorCliente.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println( e.getMessage());
		}
	}
	
	private void buscarCliente(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			Cliente c = clienteDAO.buscarPorID(id);
			request.setAttribute("cliente", c);
			
			request.getRequestDispatcher("/vista/editarCliente.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println( e.getMessage());
		}
	}
	
	private void editarCliente(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id 				= Integer.parseInt(request.getParameter("id"));
		String razonSocial	=request.getParameter("txtRazonSocial");
		String rut			=request.getParameter("txtRut");
		String correo		=request.getParameter("txtCorreo");
		String calle		=request.getParameter("txtCalle");
		int numero			=Integer.parseInt(request.getParameter("txtNum"));
		int comuna			=Integer.parseInt(request.getParameter("slcComuna"));
		
		Comuna com=new Comuna(comuna);
		Cliente c= new Cliente(id, razonSocial, rut, correo, calle, numero, com);
		String msg="";
		try {
			if(clienteDAO.editar(c)) {
				msg="Cliente fue editado con exito!";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("./vista/editarCliente.jsp").forward(request, response);
			}else {
				msg="No se pudo editar :C";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("./vista/editarCliente.jsp").forward(request, response);
			}
			
			
		} catch (Exception e) {
			System.out.println( e.getMessage());
		}
	}
	
	private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String msg="";
		try {
			if(clienteDAO.eliminar(id)) {
				msg="Cliente eliminado!";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("/AdminServlet?accion=listarClientes").forward(request, response);
			}else {
				msg="No se pudo eliminar :C";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("/vista/mantenedorCliente.jsp").forward(request, response);
			}
			
			
			
		} catch (Exception e) {
			System.out.println( e.getMessage());
		}
		
		
	}

}
