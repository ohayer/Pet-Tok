<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: olik0
  Date: 09.04.2023
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja</title>
    <style><%@include file="/WEB-INF/views/style/style.css"%></style>
</head>
<body>
<div class="header">
    <a href="/">Strona główna</a>
    <a href="#">Zaloguj się</a>
</div>
<div class="main">
    <div class="white">
        <form:form method="post" modelAttribute="user">
            <h1 class="form-title">Stwórz swoje konto już dziś!</h1>
            <label>Imię</label>
            <form:input type="text" path="name"/>
            <form:errors path="name"/>
            <label>Nazwisko</label>
            <form:input type="text" path="surname"/>
            <form:errors path = "surname"/>
            <label>Email</label>
            <form:input type="email" path="email"/>
            <form:errors path="email"/>
            <label>Hasło</label>
            <form:password path="password"/>
            <form:errors path="password"/>
            <label for="accepted">Czy zgadzasz się na przetwarzanie twoich danych przez naszą stronę?</label>
            <input type="checkbox" id="accepted" name="accepted"/>
            <form:errors path="accepted"/>
            <input type="submit" placeholder="Stwórz konto">
        </form:form>
        <h2>Masz już swoje konto?</h2>
        <h2>Przejdź do zakładki -> <a href="/login">Zaloguj się</a> </h2>
            <p class="bot-text">Strona stworzona z myślą o naszych słodkich pupilach</p>
                <img class="foot" src="img/paw.png">
    </div>
    <div class="gray">
        <img class="dog" src="img/dog.png">
    </div>
</div>
</body>
</html>
