<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/style.css">
</head>
<body>
<form action="Home" method="post">
<div class="form">
    <div class="searchbar">
        <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.."> 
    </div>
    <br>
    <br>
    <div class="wearables">
        
        <label name="fname">First name:</label>
        <label name="lname">Last name:</label><br><br>
        <label name="email">Email:</label>
    </div>
    <br>
    <br>
    <div class="buttons">
        <label for="msg">Message</label>
        <label for="notif">Notification</label>
        <label for="friend">Friend Request</label>
    </div>
    
    </div>
    <br>
    <br>
    <div class="split left">
    
       <div class="grid-container">
             <div class="grid-item"><label for="frnds">Friend</label></div>
             <div class="grid-item"><a href="url">Block Friend</a></div>
             <div class="grid-item"><a href="url">Message</a></div>
             <div class="grid-item"><a href="url">UnFriend</a></div>
          </div>
       </div>
    <div class="split right">
         
    
    </div>
    
</form>
</body>
</html>