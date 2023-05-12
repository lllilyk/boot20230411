<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>

	<h1>ajax 응답 연습</h1>
	<!-- div>button#btn1{ajax요청} -->
	<div>
		<button id="btn1">ajax 요청</button>
	</div>
	<div>
		<button id="btn2">응답코드 연습</button>
	</div>
	<div>
		<button id="btn3">응답코드 연습3</button>
	</div>
	<div>
		<button id="btn4">응답 header 연습</button>
	</div>

	<div>
		<button id="btn5">응답 body 연습</button>
	</div>

	<div>
		<button id="btn6">응답 body 연습2</button>
	</div>
	
	<!-- 응답 본문 : 현재 날짜 -->
	<div>
		<button id="btn7">응답 body 연습3</button>
	</div>
	
	<div>
		<button id="btn8">응답 body 연습4</button>
	</div>
	
	<div>
		<button id="btn9">응답 body 연습5</button>
	</div>
	
	<div>
		<button id="btn10">json을 사용한 응답 body 연습</button>
	</div>
	
	<div>
		<button id="btn11">json을 사용한 응답 body 연습2</button>
	</div>
	
	<div>
		<button id="btn12">map을 사용한 응답 body 연습3</button>
	</div>
	
	<div>
		<button id="btn13">map을 사용한 응답 body 연습4 {"address" : "seoul", "price" : 3.14} </button>
	</div>
	
	<div>
		<button id="btn14">map을 사용한 응답 body 연습5</button>
	</div>
	
	<div>
		<button id="btn15">javabean을 사용한 응답 body 연습1</button>
	</div>
	
	<div>
		<button id="btn16">javabean을 사용한 응답 body 연습2</button>
	</div>
	
	<div>
		<button id="btn17">list을 사용한 응답 body 연습2</button>
	</div>
	
	<div>
		<button id="btn18">list>map을 사용한 응답 body 연습2</button>
	</div>
	
	<div>
		<button id="btn19">list>javabean을 사용한 응답 body 연습2</button>
	</div>
	
	<div>
		<button id="btn20">mapper>list을 사용한 응답 body 연습</button>
	</div>
	
	<div>
		<button id="btn21">mapper>list을 사용한 응답 body 연습2</button>
	</div>
	
	<hr />

	<input type="number" id="categoryIdInput" value="1" />
	<button id="btn22">응답 본문 json from db</button>
	<!-- ul#productList -->
	<ul id="productList">
	
	</ul>
	<hr />
	
	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

	<script src="/js/sub37/response1.js"></script>
</body>
</html>