<%@ page import="com.model.categories" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Maven + Spring MVC + @JavaConfig</title>
 

<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />

<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>


<nav class="navbar navbar">
	<a href="/">Home</a>

	<a href="/shopping_cart" type="button"  class="btn btn-primary col-md-offset-10 btn  glyphicon glyphicon-shopping-cart">
		<span class="badge">${order.getOrder().size()*1}</span>
		</a>
</nav>



<div class="container">
 

	<div class="panel panel-info" >
	  <div class="panel-heading">Categories</div>
	  <div class="panel-body">
		  <c:forEach items="${data}" var="category">
			  <div class="col-md-4">
				  <p>
					  <a class="btn btn-warning btn-lg" href="/${category.getName()}" role="button">
						  <img src="http://placehold.it/350x150" class="img-responsive" width="304" height="236">${category.getName()}
					  </a>
				  </p>
			  </div>
		  </c:forEach>
	  </div>
  </div>
	<div class="alert alert-success"  role="alert">Good</div>
 
 
  <hr>
  <footer>
  </footer>
</div>
 
<spring:url value="/resources/core/js/hello.js" var="coreJs" />
<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs" />
<spring:url value="/resources/core/js/bootstrap.min.js" var="jQuery"/>


<script src="${jQuery}"></script>
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>


</body>
</html>