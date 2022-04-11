package filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.AccountService;

/**
 *
 * @author Scott
 */
@WebFilter(filterName = "AdminFilter", servletNames = {"AdminServlet"})
public class AdminFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request; 
        HttpServletResponse httpResponse = (HttpServletResponse) response; 
        HttpSession session = httpRequest.getSession();
        AccountService service = new AccountService();
        
        String email = (String)session.getAttribute("email");
            if ( email == null) {
                httpResponse = (HttpServletResponse)response;
                httpResponse.sendRedirect("login");
                return;
            }
            else if (service.isAdmin(email)==false) {
                httpResponse = (HttpServletResponse)response;
                httpResponse.sendRedirect("notes");
                return;
            }
        
        chain.doFilter(request, response);
    }

  
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        

    }

}
