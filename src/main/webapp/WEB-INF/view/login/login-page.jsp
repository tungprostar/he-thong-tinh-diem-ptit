<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">

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
<title>Trang chủ</title>
</head>

<body>
	<section id="body">
		<div class="container mt-5" style="max-width: 400px; margin: 0 auto;">
			<!-- Default form login -->
			<form:form
				class="text-center border border-light p-5 form-horizontal"
				action="${pageContext.request.contextPath}/authenticateUser"
				method="POST">
				<p class="h4 mb-4">Đăng nhập</p>

				<!-- Check for login error -->

				<c:if test="${param.error != null}">
					<div class="alert alert-danger col-xs-offset-1 col-xs-10">
						Thông tin đăng nhập sai.</div>
				</c:if>

				<!-- Check for logout -->

				<c:if test="${param.logout != null}">
					<div class="alert alert-success col-xs-offset-1 col-xs-10">
						Bạn đã đăng xuất.</div>
				</c:if>
				<!-- Username -->
				<input type="text" id="defaultLoginFormEmail" name="username"
					class="form-control mb-4" placeholder="Tài khoản">

				<!-- Password -->
				<input type="password" id="defaultLoginFormPassword" name="password"
					class="form-control mb-4" placeholder="Mật khẩu">

				<div class="d-flex justify-content-around">
					<div>
						<!-- Remember me -->
						<div class="custom-control custom-checkbox">
							<input type="checkbox" class="custom-control-input" name="remember-me"
								id="defaultLoginFormRemember"> <label
								class="custom-control-label" for="defaultLoginFormRemember">Nhớ
								đăng nhập</label>
						</div>
					</div>
				</div>

				<!-- Sign in button -->
				<button class="btn btn-info btn-block my-4" type="submit">Đăng
					nhập</button>

				<!-- Register -->
				<p>
					<a href="${pageContext.request.contextPath}/">Quay lại trang
						chủ</a>
				</p>
			</form:form>
			<!-- Default form login -->
		</div>
	</section>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/mdb.min.js"></script>
</body>

</html>