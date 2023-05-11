<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h5>json -> javaBean</h5>
	<!-- button#btn1+br -->
	<button id="btn1">json데이터 전송</button>
	<br />
	
	<button id="btn2">json데이터 전송2</button>
	<br />
	
	<button id="btn3">배열 데이터 전송1</button>
	<br />
	
	<button id="btn4">배열 데이터 전송2</button>
	<br />
	
	<button id="btn5">객체 데이터 전송1</button>
	<br />
	
	<button id="btn6">객체 데이터 전송2</button>
	<br />
	
	<button id="btn7">객체가 아이템인 리스트 데이터 전송1</button>
	<br />
	
	<hr />
	<input type="text" id="inputName" placeholder="이름" /> <br />
	<input type="text" id="inputAge" placeholder="나이"/>
	<button id="btn8">전송</button>
	
	<hr />
	<!-- 하나의 페이지에 같은 id 쓰면 안됨!(inputName) -->
	<!-- json이랑 placeholder는 관계없음 -->
	<input type="text" id="inputName2" placeholder="이름" /> <br />
	<input type="text" id="inputEmail" placeholder="이메일"/> <br />
	<input type="text" id="inputScore" placeholder="점수" /> <br />
	<input type="text" id="inputMarried" placeholder="결혼여부"/>
	<button id="btn9">전송</button>
	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	
	<script src="/js/sub36/ajax.js"></script>

</body>
</html>