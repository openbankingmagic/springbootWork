$('#update--submit').on('click', function() {
	var data = {
		id : $('#update--submit').val(),
		title : $('#title').val(),
		content : $('#content').val()
	}

	$.ajax({
		type : 'PUT',
		url : '/post/update',
		data : JSON.stringify(data),
		contentType : "application/json; charset=utf-8",
		dataType : 'json'
	}).done(function(r) {
		if (r.statusCode == 200) {
			alert('수정 성공');
			location.href = '/';
		} else {
			alert('수정 실패');
		}
	}).fail(function(r) {
		alert('수정 실패');
	});

});