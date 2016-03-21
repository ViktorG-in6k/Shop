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
            <form class="form-horizontal">

                    <div class="form-group">
                        <label  class="control-label col-xs-2">name</label>
                        <div class="col-xs-10">
                            <input type="text" name="userName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="control-label col-xs-2">number</label>
                        <div class="col-xs-10">
                            <input type="text" name="userNumber">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-offset-2 col-xs-10">
                            <div class="checkbox">
                                <label><input type="checkbox"> Save</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-offset-2 col-xs-10">
                            <button type="submit" class="btn btn-primary">Go</button>
                        </div>
                    </div>

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