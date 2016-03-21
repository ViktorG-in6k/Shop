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


                /${data.get(0).getCategori_id().getName()}


        </div>
        <div class="panel-body">
            <c:forEach items="${data}" var="product">
                <div class="col-md-4">
                    <p>
                        <a class="btn btn-warning btn-lg" href="/${product.getCategori_id().getName()}/${product.getName()}" role="button">
                            <img src="http://placehold.it/350x150" class="img-responsive"  width="304" height="236">${product.getName()}: $${product.getPrice()}
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