<%@page import="DB.DBCon"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        /* CSS RESET  */
        body{
            margin: 0px;
            padding: 0px;
            background: url(Images/Student7.jpg);
            background-repeat:no-repeat ;
           background-size: 1550px 800px;
           
             
           
        }
        .navbar
        {
         display: inline-block;
         border: 3px solid white;
        margin-left: 2%;
         margin-top: 25px;
         border-radius: 5px;
         /* position: fixed; */
        }
        .navbar li{
            display: inline-block;
        }
        .navbar li a{
            color: white;
            font-size: 23px;
            padding:  60px;
            text-decoration: none; 
        }
        .navbar li a:hover{
           
            color: grey;
            font-size: 23px;
            padding:  60px;
            text-decoration: none; 
        }

    
    </style>
</head>
<body><center>
    <header>
        <div class="navbar">
        <ul>
        <li><a href="StuProfile.jsp "> Profile</a> </li>
        <li><a href="StartExam">Exam</a></li>
        <li><a href="StuResult">Result</a></li>
        <li><a href="StuLogout">Logout</a></li>
        </ul>
    </div><hr>
    </header>
    <div style="width:1300px; height:600px; background-colo:lightsteelblue; ovlerflow:scroll;">
<table width=1000 cellspacing=0 cellpadding=10 bgcolor=lightgrey>
        <% 
    
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
%></table>
    </div>
    
    <a href="Student.html"><u>Home Page</u></a>
    
    
    
</center>
</body>
</html>