<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
<title>Danh sách môn học</title>
</head>

<body>
	<jsp:include page="/WEB-INF/view/navbar/navbar.jsp"></jsp:include>
	<section id="body">
		<div class="container mt-5">
			<form>
				<div class="form-row">
					<div class="form-group col-md-4">
						<form:label path="listMonHoc">Môn học</form:label>
						<form:select path="listMonHoc" id="selectBox1"
							cssClass="form-control" onchange="myFunc1()">
							<form:option value="/monhoc" label="Lựa chọn"></form:option>
							<c:forEach var="item" items="${listMonHoc }">
								<c:url value="/monhoc/${item.maMonHoc }" var="selectedLink1">
								</c:url>
								<c:if test="${empty selectedId }">
									<form:option value="${selectedLink1 }">${item.tenMonHoc }</form:option>
								</c:if>
								<c:if
									test="${not empty selectedId && selectedId != item.maMonHoc}">
									<form:option value="${selectedLink1 }">${item.tenMonHoc }</form:option>
								</c:if>
								<c:if
									test="${not empty selectedId && selectedId == item.maMonHoc}">
									<form:option value="${selectedLink1 }" selected="selected">${item.tenMonHoc }</form:option>
								</c:if>
							</c:forEach>
						</form:select>
					</div>

					<c:if test="${not empty selectedId }">
						<div class="form-group col-md-4">
							<form:label path="listNhomMonHoc">Nhóm</form:label>
							<form:select path="listNhomMonHoc" id="selectBox2"
								cssClass="form-control" onchange="myFunc2()">
								<form:option
									value="${pageContext.request.contextPath}/monhoc/${selectedId }"
									label="Lựa chọn"></form:option>
								<c:forEach var="item" items="${listNhomMonHoc }">
									<c:url value="/monhoc/${selectedId }/${item.nhomMonHoc }" var="selectedLink2">								
									</c:url>
									<c:if test="${empty selectedNhom }">
										<form:option value="${selectedLink2 }">Nhóm ${item.nhomMonHoc }</form:option>
									</c:if>
									<c:if
										test="${not empty selectedNhom && selectedNhom != item.nhomMonHoc}">
										<form:option value="${selectedLink2 }">Nhóm ${item.nhomMonHoc }</form:option>
									</c:if>
									<c:if
										test="${not empty selectedNhom && selectedNhom == item.nhomMonHoc}">
										<form:option value="${selectedLink2 }" selected="selected">Nhóm ${item.nhomMonHoc }</form:option>
									</c:if>
								</c:forEach>
							</form:select>
						</div>
					</c:if>
				</div>
				<a class="btn btn-success px-5" href="/monhoc/dsmh">Reset</a>
			</form>

			<c:if test="${not empty selectedId }">
				<table class="table mt-5 text-center table-bordered ">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Tên môn học</th>
							<th scope="col">Nhóm môn học</th>
							<th scope="col">Giảng viên</th>
							<th scope="col">Số tín chỉ</th>
							<th scope="col">Danh sách sinh viên</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${listMonHocs }" varStatus="count">
							<tr>
								<td class="align-middle">${count.count }</td>
								<td class="align-middle">${item.tenMonHoc }</td>
								<td class="align-middle">${item.nhomMonHoc }</td>
								<td class="align-middle">${item.giangVien }</td>
								<td class="align-middle">${item.soTC }</td>
								<td>
								
									<c:url value="/monhoc/${selectedId }/${item.nhomMonHoc }/dssv" var="urlLink">
<%-- 										<c:param name="maMonHoc" value="${selectedId }"></c:param> --%>
										<c:param name="tenMH" value="${item.tenMonHoc }"></c:param>
<%-- 										<c:param name="nhomMH" value="${item.nhomMonHoc }"></c:param> --%>
										<c:param name="giangVien" value="${item.giangVien }"></c:param>
										<c:param name="cauHinhDiem" value="${cauHinhDiem }"></c:param>
									</c:url>
									<a href="${urlLink }">dssv</a>
									
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</section>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/mdb.min.js"></script>
	<script type="text/javascript">
		function myFunc1() {
			var selectedValue = $('#selectBox1').val();
			location.href = selectedValue;
		};
		function myFunc2() {
			var selectedValue = $('#selectBox2').val();
			location.href = selectedValue;
		};
	</script>
	<script>
		$(document).ready(function() {
			$('#listSubjects').addClass('active');
		});
	</script>
</body>

</html>