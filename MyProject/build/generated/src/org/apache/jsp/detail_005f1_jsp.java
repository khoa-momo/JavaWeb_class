package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class detail_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("      <title>Bootstrap Example</title>\n");
      out.write("      <meta charset=\"utf-8\">\n");
      out.write("      <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("      <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n");
      out.write("      <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n");
      out.write("      <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h2>Carousel Example</h2>  \n");
      out.write("        <div id=\"myCarousel\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("          <!-- Indicators -->\n");
      out.write("          <ol class=\"carousel-indicators\">\n");
      out.write("            <li data-target=\"#myCarousel\" data-slide-to=\"0\" class=\"active\"></li>\n");
      out.write("            <li data-target=\"#myCarousel\" data-slide-to=\"1\"></li>\n");
      out.write("            <li data-target=\"#myCarousel\" data-slide-to=\"2\"></li>\n");
      out.write("          </ol>\n");
      out.write("\n");
      out.write("          <!-- Wrapper for slides -->\n");
      out.write("          <div class=\"carousel-inner\">\n");
      out.write("            <div class=\"item active\">\n");
      out.write("              <img src=\"la.jpg\" alt=\"Los Angeles\" style=\"width:100%;\">\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"item\">\n");
      out.write("              <img src=\"chicago.jpg\" alt=\"Chicago\" style=\"width:100%;\">\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"item\">\n");
      out.write("              <img src=\"ny.jpg\" alt=\"New york\" style=\"width:100%;\">\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("          <!-- Left and right controls -->\n");
      out.write("          <a class=\"left carousel-control\" href=\"#myCarousel\" data-slide=\"prev\">\n");
      out.write("            <span class=\"glyphicon glyphicon-chevron-left\"></span>\n");
      out.write("            <span class=\"sr-only\">Previous</span>\n");
      out.write("          </a>\n");
      out.write("          <a class=\"right carousel-control\" href=\"#myCarousel\" data-slide=\"next\">\n");
      out.write("            <span class=\"glyphicon glyphicon-chevron-right\"></span>\n");
      out.write("            <span class=\"sr-only\">Next</span>\n");
      out.write("          </a>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
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
