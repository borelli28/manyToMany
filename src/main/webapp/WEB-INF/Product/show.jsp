<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
				<th>Categories</th>
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
	
	<h5>Add Category</h5>
	<form:form action="/product/addCat" method="post" modelAttribute="cats">
		<input type="hidden" value="${product.id}" name="product_id"/>
	    <p>
	        <select name="category_id">
	        	<c:forEach items="${cats}" var="cat">
	        		<option value="${cat.id}">${cat.name}</option>
	        	</c:forEach>
	        </select>
	    </p>   
	    <input type="submit" value="Add"/>
	</form:form>
	

</body>
</html>