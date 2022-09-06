<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>

<layout:main title="상점">
	<form action="<c:url value="/bookshop" />" method="get">
		<label for="type">검색 종류</label>
		<select name="type" size="1">
		<option ${param.type == "name" ? "selected" : ""} value="name">책이름</option>
		<option ${param.type == "kategorie" ? "selected" : ""} value="kategorie">카테고리</option>
		<option ${param.type == "pbulisher" ? "selected" : ""} value="publisher">출판사</option>
		</select><br>
		검색<input type="text" name="search">
		<button type="submit">검색</button>
		<c:if test="${empty bookList}">
			<c:forEach var="product" items="${list}">
				<a href="<c:url value="/bookshop/product?abnum=${product.abnum }" />">
					<div>
						<table border="1">
							abnum
							<input disabled="disabled" type="number"
								value="${product.abnum }" name="abnum" />

							<tr>
								<td>${product.seller }</td>
							</tr>

							<tr>
								<td>${product.serialnum }</td>
							</tr>

							<tr>
								<td>${product.name }</td>
							</tr>

							<tr>
								<td>${product.price }원</td>
							</tr>

							<tr>
								<td>${product.publisher }</td>
							</tr>

							<tr>
								<td><img alt="${product.name }"
									src="<c:url value="/productImage/${product.abnum%10}/${product.abnum }" /> "></td>
							</tr>

						</table>
					</div>
				</a>
			</c:forEach>
			<div>
			<c:if test="${param.page -2 > 0 }">
			
			<a href="<c:url value="/bookshop?page=${param.page -2 }" />">
				${param.page - 2}
			</a>
			</c:if>
						
			<c:if test="${param.page -1 > 0 }">
			<a href="<c:url value="/bookshop?page=${param.page - 1}" />">
				${param.page - 1} 
			</a>
			
			</c:if>
			
			<a href="<c:url value="/bookshop?page=${param.page }" />" >
			${param.page}
			</a>
							
			<c:if test="${totalPage >= param.page + 1 }" >
			<a href="<c:url value="/bookshop?page=${param.page + 1}" />">
				${param.page + 1} 
			</a>
			</c:if>
			
			<c:if test="${totalPage >= param.page + 2}">
			<a href="<c:url value="/bookshop?page=${param.page + 2}" />">
				${param.page + 2} 
			</a>
			</c:if>
			</div>
		</c:if>
		<c:if test="${!empty bookList }">
			<c:forEach var="books" items="${bookList}">
				<a href="<c:url value="/bookshop/product?abnum=${books.abnum }" />">
					<div>
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
					</div>
			</c:forEach>
		</c:if>
	</form>
</layout:main>
