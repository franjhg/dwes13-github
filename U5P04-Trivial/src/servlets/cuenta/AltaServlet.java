package servlets.cuenta;

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
 * Servlet implementation class AltaServlet
 */
@WebServlet(name="/Altat")
public class AltaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensajeError="";
		ServletContext contexto = getServletContext();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;UTF-8");
		
		if (request.getMethod().equals("POST")) {
			// si venimos de enviar el formulario...
          // Procesar los campos del formulario de login y password
		String username=request.getParameter("username");
		String pass=request.getParameter("password");
        String nombre=request.getParameter("nombre");
        String descripcion=request.getParameter("descripcion");
        String admin=request.getParameter("admin");
        System.out.println(admin);
        System.out.println("admin"); 
		  // Comprobaciones que debes hacer:
          // a. Error: el campo login no puede estar vacío 
          // b. Error: el campo password no puede estar vacío
          // c. Error: no se encuentra el usuario en la base de datos
          // d. Error: la contraseña no es válida
          //if(loginname!=null && loginname!="" && loginpassword!=null && loginpassword!="") {
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

		  // Paso 4: Ejecutar la sentencia SQL a través de los objetos Statement
		  String consultaAlta = "INSERT INTO usuario (login, password, nombre, admin, descripcion) "
		  		+ "VALUES ('"	+username+"', '"+pass+"', '"+nombre+"' ,"
		  		+ " '"+admin+"', '"+descripcion+"')";
		 // System.out.println(query2);
		 // System.out.println(paramOrdenAutor);
		 // System.out.println(request.getParameter("op"));
		 // System.out.println("SELECT * from obra, autor where obra.Autor=autor.IdAutor "+query2+"");
		  ResultSet rset = sentencia.executeQuery(consultaAlta);	
        
        
		
		 if (sentencia != null)
			    sentencia.close();
			  if (conn != null)
			    conn.close();
			} catch (Exception e) {
			  e.printStackTrace();
			}
		}
		
		out.println("<html><head><meta charset='UTF-8'/>" + "<style> .error {color: red}</style>"
			+ "<title>Catálogo de Nombre Apellidos</title></head><body>");
				out.println("<h3>Alta de usuario</h3>");
				out.println("<form action='"+request.getRequestURI()+"' method='post'>"
			+ "<label>Usuario:</label><input type='text' name='username'><br/>\n"
			+ "<label>Contraseña:</label><input type='password' name='password'><br/>\n"
			+ "<label>Nombre:</label><input type='text' name='nombre'><br/>\n"
			+ "<label>Admin:</label> No <input type='radio' name='admin' value='0' checked/>\n"
			+ " Sí <input type='radio' name='admin' value='1'/><br/>\n"
			+ "<label>Descripción:</label><input type='textarea' name='descripcion'><br/>\n"
			+ "<input type='submit' value='Crear usuario' name='enviar'>\n"
			+ "</form>\n"
			+ "<p><a href='"+contexto.getContextPath()+"/Login'>¿Ya estás registrado? Haz clic en este enlace</a></p>\n"
			+ "<h3>"+mensajeError+"</h3>\n");
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
