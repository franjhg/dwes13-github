package servlets.cuenta;

import java.io.IOException;
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
 * Servlet implementation class BajaServlet
 */
@WebServlet(name="/Baja")
public class BajaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BajaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Usuario usuario=(Usuario) session.getAttribute("usuario");
		String username=usuario.getLogin();
		String pass=usuario.getPassword();
		String nombre=usuario.getNombre();
		boolean admin=usuario.isAdministrador();
		String descripcion=usuario.getDescripcion();
		System.out.println(username);
		ServletContext contexto=getServletContext();
		session.invalidate();
		
	  	//Conexion, consulta y muestra de datos
        Connection conn = null;
		Statement sentencia = null;
		try {
		  // Paso 1: Cargar el driver JDBC.
		  Class.forName("org.mariadb.jdbc.Driver").newInstance();

		  // Paso 2: Conectarse a la Base de Datos utilizando la clase Connection
		  String userName = "alumno_rw";
		  String password = "dwes";
		  String url = "jdbc:mariadb://localhost/catalogo13";
		  conn = DriverManager.getConnection(url, userName, password);

		  // Paso 3: Crear sentencias SQL, utilizando objetos de tipo Statement
		  sentencia = conn.createStatement();
		  
		  String consulta="SELECT * From usuario where '"+username+"'=login AND '"+pass+"'=password";
		  ResultSet rset = sentencia.executeQuery(consulta);
		  if(rset.next()) {
		  
		  // Paso 4: Ejecutar la sentencia SQL a través de los objetos Statement
		  String consultaAlta = "DELETE FROM usuario Where '"+username+"'=login";
		
		  ResultSet rset2 = sentencia.executeQuery(consultaAlta);	
		  }
        
		
		 if (sentencia != null)
			    sentencia.close();
			  if (conn != null)
			    conn.close();
			} catch (Exception e) {
			  e.printStackTrace();
			}
		
		
		response.sendRedirect(contexto.getContextPath()+"/Login");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
