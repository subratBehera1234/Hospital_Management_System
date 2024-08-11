<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<div class="container-fluid">
		<a class="navbar-brand" href="home.jsp"><i class="fa-solid fa-truck-medical"></i>Mo Hospital</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<%
		String path = request.getContextPath();
		%>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="temp_admin_home"><i class="fa-solid fa-house"></i>Home</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="temp_doctor"><i class="fa-solid fa-user-doctor"></i>Doctor</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="temp_specialist"><i class="fa-solid fa-hospital-user"></i>Specialist</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="#"><i class="fa-solid fa-hospital-user"></i>patient</a></li>
			</ul>
			<div class="dropdown">
				<button class="btn btn-secondary dropdown-toggle" type="button"
					id="dropdownMenuButton1" data-bs-toggle="dropdown"
					aria-expanded="false">Admin</button>
				<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
					<li><a class="dropdown-item" href="#">Log Out</a></li>
				</ul>
			</div>

		</div>
	</div>
</nav>