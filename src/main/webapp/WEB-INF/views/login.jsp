<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/views/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<link href="/resources/css/loginpage.css" rel="stylesheet" type="text/css">
<link href="/resources/css/animation.css" rel="stylesheet" type="text/css">
<link href="/resources/css/toast.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/resources/script/toast.js"></script>
</head>
<body>
<div id="login-modal" class="modal">
  
  <form class="modal-content animate" name="loginform" method="post" accept-charset="UTF-8" action="/login" id="loginform" >
    <div class="imgcontainer">
      <img src="/resources/images/login-avatar.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
      <label style='margin-left: 10%;' for="uname"><b>Username</b></label>
      <input type="text" placeholder="Enter Username" name="userName" required>

      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="password" required>
    </div>

    <div class="container" style="background-color:#f1f1f1">
	   <button type="submit" >Login</button>
	   <a href="/registrationUI" class="register" >Register</a>
    </div>
  </form>
</div>
<%@include file="/WEB-INF/views/snackbar.jsp" %>
</body>
</html>
