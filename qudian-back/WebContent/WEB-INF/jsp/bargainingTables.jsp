
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

			<!--***** CONTENT *****-->
			<div class="row">
				<table class="table table-hover">
					<thead>
						<tr class="bg-info text-white">
							<th>#</th>
							<th>价格类型</th>
							<th>价格</th>
							<th>状态</th>
							<th>备注</th>
							<th>数量</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="item" items="${message.object }" varStatus="idx">
							<tr>
								<th scope="row">
									<%-- ${item.goodsId } --%>${idx.index }</th>
								<td><c:choose>
										<c:when test="${item.priceType==1}">总价</c:when>
										<c:otherwise>单价</c:otherwise>
									</c:choose></td>
								<td>${item.bargainingPrice }</td>
								<td><c:choose>
										<c:when test="${item.bargainingStatus==1}">已成交</c:when>
										<c:otherwise>未成交</c:otherwise>
									</c:choose></td>
								<td>${item.bargainingRemark}</td>
								<td>${item.number}</td>
								<td><c:choose>
										<c:when test="${item.bargainingStatus==1}">已出售</c:when>
										<c:otherwise>
											<form action="sys/goodsBargaining/updatebar">
												<input type="hidden" value="${item.goodsId}" name="goodsId">
												<input type="hidden" value="1" name="bargainingStatus">
												<input type="hidden" value="${item.bargainingId}"
													name="bargainingId">
												<button type="submit" class="btn btn-info btn-xs">卖出</button>
											</form>
										</c:otherwise>
									</c:choose></td>
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
		$("form").submit(function() {
			var falg = confirm("确定要卖出，确定后不可修改");
			return falg;
		})
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