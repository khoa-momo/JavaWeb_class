package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  \t<title>Login</title>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\"> \n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap\" rel=\"stylesheet\"> \n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\"> \n");
      out.write("        <link href=\"css/login.css\" rel=\"stylesheet\" />\n");
      out.write("        \n");
      out.write("        <style> \n");
      out.write("            body { \n");
      out.write("                background-image:url('images/bg-1.jpg');\n");
      out.write("            ;}\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <section class=\"ftco-section\">\n");
      out.write("            <!-- ======= A.Section div ======= -->\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <!-- ======= 1.Login ======= -->\n");
      out.write("                <div class=\"row justify-content-center\">\n");
      out.write("                    <div class=\"col-md-6 text-center mb-5\">\n");
      out.write("                        <h2 class=\"heading-section\">Login</h2>\n");
      out.write("                    </div>\n");
      out.write("                </div> \n");
      out.write("                <!-- ======= 2.Sign in table ======= -->\n");
      out.write("                <div class=\"row justify-content-center\">\n");
      out.write("                    <div class=\"col-md-7 col-lg-5\">\n");
      out.write("                        <div class=\"wrap\">\n");
      out.write("                            <div class=\"img\" style=\"background-image: url(images/bg-1.jpg);\"></div><!-- Image -->\n");
      out.write("                            <div class=\"login-wrap p-4 p-md-5\">\n");
      out.write("                                <div class=\"d-flex\">\n");
      out.write("                                    <div class=\"w-100\"><h3 class=\"mb-4\">Sign In</h3></div>\n");
      out.write("                                    <!-- ======= Facebook - Twitter round icon ======= -->\n");
      out.write("                                    <div class=\"w-100\">\n");
      out.write("                                        <p class=\"social-media d-flex justify-content-end\">\n");
      out.write("                                            <a href=\"#\" class=\"social-icon d-flex align-items-center justify-content-center\"><span class=\"fa fa-facebook\"></span></a>\n");
      out.write("                                            <a href=\"#\" class=\"social-icon d-flex align-items-center justify-content-center\"><span class=\"fa fa-twitter\"></span></a>\n");
      out.write("                                        </p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div> \n");
      out.write("                                <!-- ======= Form ======= -->\n");
      out.write("                                <form action=\"#\" class=\"signin-form\">\n");
      out.write("                                    <div class=\"form-group mt-3\">\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" required name=\"username\">\n");
      out.write("                                        <label class=\"form-control-placeholder\" for=\"username\">Username</label>\n");
      out.write("                                    </div> \n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <input id=\"password-field\" type=\"password\" class=\"form-control\" required name=\"password\">\n");
      out.write("                                        <label class=\"form-control-placeholder\" for=\"password\">Password</label> \n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <button type=\"submit\" class=\"form-control btn btn-primary rounded submit px-3\">Sign In</button>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"form-group d-md-flex\">\n");
      out.write("                                        <!--Remember Me-->\n");
      out.write("                                        <div class=\"w-50 text-left\">\n");
      out.write("                                            <label class=\"checkbox-wrap checkbox-primary mb-0\">Remember Me\n");
      out.write("                                                <input type=\"checkbox\" checked>\n");
      out.write("                                                <span class=\"checkmark\"></span>\n");
      out.write("                                            </label>\n");
      out.write("                                        </div>\n");
      out.write("                                        <!--Forgot Password-->\n");
      out.write("                                        <div class=\"w-50 text-md-right\">\n");
      out.write("                                            <a href=\"#\">Forgot Password</a>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </form>\n");
      out.write("                                <p class=\"text-center\">Not a member? <a data-toggle=\"tab\" href=\"#signup\">Sign Up</a></p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div> \n");
      out.write("        </section>\n");
      out.write("        <!-- ======= script ======= -->\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\n");
      out.write("        <script src=\"js/main.js\"></script>\n");
      out.write("        <script src=\"js/popper.js\"></script>\n");
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
