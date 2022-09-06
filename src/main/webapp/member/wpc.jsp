<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<layout:main>
<form method="post" action="<c:url value="/mypage/wpc" />" target="ifrmProcess">

비밀번호<input type="password" name="wpcPw">
비밀번호 확인<input type="password" name="wpcPwCheck">

<div>
<input type="checkbox" name="lastCheck">
<label for="lastCheck">정말로 탈퇴를 원하시면 체크하세요.</label>
</div>

<button type="submit">회원 탈퇴</button>

</form>
</layout:main>