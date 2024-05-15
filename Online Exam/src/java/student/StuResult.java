package student;
import DB.DBCon;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class StuResult extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
          {
        response.setContentType("text/html;charset=UTF-8");
        try  {
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StuResult</title>");            
            out.println("</head>");
            out.println("<body><center>");
            out.println("<h1>Student Marks Statements </h1>");
            HttpSession session=request.getSession();
           String email=""+ session.getAttribute("user");
            DBCon db=new DBCon();
            db.pstmt=db.con.prepareStatement("select stu_info.sname, stu_info.sdob, stu_info.sgender, stu_info.squa, result_mstr.`exam_date`, result_mstr.`maximum`, result_mstr.`obtain` from stu_info,result_mstr where stu_info.`email`=result_mstr.`stu_id` AND result_mstr.stu_id=? ");
            db.pstmt.setString(1,email);
            db.rst=db.pstmt.executeQuery();
            if(db.rst.next()){
                out.println("<table height= 1000 width=1000 cellspacing=0 cellpadding=10 bgcolor=lightgrey");
                out.println("<tr><td>Student ID</td><td>"+email+"</td></tr>");
                out.println("<tr><td>Student Name</td><td>"+db.rst.getString(1)+"</td></tr>");
                out.println("<tr><td>Date of Birth</td><td>"+db.rst.getString(2)+"</td></tr>");
                out.println("<tr><td>Gender</td><td>"+db.rst.getString(3)+"</td></tr>");
                out.println("<tr><td>Qualification</td><td>"+db.rst.getString(4)+"</td></tr>");
                out.println("<tr><td>Exam Date</td><td>"+db.rst.getString(5)+"</td></tr>");
                out.println("<tr><td>Maximum Marks</td><td>"+db.rst.getString(6)+"</td></tr>");
                out.println("<tr><td>Obtained Marks</td><td>"+db.rst.getString(7)+"</td></tr>");
                out.println("</table>");
            }
            
            out.println("</center></body>");
            out.println("</html>");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
