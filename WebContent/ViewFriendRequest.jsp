<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %>
     <%@ page import="com.java.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Requests</title>
</head>
<body>
<div style="text-align:right">
<a href="Profile">Go to Profile</a>
</div>
<div style="text-align:center">
	<table>
	<tr>
	<th colspan=2>Friend Requests</th>
	</tr>
	<tag:forEach var="friend" items="${friendRequest}">
		<tr>
			<td>${friend.getFirstName()}${friend.getLastName()}</td>
			<td><a href="AcceptRequest?email=${friend.getEmail()}">Accept Request</a></td>
		</tr>
	</tag:forEach>
	</table>
</div>

</body>
</html>