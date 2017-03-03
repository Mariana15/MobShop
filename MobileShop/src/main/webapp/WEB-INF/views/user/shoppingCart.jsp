<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ page import="ua.entity.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<html>
<head>
<title>ShoppingCart</title>
</head>
<body>
	<div class="col-md-12"
		style="margin-top: 30px; background: #292d39; color: white; font-size: 16px; text-align: center;">
		<div class="col-md-6" style="border-right: 1px solid #f4f4f4;">
			Product</div>
		<div class="col-md-2" style="border-right: 1px solid #f4f4f4;">
			Price</div>
		<div class="col-md-2" style="border-right: 1px solid #f4f4f4;">
			Quantity</div>
		<div class="col-md-2">Delete</div>
	</div>

	<c:forEach items="${carts.items}" var="cart">
		<div class="col-md-12 cart_item "
			style="background: white; border-bottom: 1px solid #f4f4f4;">
			<div class="col-md-6"
				style="height: 300px; border-right: 1px solid #f4f4f4; text-align: left;">
				<div class="col-md-6">
					<h1>
						<img class="img-rounded" width="100%"
							src="/images/item/${cart.id}.jpg?version=${cart.version}">
					</h1>
				</div>
				<div class="col-md-6">
					<ul class="cart-1">
					<li>Model : ${item.name}</li>
				<li>Camera : ${item.camera.px}</li>
				<li>Operation system: ${item.os.name}</li>
				<li>Color: ${item.color.name }</li>
				<li>Price : ${item.price }</li>


					</ul>
				</div>
			</div>
			<div class="col-md-2"
				style="height: 300px; border-right: 1px solid #f4f4f4; text-align: center;">
				<div class="product_price">${cart.price}<span class="price">uan</span>
				</div>
			</div>
			<div class="col-md-2 cell_3"
				style="height: 200px; border-right: 1px solid #f4f4f4; text-align: center;">

				<div class="quantity_box">
					

				</div>



			</div>
			<div class="col-md-2" style="text-align: center;">
				<a style="font-size: 30px;" 
					href="/shoppingCart/delete/${cart.id}">Delete</a>
			</div>
		</div>
	</c:forEach>
	</div>


	<div class="row" style="margin-right: 0px;">
		<div style="height: 30px;"></div>
	</div>
	</div>
</body>
</html>