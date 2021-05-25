package cl.inacap.registroCivilWeb.controllers;

import java.io.IOException;
import java.util.ArrayList;
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
		} else {
			/*
			 * try { rutCliente = rutCliente.replace(".", ""); rutCliente =
			 * rutCliente.replace("-", ""); int rutAux =
			 * Integer.parseInt(rutCliente.substring(0, rutCliente.length() - 1)); char dv =
			 * rutCliente.charAt(rutCliente.length() - 1); int m = 0, s = 1; for (; rutAux
			 * != 0; rutAux /= 10) { s = (s + rutAux % 10 * (9 - m++ % 6)) % 11; } if (dv ==
			 * (char) (s != 0 ? s + 47 : 75)) { } else { rutCliente = ""; } } catch
			 * (NumberFormatException ex) { System.out.println("chao"); } catch (Exception
			 * ex) { System.out.println("chao"); }
			 */
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
			solicitudesDAO.save(solicitud);
			request.getRequestDispatcher("WEB-INF/vistas/atenderSolicitudes.jsp").forward(request, response);
			
		} else {
			request.setAttribute("errores", errores);
		}
		doGet(request, response);
	}
}
