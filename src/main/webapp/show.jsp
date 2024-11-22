<%@page import="pojo.UserPOJO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="structure.html"%>
	<%
	ArrayList<UserPOJO> al = (ArrayList<UserPOJO>)request.getAttribute("USER");
    if(al!=null)
    {
	 %><br><br>
	<center>
	<table border="1">
		<thead>
			<th>User Name</th>
			<th>Name</th>
			<th>Section</th>
			<th>Address</th>
			<th>Mobile</th>
		</thead>
		<% 
		for (UserPOJO up : al) 
		{
		%>
		<tr>
			<td><%=up.getUsername()%></td>
			<td><%=up.getName()%></td>
			<td><%=up.getSection()%></td>
			<td><%=up.getAddress()%></td>
			<td><%=up.getMobile()%></td>
		</tr>
		<%
		}
		%>  
	   </center>
	</table>
	<%} %>
</body>
</html>