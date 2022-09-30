<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>
<link rel="stylesheet" href="<c:url value="/static/css/member/mypage/mypage.css" />"/>

<layout:main title="마이페이지">
	<div class="pt-50">
		<form method="post" action="<c:url value="/mypage/basics" />" target="ifrmProcess">
		
		아이디 <input type="text" disabled name="idRe" value="${member.id}">
		이름 <input type="text" name="nameRe" value="${member.name}">
		별명 <input type="text" name="fakeNameRe" value="${member.fakeName}">
		이메일 <input type="email" name="emailRe" value="${member.email}">
		전화번호 <input type="number" name="mobileRe" value="${member.mobile}">
		주소 <input type="text" name="addressRe" value="${member.address}">
		생년월일 <util:selectBirth />
		
		
		<button type="reset">다시하기</button>
		<button type="submit">수정하기</button>
		<button ><a href="<c:url value="/member/mypage/mypage.jsp"/>">돌아가기</a></button>
		</form>
	</div>
</layout:main>