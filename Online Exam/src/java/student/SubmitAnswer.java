package student;
import DB.DBCon;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class SubmitAnswer extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
           {
        response.setContentType("text/html;charset=UTF-8");
        try  {
           PrintWriter out = response.getWriter();
           HttpSession session=request.getSession();
           String user=(String) session.getAttribute("user");
           DBCon db=new DBCon();
           out.println("Student Name:"+user);
        String qid[]=new String[10];
        String ans[]=new String[10];
        int i,obt=0;
        for(i=1; i<=4; i++){
            qid[i-1]=request.getParameter("qid"+ i);
            if(request.getParameter("ans"+i)!=null)
                ans[i-1]=request.getParameter("ans"+i);
            else
                ans[i-1]="Not Submitted";
            //Code to store Answer Sheet
            db.pstmt=db.con.prepareStatement("insert into result_trans(stu_id, ques_id, ans, date) values(?,?,?,?)");
            db.pstmt.setString(1,user);
            db.pstmt.setString(2, qid[i-1]);
            db.pstmt.setString(3,ans[i-1]);
            db.pstmt.setString(4, new java.util.Date().toString());
            db.pstmt.executeUpdate();
            db.pstmt=db.con.prepareStatement("select * from ques_mstr where qid=? and ans=?");
            db.pstmt.setString(1, qid[i-1]);
            db.pstmt.setString(2,ans[i-1]);
            db.rst=db.pstmt.executeQuery();
            if(db.rst.next()){
                obt=obt+10;
            }
            }
        
        db.pstmt=db.con.prepareStatement("insert into result_mstr (stu_id,exam_date,maximum,obtain) values(?,?,?,?)");
        db.pstmt.setString(1,user);
        db.pstmt.setString(2,new java.util.Date().toString());
        db.pstmt.setString(3,"100");
        db.pstmt.setString(4,""+obt);
        i=db.pstmt.executeUpdate();
        if(i>0){
            response.sendRedirect("StuResult");
        }
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
    }
}

   
