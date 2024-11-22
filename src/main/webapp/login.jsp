<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="DARKCYAN">
<center>
        <%
            String msg = (String)request.getAttribute("msg");
            if(msg!=null)
            {
            	out.println("<h2>"+msg+"</h2>");
            }
            else
            {} 	
        %>
     <h1>Login Here</h1>
     
     <form action="LoginChecker" method="POST">
            USERNAME &nbsp;: <input type="text" name="uname" placeholder="Enter your username"><br><br>
            PASSWORD &nbsp;: <input type="password" name="password" placeholder="Enter your password"><br><br>
            <input type="submit" value="login">      
     </form>
</center>
</body>
</html>