
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %><html>

<head>
    <title>Edit Book Form</title>
</head>
<body>
<form:form method="post" modelAttribute="bookModel">
    <div>
        <label for="isbn">ISBN</label>
        <form:input path="isbn" value="${bookToEdit.isbn}"/>
        <form:errors path="isbn" cssStyle="color: red; font-weight: bold "/><br/>
    </div>
    <div>
        <label for="title">Tittle</label>
        <form:input path="title" value="${bookToEdit.title}"/>
        <form:errors path="title" cssStyle="color: red; font-weight: bold "/><br/>
    </div>
    <div>
        <label for="author">Author</label>
        <form:input path="author" value="${bookToEdit.author}"/>
        <form:errors path="author" cssStyle="color: red; font-weight: bold "/><br/>
    </div>
    <div>
        <label for="publisher">Publisher</label>
        <form:input path="publisher" value="${bookToEdit.publisher}"/>
        <form:errors path="publisher" cssStyle="color: red; font-weight: bold "/><br/>
    </div>
    <div>
        <label for="type">Type</label>
        <form:input path="type" value="${bookToEdit.type}"/>
        <form:errors path="type" cssStyle="color: red; font-weight: bold "/><br/>
    </div>

    <input type="submit" value="Save Changes">
</form:form>

<button style="color: red" onclick="window.location.href='/admin/books/all';">Wracaj do listy</button>

</body>
</html>
