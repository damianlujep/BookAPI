<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Error</title>
</head>
<body>
<p style="text-align: center; color: blue">${url}</p>
<p style="text-align: center; color: red">${errorMessage}</p>
<p style="text-align: center; color: red; font-weight: bold">${exception}</p>
<div align="center">
    <button onclick="window.location.href='/admin/books/all';">Wracaj do listy</button>
</div>
</body>
</html>

