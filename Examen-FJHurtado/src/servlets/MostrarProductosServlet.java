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
 * Servlet implementation class MostrarProductosServlet
 */
@WebServlet(name="/MostrarProductos")
public class MostrarProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarProductosServlet() {
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
		String query1="SELECT DISTINCT familia FROM producto";
		String query2="";
		String paramFamilia="Bio";
		String paramOrden="";
		String BuscaProducto="";
		int stock=0;
		
		HttpSession session = request.getSession(false);
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		
		
		
		if (request.getMethod().equals("POST")) {
			query2="AND nombre LIKE '%"+request.getParameter("prod")+"%'";
		}
		
		
		if (request.getParameter("fam") != null && request.getParameter("fam") != "" ) {
			paramFamilia=request.getParameter("fam").toString();
			
		}
		
		if (request.getParameter("op") != null && request.getParameter("op") != "" ) {
			paramOrden=request.getParameter("op").toString();
			if(paramOrden.equals("1")) {
				//System.out.println(paramOrdenAutor);
				query2="ORDER BY nombre ASC";
			}
			if(paramOrden.equals("2")) {
				query2="ORDER By nombre desc";
			}
			if(paramOrden.equals("3")) {
				query2="ORDER By marca asc";
			}
			if(paramOrden.equals("4")) {
				query2="ORDER  By marca desc";
			}
		}
		
		
		
		out.println("<html><head><meta charset='UTF-8'/>"
				+ "<link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>"
				+ "<link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css'>"
				+ "</head><body><h3>Supermercado F. Javier Hurtado Galiano</h3>");
		out.println("<h4>Sesión iniciada como <a href='"+contexto.getContextPath()+"/Cuenta'>" 
				+ usuario.getNombre() + "</a></h4>");
		
		//Conexion, consulta y muestra de datos
		
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
		  String consulta2="SELECT * FROM producto WHERE familia='"+paramFamilia+"' "+query2+"";
		  
		  ResultSet rset = sentencia.executeQuery(consulta);
				
		  if (!rset.isBeforeFirst() ) {    
			    out.println("<h3>No hay resultados</p>");
			}
		  
		  // Paso 5: Mostrar resultados
		  out.println("<ul>");
		  
		
		  while (rset.next()) {
			  String familia=rset.getString("familia");
			 
			  
			  out.println("<li><a href='./MostrarProductos?fam="+familia+"'>"+familia+"</a></li>");
			    
		  	}			 
			  	
			  out.println("</ul>");  
			  
		//------Cuadro busqueda
			  
			  out.println("<form action='./MostrarProductos' method='post'>"
						+ "Buscar producto:<input type='text' name='prod'  placeholder='Nombre del producto'/><br>"
						+ "<input type='submit' name='enviar'><br><br>"
						+ "</form><br><br><br><br>");
			  
	//---------------------2ªconsulta
			  
			  ResultSet rset2 = sentencia.executeQuery(consulta2);
				
			  if (!rset2.isBeforeFirst() ) {    
				    out.println("<h3>No hay resultados</p>");
	
			  }
			 out.println("<h4>FAMILIA "+paramFamilia+"</h4><br><br>");
			  
				 out.println("<table class='table table-bordered table-hover'>"
				  		+ "<tr><td>NOMBRE  <a href='./MostrarProductos?op=1'> &#9650 </a><a href='./MostrarProductos?op=2'>&#9660</a></td>"
				  		+ "<td>MARCA  <a href='./MostrarProductos?op=3'> &#9650 </a><a href='./MostrarProductos?op=4'>&#9660</a></td>"
				  		+ "<td>IMAGEN  </td>"
				  		+ "<td>COMPRAR</td>");
				 out.println("</tr>");
				
				while (rset2.next()) {
					// stock=rset.getInt("stock");
					  
					  out.println("<tr>"
					    		+ "<td><a href='"+contexto.getContextPath()+"/MostrarDetalles?nombre="+rset2.getString("nombre")+"'>"+rset2.getString("nombre")+"</a></td>"
					    		+ "<td>"+rset2.getString("marca")+"</td>"
					    		+ "<td><img src='./img/productos/"+rset2.getString("imagen")+"'></td>");
					//  if(stock!=0) {
						  out.println("<td><a href='"+contexto.getContextPath()+"/AnadirCesta?idProd="+rset2.getString("idproducto")+"'><img src='./img/carrito1.png'></></td>");
					//  }
					  out.println("</tr>");  
				  	}			 
					  	
					  out.println("</table>");  
			  
			  
			  
	
		  // Paso 6: Desconexión
		  if (sentencia != null)
		    sentencia.close();
		  if (conn != null)
		    conn.close();
		} catch (Exception e) {
		  e.printStackTrace();
		}
		
		
		out.println("</body></html>");
	
	
	}//CIERRE DEL GET

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
