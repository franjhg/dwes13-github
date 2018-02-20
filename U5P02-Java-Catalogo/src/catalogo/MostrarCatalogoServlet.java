package catalogo;

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

/**
 * Servlet implementation class MostrarCatalogoServlet
 */
@WebServlet("/MostrarCatalogo")
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
		
		if (request.getParameter("op") != null && request.getParameter("op") != "") {
			paramOrdenAutor=request.getParameter("op");
			if(paramOrdenAutor=="1") {
				query2="ORDER BY obra.Titulo ASC";
			}
			if(paramOrdenAutor=="2") {
				query2="ORDER By obra.Titulo desc";
			}
			if(paramOrdenAutor=="3") {
				query2="ORDER By autor.Nombre asc";
			}
			if(paramOrdenAutor=="4") {
				query2="ORDER  By autor.Nombre desc";
			}
		}
		
		
		
		out.println("<html><head><meta charset='UTF-8'/>"
				+ "<link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>"
				+ "<link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css'>"
				+ "</head><body>");
		
		/*String usuario=request.getParameter("usuario");
		String contraseña=request.getParameter("contraseña");
		
		if((usuario==null||usuario=="")&&(contraseña==null||contraseña=="")) {
			out.println("Introduzca su nombre y contraseña de usuario<br>"
					+ "<form action='/U5P02-Java-Catalogo/MostrarCatalogo' method='post'>"
					+ "Usuario:<input type='text' name:'usuario'/><br>"
					+ "Contraseña:<input type='text' name:'contraseña/>'"
					+ "<input type='submit' name='enviar'><br><br>"
					+ "<form>");
			
		}
		
		// es necesario refrescar 
		response.sendRedirect(request.getRequestURI());*/
		
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
				  String consulta = "SELECT * from obra, autor where Autor=IdAutor "+query2+"";
				  ResultSet rset = sentencia.executeQuery(consulta);

				
				  if (!rset.isBeforeFirst() ) {    
					    out.println("<h3>No hay resultados</p>");
					}
						  
				  // Paso 5: Mostrar resultados
				  out.println("<table class='table table-bordered'>"
				  		+ "<tr><td>NOMBRE  <a href='./MostrarCatalogo?op=1'> &#9650 </a><a href='./MostrarCatalogo?op=2'>&#9660</a></td>"
				  		+ "<td>AUTOR  <a href='./MostrarCatalogo?op=3'> &#9650 </a><a href='./MostrarCatalogo?op=4'>&#9660</a></td>"
				  		+ "</tr>");
				  while (rset.next()) {
					  
		//CREAR OBJETOS			  
					  
					  String idDisco=rset.getString("obra.IdDisco");
					  String  autor=rset.getString("autor.Nombre");
					  String titulo=rset.getString("obra.Titulo");
					  String imagen=rset.getString("obra.imagen"); 
					  Disco d=new Disco( idDisco, autor, titulo, imagen);
					  
					  					  
		//----------------			  
				    out.println("<tr>"
				    		+ "<td>"+d.getTitulo()+"</td>"
				    		+ "<td>"+d.getAutor()+"</td>"
				    		+ "<td><a href='./MostrarDisco?id="+d.getIdDisco() +"'  > " + d.getTitulo() + "</a></td>"
				    		+ "</tr>");
				    		
				  }
				 // out.println("<a href='./MostrarCuidador?id='' '> Pepe</a>");
				  out.println("</table>");
				  
				  out.println("<form action='/U5P02-Java-Catalogo/MostrarDisco' method='post'>"
							+ "Buscar por Autor:<input type='text' name='autor'/><br>"
							+ "Buscar por Obra:<input type='text' name='obra'/><br>"
							+ "<input type='submit' name='enviar'><br><br>"
							+ "<form>");

				  // Paso 6: Desconexión
				  if (sentencia != null)
				    sentencia.close();
				  if (conn != null)
				    conn.close();
				} catch (Exception e) {
				  e.printStackTrace();
				}
				
			//-------------------
				
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
