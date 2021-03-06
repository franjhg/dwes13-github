package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Usuario;

/**
 * Servlet implementation class BienvenidaServlet
 */
@WebServlet(name="/Bienvenida")
public class BienvenidaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BienvenidaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext contexto = getServletContext();
		HttpSession session = request.getSession(false);
		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		
		if(session!=null) {
		Usuario usu=(Usuario) session.getAttribute("usuario");
		//Boolean [] respuestas=(Boolean[]) session.getAttribute("respuestas");
		
		out.println("<html><head><meta charset='UTF-8'/>"
				+ "<link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>"
				+ "<link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css'>"
				+ "</head><body>");
		out.println("<h1>Bienvenido "+usu.getNombre()+"</h1>");
		out.println("Las reglas son sencillas. Contesta a las preguntas");
		
		out.println("<a href='./Test1'>Comenzar</a>");
		
		out.println("</body></html>");
		}else {
			
			response.sendRedirect(contexto.getContextPath()+"/Login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
