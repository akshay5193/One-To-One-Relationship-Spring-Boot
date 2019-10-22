<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>

		<h1>All People</h1>
		<table>
		    <thead>
		        <tr>
		            <th>First Name</th>
		            <th>Last Name</th>
		            <th>License Number</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${persons}" var="person">
		        <tr>
		            <td><c:out value="${person.firstName}"/></td>
		            <td><c:out value="${person.lastName}"/></td>
		            <td><c:out value="${person.license.number}"/></td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
		<a href="/persons/new">New Person</a>
		
	</body>
</html>