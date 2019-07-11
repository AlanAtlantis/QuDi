
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="all,follow">
<base href="<%=basePath%>">
<title>北京玖远趣点</title>
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

	<!--====================================================
                        PAGE CONTENT
======================================================-->
	<div class="page-content d-flex align-items-stretch">

		<!--***** SIDE NAVBAR *****-->
		<nav class="side-navbar">
			<div class="sidebar-header d-flex align-items-center">
				<!-- <div class="avatar">
					<img src="img/avatar-1.jpg" alt="..."
						class="img-fluid rounded-circle">
				</div> -->
				<div class="title">
					<h1 class="h4">${sysLogin.username }</h1>
				</div>
			</div>
			<hr>
			<jsp:include page="include/left_nav.jsp"></jsp:include>
			<span class="heading">Extras</span>
			<ul class="list-unstyled">
				<li><a href="#"> <i class="icon-picture"></i>Demo
				</a></li>
			</ul>
		</nav>

		<div class="content-inner chart-cont">

			<!--***** CONTENT *****-->



			<div class="row">

				<!--***** USER INFO *****-->
				<div class="col-md-12">
					<div class="card form" id="form1">
						<div class="card-header">
							<h3>
								<i class="fa fa-user-circle"></i> 添加店铺
							</h3>
						</div>
						<br>
						<form action="sys/shop/addShop" id="form">
							<div class="row" id="goodsInfo">
								<div class="col-md-6">
									<div class="form-group">
										<label for="name">店铺名称</label> <input type="text"
											class="form-control" id="shopName"
											aria-describedby="emailHelp" name="shopName">
									</div>


								</div>


							</div>


							<button type="submit" class="btn btn-general btn-blue mr-2"
								id="but">Submit</button>
							<button type="reset" class="btn btn-general btn-white">Cancel</button>
						</form>
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
	<script src="${pageContext.request.contextPath}/js/front.js"></script>
	<script src="${pageContext.request.contextPath}/js/ajaxfileupload.js"></script>

	<script type="text/javascript">
	
	
		$("#form")
				.submit(
						function() {
							var shopName = $("#shopName").val();

							if (shopName.length <= 0) {
								console.log("店铺名称为空");
								$(".sys-infor").remove();
								$("#shopName")
										.after(
												"<p class='sys-infor' style='color: #ea0a0a;'>必须输入店铺名称</p>");
								return false;
							}

							return true;
						})
	</script>

	<!--Core Javascript -->

	<!-- 百度富文本 -->
	<script type="text/javascript" charset="utf-8"
		src="${pageContext.request.contextPath}/thirdparts/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="${pageContext.request.contextPath}/thirdparts/ueditor/ueditor.all.min.js">
		
	</script>

	<script type="text/javascript" charset="utf-8"
		src="${pageContext.request.contextPath}/thirdparts/ueditor/lang/zh-cn/zh-cn.js"></script>

	<script type="text/javascript">
		var ue = UE.getEditor('detailsDescribe');
		//根据不同action上传图片和附件
		UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
		UE.Editor.prototype.getActionUrl = function(action) {
			if (action == 'uploadimage') {
				return '${pageContext.request.contextPath}/sys/upload/uploadimage';
			} else if (action == 'uploadfile') {
				return '${pageContext.request.contextPath}/upload/uploadfile';
			} else {
				return this._bkGetActionUrl.call(this, action);
			}
		}
	</script>


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