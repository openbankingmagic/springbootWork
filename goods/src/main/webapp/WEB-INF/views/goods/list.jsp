<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 페이지</title>
</head>
<body>
	<table border="/">
		<tr>
			
			<th>name</th>
			<th>Price</th>
			<th>orderCount</th>
			<th>Type</th>
		</tr>
		
			<tr>
				
				<th><input id="name" type="text" ></th>
				<th><input id="price" type="text" ></th>
				<th><input id="ordercount" type="text" ></th>
				<th><input id="type" type="text" ></th>
			</tr>
		
	</table>
	<button id="pro_insert_proc">상품추가</button>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

	<script>
	$('#pro_insert_proc').on('click', function() {
		let data = {
			name : $('#name').val(),
			price : $('#price').val(),
			ordercount : $('#ordercount').val(),
			type : $('#type').val()

		};
		$.ajax({
			type : 'POST',
			url : '/goods',
			data : JSON.stringify(data),
			contentType : 'application/json; charset=utf-8',
			dataType : 'text'
		}).done(function(result) {
			if (result === 'ok') {
				alert('상품입력 성공');
				location.href = '/';
			} else {
				alert('상품입력 실패');
			}
		}).fail(function(result) {
			alert('서버 오류');
		});
	});
	
		function pro_update(pro_id){
			location.href = '/'+pro_id;	
		}
	</script>
</body>
</html>