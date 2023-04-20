<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>
	<div class = "container">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">등 번호</th>
					<th scope="col">입학년도</th>
					<th scope="col">여행일시</th>
					<th scope="col">학교이름</th>
					<th scope="col">점수평균</th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
				<c:forEach items="${love }" var="mylove">
					<tr>
						<td>${mylove.number }</td>
						<td>${mylove.sdate }</td>
						<td>${mylove.trip }</td>
						<td>${mylove.school }</td>
						<td>${mylove.scoreAvg }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>