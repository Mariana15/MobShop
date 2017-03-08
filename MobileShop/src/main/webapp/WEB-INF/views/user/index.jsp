<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
	<%@ page import="ua.entity.*" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	padding-bottom: 70px; 
	padding-top: 70px;
}
.size {
    white-space: nowrap; /* Отменяем перенос текста */
    overflow: hidden; /* Обрезаем содержимое */
    padding: 5px; /* Поля */
    text-overflow: ellipsis; /* Многоточие */
   }
</style>
<!-- сюди буде підставлено атрибут з ім'ям title -->
</head>
<body>
<div class="container">

<div class= "row">
  <div class="col-md-3 col-xs-12">
	<h3>Filter</h3>
			<form:form class="form-horizontal" action="/" method="GET" modelAttribute="filter" id="filter">
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

	<div class="col-sm-6 col-sm-offset-1">
	
		<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators" style = "margin-left:0px" >
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
				<li data-target="#myCarousel" data-slide-to="4"></li>
				<li data-target="#myCarousel" data-slide-to="5"></li>
			</ol>
			 <div class="carousel-inner">
                <div class="item active">
					<img class="slide-image" src="/resources/img/Без названия.jpg"  width="800px" alt="">
				</div>
				<div class="item">
					<img class="slide-image" src="/resources/img/Без названия (1).jpg"  width="800px" alt="">
				</div>
				<div class="item">
					<img class="slide-image" src="/resources/img/Без названия (2).jpg" width="800px"  alt="">
				</div>
				<div class="item">
					<img class="slide-image" src="/resources/img/images (1).jpg" width="800px"  alt="">
				</div>
				<div class="item">
					<img class="slide-image" src="/resources/img/images (2).jpg" width="800px"  alt="">
				</div>
				<div class="item">
					<img class="slide-image" src="/resources/img/images (3).jpg" width="800px" alt="">
				</div>
			</div>
			   <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
		</div>
	
</div>
 <div class="row">
<c:forEach items="${page.content}" var="item">
					 <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                        <img src="/images/item/${item.id}.jpg?version=${item.version}" alt="">
                            <div class="caption">
                                <h4 class="pull-right">${item.price}<span class="price">$</span></h4>
                                <h4><a href="/pageItem/${item.id}">${item.producer.name}</a></h4>
                                <p class="size">${item.description.name}.</p>
                           </div>
                            <security:authorize access="isAuthenticated()">
					<div>
					<a href="/ordernow/${item.id}">
						<button class="btn btn-success" type="submit" id="add-to-cart"> Add</button>
					</a>
					</div>
					</security:authorize>
				<security:authorize access="!isAuthenticated()">
				<a href="/registration"><button class="btn btn-success" type="submit" id="add-to-cart"> Add</button></a>
				</security:authorize>
						</div>
                        </div>
                       </c:forEach> 
                    


        </div>

    </div>	
</div>
    
    <script type="text/javascript">
$("#myCarousel").carousel();
</script>
<div class="col-md-12 col-xs-12 text-center" >
		<custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>" />
    </div>
</body>

</html>
