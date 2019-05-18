<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/mdb.min.css">
<title>Danh sách môn học</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/navbar/navbar.jsp"></jsp:include>
	<div class="container">
		<div class="mt-5">
			<p>Không tồn tại trang bạn yêu cầu</p>
			<a class="btn btn-primary" href="${pageContext.request.contextPath}/">Quay trở về trang chủ</a>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/mdb.min.js"></script>
</body>

</html>