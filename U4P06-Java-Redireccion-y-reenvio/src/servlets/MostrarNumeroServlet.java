package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostrarNumeroServlet
 */
@WebServlet("/MostrarNumero")
public class MostrarNumeroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarNumeroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		ServletContext contexto = getServletContext();
				
		int number, number1, number2, number3;
	

		if (request.getAttribute("numero") != null) {

			if (request.getAttribute("numero1") != null || request.getAttribute("numero2") != null
					|| request.getAttribute("numero3") != null) {

				number = (int) request.getAttribute("numero");
				number1 = (int) request.getAttribute("numero1");
				number2 = (int) request.getAttribute("numero2");
				number3 = (int) request.getAttribute("numero3");

				out.println("<h1 style='color:rgb("+number1+","+number2+","+number3+")'>" + number + "</h1>");
				out.println("<p><a href='./index.html'>Index</a></p>");
				out.close();
			} else {
				response.sendRedirect(contexto.getContextPath() + "/GenerarColores");
			}
		} else {
			response.sendRedirect(contexto.getContextPath() + "/Sorpresa");
		 
		
		
		
		out.println("<html><head><meta charset='UTF-8'/><title>Numero Aleatorio</title></head>");
		
		if(request.getAttribute("numero")!=null) {
			out.println("<body><h1>"+request.getAttribute("numero")+"</h1>");
			}else {
			//out.println("<body><h1>No se puede obtener el valor</h1>");
			//response.sendRedirect("index.html");
			response.sendRedirect(contexto.getContextPath()+"/Sorpresa");

			}
		
		out.println("<a href='http://localhost:8080/U4P06-Java-Redireccion-y-reenvio/index.html'>Indice</a>");
		out.println("</body></html>");
		out.close();
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
