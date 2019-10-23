<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="spring" uri = "http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
<h1 align="center">Hello from all books page!</h1>
<a href="${pageContext.request.contextPath}/book/add">add book</a>
<br>
<table border="1" align="center">
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Year</th>
        <th>Prise</th>
        <th>Info</th>
        <th>Authors</th>
        <th>Rent book</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="book" items="${allBooks}">
        <tr>
            <td>${book.id}</td>
            <td>
                ${book.name}
            </td>
            <td>
                ${book.year}
            </td>
            <td>
                ${book.price}
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/book/${book.id}">Info<a/>
            </td>
            <td> Authors </td>
            <td>
                <a href="${pageContext.request.contextPath}/rent/getRent?bookId=${book.id}">rent<a/>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/book/delete/${book.id}">DELETE<a/>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/rent/rentedBooks">rented books</a>
</body>
</html>
