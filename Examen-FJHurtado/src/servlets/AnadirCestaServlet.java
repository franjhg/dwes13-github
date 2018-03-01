package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Producto;

/**
 * Servlet implementation class AnadirCestaServlet
 */
@WebServlet(name="/AnadirCesta")
public class AnadirCestaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnadirCestaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext contexto = getServletContext();
		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		 
		 //session.setAttribute("arrProducto", arrProducto);*/
		
		request.getParameter("idProd");
		Producto [] producto = (Producto[]) session.getAttribute("arrProducto");
			
			Connection conn = null;
			Statement sentencia = null;
			try {
			  // Paso 1: Cargar el driver JDBC.
			  Class.forName("org.mariadb.jdbc.Driver").newInstance();

			  // Paso 2: Conectarse a la Base de Datos utilizando la clase Connection
			  String userName = "alumno";
			  String password = "alumno";
			  String url = "jdbc:mariadb://localhost/supermercado";
			  conn = DriverManager.getConnection(url, userName, password);

			  // Paso 3: Crear sentencias SQL, utilizando objetos de tipo Statement
			  sentencia = conn.createStatement();

			  // Paso 4: Ejecutar la sentencia SQL a través de los objetos Statement
			  String consulta = "SELECT DISTINCT familia FROM producto ";
			  String consulta2="SELECT * FROM producto WHERE idproducto='"+request.getParameter("idProd")+"'";
			  
			  ResultSet rset = sentencia.executeQuery(consulta);
					
			  if (!rset.isBeforeFirst() ) {    
				    out.println("<h3>No hay resultados</p>");
				}
			 	 
			  if (rset.next()) {
				  String idproducto=rset.getString("idproducto");
				  String nombre=rset.getString("nombre");
				  String marca=rset.getString("marca");
				  String precio=rset.getString("precio");
				  String stock=rset.getString("stock");
				  
				  Producto Objproducto=new Producto(idproducto,nombre, marca, precio, precio);
				  
				for(int i=0;i<producto.length;i++) {  
				 if(producto[i]==null) {
					producto[i]=Objproducto;
				 }
				 }
				  	}			 
					  	
					 
			  
			  
			  
	
		  // Paso 6: Desconexión
		  if (sentencia != null)
		    sentencia.close();
		  if (conn != null)
		    conn.close();
		} catch (Exception e) {
		  e.printStackTrace();
		}
			
		
			request.getHeader("Referer");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
