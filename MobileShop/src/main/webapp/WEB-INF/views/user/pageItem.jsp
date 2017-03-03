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
<title>item</title>
</head>
<body>

	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">${item.producer.name}</h1>
		</div>
	</div>


	<div class="row">

		<div class="col-md-8">
			<img class="img-responsive"
				src="/images/item/${item.id}.jpg?version=${item.version} " alt="">
		</div>

		<div class="col-md-4">
		<h3>Item Description</h3>
			<p>${item.description.name}</p>
			<h3>Product</h3>
			<p>${item.category.name}</p>
			<h3>Item Details</h3>
			<ul>
				<li>Model : ${item.name}</li>
				<li>Camera : ${item.camera.px}</li>
				<li>Operation system: ${item.os.name}</li>
				<li>Color: ${item.color.name }</li>
				<li>Price : ${item.price }</li>
			</ul>
			<security:authorize access="isAuthenticated()">
				<div>
					<a href="/ordernow/${item.id}">
						<button class="btn btn-cart" type="submit" id="add-to-cart"> Add to shopping cart</button>
					</a>
				</div>
				</security:authorize>
				<security:authorize access="!isAuthenticated()">
				<h2> If you want buy item you must login<a href = "/login"></a> or <a href="/registration">register</a></h2>
				</security:authorize>
		</div>

	</div>


</body>
</html>