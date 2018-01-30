package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidarFormularioServlet
 */
@WebServlet("/ValidarFormulario")
public class ValidarFormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidarFormularioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//text							--campo name--
		String nombre=request.getParameter("nombre");
		String apellidos=request.getParameter("apellidos");	
		String contraseña=request.getParameter("contraseña");
		
		
		
		
		
		PrintWriter out = response.getWriter();
		
		
		out.println("<html>"
				+ "<head>"
				+ "<meta charset='UTF-8'/>"
				+ "<title>Servlets y Formularios</title>"
				+ "</head>");
		out.println("<body>"
				+ "<h1>Servlets y Formularios</h1>");
	
	out.println("<p>"+validaContraseña(contraseña)+"</p>");
		
		
		
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
	public boolean validaContraseña(String contra) {
		boolean valido=true;
		
		
		return valido;
	}
}