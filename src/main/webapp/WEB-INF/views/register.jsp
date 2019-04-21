<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/views/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Register</title>
<link href="/resources/css/registration.css" rel="stylesheet" type="text/css">
<link href="/resources/css/animation.css" rel="stylesheet" type="text/css">
<link href="/resources/css/toast.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/resources/script/toast.js"></script>
</head>
<body  <c:if test="${not empty msg}">onload=popSnackBar()</c:if> >

<div class="modal">
  <form class="modal-content animate" action="/register" name="userDto" method="post">
    <div class="container">
      <h2>Sign Up</h2>
      <p>Please fill in this form to create an account.</p>
      <hr>
      <label for="email"><b>User Name</b></label>
      <input type="text" placeholder="Enter UserName" name="userName" value = "${ userDto.userName }"required>

      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="password" value = "${ password }" required>

      <label for="psw-repeat"><b>Repeat Password</b></label>
      <input type="password" placeholder="Repeat Password" name="psw-repeat" value = "${ password }"  required>
      
      <div class="clearfix">
         <a href="/login" class="register" >Cancel</a>
        <button type="submit" class="signupbtn">Sign Up</button>
      </div>
    </div>
  </form>
</div>
<%@include file="/WEB-INF/views/snackbar.jsp" %>
</body>
</html>
