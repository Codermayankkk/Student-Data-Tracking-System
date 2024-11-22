<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <%
        int username = (int)session.getAttribute("username");
        if(username == 0)
        {
          response.sendRedirect("login.jsp");	
        }
        else
        {
           out.println("<h2>"+username+"</h2>");	
        }
     %>
	<h1 style="color: white; text-align: center;">REGISTRATION&nbsp;PAGE</h1>
	<%@include file="structure.html"%><br>
	<br>
	<form action="RegisterChecker" method="POST">
		<center>
			username - <input type="text" name="username"> 
			name - <input type="text" name="name"> 
			section - <input type="text" name="sec">
		    Address - <input type="text" name="address">
			Mobile - <input type="text" name="mobile">
			<input type="submit" value="post">
	</form>
	<%
//	String msg = (String) session.getAttribute("msg");
	String msg =(String)request.getAttribute("msg"); 
	if (msg == null) 
	{

	} else 
	{
		out.println("<h3>" + msg + "</h3>");
		session.invalidate();
	}
	%>
	</center>
</body>
</html>