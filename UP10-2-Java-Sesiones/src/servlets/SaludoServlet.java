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
	
		String nombre="";	
		HttpSession session = request.getSession();
		
		if (request.getMethod().equals("POST")) { // si se ha enviado el formulario...
			nombre = request.getParameter("usuario");
			session.setAttribute(nombre,"usuario" );
		}
		if(session.isNew()) {
			session.setAttribute(nombre, "");
		}
		
		
		out.println("<html><head><meta charset='UTF-8'/>" + "<style> .error {color: red}</style>"
				+ "<title>Saludo_Java</title></head><body>");
		if(!session.isNew()) {
			out.println("<h2>Bienvenido "+nombre+"</h2>");
		}
		
		out.println("<form action='"+request.getRequestURI()+"' method='post'>"
				+ "<label>Introduce tu nombre :</label>" + "<input type='text' name='usuario'/>"
				+ "<input type='submit' name='enviar' value='Enviar'/></form>");
		
		out.println(nombre);
		
		
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

}
