<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %>
     <%@ page import="com.java.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="text-align:center">
<a href="Profile">Go to Profile</a>
</div>
			   <div class="grid-container" style="width:100%;border:1px solid black;">
  					<tag:forEach var="post" items="${posts}">
  							<div style="width:350px;float:left;margin-right:2px ;height:240px ;border-width:2px ;border-style:solid">
								<div>
									<label for="name">${post.getUser_id()} <br></label>
									<label for="date" style="margin-left:50px">${post.getDate()} <br></label>
								</div>
							<br>
							<div>
								 <textarea name="text" class="form-control" rows="8" id="comment" disabled=true >${post.getText()} </textarea>
							</div>
		
						</div>
        		    </tag:forEach>
        		</div>

</body>
</html>