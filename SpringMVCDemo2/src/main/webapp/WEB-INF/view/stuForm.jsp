<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="processStuForm" modelAttribute="student">
		First Name : <form:input path="fName"/>
		Last Name : <form:input path="lName"/>
		<input type ="submit" value="Submit">
	</form:form>
		
</body>
</html>