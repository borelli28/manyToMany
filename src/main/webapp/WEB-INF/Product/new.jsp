<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Create Product</title>
</head>
<body>

	<h1>New Product</h1>
	<form:form action="/product" method="post" modelAttribute="product">
	    <p>
	        <form:label path="name">Product Name</form:label>
	        <form:errors path="name"/>
	        <form:input path="name"/>
	    </p>
	     <p>
	        <form:label path="description">Product Description</form:label>
	        <form:errors path="description"/>
	        <form:input path="description"/>
	    </p> 
	     <p>
	        <form:label path="price">Product Price</form:label>
	        <form:errors path="price"/>
	        <form:input type="number" path="price"/>
	    </p> 
	    <input type="submit" value="Create"/>
	</form:form>

</body>
</html>