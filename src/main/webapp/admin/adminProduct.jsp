<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts/admintag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils"%>

<layout:admin>
<div class="pt-50">
	<h1>${test}</h1>
	<div class="search_wrap">
		<form method="get" action="<c:url value="/admin/product" />" autocomplete="off">
			<select id="select" name="select">
				<option ${(param.select == "seller") ? "selected" : "" } value="seller">판매자</option>
				<option ${(param.select == "name") ? "selected" : "" } value="name">제품명</option>
				<option ${(param.select == "kategorie") ? "selected" : "" } value="kategorie">카테고리</option>
				<option ${(param.select == "writer") ? "selected" : "" } value="writer">지은이</option>
				<option ${(param.select == "publisher") ? "selected" : "" } value="publisher">출판사</option>
			</select>
			<input type="text" name="str" placeholder="검색할 단어를 입력해주세요." value="${param.str}">
			<button type="submit">검색</button>
		</form>
	</div>
	<div class="list_title">
		<ul class="list_wrap">
			<li class="list_sub">
				<div>
					<h2>신청 번호</h2>
				</div>
				<div>
					<h2>판매자</h2>
				</div>
				<div>
					<h2>제품 코드</h2>
				</div>
				<div>
					<h2>제품명</h2>
				</div>
				<div>
					<h2>저자</h2>
				</div>
				<div>
					<h2>가격</h2>
				</div>
				<div>
					<h2>제품 카테고리</h2>
				</div>
				<div>
					<h2>출판사</h2>
				</div>
				<div>
					<h2>이미지</h2>
				</div>
				<div>
					<h2>승인 상태</h2>
				</div>
				<div>
					<h2>등록 일시</h2>
				</div>
				<div>
					<h2>승인/미승인</h2>
				</div>
			</li>
			<c:forEach var="product" items="${products}">
				<li class="list_sub">
					<div>
						<h4>${product.abnum}</h4>
					</div>
					<div>
						<h4>${product.seller}</h4>
					</div>
					<div>
						<h4>${product.serialnum}</h4>
					</div>
					<div>
						<h4>${product.name}</h4>
					</div>
					<div>
						<h4>${product.writer}</h4>
					</div>
					<div>
						<h4>${product.price}</h4>
					</div>
					<div>
					<h4>${product.kategorie}</h4>
					</div>
					<div>
					<h4>${product.publisher}</h4>
					</div>
					<div>
					<h4>${product.img}</h4>
					</div>
					<div>
					<h4>${product.status}</h4>
					</div>
					<div>
					<h4>${product.regDt}</h4>
					</div>
					<div>
						<button type="button" id="submit" data-status="true" data-id="${product.abnum}">승인</button>
						<button type="button" id="submit" data-status="false" data-id="${product.abnum}">미승인</button>
					</div>
				</li>
			</c:forEach>
			<c:if test="${total == 0}">
				<li class="list_sub">
					<div>
						<h4>검색한 데이터가 없습니다.</h4>
					</div>
				</li>
			</c:if>
		</ul>
	</div>
	<c:if test="${total != 0}">
		<util:pagination page="${page}" limit="${limit}" url="admin/product?select=${select}&str=${str}" total="${total}" pageCnt="5" />
	</c:if>
	</div>
</layout:admin>