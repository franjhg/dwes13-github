package figuras;

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
 * Servlet implementation class CrearFiguraServlet
 */
@WebServlet("/CrearFigura")
public class CrearFiguraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearFiguraServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		 
		 boolean cuadrado=false;
		 boolean circunferencia=false;
		 boolean rectangulo=false;
		 boolean elipse=false;
		 String ladoX=request.getParameter("ladoX");
		 String ladoY=request.getParameter("ladoY");
		 String radioX=request.getParameter("radioX");
		 String radioY=request.getParameter("radioY");
		 String color=request.getParameter("color");
		 String borde=request.getParameter("radio");
		/* double lx = Double.parseDouble(ladoX);
		 double ly = Double.parseDouble(ladoY);
		 double rx = Double.parseDouble(radioX);
		 double ry = Double.parseDouble(radioY);
		*/
		//----------------VALIDACION
		 
		 if(((ladoX!="")||(ladoY!=""))&&((radioX!="")||(radioY!=""))) {
			 ServletContext contexto = getServletContext();//SendRedirect
			 
			 response.sendRedirect(contexto.getContextPath()+"/figuras.html");
		 }
		 if((ladoX=="")&&(ladoY=="")&&(radioX=="")&&(radioY=="")) {
			 ServletContext contexto = getServletContext();//SendRedirect
			 
			 response.sendRedirect(contexto.getContextPath()+"/figuras.html");
		 }
		 
		 
		 /*request.setAttribute("numero", num);
		 RequestDispatcher rd=request.getRequestDispatcher("/GenerarColores");
			rd.forward(request, response);*/
		 //----------------------
		
		 //5
		 if((ladoX!="")&&(ladoY=="")&&(radioX=="")&&(radioY=="")){
			 cuadrado=true;	
			 out.println("cuadrado");
			 ServletContext contexto = getServletContext();//SendRedirect
			 if(!esNumero(ladoX)) {
				 
				 response.sendRedirect(contexto.getContextPath()+"/figuras.html");
			 }
						 
			 double lx = Double.parseDouble(ladoX);
			 Cuadrado cuad=new Cuadrado(lx);
			 
			 request.setAttribute("figura", cuad);
			 request.setAttribute("color", color);
			 request.setAttribute("borde", borde);
			 RequestDispatcher rd=request.getRequestDispatcher("/MostrarFigura");
				rd.forward(request, response);
				
			
				
			/* out.println(color);
			 out.println(borde);*/
		
		 }
		 if((ladoX!="")&&(ladoY!="")&&(radioX=="")&&(radioY=="")){
			 rectangulo=true;
			 out.println("rectangulo");
			 ServletContext contexto = getServletContext();//SendRedirect
			 if((!esNumero(ladoX))||(!esNumero(ladoY))) {
				 
				 response.sendRedirect(contexto.getContextPath()+"/figuras.html");
			 }
			 
			 double lx = Double.parseDouble(ladoX);
			 double ly = Double.parseDouble(ladoY);
			 Rectangulo rect= new Rectangulo(lx, ly);
			 
			 request.setAttribute("figura", rect);
			 request.setAttribute("color", color);
			 request.setAttribute("borde", borde);
			 RequestDispatcher rd=request.getRequestDispatcher("/MostrarFigura");
				rd.forward(request, response);
			 
		 }
		 if((ladoX=="")&&(ladoY=="")&&(radioX!="")&&(radioY=="")){
			 circunferencia=true;	
			 out.println("circunferencia");
			
			 ServletContext contexto = getServletContext();//SendRedirect
			 if(!esNumero(radioX)) {
				 
				 response.sendRedirect(contexto.getContextPath()+"/figuras.html");
			 }
			 
			 double rx = Double.parseDouble(radioX);
			 Circunferencia circ=new Circunferencia(rx);
			 
			 request.setAttribute("figura", circ);
			 request.setAttribute("color", color);
			 request.setAttribute("borde", borde);
			 RequestDispatcher rd=request.getRequestDispatcher("/MostrarFigura");
				rd.forward(request, response);
		 }
		 if((ladoX=="")&&(ladoY=="")&&(radioX!="")&&(radioY!="")){
			 elipse=true;	
			 out.println("elipse");
			
			 ServletContext contexto = getServletContext();//SendRedirect
			 if((!esNumero(radioX))||(!esNumero(radioY))) {
				 
				 response.sendRedirect(contexto.getContextPath()+"/figuras.html");
			 }
			 
			 double rx = Double.parseDouble(radioX);
			 double ry = Double.parseDouble(radioY);
			 Elipse elip=new Elipse(rx, ry);
		 
			 request.setAttribute("figura", elip);
			 request.setAttribute("color", color);
			 request.setAttribute("borde", borde);
			 RequestDispatcher rd=request.getRequestDispatcher("/MostrarFigura");
				rd.forward(request, response);
		 }
		 
		 
		 
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	 public boolean esNumero(String cadena) {

	        boolean resultado;

	        try {
	            Integer.parseInt(cadena);
	            resultado = true;
	        } catch (NumberFormatException excepcion) {
	            resultado = false;
	        }

	        return resultado;
	    }

}
