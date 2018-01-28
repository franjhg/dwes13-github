package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GenerarNumeroServlet
 */
@WebServlet("/Sorpresa")
public class ServletGeneraNumeros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGeneraNumeros() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int res=(int) (Math.random()*100+1);
		request.setAttribute("numero", res);
		
		//ServletContext contexto = getServletContext();//SendRedirect
		
		/*PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='UTF-8'/><title>Numero Aleatorio</title></head>");
		out.println("<body><h1>"+res+"</h1>");
		out.println("<a href='http://localhost:8080/U4P06-Java-Redireccion-y-reenvio/index.html'>Indice</a>");
		out.println("</body></html>");
		out.close();*/
		
		RequestDispatcher rd=request.getRequestDispatcher("MostrarNumero");
		rd.forward(request, response);
		
		//response.sendRedirect(contexto.getContextPath()+"/MostrarNumero");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

