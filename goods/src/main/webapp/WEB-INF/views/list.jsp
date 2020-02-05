<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>상품 페이지</title>
</head>
<body>
	<table border="/">
		<tr id="title">
			<th>id</th>
			<th>name</th>
			<th>Price</th>
			<th>orderCount</th>
			<th>Type</th>
		</tr>
		<c:forEach var="pro" items="${pros}">
			<tr class="items">
				<td>${pro.id}</td>
				<td>${pro.name}</td>
				<td>${pro.price}</td>
				<td>${pro.orderCount}</td>
				<td>${pro.type}</td>
			</tr>
		</c:forEach>
	</table>

	<button id="all">전체보기</button>
	<button id="kitchen">주방용품</button>
	<button id="food">음식</button>
	<button id="orderby">가격순</button>
	<button id="orderings">주문수량순</button>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

	<script>
		let option = 0;
       $('#all').on('click', function(){
	
			option = 0;       
         	let type = $('#all').text();
         	$.ajax({
         		type:'GET',
         		url:'/all',
         		dataType:'json'
         	}).done(function(result){
             	console.log(result);
             	$('.items').remove();
         		for(var i of result){
 
         			let item_el = "<tr class='items'><td>"+i.id+
         						  "</td><td>"+i.name+
         						  "</td><td>"+i.price+
         						  "</td><td>"+i.orderCount+
         						  "</td><td>"+i.type+"</td></tr>";
         			console.log(item_el);
         			$('#title').after(item_el);
         		} 

         	}).fail(function(result){

         	});
         });


        $('#kitchen').on('click', function(){

			option = 1;
            
        	let type = $('#kitchen').text();
			console.log(type);
        	
      		$.ajax({
      			type : 'GET',
      			url : '/type/'+type,
      			dataType : 'json'

      		}).done(function(result){
          		console.log(result);
      			$('.items').remove();
      			for(var i of result){
	      			let item_el = "<tr class='items'><td>"+i.id+
	      							 	 "</td><td>"+i.name+
	      								  "</td><td>"+i.price+
	      								  "</td><td>"+i.orderCount+
	      								  "</td><td>"+i.type+"</td></tr>"
	      			$('#title').after(item_el);
      			}
      		}).fail(function(result){

      	  	});
        });
     	 
        $('#food').on('click', function(){

			option = 2;
            
        	let type = $('#food').text();
        	console.log(type);
        	
        	$.ajax({
				type:'GET',
				url:'/type/'+type,
				dataType:'json'
					
            }).done(function(result){
				console.log(result);
				$('.items').remove();
				for(var i of result){
					let item_el = "<tr class='items'><td>"+i.id+
								  "</td><td>"+i.name+
								  "</td><td>"+i.price+
								  "</td><td>"+i.orderCount+
								  "</td><td>"+i.type+"</td></tr>"
					$('#title').after(item_el);			  
        		}

        	 }).fail(function(result){

        	 });
         });
     	 
        $('#orderby').on('click', function(){
         	let type = $('#orderby').text();
         	console.log(type)
         	
         	if (option == 1){
         	
         	$.ajax({
         		type:'GET',
         		url:'/price/주방용품',
         		dataType:'json'
         	}).done(function(result){
             	console.log(result);
             	$('.items').remove();
         		for(var i of result){
 
         			let item_el = "<tr class='items'><td>"+i.id+
         						  "</td><td>"+i.name+
         						  "</td><td>"+i.price+
         						  "</td><td>"+i.orderCount+
         						  "</td><td>"+i.type+"</td></tr>";
         			console.log(item_el);
         			$('#title').after(item_el);
         		} 

         	}).fail(function(result){

         	});
         	}else if (option == 2){
         		$.ajax({
             		type:'GET',
             		url:'/price/음식',
             		dataType:'json'
             	}).done(function(result){
                 	console.log(result);
                 	$('.items').remove();
             		for(var i of result){
     
             			let item_el = "<tr class='items'><td>"+i.id+
             						  "</td><td>"+i.name+
             						  "</td><td>"+i.price+
             						  "</td><td>"+i.orderCount+
             						  "</td><td>"+i.type+"</td></tr>";
             			console.log(item_el);
             			$('#title').after(item_el);
             		} 

             	}).fail(function(result){

             	});

             	}else{
                 	$.ajax({
             		type:'GET',
             		url:'/price/',
             		dataType:'json'
             	}).done(function(result){
                 	console.log(result);
                 	$('.items').remove();
             		for(var i of result){
     
             			let item_el = "<tr class='items'><td>"+i.id+
             						  "</td><td>"+i.name+
             						  "</td><td>"+i.price+
             						  "</td><td>"+i.orderCount+
             						  "</td><td>"+i.type+"</td></tr>";
             			console.log(item_el);
             			$('#title').after(item_el);
             		} 

             	}).fail(function(result){

             	});

                 	}     	
         });

        $('#orderings').on('click', function(){
         	let type = $('#orderings').text();
         	console.log(type)
         	
         	if (option == 1){
         	
         	$.ajax({
         		type:'GET',
         		url:'/order/주방용품',
         		dataType:'json'
         	}).done(function(result){
             	console.log(result);
             	$('.items').remove();
         		for(var i of result){
 
         			let item_el = "<tr class='items'><td>"+i.id+
         						  "</td><td>"+i.name+
         						  "</td><td>"+i.price+
         						  "</td><td>"+i.orderCount+
         						  "</td><td>"+i.type+"</td></tr>";
         			console.log(item_el);
         			$('#title').after(item_el);
         		} 

         	}).fail(function(result){

         	});
         	}else if (option == 2){
         		$.ajax({
             		type:'GET',
             		url:'/order/음식',
             		dataType:'json'
             	}).done(function(result){
                 	console.log(result);
                 	$('.items').remove();
             		for(var i of result){
     
             			let item_el = "<tr class='items'><td>"+i.id+
             						  "</td><td>"+i.name+
             						  "</td><td>"+i.price+
             						  "</td><td>"+i.orderCount+
             						  "</td><td>"+i.type+"</td></tr>";
             			console.log(item_el);
             			$('#title').after(item_el);
             		} 

             	}).fail(function(result){

             	});

             	}else{
                 	$.ajax({
             		type:'GET',
             		url:'/order/',
             		dataType:'json'
             	}).done(function(result){
                 	console.log(result);
                 	$('.items').remove();
             		for(var i of result){
     
             			let item_el = "<tr class='items'><td>"+i.id+
             						  "</td><td>"+i.name+
             						  "</td><td>"+i.price+
             						  "</td><td>"+i.orderCount+
             						  "</td><td>"+i.type+"</td></tr>";
             			console.log(item_el);
             			$('#title').after(item_el);
             		} 

             	}).fail(function(result){

             	});

                 	}  	
         });
   	 
     	 
    </script>
</body>
</html>
