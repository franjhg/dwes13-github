package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Usuario;

/**
 * Servlet implementation class CuentaServlet
 */
@WebServlet(name="/Cuenta")
public class CuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CuentaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext contexto = getServletContext();
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		
		String datosUsuario=usuario.toString();
		
		out.println("<html><head><meta charset='UTF-8'/>"
				+  "<link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>"
				+ "<link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css'>"
				+ "</head><body>"
				+ "<h1>Gestion de Usuario</h1>"
				+ ""+datosUsuario+""
				+ "<ul>"
				+ "<li><a href='"+contexto.getContextPath()+"/Logout'>Cerrar Sesion</a> </li>"
				+ "<li><a href='"+contexto.getContextPath()+"/Baja'>Baja de cuenta</a></li>"
				+ "<li><a href='"+contexto.getContextPath()+"/'>Volver</a></li> ");//a href=request.getHeader("Referer")para regresar exactamente a la URL en la que estaba el usuario
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
