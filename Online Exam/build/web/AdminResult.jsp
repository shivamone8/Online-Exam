<%@page import="DB.DBCon"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://fonts.googleapis.com/css2?family=Baloo+Bhai+2:wght@800&family=Baloo+Bhaina+2:wght@800&display=swap" rel="stylesheet">
    <style>
        /* CSS RESET  */
        body{
            font-family: 'Baloo Bhai 2', cursive;
            margin: 0px;
            padding: 0px;
            background: url(Images/Student7.jpg);
            background-repeat:no-repeat ;
           background-size: 1550px 800px;  
           font-family: Baloo Bhai;  
           
        }
        .navbar
        {
         display: inline-block;
         border: 3px solid white;
        margin-left: 0%;
         margin-top: 25px;
         border-radius: 5px;
        }
        .navbar li{
            display: inline-block;
        }
        .navbar li a{
            color: white;
            font-size:23px;
            padding: 15px;
            text-decoration: none;
        }
        .navbar li a:hover{
           
           color: grey;
           font-size:23px;
           padding:15px;
           text-decoration: none; 
       }
     

    
    </style>
</head>
<body>
    <header>
        <div class="navbar">
        <ul>
        <li><a href="StudentList.jsp"> Student List</a> </li>
        <li><a href="AddQuestion.jsp">Add Question</a></li>
        <li><a href="QuestionList.jsp">Question List</a></li>
        <li> <a href="UpDelQues.jsp">Update/Delete Question</a></li>
        <li><a href="AdminResult.jsp">Result</a></li>
        <li><a href="AdminChangePassword.jsp">Change Password</a></li>
        <li><a href="AdminLogOut">Log Out</a></li>
        </ul>
    </div><hr>
    </header>
    
    <div style="width:1500px;height:600px;background-color: lightsteelblue;overflow: scroll; margin-left: 16px">
    
        <%
            DBCon db=new DBCon();
            db.pstmt=db.con.prepareStatement("SELECT stu_info.email,stu_info.sname, stu_info.sdob , stu_info.sgender , stu_info.squa , result_mstr.exam_date , result_mstr.maximum ,result_mstr.obtain FROM stu_info, result_mstr WHERE stu_info.email=result_mstr.stu_id");
            db.rst=db.pstmt.executeQuery();
            out.println("<table width=100% cellpadding10 cellspacing=4 border=2 bgcolor=lightgrey");
            out.println("<tr><th>E-Mail</th><th>Name</th><th>Date of Birth</th><th>gender</th><th>Qualification</th><th>Exam Date</th><th>Maximum</th><th>Obtain</th></tr>");
            while(db.rst.next()){
                
                out.println("<tr><td>"+db.rst.getString(1)+"</td><td>"+db.rst.getString(2)+"</td><td>"+db.rst.getString(3)+"</td><td>"+db.rst.getString(4)+"</td><td>"+db.rst.getString(5)+"</td><td>"+db.rst.getString(6)+"</td><td>"+db.rst.getString(7)+"</td><td>"+db.rst.getString(8)+"</td><tr>");
            }
                out.println("</table>");
            
            %>
</body>
</html>