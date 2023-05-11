$("#button1").click(function() {
	$.ajax("/sub35/link1", {method:"post"});
});

$("#button2").click(function(){
	$.ajax("/sub35/link2", {method:"post"});
});

$("#button3").click(function(){
	$.ajax("/sub35/link3", {
		method:"post", 
		data: "name=ppyong"
	});
});

$("#button4").click(function(){
	$.ajax("/sub35/link4", {
		method:"post", 
		data: "address=akita&price=94"
	});
});

$("#button5").click(function(){
	$.ajax("/sub35/link5", {
		method: "post",
		data: "name=명헌&number=4&email=ppyong@gmail.com"
	});
});

$("#button6").click(function(){
	$.ajax("/sub35/link6",{
		method: "post",
		data: "address=akita&product=basketball&price=1.1"
	});
});

$("#button7").click(function() {
	$.ajax("/sub35/link7", {
		method: "post",
		data: '{"name": "ppyong"}',
		contentType: "application/json"
	});
});

$("#button8").click(function(){
	$.ajax("/sub35/link8",{
		method: "post",
		contentType: "application/json",
		data : '{"address" : "akita", "name" : "ppyong"}'
	});
});

$("#button9").click(function(){
	$.ajax("/sub35/link9",{
		method: "post",
		contentType: "application/json",
		data : '{"name" : "ppyong", "age" : 19, "married" : false}'
	});
});

$("#button10").click(function(){
	$.ajax("/sub35/link10",{
		method: "post",
		contentType: "application/json",
		data : '{"address" : null, "age" : 19, "name" : "ppyong"}'
	});
});

$("#button11").click(function(){
	$.ajax("/sub35/link11",{
		method: "post",
		contentType: "application/json",
		data : '{"book" : {"title" : "java", "price" : 300}, "address" : "seoul"}'
	});
});

$("#button12").click(function(){
	$.ajax("/sub35/link12",{
		method: "post",
		contentType: "application/json",
		data : `{"food" : ["pizza", "coke", "coffee"], "store":"pizzaschool"}`
	});
});












