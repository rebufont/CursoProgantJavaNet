package com.getafe.curso;

import java.io.IOException;

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

@WebFilter(
		servletNames = {"ServletPedido", "frmProductos.jsp" }
		//urlPatterns = "/*"
)
public class FiltroAutenticacion implements Filter {

	private ServletContext context;

	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("FiltroAutenticacion :: doGet()");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession(false);

		if (session == null) { // checking whether the session exists
			this.context.log("Unauthorized access request");
			res.sendRedirect(req.getContextPath() + "/loginPage.html");
		} else {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}

	public void destroy() {
		// close any resources here
	}

}
