package servlet;

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

import modelo.Disco;
import modelo.Usuario;

/**
 * Servlet implementation class MostrarCatalogoServlet
 */
@WebServlet(name="MostrarCatalogo")
public class MostrarCatalogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarCatalogoServlet() {
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
				
		
		String paramOrdenAutor="";
		String query2="";
		
		if (request.getParameter("op") != null && request.getParameter("op") != "" ) {
			paramOrdenAutor=request.getParameter("op").toString();
			if(paramOrdenAutor.equals("1")) {
				//System.out.println(paramOrdenAutor);
				query2="ORDER BY obra.Titulo ASC";
			}
			if(paramOrdenAutor.equals("2")) {
				query2="ORDER By obra.Titulo desc";
			}
			if(paramOrdenAutor.equals("3")) {
				query2="ORDER By autor.Nombre asc";
			}
			if(paramOrdenAutor.equals("4")) {
				query2="ORDER  By autor.Nombre desc";
			}
		}
		
		
		
		out.println("<html><head><meta charset='UTF-8'/>"
				+ "<link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>"
				+ "<link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css'>"
				+ "</head><body>");
		

		
		//Conexion, consulta y muestra de datos
		
				Connection conn = null;
				Statement sentencia = null;
				try {
				  // Paso 1: Cargar el driver JDBC.
				  Class.forName("org.mariadb.jdbc.Driver").newInstance();

				  // Paso 2: Conectarse a la Base de Datos utilizando la clase Connection
				  String userName = "alumno";
				  String password = "alumno";
				  String url = "jdbc:mariadb://localhost/catalogo13";
				  conn = DriverManager.getConnection(url, userName, password);

				  // Paso 3: Crear sentencias SQL, utilizando objetos de tipo Statement
				  sentencia = conn.createStatement();

				  // Paso 4: Ejecutar la sentencia SQL a través de los objetos Statement
				  String consulta = "SELECT * from obra, autor where obra.Autor=autor.IdAutor "+query2+"";
				 // System.out.println(query2);
				 // System.out.println(paramOrdenAutor);
				 // System.out.println(request.getParameter("op"));
				 // System.out.println("SELECT * from obra, autor where obra.Autor=autor.IdAutor "+query2+"");
				  ResultSet rset = sentencia.executeQuery(consulta);

				
				  if (!rset.isBeforeFirst() ) {    
					    out.println("<h3>No hay resultados</p>");
					}
						  
				  // Paso 5: Mostrar resultados
				  out.println("<table class='table table-bordered table-hover'>"
				  		+ "<tr><td>TITULO  <a href='./MostrarCatalogo?op=1'> &#9650 </a><a href='./MostrarCatalogo?op=2'>&#9660</a></td>"
				  		+ "<td>AUTOR  <a href='./MostrarCatalogo?op=3'> &#9650 </a><a href='./MostrarCatalogo?op=4'>&#9660</a></td>"
				  		+ "<td>DETALLES  (solo usuarios registrados)</td>"
				  		+ "</tr>");
				  while (rset.next()) {
					  
		//CREAR OBJETOS			  
					  
					  String idDisco=rset.getString("obra.IdDisco");
					  String  autor=rset.getString("autor.Nombre");
					  String titulo=rset.getString("obra.Titulo");
					  String imagen=rset.getString("obra.imagen"); 
					  Disco d=new Disco( idDisco, autor, titulo, imagen);
					  
					//  String idDisco, String  autor, String titulo, String imagen	  					  
		//----------------			  
				    out.println("<tr>"
				    		+ "<td>"+d.getTitulo()+"</td>"
				    		+ "<td>"+d.getAutor()+"</td>");
				    
				   // if((usuario.equals("admin"))&&(contraseña.equals("admin"))) {
			    		out.println( "<td><a href='./MostrarDisco?id="+d.getIdDisco() +"'  > " + d.getTitulo() + "</a></td>"
			    					+ "</tr>");
			    	//}
				  }
				 
				  	
				  out.println("</table>");
				  
				 out.println("<form action='/U5P02-Java-Catalogo/MostrarDisco' method='post'>"
							+ "Buscar por Autor:<input type='text' name='autor'  placeholder='Nombre del autor'/><br>"
							+ "Buscar por Obra:<input type='text' name='obra'  placeholder='Nombre del disco'/><br>"
							+ "<input type='submit' name='enviar'><br><br>"
							+ "</form><br><br><br><br>");
				/*  out.println("<form action='/U5P03-Java-Autenticacion/MostrarDisco' method='post'>"
							+ "<div class='form-group'><label> Buscar por Autor:</label><input type='text' name='autor'  placeholder='Nombre del autor'/></div><br>"
							+ "<div class='form-group'><label> Buscar por Obra:</label><input type='text' name='obra'  placeholder='Nombre del disco'/></div><br>"
							+ "<button type='submit' name='enviar' class='btn btn-primary'></button><br><br>"
							+ "</form><br><br><br><br>");*/

				  // Paso 6: Desconexión
				  if (sentencia != null)
				    sentencia.close();
				  if (conn != null)
				    conn.close();
				} catch (Exception e) {
				  e.printStackTrace();
				}
				
			//-------------------
				HttpSession session = request.getSession();
				Usuario usuario = (Usuario) session.getAttribute("usuario");
				out.println("<h4>Sesión iniciada como <a href='"+contexto.getContextPath()+"/Cuenta'>" 
					+ usuario.getNombre() + "</a></h4>");
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
