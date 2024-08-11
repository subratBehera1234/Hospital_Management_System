<%@page import="com.subrat.dto.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.subrat.dto.User"%>
<%@page import="com.subrat.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view appointment</title>
<%@ include file="../components/bootstrap-css.jsp"%>
</head>
<body>
	<%@ include file="../components/user_navbar.jsp"%>
	<%
	int userId = (int) session.getAttribute("userId");
	UserDao userDao = new UserDao();
	User user = userDao.fetchUser(userId);
	List<Appointment> list = user.getAppointment();
	%>

	<div class="d-flex justify-content-center">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Age</th>
					<th scope="col">Gender</th>
					<th scope="col">Email</th>
					<th scope="col">Mobile</th>
					<th scope="col">Aadhar</th>
					<th scope="col">Address</th>
					<th scope="col">Appointment Date</th>
					<th scope="col">Disease</th>
					<th scope="col">Doctor</th>
					<th scope="col">Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ap" items="<%=list%>">
					<tr scope="row">
						<td>${ap.name}</td>
						<td>${ap.age}</td>
						<td>${ap.gender}</td>
						<td>${ap.email}</td>
						<td>${ap.mobile}</td>
						<td>${ap.aadhar}</td>
						<td>${ap.address}</td>
						<td>${ap.appointmentDate}</td>
						<td>${ap.disease}</td>
						<td>${ap.doctor.name}</td>
						<td class="bg-warning">${ap.status}</td>
					</tr>

				</c:forEach>

			</tbody>
		</table>

	</div>

</body>
</html>