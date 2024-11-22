<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
      <h1 style="color: white; text-align: center;">DELETION &nbsp;PAGE</h1>
      <%@include file="structure.html"%>
      <br>
      <form action="DeleteChecker" method="POST">
      <center>
			username - <input type="text" name="username">  
			<input type="submit" value="Delete">
	</form>
	<%
	   String msg = (String)session.getAttribute("msg");
	   if(msg == null)
	   {
		   
	   }
	   else
	   {
		  out.println("<h3>"+msg+"</h3>"); 
		  session.invalidate();
	   }
	%>
	</center>
</body>
</html>