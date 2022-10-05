<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>

<layout:main title="마이페이지">
	<div class="content">
		<form method="post" action="<c:url value="/mypage/basics" />" target="ifrmProcess">
			<div class="mybasic">
				<div class="text">아이디</div> <input class="width100" type="text" disabled name="idRe" value="${member.id}">
				<div class="text">이름</div> <input class="width100" type="text" name="nameRe" value="${member.name}">
				<div class="text">별명</div> <input class="width100" type="text" name="fakeNameRe" value="${member.fakeName}">
				<div class="text">이메일</div> <input class="width100" type="email" name="emailRe" value="${member.email}">
				<div class="text">전화번호</div> <input class="width100" type="number" name="mobileRe" value="${member.mobile}">
				<div class="text">주소</div> <input class="width100" type="text" name="addressRe" value="${member.address}">
				<div class="text">생년월일</div> <div class="flex"><util:selectBirth /></div>

				<div class="basicbox">
					<button class="basicBtn1" type="reset">다시하기</button>
					<button class="basicBtn" type="submit">수정하기</button>
					<button class="basicBtn">
						<a href="<c:url value="/member/mypage/mypage.jsp"/>">돌아가기</a>
					</button>
				</div>
			</div>
		</form>
	</div>
</layout:main>