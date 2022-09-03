<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>

<layout:main title="구매페이지">

	<table border="1">
		<tr>
			<td>${dto.seller }</td>
		</tr>

		<tr>
			<td>${dto.serialnum }</td>
		</tr>

		<tr>
			<td>${dto.name }</td>
		</tr>

		<tr>
			<td>${dto.price }원</td>
		</tr>

		<tr>
			<td>${dto.publisher }</td>
		</tr>

		<tr>
			<td><img alt="${dto.name }"
				src="<c:url value="/productImage/${dto.abnum%10}/${dto.abnum }" /> "></td>
		</tr>

	</table>

</layout:main>
