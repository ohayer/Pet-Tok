<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: olik0
  Date: 24.04.2023
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Przywracanie hasła</title>
</head>
<style>
    <%@include file="/WEB-INF/views/style/reset.css" %>
</style>
<body>
<h1>Kod został podany na adres email: ${email}</h1>
<form method="post" class="password-reset-form">
    <h2>Resetowanie hasła</h2>
    <p>Wpisz swój adres e-mail, aby zresetować hasło.</p>
    <div class="form-group">
        <label>Kod:</label>
        <input  class="form-control" name="code" required>
        <label>Nowe hasło</label>
        <input type="password" class="form-control" name="password" required>
        <label>Powtórz nowe hasło</label>
        <input type="password" class="form-control" name="password2" required>
    </div>
    <p style="color: red">${message}</p>
    <button type="submit" class="btn btn-primary">Resetuj hasło</button>
</form>
<p>Pamiętaj że:
    <br>
    Hasło nie może mieć mniej niż 6 znaków.
    <br>
    Hasło musi zawierać co najmniej jedną małą literę.
    <br>
    Hasło musi zawierać co najmniej jedną dużą literę.
    <br>
    Hasło musi zawierać co najmniej jedną cyfrę.
    <br>
    Hasło musi zawierać co najmniej jeden znak specjalny (@#$%^&+=).
    </p>

</body>
</html>
