<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/views/common.jsp"%>
<div id="result">
	<table class="searched-data">
		<thead>
			<tr>
				<th>Action</th>
				<th>CompanyId</th>
				<th>CompanyName</th>
			</tr>
		</thead>
		<c:if test="${not empty result}">
			<c:forEach  items="${result}" var="item">
				<tr>
					<td>Action</td>
					<td>${item.companyId}</td>
					<td>${item.companyName}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>

</div>