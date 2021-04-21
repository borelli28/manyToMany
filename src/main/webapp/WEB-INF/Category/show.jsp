<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Show Category</title>
</head>
<body>

	<h1><c:out value="${cat.name}"></c:out></h1>
	
	<table>
		<thead>
			<tr>
				<th>Products</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${myCatProducts}" var="product">
				<tr>
					<td><c:out value="${product.name}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<h5>Add Product to <c:out value="${cat.name}"></c:out></h5>
	<form:form action="/cat/addProduct" method="post" modelAttribute="cats">
		<input type="hidden" value="${cat.id}" name="category_id"/>
	    <p>
	        <select name="product_id">
	        	<c:forEach items="${products}" var="product">
	        		<option value="${product.id}">${product.name}</option>
	        	</c:forEach>
	        </select>
	    </p>   
	    <input type="submit" value="Add"/>
	</form:form>

</body>
</html>