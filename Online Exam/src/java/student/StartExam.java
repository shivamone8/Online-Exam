package student;
import DB.DBCon;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class StartExam extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
           {
        response.setContentType("text/html;charset=UTF-8");
        try {
         PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StartExam</title>");            
            out.println("</head>");
            out.println("<body><center>");
            out.println("<h1>Question Paper </h1>");
            out.println("<form action=SubmitAnswer>");
            out.println("<table width=1200 border=1 cellspacing=0 cellpadding=10 bgcolor=lightgrey>");
            DBCon db= new DBCon();
            HttpSession session=request.getSession();
            String user= session.getAttribute("user").toString();
            db.pstmt=db.con.prepareStatement("select * from result_mstr where stu_id=?");
            db.pstmt.setString(1,user);
            db.rst=db.pstmt.executeQuery();
            if(db.rst.next()){
                out.println("You have already given the exam");
            }
            else{          
                      
            db.pstmt=db.con.prepareStatement("select * from ques_mstr");
            db.rst=db.pstmt.executeQuery();
            int count=1;
            while(db.rst.next()){
            out.println("<tr><td colspan=2><b><span style='color:red;'>Ques "+count+":</span>" + db.rst.getString(2)+"</b></td></tr>");
            out.println("<tr><td><input type=radio name=ans"+count+" value='"+db.rst.getString(3)+"'>"+db.rst.getString(3)+"</td><td><input type=radio name=ans"+count+" value='"+db.rst.getString(4)+"'>"+db.rst.getString(4)+"</td></tr>");
            out.println("<tr><td><input type=radio name=ans"+count+" value='"+db.rst.getString(5)+"'>"+db.rst.getString(5)+"</td><td><input type=radio name=ans"+count+" value='"+db.rst.getString(6)+"'>"+db.rst.getString(6)+"</td></tr>");
            out.println("<input type=hidden name=qid"+count+" value="+ db.rst.getString(1)+"> ");
                        count++;
            if(count>10)
            
            break;
            }
            
            out.println("<tr bgcolor=red><th colspan=2><input type=Submit value=Submit Answer</th></tr>");
            out.println("</table></form></center>");
            out.println("</body>");
            out.println("</html>");
        
            } 
    }
        catch(Exception e){
            e.printStackTrace();
        }

    
}
}
