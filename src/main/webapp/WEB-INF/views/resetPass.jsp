<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reset password</title>
    <style>
        <%@include file="/WEB-INF/views/style/reset.css" %>
    </style>
</head>
<body>



<form method="post" class="password-reset-form">
    <h2>Resetowanie hasła</h2>
    <p>Wpisz swój adres e-mail, aby zresetować hasło.</p>
    <div class="form-group">
        <label for="email">Adres e-mail:</label>
        <input type="email" class="form-control" id="email" name="email" required>
    </div>
    <button type="submit" class="btn btn-primary">Resetuj hasło</button>
</form>
</body>
</html>
