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

/**
 * Servlet implementation class MostrarCuidadorServlet
 */
@WebServlet("/MostrarCuidador")
public class MostrarCuidadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarCuidadorServlet() {
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
		
		
		
		boolean errorIdCuidadorFalta=false;
		
		
		if (request.getParameter("id") != null) {
		
		String idcuidador=request.getParameter("id");
		if(idcuidador==null || idcuidador=="") {
			errorIdCuidadorFalta=true;
		}
		
		out.println("<html><head><meta charset='UTF-8'/></head><body>");
		
		
		
	//Conexion, consulta y muestra de datos
		Connection conn = null;
		Statement sentencia = null;
		try {
		  // Paso 1: Cargar el driver JDBC.
		  Class.forName("org.mariadb.jdbc.Driver").newInstance();

		  // Paso 2: Conectarse a la Base de Datos utilizando la clase Connection
		  
		  //String userName = "alumno";
		  String userName = contexto.getInitParameter("usr_bd");
		 // String password = "alumno";
		  String password =contexto.getInitParameter("psw_bd");
		  String url = contexto.getInitParameter("url");
		  //String url = "jdbc:mariadb://localhost/animales";
		  conn = DriverManager.getConnection(url, userName, password);

		  // Paso 3: Crear sentencias SQL, utilizando objetos de tipo Statement
		  sentencia = conn.createStatement();

		  // Paso 4: Ejecutar la sentencia SQL a través de los objetos Statement
		 /* String consulta = "SELECT * from cuidador WHERE idCuidador='"+idcuidador+"'";
		  ResultSet rset = sentencia.executeQuery(consulta);

		  
		// Paso 5: Mostrar resultados
		  
		  if (!rset.isBeforeFirst() ) {    
			    out.println("<h3>No hay resultados</p>");
			}
		  if(errorIdCuidadorFalta==true) {
				out.println("<h2>Falta Identificador</h2>");
			}
		  
		  rset.next();
		    out.println("<p>Animales cuidados por " + rset.getString("nombre")+ ":</p>");*/
		    // TO-DO: código para mostrar los animales
		//18. 
		    String consultaAnimales = "SELECT animal.* FROM animal, cuida WHERE (animal.chip = cuida.chipAnimal) AND (cuida.idCuidador = '"+idcuidador+"')";
		    ResultSet rset = sentencia.executeQuery(consultaAnimales);
		    if (!rset.isBeforeFirst() ) {    
		      out.println("<p>Este cuidador no cuida ningún animal</p>");
		    }
		    while (rset.next()) {
		      out.println("<li>" + rset.getString("nombre") + ", de la especie " + rset.getString("especie") + "</li>");
		    }
		    out.println("</ul>");
		  
		  /*while (rset.next()) {
		    out.println("<h3>" + rset.getString("Nombre") + "</h3><br>"
		    		+ "<p>" + rset.getString("idCuidador") + "</p>");
		    		
		  }*/
	

		  // Paso 6: Desconexión
		  if (sentencia != null)
		    sentencia.close();
		  if (conn != null)
		    conn.close();
		} catch (Exception e) {
		  e.printStackTrace();
		}
		
	//-------------------
		out.println("<a href='./MostrarCuidadores'>Volver</a> ");
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
