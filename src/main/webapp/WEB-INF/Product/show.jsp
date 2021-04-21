<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Show Product</title>
</head>
<body>

	<h1><c:out value="${product.name}"></c:out></h1>
	
	<table>
		<thead>
			<tr>
				<th>Products</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productCats}" var="cat">
				<tr>
					<td><c:out value="${cat.name}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>