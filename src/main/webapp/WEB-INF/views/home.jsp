<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home</title>
<link href="/resources/css/home.css" rel="stylesheet" type="text/css">
<link href="/resources/css/toast.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/resources/script/jquery.js"></script>
<script type="text/javascript" src="/resources/script/home.js"></script>
<script type="text/javascript" src="/resources/script/toast.js"></script>
<script>
function openNav() {
  document.getElementById("mySidenav").style.width = "350px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
}
</script>
</head>
<body>
	<div class="new">
		<a href="get">About</a> <a href="get">About us</a>
	</div>
	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		<a href="/inventory" id="menuitem">Manage Inventory</a> <a href="#">About us</a>
	</div>

	<span style="font-size: 50px; cursor: pointer" onclick="openNav()">&#9776;
	</span>
	<div id='content'>
	</div>
<%@include file="/WEB-INF/views/snackbar.jsp" %>
</body>
</html>