<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts/admintag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<layout:admin>
	<div class="list_title">
		<ul class="list_wrap">
			<li class="list_sub">
				<div>
					<h3>신청 번호</h3>
				</div>
				<div>
					<h3>판매자</h3>
				</div>
				<div>
					<h3>제품 코드</h3>
				</div>
				<div>
					<h3>제품명</h3>
				</div>
				<div>
					<h3>가격</h3>
				</div>
				<div>
					<h3>제품 카테고리</h3>
				</div>
				<div>
					<h3>회사명</h3>
				</div>
				<div>
					<h3>이미지</h3>
				</div>
				<div>
					<h3>승인 상태</h3>
				</div>
				<div>
					<h3>등록 일시</h3>
				</div>
				<div>
					<h3>승인/미승인</h3>
				</div>
			</li>
			<c:forEach var="product" items="${products}">
				<li class="list_sub">
					<div>${product.abnum}</div>
					<div>${product.seller}</div>
					<div>${product.serialnum}</div>
					<div>${product.name}</div>
					<div>${product.price}</div>
					<div>${product.kategorie}</div>
					<div>${product.company}</div>
					<div>${product.img}</div>
					<div>${product.status}</div>
					<div>${product.regDt}</div>
					<div>
						<button type="button" id="submit" data-status="true" data-id="${product.abnum}">승인</button>
						<button type="button" id="submit" data-status="false" data-id="${product.abnum}">미승인</button>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</layout:admin>