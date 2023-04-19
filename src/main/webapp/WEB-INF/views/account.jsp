<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: olik0
  Date: 18.04.2023
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zarządzaj kontem</title>
    <style>
        <%@include file="/WEB-INF/views/style/style.css" %>
    </style>
</head>
<body>
<div class="header">
    <a href="/">Strona główna</a>
    <a href="/logout">Wyloguj się</a>
</div>
<div class="table-wrapper">
    <h2 style="text-align: left">Twoje pupile:</h2>
    <table>
        <thead>
        <tr>
            <th>Imię</th>
            <th>Opis</th>
            <th>Typ</th>
            <th>Liczba polubień</th>
            <th>Usuń</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pets}" var="pet">
            <tr>
                <td>${pet.name}</td>
                <td>${pet.description}</td>
                <td>${pet.type}</td>
                <td>${pet.rating}</td>
                <td>
                    <form method="post">
                        <input formaction="/delete/${pet.id}" type="submit" class="style-submit" value="🗑️"
                               style="background-color: transparent;
                            font-size: 30px;
                            outline: none;
                            padding: 0;">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="tab-sidebar"></div>
</div>

</body>
</html>
