package cl.inacap.registroCivilWeb.controllers;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cl.inacap.registroCivilModel.dao.SolicitudesDAOLocal;
import cl.inacap.registroCivilModel.dto.Solicitud;

/**
 * Servlet implementation class AtenderSolicitudController
 */
@WebServlet("/AtenderSolicitudController.do")
public class AtenderSolicitudController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject SolicitudesDAOLocal solicitudesDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtenderSolicitudController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("eliminarSolicitud") != null) {
			String nombre = request.getParameter("eliminarSolicitud").trim();
			List<Solicitud> busqueda = solicitudesDAO.filterByNombreCliente(nombre);
			Solicitud eliminar = busqueda.isEmpty()? null:busqueda.get(0);
			if(eliminar != null) {
				solicitudesDAO.delete(eliminar);
			}
			
		}
		List<Solicitud> solicitudes = solicitudesDAO.getAll();
		request.setAttribute("solicitudes", solicitudes);
		request.getRequestDispatcher("WEB-INF/vistas/atenderSolicitudes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
