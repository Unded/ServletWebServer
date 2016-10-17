<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All Products</title>
</head>
<body>
<h3>Data Base contains: </h3>
<ul>
    <c:forEach items="${productList}" var="product">
                Id: ${product.id}, Name: ${product.name}<br>
    </c:forEach>
</ul>
<br/>
<a href="index.jsp">Main page</a>
</body>
</html>
