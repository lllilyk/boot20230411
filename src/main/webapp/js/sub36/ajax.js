// 문자열, 숫자
$("#btn1").click(function(){
	const obj = {
		name : "정대만",
		age: 40
	}
	
	$.ajax("/sub36/link1",{
		method:"post",
		contentType:"application/json",
		data: JSON.stringify(obj)
	})
})

// 불리언
$("#btn2").click(function(){
	const obj1 = {
		name : "이명헌",
		email : "ace@gmail.com",
		score : 100.00,
		married : false
	}
	
	$.ajax("/sub36/link2", {
		method:"post",
		contentType: "application/json",
		data: JSON.stringify(obj1)
	})
})

// 배열
$("#btn3").click(function(){
	const data = {
		name: "태웅",
		hobby: [
			"독서",
			"농구",
			"음악감상"
		]
	}
	$.ajax("/sub36/link3", {
		method: "post",
		contentType: "application/json",
		data:JSON.stringify(data)
	})
})

$("#btn4").click(function(){
	const obj = {
		phone : [
			"apple",
			"samsung",
			"shaomi"
		]
	}
	//btn4버튼을 클릭했을 때 전송요청되는 경로는 /sub36/link4
	$.ajax("/sub36/link4",{
		method: "post",
		contentType: "application/json",
		data: JSON.stringify(obj)
	})
})

// 객체
$("#btn5").click(function(){
	const data = {
		title : "슬덩",
		publisher : "산왕",
		writer : {
			name:"이명헌",
			age:19
		}
	}
	
	$.ajax("/sub36/link5", {
		method: "post",
		contentType: "application/json",
		data: JSON.stringify(data)
	});
})

$("#btn6").click(function(){
	const obj = {
		city: "akita",
		price: 1,
		etc : {
			name:"이명헌",
			email:"no.1ace@gamil.com",
			score:100.00,
			married:false
			}
	}
	
	$.ajax("/sub36/link6",{
		method: "post",
		contentType:"application/json",
		data: JSON.stringify(obj)
	})
})

$("#btn7").click(function(){
	const data = [
		{
			name: "정우성",
			age:18
		},
		{
			name: "최동오",
			age:19
		},
		{
			name: "신현철",
			age:19
		},
	]
	
	$.ajax("/sub36/link7", {
		method: "post",
		contentType:"application/json",
		data: JSON.stringify(data)
	})
})

////////////////////////////////////////////////
$("#btn8").click(function(){
	
	const name = $("#inputName").val();
	const age = $("#inputAge").val();
	
	const data = {
		name : name,
		age : age
	}
	
	$.ajax("/sub36/link1",{
		method:"post",
		contentType:"application/json",
		data:JSON.stringify(data)
	})	
})

$("#btn9").click(function(){
	//jsp에서 inputName이 한 페이지에 2개가 있으면 값이 제대로 못넘어감
	//주의!
	const name = $("#inputName2").val();
	const email = $("#inputEmail").val();
	const score = $("#inputScore").val();
	const married = $("#inputMarried").is(":checked");
	//const married2 = document.querySelector("#inputMarried2").Checked;
	
	const obj = {
		name : name,
		email : email,
		score : score,
		married : married
	}
	
	$.ajax("/sub36/link2",{
		method:"post",
		contentType:"application/json",
		data:JSON.stringify(obj)
	})	
})









