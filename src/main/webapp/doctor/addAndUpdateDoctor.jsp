<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form action="registerAndUpdateDoctor" modelAttribute="doctor">

		<h3>Name:</h3>
		<form:input path="name" />
		<br>
		<br>

		<h3>DOB :</h3>
		<form:input path="dob" type="date" />
		<br>
		<br>

		<h3>:</h3>
		<form:input path="name" type="tel"/>
		<br>
		<br>

		<h3>Specialist :</h3>
		<form:select path="specialist">
			<c:forEach var="spec" items="${list}">
				<form:option value="${spec.name }"></form:option>
			</c:forEach>
		</form:select>
		<br>
		<br>

		<h3>Email :</h3>
		<form:input path="email" type="email" />
		<br>
		<br>

		<h3>Mobile :</h3>
		<form:input path="mobile" type="number" />
		<br>
		<br>

		<h3>password:</h3>
		<form:input path="password" type="password" />
		<br>
		<br>
	
		<form:button>Submit</form:button>
	</form:form>
</body>
</html>