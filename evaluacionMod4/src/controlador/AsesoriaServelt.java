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

import dao.AseDAO;
import dao.CapacitacionDAO;
import modelo.Asesoria;
import modelo.Capacitacion;

/**
 * Servlet implementation class AsesoriaServelt
 */
@WebServlet("/AsesoriaServelt")
public class AsesoriaServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private AseDAO asesoriaDao;
	
	@Resource(name = "miConexion")
	private DataSource datosConexion;
	
	@Override
	public void init() throws ServletException {
		asesoriaDao = new AseDAO(datosConexion);
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsesoriaServelt() {
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
		// TODO Auto-generated method stub
		String accion = request. getParameter("accion");
		
		String tema;
		String objetivo;
		Date fecha_solicitud;
		
		if (accion=="creaAsesoria") {
			tema = request.getParameter("tema");
			objetivo = request.getParameter("objetivo");
			fecha_solicitud = Date.valueOf(request.getParameter("fecha_solicitud"));
			
			Asesoria asesoria= new Asesoria(tema, objetivo, fecha_solicitud);
			try {
				boolean siGuarda = asesoriaDao.guardarAsesoria(asesoria);
				
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				
		}catch (SQLException e) {
			System.out.println(e.getErrorCode());				
			}	
		}
	}
}
