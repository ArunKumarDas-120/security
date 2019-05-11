<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/views/common.jsp"%>
<div id="result">
<input type="hidden" disabled id="responseMessage" class="${result.status}" value="${result.statusMessage}">
<form action="/company/update" method="Post" name="companyDto" id="updateCompanyForm">
	<table class="searched-data">
		<thead>
			<tr>
				<th  style="width: 10%;">Action</th>
				<th>CompanyId</th>
				<th>CompanyName</th>
			</tr>
		</thead>
		<c:if test="${(not empty result) and (not empty result.listOfData)}">
			<c:forEach  items="${result.listOfData}" var="item" varStatus="loop">
				<tr>
						<td>
							<div class="flip-card">
							  <div class="flip-card-inner">
							    <div class="flip-card-front">
							      <img src="/resources/images/edit.png"  class="edit action-icon" onclick="changeAction(this,${loop.index+1},'#updateCompanyForm')">
							    </div>
							    <div class="flip-card-back">
									<span style="margin-right:8px;">
										<img src="/resources/images/save.png" class="save action-icon" onclick="changeAction(this,${loop.index+1},'#updateCompanyForm')">
									</span>
								    <span>
								    	<img src="/resources/images/cancel.png"   class="cancel action-icon" onclick="changeAction(this,${loop.index+1},'#updateCompanyForm')">
								    </span>
							    </div>
							  </div>
							</div>
						</td>					
					<td class="editable">${item.companyId} <input type="hidden" disabled name="companyId" value="${item.companyId}"/></td>
					<td class="editable"><input type="text" disabled name="companyName" value="${item.companyName}"/></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</form>
</div>