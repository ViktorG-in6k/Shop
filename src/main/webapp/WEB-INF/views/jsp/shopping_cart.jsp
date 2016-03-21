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
        <div class="panel-heading glyphicon glyphicon-shopping-cart col-md-12">
           shopping cart
        </div>

        <table class="table">
            <thead>
            <tr>
                <th>Name</th>
                <th>Price</th>
                <td>Count</td>
                <td>Total price</td>
            </tr>
            </thead>

            <c:forEach items="${order.getOrder()}" var="order">

            <tbody>
            <tr>
                <td>${order.getProd().getName()}</td>
                <td>${order.getProd().getPrice()}</td>
                <td>
                    <form action="/rec" role="form">
                        <input type="hidden" name="product_id" value="${order.getProd().getId()}">
                        <input type="number" class="col-md-2" name="product_count" value=${order.getCountOfProducts()}>
                        <button type="submit" class="btn">change</button>
                    </form>
                </td>
                <td>$${order.getPrice()}</td>
            </tr>
            </tbody>

            </c:forEach>

            <td></td>
            <td></td>
            <td></td>
            <td>$${order.getTotalPrice()}</td>

            <a href="/order"><button type="button" class="btn btn-primary">Go</button></a>
        </table>

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