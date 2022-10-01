<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<link rel="stylesheet"
	href="<c:url value="/static/css/member/mypage/mypage.css" />" />

<layout:main title="비밀번호 변경">
	<div class="content">
		<form method="post" action="<c:url value="/mypage/password" />"
			target="ifrmProcess">
			<div class="mybasic">
				<div class="text">현재 비밀번호</div>
				<input type="password" name="pw">
				<div class="text">변경할 비밀번호</div>
				<input type="password" name="pwRe">
				<div class="text">변경 비밀번호 확인</div>
				<input type="password" name="pwReCheck">

				<div class="basicbox">
					<button class="basicBtn1" type="reset">다시 입력</button>
					<button class="basicBtn" type="submit">변경 하기</button>
					<button class="basicBtn">
						<a href="<c:url value="/member/mypage/mypage.jsp"/>">돌아가기</a>
					</button>
				</div>
			</div>
		</form>
	</div>
</layout:main>