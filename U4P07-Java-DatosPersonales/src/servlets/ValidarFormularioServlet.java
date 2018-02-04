package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

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
		 response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>"
				+ "<head>"
				+ "<meta charset='UTF-8'/>"
				+ "<title>Servlets y Formularios</title>"
				+"<style type='text/css'>"
				+ "p{color:red;border:2px solid black;}"
				+ "</style>"
				+ "</head>");
		out.println("<body>"
				+ "<h1>Servlets y Formularios</h1>");
	//text							--campo name--
		String nombre=request.getParameter("nombre");
		String apellidos=request.getParameter("apellidos");	
		String password=request.getParameter("password");
		String telefono=request.getParameter("telefono");
			String patron="^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=]).{3,}$";
			String patronTelefono="[0-9]*";
			
			SimpleDateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
			try {
			Date fecha=formatoFecha.parse(request.getParameter("fnacimiento"));
			Date fechaActual=new Date();
			
				long milisegFecha=fecha.getTime();
				long milisegFechaActual=fechaActual.getTime();
				if(milisegFecha>milisegFechaActual) {
					out.println("Fecha no válida");
				}else {
					out.println(fecha);
				}
			}catch(ParseException e) {
				e.printStackTrace();
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
				
		
	
		out.println("<p>"+nombre+"</p>");
		out.println("<p>"+apellidos+"</p>");
		
		if(password==null) {
			out.println("<p>no hay</p>");
		}
		
		if(password.matches(patron)) {
			out.println("<p>Contraseña correcta</p>");
			//out.println(password);
		}else {
			out.println("<p>Contraseña incorrecta</p>");
		}
		
		if(telefono.matches(patronTelefono)) {
			out.println("<p>telefono correcto --- "+telefono+"</p>");
			
		}else {
			out.println("<p>telefono incorrecto</p>");
		}
		
		
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