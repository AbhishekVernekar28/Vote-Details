<%@page import="dto.UserDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	List<UserDto> list2 = (List<UserDto>) request.getAttribute("list");
	%>

	<table border="1">

		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password Id</th>
			<th>Mobile</th>
			<th>Date Of Birth</th>
			<th>Gender</th>
			<th>Status</th>
			<th>Change</th>
		</tr>

		<%
		for (UserDto account : list2) {
		%>
		<tr>
			<th><%=account.getId()%></th>
			<th><%=account.getName()%></th>
			<th><%=account.getEmail()%></th>
			<th><%=account.getPassword()%></th>
			<th><%=account.getMobile()%></th>
			<th><%=account.getDob()%></th>
			<th><%=account.getGender()%></th>
			<th><%=account.isStatus()%></th>
			<th><form method="post" action="approve">
					<input type="hidden" name="username" value="<%=account.getId()%>">
					<button type="submit">Change</button>
				</form></th>
		</tr>
		<%
		}
		%>
	</table>
	<br>
	<br>
	<a href="Home.html"><button>Logout</button></a>
</body>
</html>