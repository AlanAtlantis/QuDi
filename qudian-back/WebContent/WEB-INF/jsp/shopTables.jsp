
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%><base href="<%=basePath%>">
<title>Insert title here</title>

<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/img/favicon.ico">

<!-- global stylesheets -->
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/font-icon-style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.default.css"
	id="theme-stylesheet">
<link href="${pageContext.request.contextPath}/css/toastr.css"
	rel="stylesheet" />
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
							<div class="brand-text brand-big hidden-lg-down">
								玖远趣点
							</div>
					</div>
				</div>
			</div>
		</nav>
	</header>

	<!--====================================================
                        PAGE CONTENT
======================================================-->
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
			<form action="sys/shop/addPage">
				<button type="submit" class="btn btn-info btn-xs">添加店铺</button>
			</form>
			<!--***** CONTENT *****-->
			<div class="row">
				<table class="table table-hover">
					<thead>
						<tr class="bg-info text-white">
							<th>#</th>
							<th>店铺名称</th>
							<th>店铺状态</th>
							<th>店铺等级</th>
							<th>创建时间</th>

							<th>操作</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="item" items="${shop.object }" varStatus="idx">
							<tr>
								<th scope="row">
									<%-- ${item.goodsId } --%>${idx.index }</th>
								<td>${item.shopName }</td>
								<td><c:choose>
										<c:when test="${item.shopStatus==1}">已认证</c:when>
										<c:when test="${item.shopStatus==0}">未认证</c:when>
										<c:otherwise>违规关闭</c:otherwise>
									</c:choose></td>

								<td>${item.shopLevel}</td>
								<td>${item.createTime}</td>

								<td>

									<form action="sys/shop/updatePage">
										<input type="hidden" value="${item.shopId}" name="shopId">

										<button type="submit" class="btn btn-info btn-xs">修改</button>
									</form>
									<form action="sys/shop/deleteShop">
										<input type="hidden" value="${item.shopId}" name="shopId">

										<button type="submit" class="btn btn-info btn-xs">删除</button>
									</form>
								</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
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

	<script type="text/javascript">
		
	</script>

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