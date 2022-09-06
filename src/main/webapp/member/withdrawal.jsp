<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<layout:main title="회원탈퇴 페이지">
<form method="get" action="<c:url value="/mypage/wpc" />" target="ifrmPrecess">
<h1>탈퇴 안내</h1>
<h5>회원탈퇴 안내 사항입니다.</h5>

<span>사용하고 계신 (${member.id})는 탈퇴할 경우 복귀가 불가능합니다.</span>
<span>탈퇴 후 회원 정보는 삭제되지만 회원이 작성한 게시물의 경우 유지 됩니다.<br>삭제를 원하는 게시글이 있다면 탈퇴 전 게시물 삭제 하시길 바랍니다.</span><br>

	<input type="checkbox" name="withdrawal" id="withdrawal">
	<label for="withdrawal">회원 탈퇴 동의</label><br>
	<button type="submit">확인</button>
	
	<button>
	<a href="<c:url value="/index.jsp" /> " >메인으로 돌아가기</a>
	</button>
	
</form>
</layout:main>
