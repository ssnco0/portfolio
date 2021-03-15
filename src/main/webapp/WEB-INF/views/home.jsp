<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Dashboard - SB Admin</title>
<link href="${contextPath}/resources/css/styles.css" rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js"
	crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<a class="navbar-brand" href="${contextPath}/admin">LMM</a>
		<button class="btn btn-link btn-sm order-1 order-lg-0"id="sidebarToggle" href="#">
			<i class="fas fa-bars"></i>
		</button>

		<!-- Navbar-->
		<ul class="navbar-nav ml-auto ml-md-0">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="userDropdown" href="#"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="userDropdown">
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="${contextPath}/admin/logout.do">Logout</a>
				</div>
			</li>
		</ul>
	</nav>
	<div id="layoutSidenav">
		<div id="layoutSidenav">
			<div id="layoutSidenav_nav">
				<nav class="sb-sidenav accordion sb-sidenav-dark"
					id="sidenavAccordion">
					<div class="sb-sidenav-menu">
						<div class="nav">
							<div class="sb-sidenav-menu-heading">Core</div>
							<a class="nav-link" href="${contextPath}/admin">
								<div class="sb-nav-link-icon">
									<i class="fas fa-tachometer-alt"></i>
								</div> 대시보드
							</a>
							<div class="sb-sidenav-menu-heading">Interface</div>
							<a class="nav-link collapsed" href="#" data-toggle="collapse"
								data-target="#User" aria-expanded="false" aria-controls="User">
								<div class="sb-nav-link-icon">
									<i class="fas fa-columns"></i>
								</div> 사용자 관리
								<div class="sb-sidenav-collapse-arrow">
									<i class="fas fa-angle-down"></i>
								</div>
							</a>
							<div class="collapse" id="User" aria-labelledby="headingOne"
								data-parent="#sidenavAccordion">
								<nav class="sb-sidenav-menu-nested nav">
									<a class="nav-link" href="${contextPath}/admin/member/listMembers.do">일반 사용자</a> <a
										class="nav-link" href="${contextPath}/admin/member/StorelistMembers.do">가맹점</a>
								</nav>
							</div>
							<a class="nav-link collapsed" href="#" data-toggle="collapse"
								data-target="#Mileage" aria-expanded="false"
								aria-controls="Mileage">
								<div class="sb-nav-link-icon">
									<i class="fas fa-columns"></i>
								</div> 마일리지 관리
								<div class="sb-sidenav-collapse-arrow">
									<i class="fas fa-angle-down"></i>
								</div>
							</a>
							<div class="collapse" id="Mileage" aria-labelledby="headingOne"
								data-parent="#sidenavAccordion">
								<nav class="sb-sidenav-menu-nested nav">
									<a class="nav-link" href="${contextPath}/admin/mileage/Mileage.do">사용자 마일리지</a> <a
										class="nav-link" href="${contextPath}/admin/mileage/StoreMileage.do">가맹점 마일리지</a>
								</nav>
							</div>
							<a class="nav-link collapsed" href="#" data-toggle="collapse"
								data-target="#Cupon" aria-expanded="false" aria-controls="Cupon">
								<div class="sb-nav-link-icon">
									<i class="fas fa-columns"></i>
								</div> 쿠폰 관리
								<div class="sb-sidenav-collapse-arrow">
									<i class="fas fa-angle-down"></i>
								</div>
							</a>
							<div class="collapse" id="Cupon" aria-labelledby="headingOne"
								data-parent="#sidenavAccordion">
								<nav class="sb-sidenav-menu-nested nav">
									<a class="nav-link" href="${contextPath}/admin/cupon/SearchUseCupon.do">사용자 쿠폰 관리</a> <a
										class="nav-link" href="${contextPath}/admin/cupon/SelectNoAppCupon.do">가맹점 쿠폰	승인</a>
								</nav>
							</div>

							<div class="sb-sidenav-menu-heading">Addons</div>
							<a class="nav-link" href="#">
								<div class="sb-nav-link-icon">
									<i class="fas fa-chart-area"></i>
								</div> Charts
							</a> <a class="nav-link" href="#">
								<div class="sb-nav-link-icon">
									<i class="fas fa-table"></i>
								</div> Tables
							</a>
						</div>
					</div>
					<div class="sb-sidenav-footer">
						<div class="small">Logged in as:</div>
						LMM
					</div>
				</nav>
			</div>

		</div>
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid">
					<h1 class="mt-4">대시보드</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item active">대시보드</li>
					</ol>
					<div class="row">
						<div class="col-xl-6">
							<div class="card mb-4">
								<div class="card-header">
									<i class="fas fa-chart-area mr-1"></i> Area Chart Example
								</div>
								<div class="card-body">
									<canvas id="myAreaChart" width="100%" height="40"></canvas>
								</div>
							</div>
						</div>
						<div class="col-xl-6">
							<div class="card mb-4">
								<div class="card-header">
									<i class="fas fa-chart-bar mr-1"></i> Bar Chart Example
								</div>
								<div class="card-body">
									<canvas id="myBarChart" width="100%" height="40"></canvas>
								</div>
							</div>
						</div>
					</div>
					<div class="card-body">
							<div class="table-responsive">
								<table class="table table-borderless" id="dataTable" width="100%" cellspacing="0">
									<thead>
										<tr align="center">
											<td><b>사용자아이디</b></td>
											<td><b>총 적립 마일리지</b></td>
											<td><b>총 사용 마일리지</b></td>
										</tr>
									</thead>
				
									<tbody>
										<c:forEach var="member" items="${MemberList}">
											<tr align="center">
												<td>${member.cusid}</td>
												<td>${member.summilstack}</td>
												<td>${member.sumusemil}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
				</div>
			</main>
			<footer class="py-4 bg-light mt-auto">
				
			</footer>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="${contextPath}/resources/js/scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<script src="${contextPath}/resources/assets/demo/chart-area-demo.js"></script>
	<script src="${contextPath}/resources/assets/demo/chart-bar-demo.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
		crossorigin="anonymous"></script>
	<script src="${contextPath}/resources/assets/demo/datatables-demo.js"></script>
</body>
</html>

