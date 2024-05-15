package student;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class StuLogout extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
          {
        response.setContentType("text/html;charset=UTF-8");
        try  {
            PrintWriter out = response.getWriter();
            HttpSession session=request.getSession();//Creating Session
            session.removeAttribute("user");
            String email=(String) request.getAttribute("email");
            if (email==null){
                response.sendRedirect("index.html");
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
