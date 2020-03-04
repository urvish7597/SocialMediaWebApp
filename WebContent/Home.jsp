<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../CSS/style.css">
<title>Insert title here</title>
</head>
<body>
<form action="Home" method="post">

<div class="header">
<h1>WELCOME "USER"</h1>
</div>
<br>
    <div style="float:right">
    <a style= "margin-right:10px" href="url">Profile</a>
    <a href="url">Logout</a>
    </div>
    <br>
    <br>
    <br>
    
    
    <div style="width:210px; height:210px ;border-width:2px ;border-style:solid">
    	<div>
    		<label for="name">Name</label>
			<label for="date" style="margin-left:50px">Date</label>
		</div>
		<br>
    	<div>
   			 <textarea class="form-control" rows="8" id="comment"></textarea>
    	</div>
    	<br>
    	<div>
			<label style= "margin-right:50px"><a href="url" >Like</a></label>
			<label><a href="url">Save</a></label>
		</div>
    </div>
    
    
 </form>


</body>
</html>