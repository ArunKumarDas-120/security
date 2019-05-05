<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/views/common.jsp"%>
<div id="result">
	<table class="searched-data">
		<thead>
			<tr>
				<th  style="width: 10%;">Action</th>
				<th>CompanyId</th>
				<th>CompanyName</th>
			</tr>
		</thead>
		<c:if test="${not empty result}">
			<c:forEach  items="${result}" var="item" varStatus="loop">
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
					<td>${item.companyId}</td>
					<td>${item.companyName}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>

</div>