package filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		System.out.println("entra al filtro");
		HttpServletRequest request = (HttpServletRequest) req; // L1
		HttpServletResponse response = (HttpServletResponse) res; // L1
		ServletContext contexto = request.getServletContext(); 
		String uri = request.getRequestURI();
		HttpSession session = request.getSession(false); // si no existe no la creamos // L2
		String errorSesion = ""; // L3
		// comprobamos posibles errores:
	  	// a. Aviso: intento de acceso sin sesión iniciada
		if(session !=null) {
			if(session.getAttribute("login")==null || session.getAttribute("login")=="") {
				errorSesion="La sesion esta iniciada pero no hay usuario";
			}else {
				String usu=(String) session.getAttribute("login");
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
    				  String consulta = "SELECT * from usuario where login='"+usu+"' ";
    				
    				  ResultSet rset = sentencia.executeQuery(consulta);
    				  
    				  if (!rset.isBeforeFirst() ) {    
    					  errorSesion="El usuario no existe en la base de datos";
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
		}else {
			errorSesion="No hay sesion";
		}
	  	// b. Aviso: existe sesión iniciada pero no contiene usuario
	  	// c. Aviso: existe sesión iniciada pero el usuario no existe en la base de datos
		// redirigir en caso de error, salvo en excepciones
		if( !errorSesion.isEmpty() && !(uri.endsWith("html") || uri.endsWith("Login") || uri.endsWith("Alta"))){  // L4
			contexto.log(errorSesion + " - " + uri);
			response.sendRedirect(contexto.getContextPath()+"/Login");
		}else{
			chain.doFilter(request, response);
			System.out.println("Sale del filtro");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
