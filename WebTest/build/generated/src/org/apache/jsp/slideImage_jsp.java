package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class slideImage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Detail</title>\n");
      out.write("        <link href=\"/MyProject/css/styles.css\" rel=\"stylesheet\" />\n");
      out.write("        <style>\n");
      out.write("* {box-sizing: border-box}\n");
      out.write("body {font-family: Verdana, sans-serif; margin:0}\n");
      out.write(".mySlides {display: none}\n");
      out.write("img {vertical-align: middle;}\n");
      out.write("\n");
      out.write("/* Slideshow container */\n");
      out.write(".slideshow-container {\n");
      out.write("  max-width: 1000px;\n");
      out.write("  position: relative;\n");
      out.write("  margin: auto;\n");
      out.write("}\n");
      out.write("\n");
      out.write("/* Next & previous buttons */\n");
      out.write(".prev, .next {\n");
      out.write("  cursor: pointer;\n");
      out.write("  position: absolute;\n");
      out.write("  top: 50%;\n");
      out.write("  width: auto;\n");
      out.write("  padding: 16px;\n");
      out.write("  margin-top: -22px;\n");
      out.write("  color: white;\n");
      out.write("  font-weight: bold;\n");
      out.write("  font-size: 18px;\n");
      out.write("  transition: 0.6s ease;\n");
      out.write("  border-radius: 0 3px 3px 0;\n");
      out.write("  user-select: none;\n");
      out.write("}\n");
      out.write("\n");
      out.write("/* Position the \"next button\" to the right */\n");
      out.write(".next {\n");
      out.write("  right: 0;\n");
      out.write("  border-radius: 3px 0 0 3px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("/* On hover, add a black background color with a little bit see-through */\n");
      out.write(".prev:hover, .next:hover {\n");
      out.write("  background-color: rgba(0,0,0,0.8);\n");
      out.write("}\n");
      out.write("\n");
      out.write("/* Caption text */\n");
      out.write(".text {\n");
      out.write("  color: #f2f2f2;\n");
      out.write("  font-size: 15px;\n");
      out.write("  padding: 8px 12px;\n");
      out.write("  position: absolute;\n");
      out.write("  bottom: 8px;\n");
      out.write("  width: 100%;\n");
      out.write("  text-align: center;\n");
      out.write("}\n");
      out.write("\n");
      out.write("/* Number text (1/3 etc) */\n");
      out.write(".numbertext {\n");
      out.write("  color: #f2f2f2;\n");
      out.write("  font-size: 12px;\n");
      out.write("  padding: 8px 12px;\n");
      out.write("  position: absolute;\n");
      out.write("  top: 0;\n");
      out.write("}\n");
      out.write("\n");
      out.write("/* The dots/bullets/indicators */\n");
      out.write(".dot {\n");
      out.write("  cursor: pointer;\n");
      out.write("  height: 15px;\n");
      out.write("  width: 15px;\n");
      out.write("  margin: 0 2px;\n");
      out.write("  background-color: #bbb;\n");
      out.write("  border-radius: 50%;\n");
      out.write("  display: inline-block;\n");
      out.write("  transition: background-color 0.6s ease;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".active, .dot:hover {\n");
      out.write("  background-color: #717171;\n");
      out.write("}\n");
      out.write("\n");
      out.write("/* Fading animation */\n");
      out.write(".fade {\n");
      out.write("  -webkit-animation-name: fade;\n");
      out.write("  -webkit-animation-duration: 1.5s;\n");
      out.write("  animation-name: fade;\n");
      out.write("  animation-duration: 1.5s;\n");
      out.write("}\n");
      out.write("\n");
      out.write("@-webkit-keyframes fade {\n");
      out.write("  from {opacity: .4} \n");
      out.write("  to {opacity: 1}\n");
      out.write("}\n");
      out.write("\n");
      out.write("@keyframes fade {\n");
      out.write("  from {opacity: .4} \n");
      out.write("  to {opacity: 1}\n");
      out.write("}\n");
      out.write("\n");
      out.write("/* On smaller screens, decrease text size */\n");
      out.write("@media only screen and (max-width: 300px) {\n");
      out.write("  .prev, .next,.text {font-size: 11px}\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         \n");
      out.write("        <div class=\"slideshow-container\">\n");
      out.write("\n");
      out.write("        <div class=\"mySlides fade\">\n");
      out.write("          <div class=\"numbertext\">1 / 3</div>\n");
      out.write("          <img src=\"img_nature_wide.jpg\" style=\"width:100%\">\n");
      out.write("          <div class=\"text\">Caption Text</div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"mySlides fade\">\n");
      out.write("          <div class=\"numbertext\">2 / 3</div>\n");
      out.write("          <img src=\"img_snow_wide.jpg\" style=\"width:100%\">\n");
      out.write("          <div class=\"text\">Caption Two</div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"mySlides fade\">\n");
      out.write("          <div class=\"numbertext\">3 / 3</div>\n");
      out.write("          <img src=\"img_mountains_wide.jpg\" style=\"width:100%\">\n");
      out.write("          <div class=\"text\">Caption Three</div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <a class=\"prev\" onclick=\"plusSlides(-1)\">&#10094;</a>\n");
      out.write("        <a class=\"next\" onclick=\"plusSlides(1)\">&#10095;</a>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("\n");
      out.write("        <div style=\"text-align:center\">\n");
      out.write("          <span class=\"dot\" onclick=\"currentSlide(1)\"></span> \n");
      out.write("          <span class=\"dot\" onclick=\"currentSlide(2)\"></span> \n");
      out.write("          <span class=\"dot\" onclick=\"currentSlide(3)\"></span> \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("        var slideIndex = 1;\n");
      out.write("        showSlides(slideIndex);\n");
      out.write("\n");
      out.write("        function plusSlides(n) {\n");
      out.write("          showSlides(slideIndex += n);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function currentSlide(n) {\n");
      out.write("          showSlides(slideIndex = n);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function showSlides(n) {\n");
      out.write("          var i;\n");
      out.write("          var slides = document.getElementsByClassName(\"mySlides\");\n");
      out.write("          var dots = document.getElementsByClassName(\"dot\");\n");
      out.write("          if (n > slides.length) {slideIndex = 1}    \n");
      out.write("          if (n < 1) {slideIndex = slides.length}\n");
      out.write("          for (i = 0; i < slides.length; i++) {\n");
      out.write("              slides[i].style.display = \"none\";  \n");
      out.write("          }\n");
      out.write("          for (i = 0; i < dots.length; i++) {\n");
      out.write("              dots[i].className = dots[i].className.replace(\" active\", \"\");\n");
      out.write("          }\n");
      out.write("          slides[slideIndex-1].style.display = \"block\";  \n");
      out.write("          dots[slideIndex-1].className += \" active\";\n");
      out.write("        }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        </body> \n");
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
