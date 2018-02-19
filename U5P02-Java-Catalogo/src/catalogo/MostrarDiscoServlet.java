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
 * Servlet implementation class MostrarDiscoServlet
 */
@WebServlet("/MostrarDisco")
public class MostrarDiscoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarDiscoServlet() {
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
		
		
		
		boolean errorIdDiscoFalta=false;
		
		
		if (request.getParameter("id") != null) {
		
		String paramIdDisco=request.getParameter("id");
		if(paramIdDisco==null || paramIdDisco=="") {
			errorIdDiscoFalta=true;
		}
		
		out.println("<html><head><meta charset='UTF-8'/>"
				+  "<link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>"
				+ "<link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css'>"
				+ "</head><body>");
		
		
		
	/*//Conexion, consulta y muestra de datos
		Connection conn = null;
		Statement sentencia = null;
		try {
		  // Paso 1: Cargar el driver JDBC.
		  Class.forName("org.mariadb.jdbc.Driver").newInstance();

		  //Paso 2: Conectarse a la Base de Datos utilizando la clase Connection
		  
		  String userName = "alumno";
		  String password = "alumno";
		  String url = "jdbc:mariadb://localhost/catalogo13";
		  conn = DriverManager.getConnection(url, userName, password);

		  // Paso 3: Crear sentencias SQL, utilizando objetos de tipo Statement
		  sentencia = conn.createStatement();*/

		  // Paso 4: Ejecutar la sentencia SQL a través de los objetos Statement
		
		    String consultaDisco = "SELECT * from obra, autor where obra.IdDisco="+paramIdDisco+" and Autor=IdAutor";
		    ResultSet rset = sentencia.executeQuery(consultaDisco);
		    if (!rset.isBeforeFirst() ) {    
		      out.println("<p>El disco no existe</p>");
		    }
		    while (rset.next()) {
		    	//CREAR OBJETOS			  
				  
				  String idDisco=rset.getString("obra.IdDisco");
				  String  autor=rset.getString("autor.Nombre");
				  String titulo=rset.getString("obra.Titulo");
				  String imagen=rset.getString("obra.imagen"); 
				  Disco d=new Disco( idDisco, autor, titulo, imagen);
				  
				  					  
	//----------------	
				 out.println("<table class='table table-bordered'");
				 out.println("<tr>"
				 		+ "<td>TITULO</td>"
				 		+ "<td>AUTOR</td>"
				 		+ "<td>PORTADA</td></tr>");
			    out.println("<tr>"
			    		+ "<td>"+d.getTitulo()+"</td>"
			    		+ "<td>"+d.getAutor()+"</td>"
			    		+  "<td><img src='./img/"+d.getImagen()+"'></td>"
			    		+ "</tr>");
		    }
		    out.println("</table>");
		  
		  

		/*  // Paso 6: Desconexión
		  if (sentencia != null)
		    sentencia.close();
		  if (conn != null)
		    conn.close();
		} catch (Exception e) {
		  e.printStackTrace();
		}*/
		
	//-------------------
		out.println("<br><br><a href='./MostrarCatalogo'>Volver</a> ");
		out.println("</body></html>");
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
