package figuras;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostrarFiguraServlet
 */
@WebServlet("/MostrarFigura")
public class MostrarFiguraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarFiguraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		 out.println("llega");
		 
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		 String vcolor="";
		 String vborde="";
		 
		Figuras f=(Figuras) request.getAttribute("figura");
		String color=(String) request.getAttribute("color");
		String borde=(String) request.getAttribute("borde");
		
		
		if(color==null) {
			 vcolor="Sin color";
		}else {
			vcolor=color;
		}
		if(borde==null) {
			 vborde="Sin borde";
		}else { vborde="Con borde";}
		
		out.println(f.toString()+"</br>");
		out.println(vcolor+"</br>");
		out.println(vborde+"</br>");
	
		out.println("<a href='./figuras.html'>Volver</a>");
	}
	
}
/*			request.setAttribute("cuadrado", cuad);
			 request.setAttribute("color", color);
			 request.setAttribute("borde", borde);
			 
			  request.setAttribute("rectangulo", rect);
			  request.setAttribute("circunferencia", circ);
			  request.setAttribute("elipse", elip);
*/