<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>

<layout:main>
	<div class="content">
		<form method="post" action="<c:url value="/mypage/wpc" />"
			target="ifrmProcess">
			<div class="mybasic">
				<div class="text">비밀번호</div>
				<input type="password" name="wpcPw">
				<div class="text">비밀번호 확인</div>
				<input type="password" name="wpcPwCheck">

				<div class="textLast">
					<input class="lastCheck" type="checkbox" name="lastCheck"> <label
						for="lastCheck">정말로 탈퇴를 원하시면 체크하세요.</label>
				</div>
				<div class="basicbox">
					<button class="wpcBtn" type="submit">회원 탈퇴</button>
				</div>
			</div>
		</form>
	</div>
</layout:main>