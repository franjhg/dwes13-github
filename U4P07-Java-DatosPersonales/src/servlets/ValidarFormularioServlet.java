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
		
	//text							--campo name--
		String nombre=request.getParameter("nombre");
		String apellidos=request.getParameter("apellidos");	
		String password=request.getParameter("password");
		String telefono=request.getParameter("telefono");
		String comentario=request.getParameter("comentarios");
		String[] valoresSexo=request.getParameterValues("sexo");//CHECKBOX Y DEMÁS
		String[] valorEstado=request.getParameterValues("estado");
		String[] aficiones=request.getParameterValues("Aficiones");
		
		
			//String patron="^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=]).{3,}$";
			String patron="[a-zA-Z0-9]{5,10}";
			String patronTelefono="[0-9]{9}";
			
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
		
				
			out.println("<html>"
					+ "<head>"
					+ "<meta charset='UTF-8'/>"
					+ "<title>Servlets y Formularios</title>"
					+"<style type='text/css'>"
					+ "table { border-collapse: collapse; margin: auto; }"
					+ "tr,td { border: 2px solid black;width: 250px; height: 35px; }"
					+ "</style>"
					+ "</head>");
			out.println("<body>"
					+ "<h1>Servlets y Formularios</h1>"
					+"<table><tr><td>DATOS PERSONALES</td></tr>");
					
	
		out.println("<tr><td>"+nombre+"</td></tr>");
		out.println("<tr><td>"+apellidos+"</td></tr>");
		
		if(password==null) {
			out.println("<tr><td>no hay</td></tr>");
		}
		
		if(password.matches(patron)) {
			out.println("<tr><td>Contraseña correcta</td></tr>");
			//out.println(password);
		}else {
			out.println("<tr><td>Contraseña incorrecta</td></tr>");
		}
		
		if(telefono.matches(patronTelefono)) {
			out.println("<tr><td>telefono --- "+telefono+"</td></tr>");
			
		}else {
			out.println("<tr><td>telefono incorrecto</td></tr>");
		}
		out.println("</table>");
		//SEXO
		out.println("<ul>");
			for(int i=0;i<valoresSexo.length;i++) {
				out.println("<li>Sexo: "+valoresSexo[i]+"</li>");
			}
			out.println("</ul>");
		//ESTADO
			out.println("</ul>");
			for(int i=0;i<valorEstado.length;i++) {
				out.println("<li>Estado: "+valorEstado[i]+"</li>");
			}
			out.println("</ul>");
		//AFICIONES
			out.println("<p>Aficiones</p>");
			out.println("<ul>");			
			for(int i=0;i<aficiones.length;i++) {
				out.println("<li>"+aficiones[i]+"</li>");
			}
			out.println("</ul>");
		
		out.println("<p>COMENTARIOS: "+comentario+"</p>");
		
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