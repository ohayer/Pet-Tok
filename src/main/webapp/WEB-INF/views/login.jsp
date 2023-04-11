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
      <input type="submit">
    </form>
    <p class="bot-text">Strona stworzona z myślą o naszych słodkich pupilach</p>
    <img class="foot" src="img/paw.png">
  </div>
  <div class="gray">
    <img class="dog" src="img/dog.png">
  </div>
</div>
</body>
</html>
