<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %>
     <%@ page import="com.java.model.*" %>
      <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Message</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<style>
.chat
{
    list-style: none;
    margin: 0;
    padding: 0;
}

.chat li
{
    margin-bottom: 10px;
    padding-bottom: 5px;
    border-bottom: 1px dotted #B3A9A9;
}

.chat li.left .chat-body
{
    margin-left: 60px;
}

.chat li.right .chat-body
{
    margin-right: 60px;
}


.chat li .chat-body p
{
    margin: 0;
    color: #777777;
}

.panel .slidedown .glyphicon, .chat .glyphicon
{
    margin-right: 5px;
}

.panel-body
{
    overflow-y: scroll;
    height: 250px;
}

::-webkit-scrollbar-track
{
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
    background-color: #F5F5F5;
}

::-webkit-scrollbar
{
    width: 12px;
    background-color: #F5F5F5;
}

::-webkit-scrollbar-thumb
{
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);
    background-color: #555;
}

</style>
<body>
<div style="text-align:center"><a href="Profile">go to Profile</a></div>
<div class="container">
    <div class="row">
        <div class="col-md-5">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <span class="glyphicon glyphicon-comment"></span> Chat
                    </div>
                </div>
                <div class="panel-body">
                    <ul class="chat">
                     <%List<Message> messages =(List<Message>)request.getAttribute("messages"); 
             			String cssClassPullRight = "pull-right ";
             			String textposition="left";
        for(Message message:messages){
        if(message.getFromUser()==request.getAttribute("user"))
        {
        	cssClassPullRight="";
        	textposition="left";
        }
        else{
        	cssClassPullRight="pull-right ";
        	textposition="right";
        }
        %> 
        			
                        <li class="<%=textposition%> clearfix">
                            <div class="chat-body clearfix">
                                <div class="header">
                                    <strong class="<%=cssClassPullRight %> primary-font"><%=message.getFromUser() %></strong> <small class="pull-right text-muted">
                                        <span class="glyphicon glyphicon-time"></span><%=message.getDate() %></small>
                                </div>
                                <p><%=message.getMessage() %></p>
                            </div>
                        </li>
                        <%} %>
                    </ul>
                </div>
                <div class="panel-footer">
                    <div class="input-group">
                    <form action="SendMessage" method="post">
                        <input id="btn-input" type="text" name="message" class="form-control input-sm" placeholder="Type your message here..." />
                        <span class="input-group-btn">
                            <button name="friend" value="<%=request.getAttribute("friend")%>" class="btn btn-warning btn-sm" id="btn-chat">Send</button>
                        </span>
                    </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>