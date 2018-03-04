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
 * Servlet implementation class Test2Servlet
 */
@WebServlet(name="/Test2")
public class Test2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test2Servlet() {
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
				System.out.println("arr0="+respuestas[0]);
				System.out.println("arr1="+respuestas[1]);
				System.out.println("arr2="+respuestas[2]);
			
			if (request.getMethod().equals("POST")) {
				// si venimos de enviar el formulario...
	          // Procesar los campos del formulario 
			
				String respuesta1=request.getParameter("pelicula");
			System.out.println(respuesta1); 	
			if(respuesta1.equals("1")) {
				respuestas[1]=true;
			}
			if(respuesta1.equals("0")) {
				respuestas[1]=false;
			}
			if(respuesta1.equals("null")) {
				respuestas[1]=null;
			}
			
			session.setAttribute("respuestas", respuestas);
			response.sendRedirect(contexto.getContextPath()+"/Test3");
				
			}
			
			out.println("<html><head><meta charset='UTF-8'/>"
					+ "<link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>"
					+ "<link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css'>"
					+ "</head><body>");
			
			 out.println("<h3>¿Qué película es más moderna?</h3><br>"
					 	+ "<form action='" + request.getRequestURI() + "' method='post'>"
						+ "<input type='radio' name='pelicula' value='0'>CasaBlanca<br>"
						+ "<input type='radio' name='pelicula' value='0'>Robocop<br>"
						+ "<input type='radio' name='pelicula' value='1'>Trainspotting<br>"
						+ "<input type='submit' name='Contestar2'><br><br>"
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
