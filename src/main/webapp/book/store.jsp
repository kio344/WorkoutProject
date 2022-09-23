<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>

<layout:main title="구매페이지">
<div class="item">
	<div class="item_image">
		<img alt="${dto.name }" src="<c:url value="/productImage/${dto.abnum%10}/${dto.abnum }" /> ">
	</div>
	<div class="item_info">
		<div class="book_seller">
		
		<div class="book_name">
		제품명
			<strong> ${dto.name }</strong>
		</div>
		<br>
		판매자
			${dto.seller }
		</div>
		<br>
		<div class="book_serialnum">
		제품코드
			${dto.serialnum }
		</div>
		<br>
		<div class="book_price">
		제품가격
			${dto.price }원
		</div>
		<br>
		<div class="book_publisher">
		출판사
			${dto.publisher }
		</div>
	<br>		
	<button>구입하기</button>
	</div>
</div>
</layout:main>
