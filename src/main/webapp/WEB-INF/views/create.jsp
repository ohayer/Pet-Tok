<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: olik0
  Date: 12.04.2023
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodawanie pupila</title>
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
        <h1 style="color: #3e8e41">Dodaj swojego ukochanego członka rodziny</h1>
        <form:form method="post" modelAttribute="pet">
            <label>Imię twojego pupila</label>
            <form:input path="name"/>
            <form:errors path="name"/>
            <br><br>
            <label>Opis</label>
            <form:textarea id='text' maxlength="225" path="description"
                           placeholder="Tutaj powinny znajdować się podstawowe dane na temat twojego zwierzaczka. Np kiedy ma urodziny,co lubi jeść, jak sie nazywa jego ulubiona zabawka, jak bardzo jest kochany."
                           onkeyup="countChars()"></form:textarea>
            <div id="charNum">0/225</div>
            <form:errors path="description"/>

            <br><br>
            <label>Typ ukochanego zwierzaczka</label>
            <form:select path="type">
                <form:option value="option1">piesek</form:option>
                <form:option value="option2">kotek</form:option>
                <form:option value="option3">gryzoń</form:option>
                <form:option value="option4">rybka</form:option>
            </form:select>
            <form:errors path="type"/>
            <br><br>
            <label for="file-upload" class="custom-file-upload">Wybierz zdjęcie tylko w formacie png lub jpeg;</label>
            <form:input id="file-upload" path="image" type="file" accept="image/jpeg, image/png"/>
            <form:errors path="image"/>
            <input type="submit">
        </form:form>
        <p class="bot-text">Strona stworzona z myślą o naszych słodkich pupilach</p>
        <img class="foot" src="img/paw.png">
    </div>
    <div class="gray">
        <img class="dog" src="img/dog.png" style="position: absolute">
        <img class="cows" src="img/cows.jpg" style="transform: translateY(10px) rotate(3deg);
  border: 5px solid;
  border-image: linear-gradient(45deg, #00c3ff, #ffff1c) 1;
  border-radius: 10px;
  position: absolute;
  margin-top: 200px;
  margin-left: 400px;">
    </div>
</div>
</body>
</html>
