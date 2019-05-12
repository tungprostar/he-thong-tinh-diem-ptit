<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
<title>Cấu hình điểm</title>
</head>

<body>
	<jsp:include page="/WEB-INF/view/navbar/navbar.jsp"></jsp:include>
	<section id="body">
		<div class="container mt-5">
			<c:choose>
				<c:when test="${status == 'OK'}">
					<div class="alert alert-success" role="alert"
						class="bootstrap-alert">Lưu thành công</div>
				</c:when>
				<c:when test ="${status == 'NOT_OK' }">
					<div class="alert alert-danger" role="alert"
						class="bootstrap-alert">Không hợp lệ vui lòng nhập theo định dạng cc/btl/gk/thi và có tổng = 100</div>
				</c:when>
			</c:choose>
			<c:if test="${not empty lst}">
				<div class="accordion" id="cauHinhDiemMonHoc">
					<c:forEach var="tempCauHinh" items="${lst.listCauHinhDiem }"
						varStatus="count">
						<div class="card">
							<div class="card-header" id="heading${count.index }">
								<h2 class="mb-0">
									<button class="btn btn-link" type="button"
										data-toggle="collapse" data-target="#collapse${count.index }"
										aria-expanded="true" aria-controls="collapse${count.index }">
										${tempCauHinh.tenMonHoc}</button>
								</h2>
							</div>

							<div id="collapse${count.index }" class="collapse"
								aria-labelledby="heading${count.index }"
								data-parent="#cauHinhDiemMonHoc">
								<div class="card-body">
									<form:form action="/cauhinh/saveCauHinh" modelAttribute="lst"
										method="POST">
										<input type="hidden" name="countIndex" value="${count.index }">
										<form:hidden path="listCauHinhDiem[${count.index}].maCauHinh" />
										<div class="form-group row">
											<label for="tenMonHoc" class="col-sm-2 col-form-label">Tên
												môn học</label>
											<div class="col-sm-10">
												<input type="text" readonly class="form-control-plaintext"
													id="tenMonHoc" value="${tempCauHinh.tenMonHoc }">
											</div>
										</div>
										<div class="form-group row">
											<label for="soTC" class="col-sm-2 col-form-label">Số
												tín chỉ</label>
											<div class="col-sm-10">
												<input type="text" readonly class="form-control-plaintext"
													id="tenMonHoc" value="${tempCauHinh.soTC }">
											</div>
										</div>
										<div class="form-group row">
											<label for="cauHinh" class="col-sm-2 col-form-label">Cấu
												hình</label>
											<div class="col-sm-10">
												<form:input
													data-toggle="tooltip"
													path="listCauHinhDiem[${count.index}].cauHinhDiem"
													cssClass="form-control check-form" id="cauHinh" title="Chỉ được nhập số hoặc ký tự /"
													placeholder="nhập cấu hình theo định dạng cc/btl/gk/thi" />
											</div>
										</div>
										<div class="d-flex justify-content-center">
											<input type="submit" class="btn btn-success mb-2 px-5"
												value="Lưu">
										</div>
									</form:form>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</c:if>
			<c:if test="${empty lst}">
				<jsp:include page="/WEB-INF/view/ngoaile/nothing.jsp"></jsp:include>
			</c:if>
		</div>
	</section>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/mdb.min.js"></script>
	<script>
		$(document).ready(function() {
			$('[data-toggle="tooltip"]').tooltip(); 
			$('#config').addClass('active');
				  //called when key is pressed in textbox
		 	$(".check-form").keypress(function (e) {
		     //if the letter is not digit then display error and don't type anything
		     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57) && e.which != 47) {
		        e.preventDefault();        
		    }
		   });
		});
		$(".alert").fadeTo(4000, 500).slideUp(500, function(){
		    $(this).alert('close');
		});
	</script>
</body>

</html>