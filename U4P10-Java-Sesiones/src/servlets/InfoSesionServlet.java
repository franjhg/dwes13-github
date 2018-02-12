package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InfoSesionesServlet
 */
@WebServlet("/InfoSesion")
public class InfoSesionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InfoSesionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Crear una sesión o recuperar la existente si se encuentra la cookie de sesión
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		
		int contador = 0;
		String primeraVez = "";
		// Comprobar si es la primera vez

		if (request.getParameter("reiniciarSesion") != null) {//true del enlace
			session.invalidate();
			response.sendRedirect(request.getRequestURI());

		} else {
			if (session.isNew()) {
				session.setAttribute("contador", 0);
				// 5.
				session.setAttribute("primeraVez", "Esta es tu primera visita, se ha creado una sesion");
				primeraVez = (String) session.getAttribute("primeraVez");
								
			} else {

				contador = (int) session.getAttribute("contador");
				contador++;
				session.setAttribute("contador", contador);
				session.removeAttribute("mensaje");
				
			}
		
		//session.setMaxInactiveInterval(30);
		
		// Obtener datos sobre la sesión
		Date fechaInicioSesion = new Date(session.getCreationTime());
		// Obtener la fecha del último acceso
		Date fechaUltimoAcceso = new Date(session.getLastAccessedTime());

		// Comienza la salida...
		
		out.println("<html><head><meta charset='UTF-8'/>" + "<style> .error {color: red}</style>"
				+ "<title>Sesiones en JavaEE</title></head><body>");
		response.setContentType("text/html;UTF-8");
		out.println(
				"<h2>Información sobre la sesión</h2>" + "<ul>" + "<li> Identificador: " + session.getId() + "</li>\n"
						+ "<li> Fecha de creación: " + fechaInicioSesion + "</li>\n" + "<li> Fecha de último acceso: "
						+ fechaUltimoAcceso + "</li>\n" + "<li> Número de visitas: " + contador + "</li>\n" +
						// 5.
						"<p> " + primeraVez + "</p>" + "</ul>" + "<p><a href='" + request.getRequestURI()
						+ "'>Refrescar</a></p></br>");

		out.println("<p><a href='" + request.getRequestURI() + "?reiniciarSesion=true'>Borrar la sesión</a></p>");

		out.println("</body></html>");
		out.close();
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}