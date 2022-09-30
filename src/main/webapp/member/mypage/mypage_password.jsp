<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<link rel="stylesheet" href="<c:url value="/static/css/member/mypage/mypage.css" />"/>

<layout:main title="비밀번호 변경">
	<div class="pt-50">
		<form method="post" action="<c:url value="/mypage/password" />" target="ifrmProcess">
		현재 비밀번호<input type="password" name="pw">
		변경할 비밀번호<input type="password" name="pwRe">
		변경 비밀번호 확인 <input type="password" name="pwReCheck">
		
		<button type="reset">다시 입력</button>
		<button type="submit">변경 하기</button>
		<button ><a href="<c:url value="/member/mypage/mypage.jsp"/>">돌아가기</a></button>
		
		</form>
	</div>
</layout:main>