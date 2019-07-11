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
%><base href="<%=basePath%>">
<head>
<meta charset="UTF-8">
<title>上传商品图片 </title>

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
<style>
.main {
	width: 80%;
	margin: auto;
}

* {
	padding: 0;
	margin: 0;
}

.btn {
	padding: 9px 18px;
	background: #40AFFE;
	color: #FFFFFF;
	border-radius: 5px;
}

.upimg {
	position: relative;
	width: 100px;
	height: 100px;
	border-radius: 5px;
	border: dashed #999999;
	background: url(img/addimg.svg) no-repeat;
	background-position: 33px;
}

.upimg input {
	position: absolute;
	width: 100px;
	height: 100px;
	opacity: 0;
}

#showui {
	display: flex;
	justify-content: flex-start;
}

#showui li {
	width: 150px;
	height: 150px;
	position: relative;
	overflow: hidden;
	display: inline-block;
	margin-right: 5px;
}

#showui li img.showimg {
	position: absolute;
	text-align: center;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	z-index: 6;
}

.showdiv {
	position: absolute;
	z-index: 9;
	bottom: 0;
	width: calc(100% - 20px);
	padding: 10px;
	display: flex;
	justify-content: space-around;
	background: rgba(0, 0, 0, .6);
}

.showdiv img {
	width: 20px;
	height: 20px;
	cursor: pointer;
}

#showui li:first-child img.left {
	opacity: .6;
	cursor: no-drop;
}

#showui li:last-child img.right {
	opacity: .6;
	cursor: no-drop;
}

.oneright {
	opacity: .6;
	cursor: no-drop !important;
}
</style>
</head>

<body>


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




				<div class="col-md-12">
					<div class="card form" id="form1">
						<div class="card-header">
							<h3>
								<i class="fa fa-user-circle"></i> 上传商品图片
							</h3>
						</div>
						<br>

						<div class="row">

							<table class="table table-hover">
								<thead>
									<tr class="bg-info text-white">
										<th>#</th>
										<th>图片</th>
										<th>是否为主图</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${ goodsImg.object}" varStatus="idx">
										<tr class="bg-info text-white">
											<td><%-- ${item.picId } --%>${idx.index }</td>
											<td><img alt="img" src="${item.picUrl }"></td>
											<td><c:choose>
													<c:when test="${item.isMain==1 }">是</c:when>
													<c:otherwise>否</c:otherwise>
												</c:choose></td>
											<td>

												<form action="sys/goodsImg/updateImg">
													<input type="hidden" value="${item.picId}" name="picId">
													<input type="hidden" value="${item.goodsId}" name="goodsId">
													<button type="button" onclick="update(${item.picId})"
														class="btn btn-info btn-xs">修改</button>
												</form>
												<form action="sys/goodsImg/deleteImg">
													<input type="hidden" value="${item.picId}" name="picId">
													<input type="hidden" value="${item.goodsId}" name="goodsId">
													<button type="submit" class="btn btn-info btn-xs">删除</button>
												</form>

											</td>
										</tr>

									</c:forEach>
								</tbody>
							</table>
						</div>

						<form action="sys/photoUpload" method="post"
							enctype="multipart/form-data">
							<input type="hidden" value="1" name="picId"> <input
								type="hidden" value="1" name="action"><input
								type="hidden" value="0" name="isMain"> <input
								type="hidden" name="goodsId" value="${goodsId }">
							<div class="row" id="goodsInfo">
								<div class="col-md-6">
									<div class="form-group"></div>
									<div class="form-group">
										<label for="name">商品图片上传</label>
										<div>
											<input type="file" name="file" value="选择图片"/>
										</div>
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

	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<form action="sys/photoUpload" method="post"
				enctype="multipart/form-data">
				<input type="hidden" name="goodsId" value="${goodsId }"> <input
					type="hidden" value="2" name="action"> <input type="hidden"
					value="" name="picId" id="picId">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">修改</h4>
					</div>

					<div class="modal-body">

						<div class="form-group">
							<label for="txt_departmentname">选择图片</label> <input type="file"
								name="file">
						</div>
						<div class="form-group">
							<label for="txt_parentdepartment">是否为主图</label> <input
								type="radio" name="isMain" value="0" checked="checked">否
							<input type="radio" name="isMain" value="1">是
						</div>

					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭
						</button>
						<button type="submit" class="btn btn-general btn-blue mr-2"
							id="but">Submit</button>
					</div>
				</div>
			</form>
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
		$("#btn_add").click(function() {

			$("#myModalLabel").text("新增");

			$('#myModal').modal();

		});

		function update(id) {
			$("#picId").val(id);
			$('#myModal').modal();
		}
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

	<script type="text/javascript">
		Ext
				.onReady(function() {
					Ext
							.create(
									'Ext.form.Panel',
									{
										title : '图片上传',
										width : 600,
										bodyPadding : 10,
										frame : true,
										renderTo : Ext.getBody(),
										items : [ {
											xtype : 'filefield',
											name : 'file',
											fieldLabel : 'Photo',
											labelWidth : 50,
											msgTarget : 'side',
											fileUpload : true,
											allowBlank : false,
											blankText : "Select an image",
											emptyText : 'You can only upload a single PNG 10M or less, JPG, GIF format images',
											anchor : '100%',
											buttonText : '选择图片'
										} ],

										buttons : [ {
											text : '上传',
											handler : function() {
												var form = this.up('form')
														.getForm();
												if (form.isValid()) {
													form
															.submit({
																url : 'sys/photoUpload',
																waitMsg : '正在上传图片...',
																success : function(
																		fp, o) {
																	Ext.Msg
																			.alert(
																					'提示',
																					o.result.msg);
																}
															});
												}
											}
										} ]
									});
				});
	</script>


</body>

</html>