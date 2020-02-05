<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정 페이지</title>
</head>
<body>
   <table border="/">
      <tr>
         <th>id</th>
         <th>name</th>
         <th>price</th>
         <th>orderCount</th>
         <th>Type</th>

      </tr>

      <tr>
         <th><input id="id" type="text" value="${pro.id}"></th>
         <th><input id="name" type="text" value="${pro.name}"></th>
         <th><input id="price" type="price" value="${pro.price}"></th>
         <th><input id="ordercount" type="ordercount" value="${pro.ordercount}"></th>
         <th><input id="type" type="text" value="${pro.type}"></th>
      </tr>

   </table>
   <button id="pro_update_proc">수정하기</button>
   <button id="pro_delete_proc">삭제하기</button>

   <script
      src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

   <script>
      $('#pro_update_proc').on('click',function(){
         let data = {
            id: $('#id').val(), 
            name: $('#name').val(), 
            price: $('#price').val(),
            ordercount: $('#ordercount').val(),
            type: $('#type').val()
         };   
         $.ajax({
            type:'PUT',
            url:'/goods/api/update',
            data: JSON.stringify(data),
            contentType: 'application/json; charset=utf-8',
            dataType:'text'
         }).done(function(result){
             console.log(result)
            if(result === 'ok'){
               alert('회원정보 수정 성공');
               location.href='/';
            }else{
               alert('회원정보 수정 실패');
            }
         }).fail(function(result){
               alert('서버 오류');
         });
      });

      $('#pro_delete_proc').on('click', function() {
         let id = $('#id').val()
         $.ajax({
            type : 'DELETE',
            url : '/goods/api/delete/'+id,
   
            dataType : 'text'
         }).done(function(result) {
        	 console.log(result)
            if (result === 'ok') {
               alert('회원정보가 삭제되었습니다.');
               location.href = '/';
            }
         }).fail(function(result) {
             console.log(result)
            alert('회원정보 삭제에 실패하였습니다.');
         });
      });

   </script>
</body>
</html>