<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/views/common.jsp"%>
<div id="result">
	<form action="/category/update" method="Post" name="categoryDto">
		<table class="searched-data">
			<thead>
				<tr>
					<th>Action</th>
					<th>CategoryId</th>
					<th>CategoryName</th>
				</tr>
			</thead>
			<c:if test="${not empty result}">
				<c:forEach items="${result}" var="item" varStatus="loop">
					<tr>
						<td>
							<div class="flip-card">
							  <div class="flip-card-inner">
							    <div class="flip-card-front">
							      <img src="/resources/images/edit.png"  class="edit action-icon" onclick="changeAction(this)">
							    </div>
							    <div class="flip-card-back">
									<span style="margin-right:8px;">
										<img src="/resources/images/save.png" class="save action-icon" onclick="changeAction(this)">
									</span>
								    <span>
								    	<img src="/resources/images/cancel.png"   class="cancel action-icon" onclick="changeAction(this)">
								    </span>
							    </div>
							  </div>
							</div>
						</td>
						<td>${item.catagoryId}</td>
						<td>${item.catagoryName}</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</form>
</div>