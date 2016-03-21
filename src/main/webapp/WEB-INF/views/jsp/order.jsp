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
        <span class="badge"></span>
    </a>
</nav>



<div class="container">


    <div class="panel panel-info" >
        <div class="panel-heading">Categories</div>
        <div class="panel-body">
            <form class="form-horizontal">
                <fieldset disabled="disabled">
                    <div class="form-group">
                        <label for="inputEmail" class="control-label col-xs-2">Email</label>
                        <div class="col-xs-10">
                            <input type="email" class="form-control" id="inputEmail" placeholder="Email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="control-label col-xs-2">Пароль</label>
                        <div class="col-xs-10">
                            <input type="password" class="form-control" id="inputPassword" placeholder="Пароль">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-offset-2 col-xs-10">
                            <div class="checkbox">
                                <label><input type="checkbox"> Запомнить</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-offset-2 col-xs-10">
                            <button type="submit" class="btn btn-primary">Войти</button>
                        </div>
                    </div>
                </fieldset>
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