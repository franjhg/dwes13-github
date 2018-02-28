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
 * Servlet implementation class Test1Servlet
 */
@WebServlet(name="/Test1")
public class Test1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test1Servlet() {
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
			Boolean[]respuestas=(Boolean[]) session.getAttribute("respuestas");
			
			
			if (request.getMethod().equals("POST")) {
				// si venimos de enviar el formulario...
	          // Procesar los campos del formulario 
			
				String respuesta1=request.getParameter("pelicula");
			System.out.println(respuesta1); 	
			
			}
			
			out.println("<html><head><meta charset='UTF-8'/>"
					+ "<link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>"
					+ "<link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css'>"
					+ "</head><body>");
			
			 out.println("<h3>¿Qué película es más antigua?</h3><br>"
					 	+ "<form action='" + request.getRequestURI() + "' method='post'>"
						+ "<input type='radio' name='pelicula' value='1'>CasaBlanca<br>"
						+ "<input type='radio' name='pelicula' value='0'>Robocop<br>"
						+ "<input type='radio' name='pelicula' value='0'>Trainspotting<br>"
						+ "<input type='submit' name='Contestar1'><br><br>"
						+ "</form><br><br><br><br>");

			 
			 

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
