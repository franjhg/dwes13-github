package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SaludoServlet
 */
@WebServlet("/Saludo")
public class SaludoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaludoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;UTF-8");
				
		HttpSession session = request.getSession();//Recuperamos o iniciamos sesion
		String mensaje="";
		String nombre="";
		
		if(request.getParameter("cerrarSesion")!=null) {
			//cerrar sesion
			session.invalidate();
		}else {
		
		
		
		if(session.isNew()) {
			session.setAttribute("vnombre","");//Creamos la variable se sesion

		}else {
			
			
		
			if(request.getMethod().equals("POST")) {
				nombre=request.getParameter("nombre");
				if(nombre==null||nombre=="") {
					mensaje="Debe introducir un nombre";
				}else {
					session.setAttribute("vnombre",request.getParameter("nombre"));//variable se sesion=parametro nombre que se ha enviado
					nombre=session.getAttribute("vnombre").toString();
				mensaje="Bienvenido "+nombre;
				}
			}
		
		}	
		}
		out.println("<html><head><meta charset='UTF-8'/> "
				//+ "<style> .error {color: red}</style>"
				+ "</head><body>");
				
			if((nombre!=null) && (nombre!="")) {
				out.println("<p>"+ mensaje + "</p>");
				out.println("<p><a href='" + request.getRequestURI() + "?cerrarSesion=true'>Cerrar Sesion</a></p>");//ENLACE PARA CERRAR SESION
				
				out.println("</body></html>");
			}else {
		
		out.println(mensaje);
		out.println("<form action='"+request.getRequestURI()+"' method='post'"
				+"<label>Introduce tu nombre:</label> <input type='text' name='nombre'/>"
				
				+"<input type='submit' name='enviar' value='Enviar'/></form>");	
		
		
		
			}
		out.println("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
