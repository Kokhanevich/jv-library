<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Rent books</title>
</head>
<body>
<table border="1" align="center">
    <tr>
        <th>Title</th>
        <th>Year</th>
        <th>Prise</th>
        <th>Authors</th>
        <th>Rent status</th>
        <th>Return book</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>
                    ${book.name}
            </td>
            <td>
                    ${book.year}
            </td>
            <td>
                    ${book.price}
            </td>
            <td> Authors </td>
            <td>${rent.active}</td>
            <td>
                <a href="${pageContext.request.contextPath}/rent/return/${book.id}">return<a/>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/book/all">all books</a>
</body>
</html>
