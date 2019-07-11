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
<title>北京玖远趣点</title>
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

			<!--***** CONTENT *****-->



			<div class="row">

				<!--***** USER INFO *****-->
				<div class="col-md-12">
						<div class="card-header">
							<h3>
								<i class="fa fa-user-circle"></i> 订单
							</h3>	
							<br/>
							<form action="sys/sysuser/thequery_theorder" method="get">
							<input type="hidden" name="userid" id="userid" value="${userid}">
							
							    <div class="form-group">
                                        <input type="text" name="orderid" class="form-control" id="orderid"  placeholder="订单号" style="width:300px;">
                                  </div>
						         <button type="submit" class="btn btn-general btn-blue mr-2"
								id="but" style="position:absolute;right:650px;top:55px;">查询</button> 
						</form>
						</div>

					 <table class="table table-hover">
                  <thead>
                    <tr class="bg-info text-white">
                      <th>订单号</th>
                       <th>商品个数</th>
                      <th>价格</th>
                      <th>下单时间</th>
                      <th>支付方式</th>
                      <th>支付转态</th>
                      <th>支付时间</th>
                      <th>回调订单号</th>                     
                      <th>发货时间</th>
                      <th>备注</th>
                    </tr>
                  </thead>
                  <c:forEach items="${list}" var="list">
                  <tbody>
                    <tr>
                      <th scope="row"><c:out value="${list.orderid }"></c:out></th>
                      <td><c:out value="${list.num }"></c:out></td>
                      <td><c:out value="${list.pay_price }"></c:out></td>
                      <td><c:out value="${list.ordertime }"></c:out></td>
                       <td>
                       <c:choose>
                       <c:when test="${list.pay_type eq  '0' }"> 銀行卡  </c:when>
                       <c:when test="${ list.pay_type eq  '1'}">  微信 </c:when>
                        <c:otherwise> 支付寶</c:otherwise>
                       </c:choose>
                       </td>
                       <td>
                        <c:choose>
                       <c:when test="${list.status eq  '1' }"> 待支付  </c:when>
                        <c:otherwise> 已支付</c:otherwise>
                       </c:choose>
                       </td>
                       <td><c:out value="${list.paytime }"></c:out></td>
                       <td><c:out value="${list.back_order }"></c:out></td>
                      <td><c:out value="${list.delivertime }"></c:out></td>
                      <td><c:out value="${list.remarks}"></c:out></td>
                    </tr>
                  </tbody></c:forEach>
                </table>
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