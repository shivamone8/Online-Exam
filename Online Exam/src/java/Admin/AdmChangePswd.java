package Admin;
import DB.DBCon;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class AdmChangePswd extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            {
        response.setContentType("text/html;charset=UTF-8");
        try  {
            PrintWriter out = response.getWriter();
           HttpSession session=request.getSession();
           String user=session.getAttribute("user").toString();
           String opswd=request.getParameter("opswd");
           String npswd=request.getParameter("npswd");
           String cpswd=request.getParameter("cpswd");
           DBCon db=new DBCon();
           db.pstmt=db.con.prepareStatement("select * from login where email=? and password=?");
           db.pstmt.setString(1, user);
           db.pstmt.setString(2,opswd);
           db.rst=db.pstmt.executeQuery();
           if(db.rst.next()){
               if(npswd.equals(cpswd)){
                   db.pstmt=db.con.prepareStatement("Update login set password=? where email=?");
                   db.pstmt.setString(1,npswd);
                   db.pstmt.setString(2,user);
                   int i=db.pstmt.executeUpdate();
                   if(i>0){
                   out.println("Password Updated Successfully");
                   out.println("<a href=AdminHome.html>Back</a>");
               }
               }
               else{
                   out.println("new and Confirm password doesn't match ");
               }
           }
           else{
               out.println("Password is wrong");
           }
           
        }
        catch(Exception e){
            e.printStackTrace();
        }
            }
}

    



