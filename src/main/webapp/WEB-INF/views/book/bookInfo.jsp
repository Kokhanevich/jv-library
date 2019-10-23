<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="spring" uri = "http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books info</title>
</head>
<body>
<h1 align="center">Hello from book info page</h1>
<table border="1" align="center">
    <tr>
        <th>Title</th>
        <th>Year</th>
        <th>Prise</th>
        <th>Authors</th>
    </tr>
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
        </tr>
</table>
</body>
</html>
