<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
      <h1 style="color: white; text-align: center;">UPDATION &nbsp;PAGE</h1>
      <%@include file="structure.html"%>
      <br>
      <form action="UpdateChecker" method="POST">
      <center>
			username - <input type="text" name="username"> 
			name - <input type="text" name="name"> 
			section - <input type="text" name="sec"> 
		    Address - <input type="text" name="address">
			Mobile - <input type="text" name="mobile"> 
			<input type="submit" value="update">
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