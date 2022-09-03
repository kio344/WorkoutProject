<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>

<layout:main title="상점">
	<form action="/bookshop" method="post">
		<c:forEach var="item" items="${list}">
			<div>
				<table border="1">
					<tr>
						<td>${item.seller }</td>
					</tr>

					<tr>
						<td>${item.serialnum }</td>
					</tr>

					<tr>
						<td>${item.name }</td>
					</tr>

					<tr>
						<td>${item.price }</td>
					</tr>

					<tr>
						<td>${item.publisher }</td>
					</tr>
					
				</table>
			</div>
		</c:forEach>
	</form>
</layout:main>
