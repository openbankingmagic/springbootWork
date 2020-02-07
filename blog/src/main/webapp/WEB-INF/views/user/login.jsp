<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../include/nav.jsp"%>

<div class="container">

	<form>
		<div class="form-group">
			<label for="username">유저네임</label> <input type="text" class="form-control" placeholder="Enter Username" id="username">
		</div>
		<div class="form-group">
			<label for="password">패스워드</label> <input type="password" class="form-control" placeholder="Enter password" id="password">
		</div>

	</form>

	<button id="login--submit" class="btn btn-primary">로그인</button>

</div>

<script>
	$('#login--submit').on('click',function(){
		//e.preventDefault(); <-a 태그등 다양한 곳에 쓰임 , 버튼이 가지는 해당 태그가 가지는 이벤트 작동 못하게 날릴수 있음
		var data = {
			username: $('#username').val(),
			password: $('#password').val()
		};

		$.ajax({
			type:'POST',
			url:'/user/login',
			data:JSON.stringify(data),
	        contentType : 'application/json; charset=utf-8', 
	        dataType:'json'
		}).done(function(r){
			alert("로그인 성공");
			location.href='/';
			console.log(r);
		}).fail(function(r){
			alert("로그인 실패");
			console.log(r);
	    });
	});
	
</script>

<%@include file="../include/footer.jsp"%>