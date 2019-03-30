<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<form  method="post" action="login">
<label>User Name</label> <input type="text" name="userName"/> <br>
<label>Password</label> <input type="password" name="password"/>
<input type="submit" value="Submit"/>
</form>
</body>
</html>