package Admin;

import DB.DBCon;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddQuestion2 extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
             {
        response.setContentType("text/html;charset=UTF-8");
        try  {
            PrintWriter out = response.getWriter();
            String qid = request.getParameter("qid");
            String ques = request.getParameter("ques");
            String opt1 = request.getParameter("opt1");
            String opt2 = request.getParameter("opt2");
            String opt3 = request.getParameter("opt3");
            String opt4 = request.getParameter("opt4");
            String ans = request.getParameter("ans");
            DBCon db = new DBCon();
            db.pstmt = db.con.prepareStatement("insert into ques_mstr(qid,ques,opt1,opt2,opt3,opt4,ans) values(?,?,?,?,?,?,?)");
            db.pstmt.setString(1,qid);
            db.pstmt.setString(2,ques);
            db.pstmt.setString(3,opt1);
            db.pstmt.setString(4,opt2);
            db.pstmt.setString(5,opt3);
            db.pstmt.setString(6,opt4);
            db.pstmt.setString(7,ans);
            int i = db.pstmt.executeUpdate();
            if(i>0){
                response.sendRedirect("AddQuestion.jsp?msg=Question Added Succesfully");
            }
            else{
            out.println("Error in question Registration");
        }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}