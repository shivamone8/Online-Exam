package student;

import DB.DBCon;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginConf extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String email=request.getParameter("email");
            String password=request.getParameter("pswd");
            DBCon  db = new DBCon();
            db.pstmt = db.con.prepareStatement("select * from login where email=? and password=? and usertype=?");
            db.pstmt.setString(1,email);
            db.pstmt.setString(2,password);
            db.pstmt.setString(3, "Student");
            db.rst = db.pstmt.executeQuery();
            if(db.rst.next()){
                HttpSession session=request.getSession();
                session.setAttribute("user", email);
                response.sendRedirect("Student.html");
            }
             else{
                out.println("Incorrect User Name or Password");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }
}