<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>


<div class="row">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="/admin/item">Item</a></li>
					<li><a href="/admin/category">Category</a></li>
					<li><a href="/admin/camera">Camera</a></li>
					<li><a href="/admin/producer">Producer</a></li>
					<li><a href="/admin/noc">Number of cores</a></li>
					<li><a href="/admin/nosc">Number of sim cards</a></li>
					<li><a href="/admin/os">Operation system</a></li>
					<li><a href="/admin/color">Color</a></li>
					<li><a href="/admin/diagonal">Diagonal</a></li>
					<li><a href="/admin/fc">Front camera</a></li>
					<li><a href="/admin/memory">Memory</a></li>
					<li><a href="/admin/ts">Type sim</a></li>
					<li><a href="/admin/description">description<span
							class="sr-only">(current)</span></a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>
<div class="row">
		<div class="col-md-3 col-xs-12">
		<form:form modelAttribute="filter" action="/admin/description" method="get" class="form-inline">
			<div class="form-group">
				<form:input path="search" placeholder="search" class="form-control" />
				<custom:hiddenInputs excludeParams="search"/>
				<button type="submit" class="btn btn-primary">Ok</button>
			</div>
		</form:form>
	</div>
	<div class="col-md-7 col-xs-12">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/description" method="POST" modelAttribute="description">
				<custom:hiddenInputs excludeParams="name"/>
					<div class="form-group">
					<label for="name" class="col-sm-offset-2 col-sm-10"><form:errors path="name"/></label>
						<label for="name" class="col-sm-2 control-label">Name</label>
						<div class="col-sm-10">
							<form:input type="text" class="form-control" path="name" id="name"/>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Create</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-3 col-xs-12"></div>
	<div class="col-md-7 col-xs-12">
		<div class="row">
			<div class="row">
				<div class="col-md-4 col-xs-4">
					<h3>description </h3>
				</div>
				<div class="col-md-4 col-xs-4">
					<h3>Update</h3>
				</div>
				<div class="col-md-4 col-xs-4">
					<h3>Delete</h3>
				</div>
			</div>
		</div>
		<c:forEach items="${page.content}" var="description">
				<div class="row">
					<div class="col-md-4 col-xs-4">${description.name}</div>
					<div class="col-md-4 col-xs-4"><a class="btn btn-warning" href="/admin/description/update/${description.id}<custom:allParams/>">update</a></div>
					<div class="col-md-4 col-xs-4"><a class="btn btn-danger" href="/admin/description/delete/${description.id}<custom:allParams/>">delete</a></div>
				</div>
			</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12">
		<div class="row">
			<div class="col-md-6 col-xs-6 text-center">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<custom:sort innerHtml="Name asc" paramValue="name"/>
						<custom:sort innerHtml="Name desc" paramValue="name,desc"/>
					</ul>
				</div>
			</div>
			<div class="col-md-6 col-xs-6 text-center">
				<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>" />
	</div>
</div>