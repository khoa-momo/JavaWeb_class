package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, true);
      out.write(" \n");
      out.write("        ");
      Myjava.Student student = null;
      synchronized (request) {
        student = (Myjava.Student) _jspx_page_context.getAttribute("student", PageContext.REQUEST_SCOPE);
        if (student == null){
          student = new Myjava.Student();
          _jspx_page_context.setAttribute("student", student, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("student"), "roll", "SE1", null, null, false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("student"), "name", "ABC", null, null, false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("student"), "phone", "0123", null, null, false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("student"), "email", "SE1@gm", null, null, false);
      out.write("\n");
      out.write("        \n");
      out.write("        <div style=\"height: 500px; background-color: greenyellow\">\n");
      out.write("            <h1>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((Myjava.Student)_jspx_page_context.findAttribute("student")).getRoll())));
      out.write("</h1>\n");
      out.write("            <h1>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((Myjava.Student)_jspx_page_context.findAttribute("student")).getName())));
      out.write("</h1>\n");
      out.write("            <h1>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((Myjava.Student)_jspx_page_context.findAttribute("student")).getPhone())));
      out.write("</h1>\n");
      out.write("            <h1>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((Myjava.Student)_jspx_page_context.findAttribute("student")).getEmail())));
      out.write("</h1>       \n");
      out.write("            <hr>\n");
      out.write("            \n");
      out.write("            ");
      Myjava.Student stud = null;
      synchronized (request) {
        stud = (Myjava.Student) _jspx_page_context.getAttribute("stud", PageContext.REQUEST_SCOPE);
        if (stud == null){
          try {
            stud = (Myjava.Student) java.beans.Beans.instantiate(this.getClass().getClassLoader(), "student");
          } catch (ClassNotFoundException exc) {
            throw new InstantiationException(exc.getMessage());
          } catch (Exception exc) {
            throw new ServletException("Cannot create bean of class " + "student", exc);
          }
          _jspx_page_context.setAttribute("stud", stud, PageContext.REQUEST_SCOPE);
          out.write("\n");
          out.write("                ");
          org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("stud"), request);
          out.write("\n");
          out.write("            ");
        }
      }
      out.write("\n");
      out.write("            \n");
      out.write("            <h1>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((Myjava.Student)_jspx_page_context.findAttribute("stud")).getRoll())));
      out.write("</h1>\n");
      out.write("            <h1>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((Myjava.Student)_jspx_page_context.findAttribute("stud")).getName())));
      out.write("</h1>\n");
      out.write("            <h1>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((Myjava.Student)_jspx_page_context.findAttribute("stud")).getPhone())));
      out.write("</h1>\n");
      out.write("            <h1>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((Myjava.Student)_jspx_page_context.findAttribute("stud")).getEmail())));
      out.write("</h1>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, true);
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
