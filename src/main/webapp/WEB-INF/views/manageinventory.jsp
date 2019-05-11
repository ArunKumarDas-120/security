<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/views/common.jsp"%>
<link href="/resources/css/inventorymanagmanet.css" rel="stylesheet" type="text/css">
<link href="/resources/css/inventorymanagmentserach.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/resources/script/inventorymanagment.js"></script>
<div style="width: 100%; height: 100%;">
	<h2>Manage Inventory</h2>
	<div class="menu-tab">
		<button class="menu active" id='category'>Category</button>
		<button class="menu passive" id='company'>Company</button>
		<button class="menu passive" id='product'>Products</button>
	</div>
	<div id="category" class="menu-tabcontent open">
		<div class="action-menu">
			<button class="action active" id='add'>Add</button>
			<button class="action passive" id='modify'>Update</button>
		</div>
		<div id="add" class="action-menu-tabcontent open">
			<h3>Add category</h3>
			<hr>
			<div>
				<form id="addCategoryForm" name="categoryDto" action="/category/add" method="post" class="allTrue">
					<input type="text" placeholder="Category" name="catagoryName"
						value="" id="catagoryName" class="add-txt" required>
					<button type="button"
						onclick="add('#addCategoryForm')" class="add-btn">Add</button>
				</form>
			</div>
		</div>
		<div id="modify" class="action-menu-tabcontent close">
			<h3>update category</h3>
			<hr>
			<div class="chat-popup search-wizard">
			  <form action="/category/search" name="categoryDto" id="categorySearchForm" method="post" class="anyTrue">
			    <label for="msg"><b>Search</b></label>
			    <input type="text" placeholder="Type Criteria...."  class='serach' name="catagoryName"
						 id="catagoryName" class='serach' required>
			    <button type="button" class="btn" onclick="search('#categorySearchForm','#cat-searchResult')">Search</button>
			    <button type="button" class="btn cancel close-search">Close</button>
			  </form>
			</div>
			<button class="open-button" >Search</button>
			<div id="cat-searchResult">
			</div>
		</div>
	</div>
	<div id="company" class="menu-tabcontent close">
		<div class="action-menu">
			<button class="action active" id='add'>Add</button>
			<button class="action passive" id='modify'>Update</button>
		</div>
		<div id="add" class="action-menu-tabcontent open">
			<h3>Add company</h3>
			<hr>
			<div>
				<form id="addCompanyForm" name="companyDto" action="/company/add" method="post">
					<input type="text" placeholder="Company" name="companyName"
						value="" id="companyName" class="add-txt" required>
					<button type="button"
						onclick="add('#addCompanyForm')" class="add-btn">Add</button>
				</form>
			</div>
		</div>
		<div id="modify" class="action-menu-tabcontent close">
			<h3>update company</h3>
			<hr>
			<div class="chat-popup search-wizard">
			  <form action="/company/search" method="post"  id="companySearchForm" name="companyDto">
			    <label for="msg"><b>Search</b></label>
			    <input type="text" placeholder="Type Criteria...."  class='serach' name="companyName" required>
			     <button type="button" class="btn" onclick="search('#companySearchForm','#comp-searchResult')">Search</button>
			    <button type="button" class="btn cancel close-search">Close</button>
			  </form>
			</div>
			<button class="open-button" >Search</button>
			<div id="comp-searchResult">
			</div>
		</div>
	</div>
	<div id="product" class="menu-tabcontent close">
		<div class="action-menu">
			<button class="action active" id='add'>Add</button>
			<button class="action passive" id='modify'>Update</button>
		</div>
		<div id="add" class="action-menu-tabcontent open">
			<h3>Add product</h3>
			<hr>
			<div class="container addprodContainer">
			  <form action="/product/add"  method="post" id="addProdcutForm" name="productDto" class="anyTrue">
			        <div class="row">
			          <div class="col">
			            <label class="product-label">Product Name</label>
			            <input type="text" class="product-text" id="productName" name="productName" placeholder="ProductName...">
			            <label class="product-label">Serial Number</label>
			            <input type="text" class="product-text" id="productSerialNumber" name="productSerialNumber" placeholder="SerialNumber...">
			            <label class="product-label">Model Number</label>
			            <input type="text"  class="product-text" id="productModelNumber" name="productModelNumber" placeholder="ModelNumber...">
			          </div>
			          <div class="col">
			            <label class="product-label">Category</label>
			            <select class="select-css category category-with-id" name="catogery.catagoryId">
							<option>--Select--</option>
							<c:if test="${not empty listOfCategory}">
								<c:forEach items="${listOfCategory}" var="category">
									<option value="${category.catagoryId}">${category.catagoryName}</option>
								</c:forEach>
							</c:if>
						</select>
			            <label class="product-label">Company</label>
			            <select class="select-css company" name="company.companyId">
							<option>--Select--</option>
							<c:if test="${not empty listOfCompany}">
								<c:forEach items="${listOfCompany}" var="company">
									<option value="${company.companyId}">${company.companyName}</option>
								</c:forEach>
							</c:if>
						</select>
						<label class="product-label">Pricer</label>
			            <input type="text"  class="product-text" id="productPrice" name="productPrice" placeholder="price..">
			          </div>   
			        </div>
        			<input type="button" value="Add" class="product-btn add" onclick="add('#addProdcutForm')">
     		 </form>
			</div>
		</div>
		<div id="modify" class="action-menu-tabcontent close">
			<h3>update product</h3>
			<hr>
			<div class="search-wizard container">
			  <form action="/product/search"  method="post" id="productSearchForm" name="productDto" class="anyTrue">
			        <div class="row">
			          <div class="col">
			            <label class="product-label">Product Name</label>
			            <input type="text" class="product-text" id="productName" name="productName" placeholder="ProductName...">
			            <label class="product-label">Serial Number</label>
			            <input type="text" class="product-text" id="productSerialNumber" name="productSerialNumber" placeholder="SerialNumber...">
			            <label class="product-label">Model Number</label>
			            <input type="text"  class="product-text" id="productModelNumber" name="productModelNumber" placeholder="ModelNumber...">
			          </div>
			          <div class="col">
			            <label class="product-label">Category</label>
			            <select class="select-css category category-with-id" name="catogery.catagoryName">
							<option>--Select--</option>
							<c:if test="${not empty listOfCategory}">
								<c:forEach items="${listOfCategory}" var="category">
									<option value="${category.catagoryId}">${category.catagoryName}</option>
								</c:forEach>
							</c:if>
						</select>
			            <label class="product-label">Company</label>
			            <select class="select-css company" name="company.companyName">
							<option>--Select--</option>
							<c:if test="${not empty listOfCompany}">
								<c:forEach items="${listOfCompany}" var="company">
									<option value="${company.companyId}">${company.companyName}</option>
								</c:forEach>
							</c:if>
						</select>
			          </div>   
			        </div>
        			<input type="button" value="Search" class="product-btn search" onclick="search('#productSearchForm','#prod-searchResult')">
					<input type="button" value="Cancel" class="product-btn cancel close-search">
     		 </form>
			</div>
			<button class="open-button" >Search</button>
			<div id="prod-searchResult">
			</div>
		</div>
	</div>
</div>