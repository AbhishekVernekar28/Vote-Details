<%@page import="dto.Booth_dto"%>
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
<% List<Booth_dto> list1=(List<Booth_dto>)request.getAttribute("list"); %>

<table border="1">

<tr>
<th>Polling_Booth_Number</th>
<th>Polling_Booth_Name</th>
<th>Parent_Constituency </th>
<th>_2014_Winner</th>
<th>_2014_RunnerUp Id</th>
<th>_2014_Margin_per</th>
<th>_2014_Margin</th>
<th>_2014_Total_votes</th>
<th>_2014_BJP_votes</th>
<th>_2014_BIP_per</th>
<th>_2014_INC_Votes</th>
<th>_2014_INC_per</th>
<th>_2019_Winner</th>
<th>_2019_Margin_per</th>
<th>_2019_Margin</th>
<th>_2019_Total_votes</th>
<th>_2019_BJP_votes</th>
<th>_2019_BIP_per</th>
<th>_2019_INC_Votes</th>
<th>_2019_INC_per</th>
</tr>

<%for(Booth_dto booth:list1){ %>
<tr>
<th><%=booth.getPolling_Booth_Number() %></th>
<th><%=booth.getPolling_Booth_Name() %></th>
<th><%=booth.getParent_Constituency() %></th>
<th><%=booth.get_2014_Winner() %></th>
<th><%=booth.get_2014_RunnerUp() %></th>
<th><%=booth.get_2014_Margin_per() %></th>
<th><%=booth.get_2014_Margin() %></th>
<th><%=booth.get_2014_Total_votes() %></th>
<th><%=booth.get_2014_BJP_votes() %></th>
<th><%=booth.get_2014_BIP_per() %></th>
<th><%=booth.get_2014_INC_Votes() %></th>
<th><%=booth.get_2014_INC_per() %></th>
<th><%=booth.get_2019_Winner() %></th>
<th><%=booth.get_2019_Margin_per() %></th>
<th><%=booth.get_2019_Margin() %></th>
<th><%=booth.get_2019_Total_votes() %></th>
<th><%=booth.get_2019_BJP_votes() %></th>
<th><%=booth.get_2019_BIP_per() %></th>
<th><%=booth.get_2019_INC_Votes() %></th>
<th><%=booth.get_2019_INC_per() %></th>

</tr>
<%} %>
</table>
<br><br>
<a href="Home.html"><button>Logout</button></a>
<a href="AddData.html"><button>Add Data</button></a>
</body>
</html>