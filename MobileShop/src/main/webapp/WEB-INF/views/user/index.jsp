<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>>
	<%@ page import="ua.entity.*" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


           
<div class="row">
	<div class="col-sm-6 col-sm-offset-3">
		<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
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
</div>
 <div class="row">
<c:forEach items="${page.content}" var="item">
					 <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                        <img src="/images/item/${item.id}.jpg?version=${item.version}" alt="">
                            <div class="caption">
                                <h4 class="pull-right">${item.price}<span class="price">$</span></h4>
                                <h4><a href="/pageItem/${item.id}">${item.name}</a></h4>
                                <p class="size">${item.description.name}.</p>
                           </div>
                            
						</div>
                        </div>
                       </c:forEach> 
                    


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
