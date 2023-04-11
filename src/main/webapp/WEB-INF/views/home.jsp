<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: olik0
  Date: 08.04.2023
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Strona główna</title>
    <style><%@include file="/WEB-INF/views/style/style.css"%></style>
    <script defer><%@include file="/WEB-INF/views/style/home.js"%></script>
</head>
<body>
<div class="header">
    <a href="/">Strona główna</a>
    <% if (session.getAttribute("email") != null) { %>
    <a href="http://localhost:8080/logout">Wyloguj się</a>
    <% } else { %>
    <a href="/login">Zaloguj się</a>
    <% } %>

</div>
<div class="main">
    <div class="white">
        <% if (session.getAttribute("email") != null) { %>
       <h1>Witaj ${name}</h1>
        <% } else { %>
        <h1>Nie masz jeszcze u nas konta?</h1>
        <h2>Kliknij <a href="/register">Stwórz konto</a> </h2>
        <h2>Lub kliknij <a href="/login">Zaloguj się</a>, aby się zalogować</h2>
        <% } %>
<%--        <h1>Nie masz jeszcze u nas konta?</h1>--%>
<%--        <h2>Kliknij <a href="/register">Stwórz konto</a> </h2>--%>
<%--        <h2>Lub kliknij <a href="/login">Zaloguj się</a>, aby się zalogować</h2>--%>
        <p class="bot-text">Strona stworzona z myślą o naszych słodkich pupilach</p>
        <img class="foot" src="img/paw.png">
    </div>
    <div class="gray">
      <img class="dog" src="img/dog.png">
        <ul class="month">Święta zwierzaczków w tym miesiącu:
            <c:forEach items="${holidays}" var="holiday">
                <li>${holiday.day}-${holiday.name}</li>
            </c:forEach>
        </ul>
    </div>
</div>
</body>
</html>
