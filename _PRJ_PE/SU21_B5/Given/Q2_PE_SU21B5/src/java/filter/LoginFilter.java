/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
public class LoginFilter implements Filter {
    
        /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        //lay du lieu Session
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        String url = httpRequest.getRequestURI();
        
        if (url.contains("login")) {
            System.out.println("1)==================LoginFilter==================="); 
            System.out.println("&&&&&&& url: "+url);
            
            //----------------------------------------For logging only---------------------------------------
            if (session.getAttribute("Success") != null && session.getAttribute("Success").toString().equals("logged")) {
                //already logged
                System.out.println("(login)Filter get session value?: "+session.getAttribute("Success").toString()+"\n------>Login true");
            }
            //---------------------------------------------------------------------------------------------------------
            chain.doFilter(request, response); //to login servlet
        }else if (session.getAttribute("Success") != null && session.getAttribute("Success").toString().equals("logged")){
            System.out.println("$$Filter get session value?: "+session.getAttribute("Success").toString()+"\n------>Login true"); 
            chain.doFilter(request, response);
        }else{ 
            ((HttpServletResponse) response).sendRedirect("./login");
        } 
    }   

    
    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {        
    }

    /**
     * Init method for this filter
     * @param filterConfig
     */
    @Override
    public void init(FilterConfig filterConfig) {        
        
    }
    
}
