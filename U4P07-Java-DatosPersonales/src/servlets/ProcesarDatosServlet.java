package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * Servlet implementation class ProcesarDatosServlet
 */
@WebServlet("/ProcesarDatos")
public class ProcesarDatosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcesarDatosServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		//NOMBRES DE TODOS LOS CAMPOS
		out.println("<html>"
				+ "<head>"
				+ "<meta charset='UTF-8'/>"
				+ "<title>Servlets y Formularios</title>"
				+ "</head>");
		out.println("<body>"
				+ "<h1>Servlets y Formularios</h1>");
		
		out.println("<h3>NOMBRES DE TODOS LOS CAMPOS</h3>");
		out.println("<ul>");//LOS NOMBRES DE TODOS LOS CAMPOS
		Enumeration<String> parametros=request.getParameterNames();
		while(parametros.hasMoreElements()) {
			
			out.println("<li>"+parametros.nextElement()+"</li>");
		}
		out.println("</ul>");
		
		//PAREJAS CAMPO-VALORES
		out.println("<h3>PAREJAS CAMPO-VALORES</h3>");
		Map<String,String[]>paresPeticion=request.getParameterMap();
		paresPeticion.forEach((parametro,valores)->
		{
			out.println("<p>"+parametro+": ");
			for(String v:valores) {
				out.print("- "+v);
			}
		});
		out.println("");
		
		//FORMATO DE FECHA
		out.println("<h3>FORMATO DE FECHA</h3>");
		SimpleDateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
		try {
		Date fecha=formatoFecha.parse(request.getParameter("fnacimiento"));
			SimpleDateFormat formatoFechaSalida=new SimpleDateFormat("dd/MM/yyyy");
			out.println("Fecha: "+ formatoFechaSalida.format(fecha));
		}catch(ParseException e) {
			e.printStackTrace();
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		/*//text							--campo name--
		String nombre=request.getParameter("nombre");
		String apellidos=request.getParameter("apellidos");
		
		//date
		String fnacimiento=request.getParameter("fnacimiento");
		SimpleDateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
		try {
		Date fnacimiento=formatoFecha.parse(request.getParameter("fnacimiento"));
			SimpleDateFormat formatoFechaSalida=new SimpleDateFormat("dd/MM/yyyy");
		}
		
		out.println(nombre);
		out.println(apellidos);
		out.println(fnacimiento);*/
		
		
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
