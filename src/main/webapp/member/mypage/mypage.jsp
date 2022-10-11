<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<link rel="stylesheet" href="<c:url value="/static/css/member/mypage/mypage.css" />" />

<layout:main title="마이페이지">
	<div class="content">
		<form method="get" action="<c:url value="/mypage" /> "
			target="ifmProcess">
			<div class="mybasic">
				<div class="text">이름</div>
				<input class="width100" type="text" disabled value="${member.name}">
				<div class="text">별명</div>
				<input class="width100" type="text" value="${member.fakeName}">
				<div class="text">이메일</div>
				<input class="width100" type="email" value="${member.email}">
				<div class="basicbox">
					<button class="basicBtn1">
						<a href="<c:url value="/mypage/basics"/> ">인적사항 변경</a>
					</button>
					<button class="basicBtn">
						<a href="<c:url value="/mypage/password"/> ">비밀번호 변경</a>
					</button>
					<button class="basicBtn">
						<a href="<c:url value="/mypage/withdrawal"/> ">회원 탈퇴</a>
					</button>
				</div>
			</div>
			<!-- 프로필 이미지 넣기 -->
		</form>
	</div>
</layout:main>