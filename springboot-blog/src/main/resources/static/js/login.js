/**
 * 
 */
$('#login--submit').on('click', function(e) {
	// e.preventDefault();
	var data = {
		username : $('#username').val(),
		password : $('#password').val()
	};

	$.ajax({
		type : 'POST',
		url : '/user/loginProc',
		data : data, // username=ssar&password=1234
		contentType : 'application/x-www-form-urlencoded',
		dataType : 'json'
	}).done(function(r) {
		alert(r.statusCode);
		console.log(r);
		console.log(r.statusCode);
		alert("로그인 성공");
		location.href = '/';
	}).fail(function(r) {
		console.log(r);
		alert("로그인 실패");
	});
});

// 엔터키 치면 바로 로그인 되게
$("#password").keydown(function(key) {
	if (key.keyCode == 13) {// 키가 13이면 실행 (엔터는 13)
		$('#login--submit').click();
	}
});