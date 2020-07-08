package controlador;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import dao.ClienteDAO;
import dao.VisitaDAO;
import modelo.Asesoria;
import modelo.Capacitacion;
import modelo.Cliente;
import modelo.Comuna;
import modelo.Visita;

/**
 * Servlet implementation class ProfesionalServlet
 */
@WebServlet("/ProfesionalServlet")
public class ProfesionalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private VisitaDAO visitaDAO;
	
	@Resource(name = "miConexion")
	private DataSource datosConexion;
	
	@Override
	public void init() throws ServletException {
		visitaDAO= new VisitaDAO(datosConexion);
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfesionalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("accion");
		try {
			
			switch (accion) {
			case "agregarVisita":			
				agregarVisita(request, response);
				break;
			
			default:
				break;
			}
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			System.out.println("aqui");
			
		}
	}

	
	private void agregarVisita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tipo=request.getParameter("tipo");
		int id=Integer.parseInt(request.getParameter("id"));
		
		Date fecha = Date.valueOf(request.getParameter("txtFecha"));
		
		Time hora = Time.valueOf(LocalTime.parse(request.getParameter("txtHora")));
		String duracion = request.getParameter("txtDuracion");
		Visita v=null;
		try {
			if(tipo.equalsIgnoreCase("asesoria")) {
				Asesoria a = new Asesoria(id);
				v= new Visita(fecha, hora, duracion, a);
			}
			if(tipo.equalsIgnoreCase("capacitacion")) {
				Capacitacion c = new Capacitacion(id);
				v= new Visita(fecha, hora, duracion, c);
			}			
			
			String msg="";
			if(visitaDAO.guardar(v, tipo)) {
				msg="Visita agendada correctamente";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("./vista/agregarVisita.jsp").forward(request, response);
			}else {
				System.out.println("no se guardo :c");
			}
			
			
				
		} catch (SQLException e) {					
			System.out.println(e.getMessage());
		}
		
	}
}
