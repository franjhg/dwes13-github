

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_Hora
 */
@WebServlet("/Servlet_Hora")
public class Servlet_Hora extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_Hora() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Date date = new Date();
		DateFormat hora = new SimpleDateFormat("HH:mm:ss");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='UTF-8'/><title>Primer Servlet</title></head>");
		out.println("<body><h1>Segundo servlet</h1>");
		out.println("<h3>Me llamo FRAN</h3>");
		out.println("<p>Hora " + hora.format(date) + "</p>");
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

}
/*Date date = new Date();
//Caso 1: obtener la hora y salida por pantalla con formato:
DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
System.out.println("Hora: "+hourFormat.format(date));
//Caso 2: obtener la fecha y salida por pantalla con formato:
DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
System.out.println("Fecha: "+dateFormat.format(date));
//Caso 3: obtenerhora y fecha y salida por pantalla con formato:
DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
System.out.println("Hora y fecha: "+hourdateFormat.format(date));*/
