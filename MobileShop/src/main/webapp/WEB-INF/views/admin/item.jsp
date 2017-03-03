<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<style>
	#filter>.form-group>.col-sm-12>span{
		display: block;
	}
</style>
<div class="row">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
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
					<li class="active"><a href="/admin/item">Item</a><span
						class="sr-only">(current)</span></li>
						<li><a href="/admin/description">description</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>

<div class="row">
	<div class="col-md-3 col-xs-12">
	
			<form:form class="form-horizontal" action="/admin/item" method="GET" modelAttribute="filter" id="filter">
				<custom:hiddenInputs excludeParams="search, minPrice, maxPrice, producerIds,categoryIds,cameraIds,colorIds,diagonalIds,fcIds,memoryIds,nocIds,noscIds,osIds,tsIds"/>
				<div class="form-group">
					<div class="col-sm-12">
	      				<form:input type="text" class="form-control" path="search" placeholder="Search"/>
	    			</div>
				</div>
				<div class="form-group">
					<div class="col-sm-6 col-xs-6">
	      				<form:input type="text" class="form-control" path="minPrice" placeholder="Min price"/>
	    			</div>
	    			<div class="col-sm-6 col-xs-6">
	      				<form:input type="text" class="form-control" path="maxPrice" placeholder="Max price"/>
	    			</div>
				</div>
				<div class="form-group">
				<label for="id">Producer:</label>
					<div class="col-sm-12">
						<form:checkboxes items="${producers}" path="producerIds" itemLabel="name" itemValue="id"/>
					</div>
				</div>
				<div class="form-group">
				<label for="id">Category:</label>
					<div class="col-sm-12">
						<form:checkboxes items="${categorys}" path="categoryIds" itemLabel="name" itemValue="id"/>
					</div>
				</div>
				<div class="form-group">
				<label for="id">Camera:</label>
					<div class="col-sm-12">
						<form:checkboxes items="${cameras}" path="cameraIds" itemLabel="px" itemValue="id"/>
					</div>
				</div>
				<div class="form-group">
				<label for="id">Color:</label>
					<div class="col-sm-12">
						<form:checkboxes items="${colors}" path="colorIds" itemLabel="name" itemValue="id"/>
					</div>
				</div>
				<div class="form-group">
				<label for="id">Diagonal:</label>
					<div class="col-sm-12">
						<form:checkboxes items="${diagonals}" path="diagonalIds" itemLabel="d" itemValue="id"/>
					</div>
				</div>
				<div class="form-group">
				<label for="id">Front camera:</label>
					<div class="col-sm-12">
						<form:checkboxes items="${fcs}" path="fcIds" itemLabel="px" itemValue="id"/>
					</div>
				</div>	<div class="form-group">
				<label for="id">Memory:</label>
					<div class="col-sm-12">
						<form:checkboxes items="${memories}" path="memoryIds" itemLabel="mb" itemValue="id"/>
					</div>
				</div>	
				<div class="form-group">
				<label for="id">Number of cores:</label>
					<div class="col-sm-12">
						<form:checkboxes items="${nocs}" path="nocIds" itemLabel="cor" itemValue="id"/>
					</div>
				</div>	
				<div class="form-group">
				<label for="id">Number of sim cards:</label>
					<div class="col-sm-12">
						<form:checkboxes items="${noscs}" path="noscIds" itemLabel="sim" itemValue="id"/>
					</div>
				</div>	
				<div class="form-group">
				<label for="id">Operation system:</label>
					<div class="col-sm-12">
						<form:checkboxes items="${oses}" path="osIds" itemLabel="name" itemValue="id"/>
					</div>
				</div>
				<div class="form-group">
				<label for="id">Type sim:</label>
					<div class="col-sm-12">
						<form:checkboxes items="${tss}" path="tsIds" itemLabel="name" itemValue="id"/>
					</div>
				</div>		
			
				<div class="form-group">
    				<div class="col-sm-12">
      					<button type="submit" class="btn btn-primary">Search</button>
    				</div>
  				</div>
			</form:form>
		
	</div>
	<div class="col-md-7 col-xs-12">
	
		<div class="row">
			<div class="col-md-12 col-xs-12" >
				<form:form class="form-horizontal" action="/admin/item" method="POST" modelAttribute="item" enctype="multipart/form-data">
				<custom:hiddenInputs excludeParams="category, name, producer, camera, color, diagonal, fc, memory, noc, nosc, os, ts, price"/>
					<div class="form-group">
						<label for="name" class="col-sm-offset-2 col-sm-10"><form:errors path="name"/></label>
					</div>
					<div class="form-group">
    					<label for="name" class="col-sm-2 control-label">Name</label>
    					<div class="col-sm-10">
      						<form:input type="text" class="form-control" path="name" id="name"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label class="col-sm-2 control-label">Producer</label>
    					<div class="col-sm-10">
					<form:select class="form-control" path="producer" id="producer" items="${producers}" itemValue="id" itemLabel="name"/>    	
									</div>
  					</div>
  					<div class="form-group">
    					<label class="col-sm-2 control-label">Category</label>
    					<div class="col-sm-10">
					<form:select class="form-control" path="category" id="category" items="${categorys}" itemValue="id" itemLabel="name"/>    		
								</div>
  					</div>
  					<div class="form-group">
    					<label class="col-sm-2 control-label">Camera</label>
    					<div class="col-sm-10">
					<form:select class="form-control" path="camera" id="camera" items="${cameras}" itemValue="id" itemLabel="px"/>    		
								</div>
  					</div>
  					<div class="form-group">
    					<label class="col-sm-2 control-label">Color</label>
    					<div class="col-sm-10">
					<form:select class="form-control" path="color" id="color" items="${colors}" itemValue="id" itemLabel="name"/>    			
							</div>
  					</div>
  					<div class="form-group">
    					<label class="col-sm-2 control-label">Diagonal</label>
    					<div class="col-sm-10">
					<form:select class="form-control" path="diagonal" id="diagonal" items="${diagonals}" itemValue="id" itemLabel="d"/>    			
							</div>
  					</div>
  					<div class="form-group">
    					<label class="col-sm-2 control-label">Front camera</label>
    					<div class="col-sm-10">
					<form:select class="form-control" path="fc" id="fc" items="${fcs}" itemValue="id" itemLabel="px"/>    		
						</div>
  					</div>
  					<div class="form-group">
    					<label class="col-sm-2 control-label">Memory</label>
    					<div class="col-sm-10">
					<form:select class="form-control" path="memory" id="memory" items="${memories}" itemValue="id" itemLabel="mb"/>    		
						</div>
  					</div>
  					<div class="form-group">
    					<label class="col-sm-2 control-label">Number of cores</label>
    					<div class="col-sm-10">
					<form:select class="form-control" path="noc" id="noc" items="${nocs}" itemValue="id" itemLabel="cor"/>    		
						</div>
  					</div>
  					<div class="form-group">
    					<label class="col-sm-2 control-label">Number of sim cards</label>
    					<div class="col-sm-10">
					<form:select class="form-control" path="nosc" id="nosc" items="${noscs}" itemValue="id" itemLabel="sim"/>    		
						</div>
  					</div>
  					<div class="form-group">
    					<label class="col-sm-2 control-label">Operation system </label>
    					<div class="col-sm-10">
					<form:select class="form-control" path="os" id="os" items="${oses}" itemValue="id" itemLabel="name"/>    		
						</div>
  					</div>
  					<div class="form-group">
    					<label class="col-sm-2 control-label">Type sim</label>
    					<div class="col-sm-10">
					<form:select class="form-control" path="ts" id="ts" items="${tss}" itemValue="id" itemLabel="name"/>    		
						</div>
  					</div>
  					
  					<form:errors path = "*"/>
						<div class="form-group">
						<label for="name" class="col-sm-offset-2 col-sm-10"><form:errors path="price"/></label>
						<label for="price" class="col-sm-2 control-label">Price</label>
						<div class="col-sm-10">
							<form:input type="text" class="form-control" path="price" id="price"/>
						</div>
					</div>
					<div class="form-group">
						<label for="specefication" class="col-sm-2 control-label">Description</label>
						<div class="col-sm-10">
							<form:select class="form-control" path="description" id="description" items="${descriptions}" itemValue="id" itemLabel="name"/>
						</div>
						</div>
				<div class="form-group">
  						<div class="col-sm-offset-2 col-sm-10">
		  					<label class="btn btn-default btn-file">
		        				Browse <input type="file" name="file" style="display: none;">
		    				</label>
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
	
		<div class="row">
			<div class="col-md-2 col-xs-2"><h4>Image</h4></div>
			<div class="col-md-2 col-xs-2"><h4>Item name</h4></div>
			<div class="col-md-2 col-xs-2"><h4>Item price</h4></div>
			<div class="col-md-2 col-xs-2"><h4>Category</h4></div>
			<div class="col-md-2 col-xs-2"><h4>Producer</h4></div>
			<div class="col-md-2 col-xs-2"><h4>Update</h4>
			<h4>Delete</h4></div>
		</div>
			<c:forEach items="${page.content}" var="item">
				<div class="row">
					<div class="col-md-2 col-xs-2"><img class="img-rounded" width="100%" src="/images/item/${item.id}.jpg?version=${item.version}"></div>
					<div class="col-md-2 col-xs-2">${item.name}</div>
					<div class="col-md-2 col-xs-2">${item.price}</div>
					<div class="col-md-2 col-xs-2">${item.category.name}</div>
					<div class="col-md-2 col-xs-2">${item.producer.name}</div>
				<div class="col-md-2 col-xs-2"><a class="btn btn-warning" href="/admin/item/update/${item.id}<custom:allParams/>">update</a>
					<a class="btn btn-danger" href="/admin/item/delete/${item.id}<custom:allParams/>">delete</a></div>
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
						<custom:sort innerHtml="Price asc" paramValue="price"/>
						<custom:sort innerHtml="Price asc" paramValue="price,desc"/>
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