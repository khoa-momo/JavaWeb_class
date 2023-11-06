package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class send_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <style> \n");
      out.write("            body { \n");
      out.write("                background-image:url('image/events-bg.jpg');\n");
      out.write("            ;}\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>SendRedirected-jsp!</h1>\n");
      out.write("        <div class=\"img\" style=\"background-image: url(https://media.istockphoto.com/photos/blurred-bangkok-city-night-background-picture-id1289383957);\"></div>\n");
      out.write("        \n");
      out.write("        <p style=\"background-image: url('login-form-15/images/bg-1.jpg');\"></p>\n");
      out.write("        \n");
      out.write("        <img src = \"image/00s2pygcq0k81.jpg\" alt=\"cat\" style=\"width:auto;\">\n");
      out.write("        \n");
      out.write("        <br/>\n");
      out.write("        <br/>\n");
      out.write("        <img src=\"https://media.istockphoto.com/photos/blurred-bangkok-city-night-background-picture-id1289383957\" alt=\"caewts\" style=\"width:auto;\">\n");
      out.write("    \n");
      out.write("        <br/>\n");
      out.write("        <br/>\n");
      out.write("        <img src=\"image/luz2.jpg\" alt=\"aaz\" style=\"width:auto;\">\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <br/>\n");
      out.write("        <br/>\n");
      out.write("        <img src=\"image\\simpson.jpg\" alt=\"caewts\" style=\"width:auto;\">\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <p style=\"background-image: url('image/events-bg.jpg');\"></p>\n");
      out.write("        body { \n");
      out.write("            background-image:url('image/events-bg.jpg');\n");
      out.write("        ;}\n");
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
