package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class SaludoCookiesServlet
 */
@WebServlet("/Saludo")
public class SaludoCookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaludoCookiesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext contexto = getServletContext();
		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();

		String errorUsuario = "";
		String usuario = "";
		
//PARA ELIMINAR COOKIES
		if (request.getParameter("eliminarCookie") != null) {
			Cookie cookieCaducada = new Cookie("usuario","");
			cookieCaducada.setMaxAge(0);
			response.addCookie(cookieCaducada);
			// es necesario refrescar para que se lea la cookie
			response.sendRedirect(request.getRequestURI());
		}
		//-----------------
		
// procesamiento del formulario
		if (request.getMethod().equals("POST")) { // si se ha enviado el formulario...
// validar nombre
			usuario = request.getParameter("usuario");//BUSQUEDA DE COOKIE(REQUEST)
			if (usuario == "") {
				errorUsuario = "Debes introducir un nombre";
			} else {
				Cookie nuevaCookieUsuario = new Cookie("usuario", usuario);
				nuevaCookieUsuario.setPath("/U4P09-Java-Cookies");			//CREACION COOKIE(RESPONSE)
				response.addCookie(nuevaCookieUsuario);
				response.sendRedirect(request.getRequestURI());//PARA NO REFRESCAR
			}
		}

// se empieza a generar la salida HTML
		out.println("<html><head><meta charset='UTF-8'/>"
					+ "<style> .error {color: red}</style>"
					+ "</head><body>");

		Cookie cookieUsuario = buscarCookie("usuario", request);
		if (cookieUsuario != null) {
			out.println("<h2>Bienvenid@, " + cookieUsuario.getValue() + "</h2>");
			out.println("<form action='"+request.getRequestURI()+"' method='post'>"
					+ "<label>Introduce tu nombre si quieres cambiar de usuario:</label>" + "<input type='text' name='usuario'/>"
					+ "<span class='error'>" + errorUsuario + "</span><br/>"
					+ "<input type='submit' name='enviar' value='Enviar'/></form>");
			
		} else {

			
			out.println("<form action='"+request.getRequestURI()+"' method='post'>"
					+ "<label>Introduce tu nombre para dirigirnos a ti:</label>" + "<input type='text' name='usuario'/>"
					+ "<span class='error'>" + errorUsuario + "</span><br/>"
					+ "<input type='submit' name='enviar' value='Enviar'/></form>");
		}
		out.println("<p><a href='" + request.getRequestURI() + "'>Refrescar</a></p>");
		out.println("<p><a href='" + request.getRequestURI() + "?eliminarCookie=true'>Eliminar cookie</a></p>");//ENLACE PARA ELIMINAR COOKIE
		out.println("</body></html>");
						
		out.close();
		 
		 
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private Cookie buscarCookie(String nombreCookie, HttpServletRequest request) {
		Cookie c= null;
		Map<String, Cookie> mapC = new HashMap<String, Cookie>();
		Cookie [] arrC= request.getCookies();
		if(arrC != null) {
		for(Cookie e : arrC) {
			mapC.put(e.getName(), e);
			
		}
		c= mapC.get(nombreCookie);
		}
		return c;
		
	}
	
}
