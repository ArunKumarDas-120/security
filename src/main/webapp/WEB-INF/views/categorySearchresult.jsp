<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/views/common.jsp"%>
<div id="result">
<input type="hidden" disabled id="responseMessage" class="${result.status}" value="${result.statusMessage}">
	<form action="/category/update" method="Post" name="categoryDto" id="updateCatagoryForm">
		<table class="searched-data">
			<thead>
				<tr>
					<th style="width: 10%;">Action</th>
					<th>CategoryId</th>
					<th>CategoryName</th>
				</tr>
			</thead>
			<c:if test="${(not empty result) and (not empty result.listOfData)}">
				<c:forEach items="${result.listOfData}" var="item" varStatus="loop">
					<tr>
						<td>
							<div class="flip-card">
							  <div class="flip-card-inner">
							    <div class="flip-card-front">
							      <img src="/resources/images/edit.png"  class="edit action-icon" onclick="changeAction(this,${loop.index+1},'#updateCatagoryForm')">
							    </div>
							    <div class="flip-card-back">
									<span style="margin-right:8px;">
										<img src="/resources/images/save.png" class="save action-icon" onclick="changeAction(this,${loop.index+1},'#updateCatagoryForm')">
									</span>
								    <span>
								    	<img src="/resources/images/cancel.png"   class="cancel action-icon" onclick="changeAction(this,${loop.index+1},'#updateCatagoryForm')">
								    </span>
							    </div>
							  </div>
							</div>
						</td>
						<td class="editable">${item.catagoryId} <input type="hidden" disabled name="catagoryId" value="${item.catagoryId}"/></td>
						<td class="editable"> <input type="text" disabled name="catagoryName" value="${item.catagoryName}"/></td> 
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</form>
</div>