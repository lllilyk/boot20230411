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
	const obj = {name : "ppyong"};
	
	$.ajax("/sub35/link7", {
		method: "post",
		//data: '{"name": "ppyong"}',
		data: JSON.stringify(obj),
		contentType: "application/json"
	});
});

$("#button8").click(function(){
	const data = {address: "akita", 
				  name:"ppyong"};
	
	$.ajax("/sub35/link8",{
		method: "post",
		contentType: "application/json",
		//data : '{"address" : "akita", "name" : "ppyong"}'
		data: JSON.stringify(data)
	});
});

$("#button9").click(function(){
	const obj = {name: "ppyong",
				 age: 19,
				 married: false};
	
	$.ajax("/sub35/link9",{
		method: "post",
		contentType: "application/json",
		//data : '{"name" : "ppyong", "age" : 19, "married" : false}'
		data : JSON.stringify(obj)
	});
});

$("#button10").click(function(){
	const obj = {
				address: null,
				age: 19,
				name:"ppyong"		
	}
	
	$.ajax("/sub35/link10",{
		method: "post",
		contentType: "application/json",
		//data : '{"address" : null, "age" : 19, "name" : "ppyong"}'
		data : JSON.stringify(obj)
	});
});

$("#button11").click(function() {
	const data = {
				book : {
						title: "java",
						price: 300
				},
				address: "seoul"
	}
	
	$.ajax("/sub35/link11",{
		method: "post",
		contentType: "application/json",
		//data : '{"book" : {"title" : "java", "price" : 300}, "address" : "seoul"}'
		data: JSON.stringify(data)
	})
})

$("#button12").click(function(){
	const data = {
		food:[
			"pizza", 
			"coke",
			"coffee"
		],
		store: "pizzaschool"
	};
	
	$.ajax("/sub35/link12",{
		method: "post",
		contentType: "application/json",
		//data : `{"food" : ["pizza", "coke", "coffee"], "store":"pizzaschool"}`
		data: JSON.stringify(data)
	})
})

$("#button13").click(function(){
	const data = ["pizza", "coke", "coffee"];
	$.ajax("/sub35/link13", {
		method: "post",
		contentType: "application/json",
		//data : `["pizza", "coke", "coffee"]`
		data: JSON.stringify(data)
	})
})

$("#button14").click(function(){
	const data = [
		{
			name: "강백호",
			position: "파워포워드"
		},
		{
			name: "서태웅",
			position: "스몰포워드"
		},
		{
			name: "송태섭",
			position: "포인트가드"
		},
	]
	$.ajax("/sub35/link14", {
		method: "post",
		contentType: "application/json",
		//data : `[{"name":"강백호", "pos":"파포"}, {"name":"서태웅", "pos":"스포"}]`
		data: JSON.stringify(data)
	})
})








