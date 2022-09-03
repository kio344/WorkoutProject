<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>

<layout:main title="상점">
	<form action="<c:url value="/bookshop" />" method="post">
		<c:forEach var="item" items="${list}">
			<a href="<c:url value="/bookshop/product?abnum=${item.abnum }" />" >
				<div>
					<table border="1">
						abnum
						<input disabled="disabled" type="number" value="${item.abnum }" id="abnum" />

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
							<td>${item.price }원</td>
						</tr>

						<tr>
							<td>${item.publisher }</td>
						</tr>

						<tr>
							<td><img alt="${item.name }"
								src="<c:url value="/productImage/${item.abnum%10}/${item.abnum }" /> "></td>
						</tr>

					</table>
				</div>
			</a>
		</c:forEach>
	</form>
</layout:main>
