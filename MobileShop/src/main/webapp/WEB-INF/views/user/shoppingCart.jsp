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
				<li>Diagonal: ${cart.diagonal.d }</li>
				<li>Front camera: ${cart.fc.px }</li>
				<li>Memory: ${cart.memory.mb }</li>
				<li>Cores: ${cart.noc.cor }</li>
				<li>Sim cards: ${cart.nosc.sim }</li>
				<li>Type sim: ${cart.ts.name }</li>
					</ul>
				</div>
			</div>
			<div class="col-md-2">
				<div class="product_price">${cart.price}<span class="price">$</span>
				</div>
			</div>
			<div class="col-md-2">
				<div class="product_description"><p class="size">${cart.description.name}.</p>
			</div>
			</div>
			<div class="col-md-2" style="text-align: center;">
				<a class="btn btn-success" style = "margin-bottom: 20px;" 
					href="/shoppingCart/buyItems/${cart.id}">Buy</a>
			</div>
			<div class="col-md-2" style="text-align: center;">
				<a class="btn btn-danger" 
					href="/shoppingCart/delete/${cart.id}">Delete</a>
			</div>
		</div>
	</c:forEach>
	


	<div class="row" style="margin-right: 0px;">
		<div style="height: 30px;"></div>
	</div>
	
</body>
</html>