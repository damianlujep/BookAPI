<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>
<table border="1">
    <thead>
    <th>ISBN</th>
    <th>Title</th>
    <th>Author</th>
    <th></th>
    <th></th>
    <th></th>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.isbn}"/></td>
            <td><c:out value="${book.title}"/></td>
            <td><c:out value="${book.author}"/></td>
            <td><a href="/admin/books/edit/${book.id}">Edit</a> </td>
            <td><a href="/admin/books/delete/${book.id}">Delete</a> </td>
            <td><a href="/admin/books/details/${book.id}">Details</a> </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p></p>
<button style="font-weight: bold; color: red" onclick="window.location.href='/admin/books/add';">Dodaj nową książkę</button>
</body>
</html>

