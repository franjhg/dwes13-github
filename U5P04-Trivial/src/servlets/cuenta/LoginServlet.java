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
import javax.servlet.http.HttpSession;

import modelo.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name="/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// Declarar una variable de mensaje de error para mostrar después:
        String mensajeError = "";
        String loginname="";
        String loginpassword="";
        
		ServletContext contexto=getServletContext();
		
		HttpSession session = request.getSession(false); // L1
		// si ya había sesión con un valor de usuario válido
		if (session != null) {
			//if ((session.getAttribute("login") != null)) { // L2
				response.sendRedirect(contexto.getContextPath() + "/Bienvenida"); // L3
			//}
		}
		else { // no hay sesión iniciada
			if (request.getMethod().equals("POST")) {
				// si venimos de enviar el formulario...
              // Procesar los campos del formulario de login y password
              loginname=request.getParameter("username");
              loginpassword=request.getParameter("password");
			  // Comprobaciones que debes hacer:
              // a. Error: el campo login no puede estar vacío 
              // b. Error: el campo password no puede estar vacío
              // c. Error: no se encuentra el usuario en la base de datos
              // d. Error: la contraseña no es válida
              	if(loginname!=null && loginname!="" && loginpassword!=null && loginpassword!="") {
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
  				  String consulta = "SELECT * from usuario where login='"+loginname+"' and password='"+loginpassword+"' ";
  				
  				  ResultSet rset = sentencia.executeQuery(consulta);

  				
  				  	if (!rset.isBeforeFirst() ) {    
  					    out.println("<h3>Este usuario no está registrado</p>");
  				  	}else {
  	            	  
  	              
            	  
  				rset.next(); 
  		 // Si todo ha ido bien:
  	    // 1. Crear un objeto de la clase Usuario con los datos obtenidos de la BD	  
  					//CREAR OBJETOS			  
  								 
  								  String nlogin=rset.getString("login");
  								  String npassword=rset.getString("password");
  								  String nnombre=rset.getString("nombre");
  								  String ndescripcion=rset.getString("descripcion");
  								  boolean nadmin= rset.getBoolean("admin");
  								  Usuario usuario = new Usuario(nlogin, npassword, nnombre, ndescripcion, nadmin);
  								  
  								  Boolean[]respuestas=new Boolean[3];
  				  
  								  out.println("Objeto creado");
             
				// 2. Crear una nueva sesión y avisarlo en un mensaje de log:
              	session = request.getSession(); // en este caso sin "false" para que se cree
				contexto.log(" * Creando sesión en " + request.getRequestURI());
              	// 3. Añadir los atributos de sesión "arr de Respuestas" y "usuario"
				session.setAttribute("respuestas", respuestas);
				//session.setAttribute("password", loginpassword);
				session.setAttribute("usuario", usuario);
              	// 4. Redirigir al contenido
				response.sendRedirect(contexto.getContextPath()+"/Bienvenida");
  				  }
  				  
  				  // Paso 6: Desconexión
  				  if (sentencia != null)
  				    sentencia.close();
  				  if (conn != null)
  				    conn.close();
  				} catch (Exception e) {
  				  e.printStackTrace();
  				}
  				}
			}
			// salida : L4
			//PrintWriter out = response.getWriter();
			response.setContentType("text/html;UTF-8");
			out.println("<html><head><meta charset='UTF-8'/>" 
                        + "<style> .error {color: red}</style>"
                        + "<title>Catálogo de Nombre Apellidos</title></head><body>");
			out.println("<h3>Inicio de sesión</h3>");
			out.println("<form action='" + request.getRequestURI() + "' method='post'>"
					+ "<label>Usuario:</label><input type='text' name='username'><br/>"
					+ "<label>Contraseña:</label><input type='password' name='password'><br/>"
					+ "<input type='submit' value='Iniciar sesión' name='enviar'>" 
                    + "</form>" + "<p><a href='"
					+ contexto.getContextPath() + "/Alta'>¿Aún no estás registrado? Haz clic en este enlace</a></p>"
					+ "<h3>" + mensajeError + "</h3>");
			out.println("</body></html>");
              	
		
              
           }	   
       	//-------------------
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
