<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>

<layout:main title="구매페이지">
<form action="<c:url value="/bookshop/payment" />" method="get">
	<div class="item">
		<div class="item_image">
			<img class="bookimage" alt="${dto.name }"
				src="<c:url value="/productImage/${dto.abnum%10}/${dto.abnum }" /> ">
		</div>
		<div class="item_info">
			<div class="book_seller">
				<div class="book_name">
					제품명 <strong> ${dto.name }</strong>
				</div>
					<input type="hidden" name="abnum" value="${dto.abnum }">
				<br>
				<div class="displayNone">판매자 ${dto.seller }</div>
				<br>

				<div class="book_serialnum displayNone">제품코드 ${dto.serialnum }</div>
				<br>

				<div class="book_price"> <input type="hidden" name="price" value="${dto.price }"> 제품가격 ${dto.price }원</div>
				<br>

				<div class="book_publisher">출판사 ${dto.publisher }</div>
				<br>
				<div class="bookCount">수량</div> <input type="number" name="count" value="1" >
				<a href="<c:url value="/book/payment.jsp"/>"><button class="paymentBtn">구입하기</button></a>
			</div>
		</div>
	</div>
</form>
</layout:main>
