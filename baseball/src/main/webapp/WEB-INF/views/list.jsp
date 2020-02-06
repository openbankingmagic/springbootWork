<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../include/nav.jsp"%>
<div class="container">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>tid</th>
				<th>teamname</th>
				<th>createDate</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="teams" items="${teams }" varStatus="status">
			<tr class = "team">
				<td>${teams.tid }</td>
				<td>${teams.teamname }</td>
				<td>${teams.createDate }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<%@include file="../include/footer.jsp"%>