<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/views/common.jsp"%>
<link href="/resources/css/inventorymanagmanet.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript"
	src="/resources/script/inventorymanagment.js"></script>
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
			<form id="addCategoryForm" name="categoryDto">
				<input type="text" placeholder="Category" name="catagoryName"
					value="" id="catagoryName" required>
					<button type="button" onclick="add('addcategory','addCategoryForm')">
					Add</button>
			</form>
				
			</div>
		</div>
		<div id="modify" class="action-menu-tabcontent close">
			<h3>update category</h3>
			<hr>
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
		</div>
		<div id="modify" class="action-menu-tabcontent close">
			<h3>update company</h3>
			<hr>
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
		</div>
		<div id="modify" class="action-menu-tabcontent close">
			<h3>update product</h3>
			<hr>
		</div>
	</div>
</div>