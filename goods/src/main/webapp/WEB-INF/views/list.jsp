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
			<th>id</th>
			<th>name</th>
			<th>Price</th>
			<th>orderCount</th>
			<th>Type</th>
		</tr>
		<c:forEach var="pro" items="${pros}">
			<tr>
				<th>${pro.id}</th>
				<th>${pro.name}</th>
				<th>${pro.price}</th>
				<th>${pro.ordercount}</th>
				<th>${pro.type}</th>
				<td><button onclick="pro_update(${pro.id})">edit</button></td>
			</tr>
		</c:forEach>
	</table>
	<button onclick="insert()">회원가입</button>
	<button id="pro_insert_proc">전체보기</button>
	<button id="pro_insert_proc">주방용품</button>
	<button id="pro_insert_proc">정육</button>
	<button id="pro_insert_proc">수산물</button>
	<button id="pro_insert_proc">음식</button>
	<button id="pro_insert_proc">가격순</button>
	<button id="pro_insert_proc">주문순</button>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

	<script>
		function insert(){
			location.href='/goods/';
			}
	
		function pro_update(pro_id){
			location.href = '/'+pro_id;	
		}
	</script>
</body>
</html>