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
<title>Insert title here</title>
</head>
<body>
	<form id="Form2" action="sys/upload/springUpload" method="post"
		enctype="multipart/form-data">
		<input type="file" name="file"> <input type="submit"
			value="上传" id="uploadimg" />
	</form>

	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	
</body>
</html>