<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: olik0
  Date: 11.04.2023
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logowanie</title>
  <style><%@include file="/WEB-INF/views/style/style.css"%></style>
</head>
<body>
<div class="header">
  <a href="/">Strona główna</a>
  <a href="#">Zaloguj się</a>
</div>
<div class="main">
  <div class="white">
    <h1 style="color: #3e8e41">Zaloguj się, aby móc korzystać z funkcji naszej strony!</h1>
    <form method="post">
      <label>Podaj email</label>
      <input type="email" name="email"/>
      <label>Podaj hasło</label>
      <input type="password" name="password"/>
      <c:if test="${param.error=='invalid_credentials'}">
        <div style="text-align: center; color: red">*Nieprawidłowy email lub hasło. Proszę wpisać jeszcze raz.</div>
      </c:if>
      <input type="submit">
    </form>
    <h1 style="padding-top: 100px">Nie pamiętasz swojego hasła? Kliknij <a href="/resetPassword">link</a>, aby przywrócić hasło za pomocą kod wysłanego na podany adres email. </h1>
    <p class="bot-text">Strona stworzona z myślą o naszych słodkich pupilach</p>
    <img class="foot" src="img/paw.png">
  </div>
  <div class="gray">
    <img class="dog" src="img/dog.png">
  </div>
</div>
</body>
</html>
