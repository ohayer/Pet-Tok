<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <h2>Imię: ${pet.name}, Nazwa właściciela: ${user.name} ${user.surname}</h2>
        <div style="border: 1px solid dimgray; padding: 0; display: inline-block; margin-left: 180px; margin-top: 100px; position: relative; width: 500px; height: 500px;">
            <img src="${imageSrc}" alt="${imageSrc}" style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; object-fit: cover;">
        </div>
        <c:if test="${pet.type eq 'ryba'}">
            <img class="images" src="${pageContext.request.contextPath}/icons/fish.png">
        </c:if>
        <c:if test="${pet.type eq 'ptak'}">
            <img class="images" src="${pageContext.request.contextPath}/icons/bird.png">
        </c:if>
        <c:if test="${pet.type eq 'gad'}">
            <img class="images" src="${pageContext.request.contextPath}/icons/turtle.png">
        </c:if>
        <c:if test="${pet.type eq 'pies'}">
            <img class="images" src="${pageContext.request.contextPath}/icons/dog.png">
        </c:if>
        <c:if test="${pet.type eq 'kot'}">
            <img class="images" src="${pageContext.request.contextPath}/icons/cat.png">
        </c:if>
        <c:if test="${pet.type eq 'gryzoń'}">
            <img class="images" src="${pageContext.request.contextPath}/icons/rabbit.png">
        </c:if>
        <br><br>
        <button onclick="window.history.back()" style="margin-left: 300px">Poprzedni</button>
        <button><a style="color: white;text-decoration: none" href="/search">Następny</a></button>
        <p class="bot-text">Strona stworzona z myślą o naszych słodkich pupilach</p>
        <img class="foot" src="${pageContext.request.contextPath}/img/paw.png">
    </div>
    <div class="gray">
        <h1>Opis zwierzaczka:</h1>
        <h3 class="description-pet">${pet.description}</h3>
        <h1 style="margin-top: 110px">Likes: ${pet.rating}</h1>
        <form method="post">
            <input onmouseover="this.style.color=`red`" onmouseout="this.style.color='grey'" type="submit" class="style-submit" value="❤"
            style="background-color: transparent;
            color: grey;
        font-size: 60px;
        outline: none;
        padding: 0;">
        </form>
        <h1 style="margin-top: 200px">Nie dodałeś jeszcze swojego pupila? Masz okazję, przejdź w ten <a href="http://localhost:8080/create">link</a>
            i dodaj własne zwierzątko do naszego portalu! </h1>
    </div>
</div>
</body>
</html>

