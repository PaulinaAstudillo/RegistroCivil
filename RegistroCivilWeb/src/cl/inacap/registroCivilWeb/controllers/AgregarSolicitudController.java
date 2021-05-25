package cl.inacap.registroCivilWeb.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.registroCivilModel.dao.SolicitudesDAOLocal;
import cl.inacap.registroCivilModel.dto.Solicitud;

/**
 * Servlet implementation class AgregarSolicitudController
 */
@WebServlet("/AgregarSolicitudController.do")
public class AgregarSolicitudController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private SolicitudesDAOLocal solicitudesDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgregarSolicitudController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/vistas/agregarSolicitud.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<String> errores = new ArrayList<>();

		String rutCliente = request.getParameter("rutCliente-txt").trim();
		String nombreCliente = request.getParameter("nombreCliente-txt").trim();
		String tipoSolicitud = request.getParameter("tipoSolicitud-select").trim();
		if (rutCliente.isEmpty()) {
			errores.add("Ingrese su rut");
		} 

		if (nombreCliente.isEmpty()) {
			errores.add("Ingrese su nombre");
		}
		if (tipoSolicitud.isEmpty()) {
			errores.add("Debe seleccionar un tipo de Solicitud");
		}
		if (errores.isEmpty()) {
			Solicitud solicitud = new Solicitud();
			solicitud.setRutCliente(rutCliente);
			solicitud.setNombreCliente(nombreCliente);
			solicitud.setTipoSolicitud(tipoSolicitud);

			AtomicInteger nroSolicitud = new AtomicInteger(0);
			nroSolicitud.incrementAndGet();
			solicitud.setNroSolicitud(nroSolicitud);

			solicitudesDAO.save(solicitud);
			request.getRequestDispatcher("WEB-INF/vistas/atenderSolicitudes.jsp").forward(request, response);

		} else {
			request.setAttribute("errores", errores);
		}
		doGet(request, response);
	}
}
