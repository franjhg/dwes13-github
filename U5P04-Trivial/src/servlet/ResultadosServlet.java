package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Usuario;

/**
 * Servlet implementation class ResultadosServlet
 */
@WebServlet(name="/Resultados")
public class ResultadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultadosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext contexto = getServletContext();
		HttpSession session = request.getSession(false);
		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		int conttrue=0;
		int contfalse=0;
		int contnull=0;
		
		
		if(session!=null) {
			Usuario usu=(Usuario) session.getAttribute("usuario");
			Boolean[]respuestas=(Boolean[]) session.getAttribute("respuestas");
			System.out.println("arr0="+respuestas[0]);
			System.out.println("arr1="+respuestas[1]);
			System.out.println("arr2="+respuestas[2]);
		
		out.println("<html><head><meta charset='UTF-8'/>"
				+ "<link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>"
				+ "<link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css'>"
				+ "</head><body>");
		
		 out.println("<h3>ResultadosServlet</h3><br>");
		 	for (int i=0;i<respuestas.length;i++) {	
		 		if(respuestas[i].equals(true)) {
		 			conttrue++;
		 		}
		 		if(respuestas[i].equals(false)) {
		 			contfalse++;
		 		}
		 		if(respuestas[i].equals(null)) {
		 			contnull++;
		 			response.sendRedirect(contexto.getContextPath()+"/Test'+[i]+'");
		 		}
			}
		 	
		 	out.println("<p>Aciertos: "+conttrue+"</p><br>"
		 			+"<p>Fallos: "+contfalse+"</p><br>"
		 			+"<p>Respuestas sin contestar: "+contnull+"</p><br><br><br>"
		 			+ "<a href='"+contexto.getContextPath()+"/Logout'>Comenzar de nuevo</a>");
		 
		 
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
