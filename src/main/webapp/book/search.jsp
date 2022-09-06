<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>

<layout:main title="검색 페이지">
<c:forEach var="books" items="${bookList}">
	<table border="1">
	
		<tr>
			<td>${books.seller }</td>
		</tr>

		<tr>
			<td>${books.serialnum }</td>
		</tr>

		<tr>
			<td>${books.name }</td>
		</tr>

		<tr>
			<td>${books.price }원</td>
		</tr>

		<tr>
			<td>${books.publisher }</td>
		</tr>

		<tr>
			<td><img alt="${books.name }"
				src="<c:url value="/productImage/${books.abnum%10}/${books.abnum }" /> "></td>
		</tr>

	</table>
</c:forEach>

</layout:main>
