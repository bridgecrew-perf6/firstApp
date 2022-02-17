<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Новости</title>

    <style type="text/css">
        .layout {
            alignment: left;
            height: 25px;
            position: relative;
        }
    </style>
</head>
<body>
    <h2> Баланс </h2>
    <span>${userBalance}</span><br>
    <a href="/">Главная</a>


    <div class="layout"></div>

    <button>
        <a href="/presales">Перейти к продажам</a>
    </button>

    <div class="layout"></div>

</body>
</html>
