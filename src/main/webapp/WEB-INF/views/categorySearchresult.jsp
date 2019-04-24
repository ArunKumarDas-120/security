<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/views/common.jsp"%>
<div id="result">
	<table>
		<thead>
			<tr>
				<th>CategoryId</th>
				<th>CategoryName</th>
			</tr>
		</thead>
		<c:if test="${not empty result}">
			<c:forEach items="${result}" var="item">
				<tr>
					<td>${item.catagoryId}</td>
					<td>${item.catagoryName}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>

</div>