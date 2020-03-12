<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %>
     <%@ page import="com.java.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CSS/style.css">
<title>Insert title here</title>
<script>
function myFunction() {
    var input, filter, ul, li, a, i, txtValue;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    ul = document.getElementById("myUL");
    li = ul.getElementsByTagName("li");
    if(filter.length>0)
    	{
    	 ul.style.display="block";
    for (i = 0; i < li.length; i++) {
        txtValue = li[i].textContent || li[i].innerText;
           if ((txtValue.toUpperCase()).indexOf(filter) > -1) {
      		    li[i].style.display = "block";
      		  }
     	    else {
     		         li[i].style.display = "none";
      			  }
    		}
    	}
    else{
    	 ul.style.display="none";
    }
}
</script>
</head>
<body>
<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search friend names.." title="Type in a name">

<ul id="myUL">
	<tag:forEach var="friend" items="${friends}">			
     	<li style="display:none">${friend.getFirstName()} ${friend.getLastName()}<a href="ViewProfile?friendemail=${friend.getEmail()}">  View Profile</a></li>         		    
    </tag:forEach>
</ul>
<form action="Home" method="post">

<div class="header">
<% 
User currentUser = (User)session.getAttribute("user") ;
%>
<h1>Welcome <%=currentUser.getFirstName()+" "+currentUser.getLastName() %></h1>
</div>
<br>
    <div style="float:right">
    <a style= "margin-right:10px" href="Profile">Profile</a>
    <a href="Logout">Logout</a>
    </div>
    <br>
    <br>
    <br>
   	<div style="width:80%;border:1px solid black; ">
   	
   		<tag:forEach var="post" items="${posts}">
    
    <div  style="width:30%;float:left;margin-right:2px ;height:240px ;border-width:2px ;border-style:solid">
		<div>
			<label for="name">${post.getUser_id()} <br></label>
			<label for="date" style="margin-left:50px">${post.getDate()} <br></label>
		</div>
		<br>
		<div>
			 <textarea class="form-control" rows="8" id="comment">${post.getText()} </textarea>
		</div>
		<br>
		<div>
			<label style= "margin-right:50px"><a href="Like?post_id=${post.getPost_id()}&&page=Home" >Like</a> ${post.getLike()}</label>
			<label><a href="url">Save</a></label>
		</div>
	</div>
   
    
    </tag:forEach>
   	</div>
    
    
    
    
 </form>


</body>
</html>