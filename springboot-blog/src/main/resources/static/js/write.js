$('#write--submit').on('click', function() {
	var data = {
		title : $('#title').val(),
		content : $('#content').val()
	}

	$.ajax({
		type : 'POST',
		url : '/post/write',
		data : JSON.stringify(data),
		contentType : "application/json; charset=utf-8",
		dataType : 'json'
	}).done(function(r) {
		if (r.statusCode == 200) {
			alert('글쓰기 성공');
			location.href = '/';
		} else {
			alert('글쓰기 실패');
		}
	}).fail(function(r) {
		alert('글쓰기 실패');
	});
});