/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generic_sample;

import java.io.IOException; 
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse; 

/**
 *
 * @author DELL
 */
public class MyServlet extends GenericServlet {

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("application/vnd.ms-excel;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
            out.println("MSSV\tTen SV\tPhone\tAddress");
            out.println("S1\tA\t123\tHN");
            out.println("S2\tD\t143\tHN");
            out.println("S3\tC\t185\tHN");
            out.println("S4\tD\t156\tHN");
//            out.println("<html>");
//            
//            out.println("<head>");
//            out.println("<title>Generic Servlet</title>");            
//            out.println("</head>");
//            
//            out.println("<body>"); 
//            out.println("<h1>Generic Servlet Basic</h1>");     
//            out.println("</body>");
//            
//            out.println("</html>");     
//            out.close();
    }

    @Override
    public void destroy() {
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    

}
