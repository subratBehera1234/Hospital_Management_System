<%@page import="com.subrat.dto.Doctor"%>
<%@page import="java.util.List"%>
<%@page import="com.subrat.dao.DoctorDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ include file="../components/bootstrap-css.jsp"%>
</head>
<body>
<% DoctorDao doctorDao=new DoctorDao();
List<Doctor> list=doctorDao.fetchAll();

int userId=(int)session.getAttribute("userId");
%>
	<div class="d-flex justify-content-center">
	
	<form action="add_apppointment" method="post">
	<label>Name</label><br>
	<input type="text" name="name"><br><br>
	<label>Age</label><br>
	<input type="number" name="age"><br><br>
	<label>email</label><br>
	<input type="email" name="email"><br><br>
	<label>mobile</label><br>
	<input type="number" name="mobile"><br><br>
	<label>appointmentData</label><br>
	<input type="date" name="appointmentData"><br><br>
	<label>aadhar</label><br>
	<input type="number" name="aadhar"><br><br>
	<label>address</label><br>
	<input type="text" name="address"><br><br>
	<label>Doctor</label><br>
	<select>
	<c:forEach var="d" items="<%=list %>">
	<option value="${d.id}">${d.name}(${d.specialist})</option>
	</c:forEach>
	
	</select>
	<input type="hidden name="userId" value="<%=userId%>">
	</form>
	</div>
</body>
</html>