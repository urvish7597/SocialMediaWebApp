<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %>
     <%@ page import="com.java.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript">
    function makeEditable(editbtn){


    	editbtn.parentElement.parentElement.querySelector(".form-control").disabled = false;
        
    }
</script>
</head>
<body>
	<div>
		<div class="userInfo" style="text-align:center">${loggedUser.getFirstName()} ${loggedUser.getLastName()}<br>${loggedUser.getEmail()}</div>
		<div style="text-align:center">
			<form action="DoPost" method="post">
				<textarea rows="5" cols="10" name="Posttext"></textarea>
				<input type="submit" value="submit">
			</form>
		</div>
		<div style="width: 100%; display: table;">
    		<div style="display: table-row">
        		<div class="friends" style="width: 300px; display: table-cell;"> 
        			<tag:forEach var="friend" items="${loggedUser.getFriends()}">
        			
        				<div style="border:1px solid black">
     						<a><label for="name">${friend.getFirstName()} ${friend.getLastName()}</label></a>
        					<a href="#">message</a>
        					<a href="#">unfriend</a>
        				</div>
         		    
         		    </tag:forEach>
        		</div>
        		<div class="grid-container" style="width:80%;border:1px solid black; display: table-cell;">
  					<tag:forEach var="post" items="${loggedUser.getPosts()}">
  							<div style="width:30%;float:left;margin-right:2px ;height:240px ;border-width:2px ;border-style:solid">
								<div>
									<label for="name">${post.getUser_id()} <br></label>
									<label for="date" style="margin-left:50px">${post.getDate()} <br></label>
								</div>
							<br>
						<form style="display:inline-block" action="Save" method="post"> 
							<div>
								 <textarea name="text" class="form-control" rows="8" id="comment" disabled=true >${post.getText()} </textarea>
							</div>
							<br>
							<button name="save" value="${post.getPost_id()}">Save</button>
						</form>
		
							<div>
								<label style= "display:inline-block;margin-right:10px"><a href="url" >Like</a></label>
								<button style= "display:inline-block" onclick="makeEditable(this)">Edit</button>
					
								<form style= "display:inline-block" action="Delete" method="post">
									<button name="delete" value="${post.getPost_id()}">Delete</button>
								</form>
							</div>
						</div>
        		    </tag:forEach>
        		</div>
    		</div>
		</div>
	</div>
</body>
</html>