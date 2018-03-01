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

import modelo.Usuario;

/**
 * Servlet implementation class MostrarDetallesServlet
 */
@WebServlet(name="/MostrarDetalles")
public class MostrarDetallesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarDetallesServlet() {
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
		String paramNombreProducto="";
		HttpSession session = request.getSession(false);
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		if (request.getParameter("nombre") != null && request.getParameter("nombre") != "") {
			
			paramNombreProducto=request.getParameter("nombre");
		}
		
		out.println("<html><head><meta charset='UTF-8'/>"
				+ "<link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>"
				+ "<link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css'>"
				+ "</head><body><h3>Supermercado F. Javier Hurtado Galiano</h3>");
		out.println("<h4>Sesión iniciada como <a href='"+contexto.getContextPath()+"/Cuenta'>" 
				+ usuario.getNombre() + "</a></h4>");
		//-------------
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
		  String consulta = "SELECT * FROM producto, ubicacion WHERE producto.ubicacion=ubicacion.idubicacion AND producto.nombre='"+paramNombreProducto+"' ";
		 
		  
		  ResultSet rset = sentencia.executeQuery(consulta);
				
		  if (!rset.isBeforeFirst() ) {    
			    out.println("<h3>No hay resultados</p>");
			}
		  
		  
		  
		  

		 if (rset.next()) {
			  String nombre=rset.getString("nombre");
			  String marca=rset.getString("marca");
			  String precio=rset.getString("precio");
			  String stock=rset.getString("stock");
			  String descripcion=rset.getString("descripcion");
			  String familia=rset.getString("familia");
			  String imagen=rset.getString("imagen");
			  String pasillo=rset.getString("pasillo");
			  String modulo=rset.getString("modulo");
			  String altura=rset.getString("altura");
			  String hueco=rset.getString("hueco");
			  
			 out.println("<ul>"
					 +"<li>"+nombre+"</li>"
					+"<li>"+marca+"</li>"
					+"<li>"+precio+"</li>"
					+"<li>"+stock+"</li>"
					+"<li>"+descripcion+"</li>"
					+"<li>"+familia+"</li>"
					+"<li>"+pasillo+"</li>"
					+"<li>"+modulo+"</li>"
					+"<li>"+altura+"</li>"
					+"<li>"+hueco+"</li>"
					+"<li><img src='./img/productos/"+imagen+"'></li>"
					 +"</ul>"); 
			  
			 out.println("<br><br><a href='"+request.getHeader("Referer")+"'>Volver</a> ");
			    
		  	}			 
		  
		  
		  if (sentencia != null)
			    sentencia.close();
			  if (conn != null)
			    conn.close();
			} catch (Exception e) {
			  e.printStackTrace();
			}
		
		
		out.println("</body></html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
