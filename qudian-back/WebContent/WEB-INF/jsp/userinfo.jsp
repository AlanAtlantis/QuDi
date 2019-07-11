<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="all,follow">
<title>北京玖远趣点用戶信息頁面</title>
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/img/favicon.ico">

<!-- global stylesheets -->

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/font-icon-style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.default.css"
	id="theme-stylesheet">

<!-- Core stylesheets -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/pages/register.css">
</head>

<body>

	<!--====================================================
                         MAIN NAVBAR
======================================================-->
	<header class="header">
		<nav class="navbar navbar-expand-lg ">
			<div class="search-box">
				<button class="dismiss">
					<i class="icon-close"></i>
				</button>
				<form id="searchForm" action="#" role="search">
					<input type="search" placeholder="Search Now" class="form-control">
				</form>
			</div>
			<div class="container-fluid ">
				<div
					class="navbar-holder d-flex align-items-center justify-content-between">
					<div class="navbar-header">
							<div class="brand-text brand-big hidden-lg-down">玖远趣点</div>
					</div>
				</div>
			</div>
		</nav>
	</header>

	<div class="page-content d-flex align-items-stretch">

		<!--***** SIDE NAVBAR *****-->
		<nav class="side-navbar">
			<div class="sidebar-header d-flex align-items-center">

				<div class="title">
					<h1 class="h4">${sysLogin.username }</h1>
				</div>
			</div>
			<hr>
			<jsp:include page="include/left_nav.jsp"></jsp:include>
		</nav>

		<div class="content-inner chart-cont">

			<div class="row">
				<!--***** USER INFO *****-->
				<div class="col-md-12">
					<div class="card form" id="form1">
						<div class="card-header">
							<h3>
								<i class="fa fa-user-circle"></i> 用户個人信息
							</h3>
						</div>
						<br>
							<div class="row" id="id">
								<div class="col-md-6">
								<c:forEach items="${listUserinfo}" var="list">
									<div class="form-group" style="position:relative;right:-20px; " >
										<label for="name">用户名：</label>&nbsp;&nbsp;&nbsp;${list.username} <br/>
						                <label for="name">密码：</label>&nbsp;&nbsp;&nbsp;${list.password} <br/>
								        <label for="name">电话：</label>&nbsp;&nbsp;&nbsp;${list.phone} <br/>
							            <label for="name">税号：</label>&nbsp;&nbsp;&nbsp;${list.dutyparagraph} <br/>
							         	<label for="name">邮箱：</label>&nbsp;&nbsp;&nbsp;${list.email} <br/>
							            <label for="name">生日：</label>&nbsp;&nbsp;&nbsp;${list.birthday} <br/>
										<label for="name">地址：</label>&nbsp;&nbsp;&nbsp;${list.address} <br/>
								        <label for="name">营业执照：</label>&nbsp;&nbsp;&nbsp;${list.businesslicense} <br/>
										<label for="name">银行卡号：</label>&nbsp;&nbsp;&nbsp;${list.bankcard} <br/>
								        <label for="name">创建时间：</label>&nbsp;&nbsp;&nbsp;${list.createdate} <br/>
										<label for="name">备注：</label>&nbsp;&nbsp;&nbsp;${list.remarks} <br/>
										</div>
										</c:forEach>
								</div>
								
							</div>
					</div>
				</div>
			</div>

		</div>
	</div>

	<!--Global Javascript -->
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/popper/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/tether.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.cookie.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/chart.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/front.js"></script>
	<script src="${pageContext.request.contextPath}/js/toastr.min.js"></script>

	<!--Core Javascript -->
	<script>
		new Chart(document.getElementById("myChart-nav").getContext('2d'), {
			type : 'doughnut',
			data : {
				labels : [ "M", "T", "W", "T", "F", "S", "S" ],
				datasets : [ {
					backgroundColor : [ "#2ecc71", "#3498db", "#95a5a6",
							"#9b59b6", "#f1c40f", "#e74c3c", "#34495e" ],
					data : [ 12, 19, 3, 17, 28, 24, 7 ]
				} ]
			},
			options : {
				legend : {
					display : false
				},
				title : {
					display : true,
					text : ''
				}
			}
		});
	</script>
</body>

</html>