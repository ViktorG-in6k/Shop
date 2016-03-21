<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Shop</title>


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
        <div class="panel-heading">
            <a href="/">Categories</a>
            <a href="/${product.getCategori_id().getName()}">/${product.getCategori_id().getName()}</a>
            /${product.getName()}</div>
        <div class="panel-body">
                <div class="col-md-12">
                    <img src="http://placehold.it/350x150" class="img-responsive " width="304" height="236">
                </div>
            <form action="/add" role="form">
                <input type="hidden"  name="product" value="${product.id}">
                <button type="submit" class="btn col-md-offset-10 glyphicon glyphicon-shopping-cart"> by $${product.getPrice()}</button>
            </form>
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