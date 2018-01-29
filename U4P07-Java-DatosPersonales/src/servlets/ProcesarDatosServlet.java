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
		
		out.println("<ul");//PAGINA 4
		
		
		//text							--campo name--
		String nombre=request.getParameter("nombre");
		String apellidos=request.getParameter("apellidos");
		
		//date
		String fnacimiento=request.getParameter("fnacimiento");
		/*SimpleDateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
		try {
		Date fnacimiento=formatoFecha.parse(request.getParameter("fnacimiento"));
			SimpleDateFormat formatoFechaSalida=new SimpleDateFormat("dd/MM/yyyy");
		}*/
		
		out.println(nombre);
		out.println(apellidos);
		out.println(fnacimiento);
		
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
