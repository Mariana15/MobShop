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


	<c:forEach items="${carts.items}" var="cart">
		<div class="col-md-12 cart_item ">
			<div class="col-md-6">
				<div class="col-md-6">
					<h1>
						<img class="img-rounded" width="100%"
							src="/images/item/${cart.id}.jpg?version=${cart.version}">
					</h1>
				</div>
				<div class="col-md-6">
					<ul class="cart-1">
					<li>Model : ${cart.name}</li>
				<li >Camera : ${cart.camera.px}</li>
				<li>Operation system: ${cart.os.name}</li>
				<li>Color: ${cart.color.name }</li>
				<li>Price : ${cart.price }</li>


					</ul>
				</div>
			</div>
			<div class="col-md-2"
				style="height: 300px; border-right: 1px solid #f4f4f4; text-align: center;">
				<div class="product_price">${cart.price}<span class="price">$</span>
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
	


	<div class="row" style="margin-right: 0px;">
		<div style="height: 30px;"></div>
	</div>
	
</body>
</html>