package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class page4jsp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action='page3' method='post'> \n");
      out.write("        \n");
      out.write("        <div id=\"current-time\"></div>\n");
      out.write("        <script>\n");
      out.write("            var curDate = new Date(); \n");
      out.write("            var curDay = curDate.getDate(); \n");
      out.write("            var curMonth = curDate.getMonth() + 1; \n");
      out.write("            var curYear = curDate.getFullYear(); \n");
      out.write("            var curHour = curDate.getHours();\n");
      out.write("            var curMinute = curDate.getMinutes(); \n");
      out.write("            document.getElementById('current-time').innerHTML = curDay + \"/\" + curMonth + \"/\" + curYear +\" \"+curHour+\":\"+curMinute;\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        Choose time:\n");
      out.write("        <select name=\"time\">\n");
      out.write("            <option value=\"1\">Minute</option>\n");
      out.write("            <option value=\"2\">Hour</option>\n");
      out.write("            <option value=\"3\">Day</option>\n");
      out.write("            <option value=\"4\">Month</option>\n");
      out.write("            <option value=\"5\">Year</option>\n");
      out.write("        </select>\n");
      out.write("        <input type='submit' value='Submit'>\n");
      out.write("        \n");
      out.write("        </form>\n");
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
