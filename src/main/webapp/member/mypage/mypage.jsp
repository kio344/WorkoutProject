<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<link rel="stylesheet" href="<c:url value="/static/css/member/mypage/mypage.css" />"/>

<layout:main title="마이페이지">
	<div class="pt-50">
		<form method="get" action="<c:url value="/mypage" /> " target="ifmProcess" >
		이름 <input type="text" disabled value="${member.name}">
		별명 <input type="text" value="${member.fakeName}">
		이메일 <input type="email" value="${member.email}">
		
		<button><a href="<c:url value="/mypage/basics"/> " >인적사항 변경</a></button>
		<button><a href="<c:url value="/mypage/password"/> " >비밀번호 변경</a></button>
		<button><a href="<c:url value="/mypage/withdrawal"/> " >회원 탈퇴</a></button>
		
		<!-- 프로필 이미지 넣기 -->
		
		</form>
	</div>
</layout:main>