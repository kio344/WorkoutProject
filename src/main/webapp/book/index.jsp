<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>

<layout:main title="상점">
	<form action="<c:url value="/bookshop" />" method="get" class="bookSearch">
		<div class="searchSelect">
			<label for="type">검색 종류</label> 
			<select name="type" size="1">
				<option ${param.type == "name" ? "selected" : ""} value="name">책이름</option>
				<option ${param.type == "kategorie" ? "selected" : ""}
					value="kategorie">카테고리</option>
				<option ${param.type == "pbulisher" ? "selected" : ""}
					value="publisher">출판사</option>
			</select>
		</div>
		<br>
		<div class="search">
			<input type="text" name="search" placeholder="검색하실 책 이름을 입력해 주세요." onfocus="this.placeholder=''" onblur="this.placeholder='검색하실 책 이름을 입력해 주세요.'"> 
			<input type="hidden" name="page" value="1" />
			<button type="submit" class="searchBtn">검색</button>
		</div>
	</form>
	<c:if test="${empty list }" >
	검색하신 책이 없습니다.
	</c:if>
		
	<c:if test="${!empty list }" >
		<div class="books">
			<c:forEach var="product" items="${list}">
				<a href="<c:url value="/bookshop/product?abnum=${product.abnum }" />">
					<div>
						<table class="book">
							<input disabled="disabled" type="test" value="${product.abnum }" name="abnum" class="displayNone"/>
								<tr class="displayNone">
									<td>${product.seller }</td>
								</tr>
		
								<tr class="displayNone">
									<td>${product.serialnum }</td>
								</tr>
		
								<tr class="bookExp">
									<td>${product.name }</td>
								</tr>
		
								<tr class="bookExp">
									<td>${product.price }원</td>
								</tr>
		
								<tr class="bookExp">
									<td>${product.publisher }</td>
								</tr>
							<tr>
								<td><img alt="${product.name }" src="<c:url value="/productImage/${product.abnum%10}/${product.abnum }" /> " class="bookImg"></td>
							</tr>
						</table>
					</div>
				</a>
			</c:forEach>
		</div>
	<div class="booksPageNum">
		
		<a href="<c:url value="/bookshop?type=${type }&search=${search }&page=1" />">
			<button >&lt;&lt;</button>&nbsp;&nbsp;
		</a>
		   
		
		<c:if test="${param.page - 1 > 0 }">
			<a href="<c:url value="/bookshop?type=${type }&search=${search }&page=${param.page -1 }" />">
				&lt;
			</a>
		</c:if>
		<c:if test="${param.page - 2 > 0 }">
			<a href="<c:url value="/bookshop?type=${type }&search=${search}&page=${param.page -2 }" />" class="bookPageNum">
				${param.page - 2} </a>
		</c:if>

		<c:if test="${param.page - 1 > 0 }">
			<a href="<c:url value="/bookshop?type=${type }&search=${search}&page=${param.page -1 }" />" class="bookPageNum">
				${param.page - 1} </a>
		</c:if>

		<a href="<c:url value="/bookshop?type=${type }&search=${search}&page=${param.page}" />" class="bookPageNum">
			${param.page} </a>

		<c:if test="${totalPage >= param.page + 1 }">
			<a href="<c:url value="/bookshop?type=${type }&search=${search}&page=${param.page + 1}" />" class="bookPageNum">
				${param.page + 1} </a>
		</c:if>

		<c:if test="${totalPage >= param.page + 2}">
			<a href="<c:url value="/bookshop?type=${type}&search=${search}&page=${param.page + 2}" />" class="bookPageNum">
				${param.page + 2} </a>
		</c:if>
		
		<c:if test="${totalPage >= param.page + 1 }">
			<a href="<c:url value="/bookshop?type=${type }&search=${search }&page=${param.page + 1 }" />">
				&gt;&nbsp;&nbsp;
			</a>
		</c:if>
		
		<a href="<c:url value="/bookshop?type=${type }&search=${search }&page=${totalPage }" />">
			<button >&gt;&gt;</button>
		</a>
		
		${param.page} / 총 ${totalPage}페이지
		
	</div>
	</c:if>
</layout:main>
