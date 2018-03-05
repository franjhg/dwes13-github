
package filters;

import java.io.IOException;
import java.io.PrintWriter;

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

import modelo.Usuario;

/**
 * Servlet Filter implementation class TestFilter
 */
@WebFilter("/TestFilter")
public class TestFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TestFilter() {
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
		HttpServletRequest request = (HttpServletRequest) req; // L1
		HttpServletResponse response = (HttpServletResponse) res;
		ServletContext contexto = request.getServletContext();
		HttpSession session = request.getSession(false);
		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		
		int contnull=0;
		
		
		if(session!=null) {
			Usuario usu=(Usuario) session.getAttribute("usuario");
			Boolean[]respuestas=(Boolean[]) session.getAttribute("respuestas");
			System.out.println("arr0="+respuestas[0]);
			System.out.println("arr1="+respuestas[1]);
			System.out.println("arr2="+respuestas[2]);
		
		
		
		 out.println("<h3>ResultadosServlet</h3><br>");
		 	for (int i=0;i<respuestas.length;i++) {	
		 		
		 		if((respuestas[i]!=true && respuestas[i]!=false)) {
		 			contnull++;
		 			response.sendRedirect(contexto.getContextPath()+"/Test'+[i]+'");
		 		}
			}
		 	if(contnull==0) {
		 		response.sendRedirect(contexto.getContextPath()+"/Resultados");
		 	}
		 	
		 	
		 
		}
		
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
