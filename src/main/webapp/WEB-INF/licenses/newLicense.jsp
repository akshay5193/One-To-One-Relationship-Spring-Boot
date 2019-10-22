<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
		
		<h1>New License</h1>
		<form:form action="/licenses" method="post" modelAttribute="license">
		    
		    <select name="person" >
		    	<c:forEach items="${persons}" var="person">
		    	<c:if test="${person.license.number == null }">
		    	<option value="${person.id}"> ${person.firstName} ${person.lastName }</option>
		    	</c:if>
		    	</c:forEach>
		    </select>
		    
		    <p>
		        <form:label path="state">State: </form:label>
		        <form:errors path="state"/>
		        <form:input path="state"/>
		    </p>
		    <p>
		        <form:label path="expirationDate">Expiration Date: </form:label>
		        <form:errors path="expirationDate"/>
		        <form:input type="date" path="expirationDate"/>
		    </p>


		    <input type="submit" value="Submit"/>
		</form:form>    
		
	</body>
</html>