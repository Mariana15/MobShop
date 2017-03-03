<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
  <style>
            .navbar-brand{
                padding: 0 15px;
            }
  </style>
	
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="/" class="navbar-brand">
                        <img src="/resources/img/images (1).jpg" class="img img-thumbnail" width="150px">
                    </a>
                </div>
                 <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
               			 <li><a href="/registration">Registration</a></li>
                         <li> <a href="/">Shop</a></li>
                        <li><a href="/shoppingCart"><img src="/resources/img/empty-cart-light.png" class="img img-thumbnail" width="30px"></a></li>
                        
                            </ul>
                       
                    <security:authorize access="!isAuthenticated()">
	                    <form:form class="navbar-form navbar-right" action="/login" method="POST">
	                        <div class="form-group">
	                            <input class="form-control" placeholder="Login" name="login">
	                        </div>
	                        <div class="form-group">
	                            <input class="form-control" placeholder="Password" type="password" name="password">
	                        </div>
	                        <div class="checkbox">
							    <label>
							      <input name="remember-me" type="checkbox"> Remember me
							    </label>
							</div>
	                        <button class="btn btn-primary">Sign in</button>
	                    </form:form>
                    </security:authorize>
                    <security:authorize access="isAuthenticated()">
	                    <form:form class="navbar-form navbar-right" action="/logout" method="POST">
	                        <button class="btn btn-primary">Sign out</button>
	                    </form:form>
                    	<security:authorize access="hasRole('ROLE_ADMIN')">
		                    <ul class="nav navbar-nav navbar-right">
		                        <li><a href="/admin">Admin</a></li>
		                        <security:authorize access="hasRole('ROLE_USER')">
                    		 <ul class="nav navbar-nav navbar-right">
                    		 
                    		 </ul>
                    	</security:authorize>
		                        <li class="dropdown">
		                            <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                Dropdown <span class="caret"></span>
                            </a>
		                            <ul class="dropdown-menu">
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
									<li><a href="/admin/item">Item</a></li>
		                            </ul>
		                        </li>
		                    </ul>
                    	</security:authorize>
                    	
                    </security:authorize>
                </div>
            </div>
        </nav>