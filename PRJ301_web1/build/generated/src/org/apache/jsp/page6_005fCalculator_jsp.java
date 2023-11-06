package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class page6_005fCalculator_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>page6_Calculator</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form method=\"Post\" action=\"page6_Calculator\"></form> \n");
      out.write("        <center><table>\n");
      out.write("                \n");
      out.write("            <tr>Calculator</tr> \n");
      out.write("            ");
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>First number</td>\n");
      out.write("                <td><input type=\"text\" name=\"first\" value=\"");
      out.print( request.getAttribute("first") );
      out.write("\"/></td>\n");
      out.write("            </tr> \n");
      out.write("<!--            <tr>\n");
      out.write("                <td colspan=\"4\"> <p style=\"color:red\"> ");
      out.print( request.getAttribute("first_error") 
                        != null ? request.getAttribute("first_error"): "" );
      out.write(" </p></td>\n");
      out.write("            </tr>-->\n");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>Second number</td>\n");
      out.write("                <td><input type=\"text\" name=\"second\" value=\"");
      out.print( request.getAttribute("second") );
      out.write("\"/></td>\n");
      out.write("            </tr>      \n");
      out.write("\n");
      out.write("<!--            <tr>\n");
      out.write("                <td colspan=\"4\"> <p style=\"color:red\"> ");
      out.print( request.getAttribute("second_error")  
                        != null ? request.getAttribute("second_error"): "" );
      out.write(" </p></td>\n");
      out.write("            </tr>-->\n");
      out.write("\n");
      out.write("            <tr> \n");
      out.write("                <td>+<input type=\"radio\" value=\"+\" name=\"operator\" checked=\n");
      out.write("                            \"");
      out.print( "+".equals(request.getAttribute("operator")) ? "checked" : "" );
      out.write(" \" /></td>\n");
      out.write("                &nbsp;\n");
      out.write("                <td>-<input type=\"radio\" value=\"-\" name=\"operator\" checked=\n");
      out.write("                            \"");
      out.print( "-".equals(request.getAttribute("operator")) ? "checked" : "" );
      out.write("\" /></td>\n");
      out.write("                &nbsp;\n");
      out.write("                <td>*<input type=\"radio\" value=\"*\" name=\"operator\" checked=\n");
      out.write("                            \"");
      out.print( "*".equals(request.getAttribute("operator")) ? "checked" : "" );
      out.write("\" /></td>\n");
      out.write("                &nbsp;\n");
      out.write("                <td>/<input type=\"radio\" value=\"/\" name=\"operator\" checked=\n");
      out.write("                            \"");
      out.print( "/".equals(request.getAttribute("operator")) ? "checked" : "" );
      out.write("\" /></td>\n");
      out.write("            </tr>   \n");
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td colspan=\"2\"><input type=\"submit\" value=\"Caculate\" /></td>\n");
      out.write("                <td colspan=\"2\"><input type=\"reser\" name=\"Clear\" /></td>\n");
      out.write("            </tr>  \n");
      out.write("            <tr>\n");
      out.write("                <td colspan=\"2\">Result</td>\n");
      out.write("                <td colspan=\"2\"><input type=\"text\" name=\"result\" value=\n");
      out.write("                                       \"");
      out.print( request.getAttribute("result"));
      out.write("\" />\n");
      out.write("                </td>\n");
      out.write("            </tr>         \n");
      out.write("                \n");
      out.write("        </table></center>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
