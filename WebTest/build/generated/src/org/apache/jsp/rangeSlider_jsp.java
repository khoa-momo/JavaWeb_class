package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class rangeSlider_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://demos.jquerymobile.com/1.4.2/css/themes/default/jquery.mobile-1.4.2.min.css\">  \n");
      out.write("        <script src=\"https://demos.jquerymobile.com/1.4.2/js/jquery.js\"></script> \n");
      out.write("\t<script src=\"https://demos.jquerymobile.com/1.4.2/js/jquery.mobile-1.4.2.min.js\"></script>\n");
      out.write("        <style>\n");
      out.write("            form  {\n");
      out.write("                margin: 60px 0 0 0 !important;\n");
      out.write("             }\n");
      out.write("\n");
      out.write("            .ui-slider .ui-btn-inner {\n");
      out.write("                padding: 4px 0 0 0 !important;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .ui-slider-popup {\n");
      out.write("                position: absolute !important;\n");
      out.write("                width: 64px;\n");
      out.write("                height: 64px;\n");
      out.write("                text-align: center;\n");
      out.write("                font-size: 36px;\n");
      out.write("                padding-top: 14px;\n");
      out.write("                z-index: 100;\n");
      out.write("                opacity: 0.8;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"rangeSlider\" method=\"Post\">\n");
      out.write("            <div data-role=\"rangeslider\">\n");
      out.write("                <label for=\"range-1a\">Rangeslider:</label>\n");
      out.write("                <input type=\"range\" name=\"range_1a\" id=\"range-1a\" min=\"0\" max=\"100\" value=\"40\" data-popup-enabled=\"true\" data-show-value=\"true\">\n");
      out.write("                <label for=\"range-1b\">Rangeslider:</label>\n");
      out.write("                <input type=\"range\" name=\"range_1b\" id=\"range-1b\" min=\"0\" max=\"100\" value=\"80\" data-popup-enabled=\"true\" data-show-value=\"true\">\n");
      out.write("                <input type=\"submit\" value=\"Save\" />\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\">  \n");
      out.write("            $('input').popup(); \n");
      out.write("        </script>\n");
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
