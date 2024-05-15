package Admin;
import DB.DBCon;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class AdminLoginConf extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            {
        response.setContentType("text/html;charset=UTF-8");
        try  {
            
            PrintWriter out = response.getWriter();
            String usertype= request.getParameter("user");
            String email=request.getParameter("email");
            
            String password=request.getParameter("pswd");
            DBCon db = new DBCon();
            db.pstmt=db.con.prepareStatement("select * from login where email=? and password=? and usertype=? ");
        db.pstmt.setString(1,email);
        db.pstmt.setString(2,password);
        db.pstmt.setString(3,usertype);
        db.rst= db.pstmt.executeQuery();
        if(db.rst.next()){
             HttpSession session=request.getSession();
           session.setAttribute("user",email);
            response.sendRedirect("AdminHome.html");
                    }
        else{
            out.println("Incorrect user Name or Password");
        }
                }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
