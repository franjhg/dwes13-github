package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostrarCuidadoresServlet
 */
@WebServlet("/MostrarCuidadores")
public class MostrarCuidadoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarCuidadoresServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='UTF-8'/></head><body>");
		
		//Conexion, consulta y muestra de datos
		
				Connection conn = null;
				Statement sentencia = null;
				try {
				  // Paso 1: Cargar el driver JDBC.
				  Class.forName("org.mariadb.jdbc.Driver").newInstance();

				  // Paso 2: Conectarse a la Base de Datos utilizando la clase Connection
				  String userName = "alumno";
				  String password = "alumno";
				  String url = "jdbc:mariadb://localhost/animales";
				  conn = DriverManager.getConnection(url, userName, password);

				  // Paso 3: Crear sentencias SQL, utilizando objetos de tipo Statement
				  sentencia = conn.createStatement();

				  // Paso 4: Ejecutar la sentencia SQL a través de los objetos Statement
				  String consulta = "SELECT * from cuidador";
				  ResultSet rset = sentencia.executeQuery(consulta);

				
				  if (!rset.isBeforeFirst() ) {    
					    out.println("<h3>No hay resultados</p>");
					}
						  
				  // Paso 5: Mostrar resultados
				  out.println("<table><tr><td>NOMBRE</td>"
				  		+ "</tr>");
				  while (rset.next()) {
				    out.println("<tr>"
				    		+ "<td><a href='./MostrarCuidador?id="+rset.getString("idCuidador") +"'  > " + rset.getString("Nombre") + "</a></td>"
				    		+ "</tr>");
				    		
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
