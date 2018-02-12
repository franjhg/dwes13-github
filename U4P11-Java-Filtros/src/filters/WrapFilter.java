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

/**
 * Servlet Filter implementation class WrapFilter
 */
@WebFilter(filterName="FiltroWrap")
public class WrapFilter implements Filter {

    /**
     * Default constructor. 
     */
    public WrapFilter() {
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
		ServletContext context=request.getServletContext();
		response.setContentType("text/html;UTF-8");
		PrintWriter out=response.getWriter();
		System.out.println("Aplicando filtro Wrap");
		
		out.println("<html><head><meta charset='UTF-8'/></head>");
				if(context.getAttribute("contador")!=null) {
					int contador=Integer.parseInt((context.getAttribute("contador").toString()));
					out.println("<title>Nº Visitas:"+contador+"</title>");
					}
		out.println( "<body>");
		// pass the request along the filter chain
		chain.doFilter(request, response);
		/*if(context.getAttribute("contador")!=null) {
			int contador=Integer.parseInt((context.getAttribute("contador").toString()));
			out.println("Obtenido del contexto por WrapFilter: "+contador+"<br>");
			}*/
		//out.println("Obtenido del contexto por WrapFilter: "+context.getAttribute("contador")+"<br>");
		out.println("<p>FJHurtado</p>");
		out.println("</body></html>");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
