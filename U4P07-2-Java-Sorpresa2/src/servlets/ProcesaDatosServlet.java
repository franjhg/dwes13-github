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
 * Servlet implementation class ProcesaDatosServlet
 */
@WebServlet("/ProcesaDatos")
public class ProcesaDatosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcesaDatosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		 ServletContext contexto = getServletContext();
		 
		 String nombre=request.getParameter("nombre");
		 	//out.println(nombre);
		 String numero=request.getParameter("numero");
		 String color=request.getParameter("color");
		 
		 if((nombre=="")||(numero=="")||(color=="")) {
			 response.sendRedirect(contexto.getContextPath()+"/index.html"); 
		 }else {
			 int n=Integer.parseInt(numero);
			int num= (int)(Math.random()*n+1);
			request.setAttribute("numero", num);
			request.setAttribute("nombre", nombre);
			request.setAttribute("color", color);
			RequestDispatcher rd = request.getRequestDispatcher("/MostrarResultado");
			rd.forward(request, response);
				//out.println(color);
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
