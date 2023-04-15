<%--
  Created by IntelliJ IDEA.
  User: olik0
  Date: 15.04.2023
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Przeglądaj pupile</title>

    <style>
        <%@include file="/WEB-INF/views/style/style.css" %>
    </style>
    <script defer>
        <%@include file="/WEB-INF/views/style/home.js" %>
    </script>
</head>
<body>
<div class="header">
    <a href="/">Strona główna</a>
    <% if (session.getAttribute("email") != null) { %>
    <a href="/create">Kreator Pupili</a>
    <a href="/search">Przeglądaj Pupile</a>
    <a href="http://localhost:8080/logout">Wyloguj się</a>
    <% } else { %>

    <a href="/login">Kreator Pupili</a>
    <a href="/login">Przeglądaj Pupile</a>
    <a href="/login">Zaloguj się</a>
    <% } %>

</div>
<div class="main">
    <div class="white">
        <div style="border: 2px solid dimgray; padding: 0; display: inline-block; margin-left: 180px; margin-top: 170px; position: relative; width: 500px; height: 500px;">
            <img src="${imageSrc}" alt="${imageSrc}" style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; object-fit: cover;">
        </div>

        <p class="bot-text">Strona stworzona z myślą o naszych słodkich pupilach</p>
        <img class="foot" src="img/paw.png">
    </div>
    <div class="gray">
        <h1>Imię:</h1>
        <h3>${pet.name}</h3>
        <h1>Opis zwierzaczka:</h1>
        <h3>${pet.description}</h3>
        <h1>Ilość polubień</h1>
        <h3>${pet.rating}</h3>
        <h1>Typ :</h1>
        <h3>${pet.type}</h3>
<%--        <img class="dog" src="img/dog.png" style="position: absolute">--%>
    </div>
</div>
</body>
</html>

