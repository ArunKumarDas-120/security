<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
<link href="/resources/css/admin.css" rel="stylesheet">
</head>
<body>
	<div id="Html1"
		style="position: absolute; left: 78px; top: 63px; width: 673px; height: 98px; z-index: 0">
	</div>
	<form method="get" action="/admin/searc/user">
	<input type="submit" id="Button1" name="" value="Search"
		style="position: absolute; left: 541px; top: 101px; width: 121px; height: 30px; z-index: 1;">
	<input type="text" id="Editbox1"
		style="position: absolute; left: 341px; top: 101px; width: 165px; height: 18px; z-index: 2;"
		name="criteria" value="" spellcheck="false">
	<label for="" id="Label1"
		style="position: absolute; left: 172px; top: 97px; width: 128px; height: 22px; line-height: 22px; z-index: 3;">User
		Name</label>
	</form>
	<table
		style="position: absolute; left: 68px; top: 200px; width: 1000px; height: 28px; z-index: 4;"
		id="Table1">
		<tr>
			<td class="cell0"><span
				style="color: #000000; font-family: Arial; font-size: 13px; line-height: 16px;"><span
					class="text">Userid</span></span></td>
			<td class="cell0"><span
				style="color: #000000; font-family: Arial; font-size: 13px; line-height: 16px;"><span
					class="text">userName</span></span></td>
			<td class="cell0"><span
				style="color: #000000; font-family: Arial; font-size: 13px; line-height: 16px;"><span
					class="text">password</span> </span></td>
			<td class="cell0"><span
				style="color: #000000; font-family: Arial; font-size: 13px; line-height: 16px;"><span
					class="text">Roles</span> </span></td>
			<td class="cell0"><span
				style="color: #000000; font-family: Arial; font-size: 13px; line-height: 16px;"><span
					class="text">Account Expired</span> </span></td>
			<td class="cell0"><span
				style="color: #000000; font-family: Arial; font-size: 13px; line-height: 16px;"><span
					class="text">Account Locked</span> </span></td>
			<td class="cell0"><span
				style="color: #000000; font-family: Arial; font-size: 13px; line-height: 16px;"><span
					class="text">Expired Credential</span> </span></td>
			<td class="cell0"><span
				style="color: #000000; font-family: Arial; font-size: 13px; line-height: 16px; text-align: center"><span
					class="text">User Enabled</span> </span></td>
		</tr>
	</table>
</body>
</html>