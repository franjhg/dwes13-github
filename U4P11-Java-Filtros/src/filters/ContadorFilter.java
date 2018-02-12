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
import javax.servlet.http.HttpServlet;
import jdk.nashorn.internal.runtime.Context;

/**
 * Servlet Filter implementation class ContadorFilter
 */
@WebFilter(filterName="FiltroDeContador")
public class ContadorFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ContadorFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		PrintWriter out = response.getWriter();
		int cont=1;
		ServletContext context=request.getServletContext();
		
		System.out.println("Aplicando filtro contador");
		
		if(context.getAttribute("contador")!=null) {
			/*int*/ cont=Integer.parseInt(context.getAttribute("contador").toString());
			cont++;
			context.setAttribute("contador", cont);
		}else {
			/*int*/ cont=1;
			context.setAttribute("contador",cont);
		}
		//System.out.println("Contador");
		// pass the request along the filter chain
		chain.doFilter(request, response);
		out.println("Obtenido por ContadorFilter: "+cont+"<br>");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
