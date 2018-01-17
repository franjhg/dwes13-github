package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrimerServlet
 */
//@WebServlet("/EjemploServletHttp")
public class EjemplosServletHttp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EjemplosServletHttp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='UTF-8'/><title>Primer Servlet</title></head>");
		out.println("<body><h1>3.3. Extensión de la clase HttpServlet</h1>");
		out.println("<h3>3.3. Extensión de la clase HttpServlet</h3>");
		out.println("<p>Ejecución de " + request.getContextPath() + "</p>");
		out.println("<a href='./index.html'>Volver</a>");
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
	
	public void init() {
	    log("Iniciando el servlet genérico");
	  }
	  public void destroy() {
	    log("Destruyendo el servlet genérico");
	  }

	  public String getServletInfo() {
	    return "Servlet de Ejemplo usando GenericServlet";
	  }
}
