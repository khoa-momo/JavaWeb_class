/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author DELL
 */
public class LoggingFilter implements Filter {
    
    private String LogFileName;
    
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
        //lay thong tin ve request hien tai
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String url = httpRequest.getRequestURI();
        String queryString = httpRequest.getQueryString();        
        String sessionId = httpRequest.getSession().getId();
        LocalDateTime now = LocalDateTime.now();
        
        //viet lai thong tin nay vao file logFileName
        File file = new File(LogFileName);
        try (FileWriter writer = new FileWriter(file, true)) //write them vao flie
        {
            writer.write(url+"|"+queryString+"|"+sessionId+"|"+now.toString()+"\n");
        }
        
        chain.doFilter(request, response);//chuyen qua mat xich tiep theo        
        
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
        LogFileName = filterConfig.getInitParameter("LogFileName");
    }
    
}
