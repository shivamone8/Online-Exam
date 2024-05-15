package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DB.DBCon;

public final class StuProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Document</title>\n");
      out.write("    <style>\n");
      out.write("        /* CSS RESET  */\n");
      out.write("        body{\n");
      out.write("            margin: 0px;\n");
      out.write("            padding: 0px;\n");
      out.write("            background: url(Images/Student7.jpg);\n");
      out.write("            background-repeat:no-repeat ;\n");
      out.write("           background-size: 1550px 800px;\n");
      out.write("           \n");
      out.write("             \n");
      out.write("           \n");
      out.write("        }\n");
      out.write("        .navbar\n");
      out.write("        {\n");
      out.write("         display: inline-block;\n");
      out.write("         border: 3px solid white;\n");
      out.write("        margin-left: 2%;\n");
      out.write("         margin-top: 25px;\n");
      out.write("         border-radius: 5px;\n");
      out.write("         /* position: fixed; */\n");
      out.write("        }\n");
      out.write("        .navbar li{\n");
      out.write("            display: inline-block;\n");
      out.write("        }\n");
      out.write("        .navbar li a{\n");
      out.write("            color: white;\n");
      out.write("            font-size: 23px;\n");
      out.write("            padding:  60px;\n");
      out.write("            text-decoration: none; \n");
      out.write("        }\n");
      out.write("        .navbar li a:hover{\n");
      out.write("           \n");
      out.write("            color: grey;\n");
      out.write("            font-size: 23px;\n");
      out.write("            padding:  60px;\n");
      out.write("            text-decoration: none; \n");
      out.write("        }\n");
      out.write("\n");
      out.write("    \n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body><center>\n");
      out.write("    <header>\n");
      out.write("        <div class=\"navbar\">\n");
      out.write("        <ul>\n");
      out.write("        <li><a href=\"StuProfile.jsp \"> Profile</a> </li>\n");
      out.write("        <li><a href=\"StartExam\">Exam</a></li>\n");
      out.write("        <li><a href=\"StuResult\">Result</a></li>\n");
      out.write("        <li><a href=\"StuLogout\">Logout</a></li>\n");
      out.write("        </ul>\n");
      out.write("    </div><hr>\n");
      out.write("    </header>\n");
      out.write("    <div style=\"width:1300px; height:600px; background-colo:lightsteelblue; ovlerflow:scroll;\">\n");
      out.write("<table width=1000 cellspacing=0 cellpadding=10 bgcolor=lightgrey>\n");
      out.write("        ");
 
    
  String user=(String)session.getAttribute("user");
DBCon db=new DBCon();
 db.pstmt=db.con.prepareStatement("select * from stu_info where email=?");
 db.pstmt.setString(1, user);
 db.rst=db.pstmt.executeQuery();
 if(db.rst.next()){
 out.println("");
out.println("<tr><td> Email</td><td> "+db.rst.getString(1)+"</td></tr> ");
out.println("<tr><td>Student Name</td><td> "+db.rst.getString(2)+"</td></tr> ");
out.println("<tr><td> Qualification</td><td> "+db.rst.getString(3)+"</td></tr> ");
out.println("<tr><td> DOB</td><td> "+db.rst.getString(4)+"</td></tr> ");
out.println("<tr><td>Gender</td><td> "+db.rst.getString(5)+"</td></tr> ");
out.println("<tr><td>Address</td><td> "+db.rst.getString(6)+"</td></tr> ");
out.println("<tr><td>City</td><td> "+db.rst.getString(7)+"</td></tr> ");
out.println("<tr><td>State</td><td> "+db.rst.getString(8)+"</td></tr> ");
out.println("<tr><td>Pin</td><td> "+db.rst.getString(9)+"</td></tr> ");
out.println("<tr><td>Contact</td><td> "+db.rst.getString(10)+"</td></tr> ");
out.println("");
 }

      out.write("</table>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <a href=\"Student.html\"><u>Home Page</u></a>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("</center>\n");
      out.write("</body>\n");
      out.write("</html>");
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
