package authorizationFilter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;

/**
 * Servlet Filter implementation class AuthorizationFilter
 */
public class AuthorizationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthorizationFilter() {
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
		HttpServletRequest req = (HttpServletRequest)request;
		String name = req.getParameter("userName");
		String password = req.getParameter("userPassword");
		HttpSession session = req.getSession();
		Object sessName = session.getAttribute("name");
		Object sessPass = session.getAttribute("password");
		if (sessName!=null&&sessPass!=null) {
			req.getRequestDispatcher("AuthorizationServlet").forward(request, response);
		} else if((name.equals("user")&&password.equals("user"))||(name.equals("admin")&&password.equals("admin"))) {
			session.setAttribute("name", name);
			session.setAttribute("password", password);
		} else {
			req.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
