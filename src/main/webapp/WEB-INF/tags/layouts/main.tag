<%@ tag description="메인 공통 레이아웃" pageEncoding="utf-8" %>
<%@ tag body-content="scriptless" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ attribute name="title" type="java.lang.String" %>

<layout:common title="${title}">
	<jsp:attribute name="header">
		<header>
			<section class="join-menu" >
				<div class="layout_width">
					<c:if test="${empty member}" >
						<a href="<c:url value="/member/join.jsp" /> " > 회원가입 </a>
						<a href="<c:url value="/member/login.jsp" /> " class="mr"> 로그인 </a>
					</c:if>
					<c:if test="${!empty member }">
						${member.name }님 환영합니다. 
						<a href="<c:url value="/mypage" /> ">MyPage</a>
						<a href="<c:url value="/withdrawal" />" onclick="return confirm('정말 탈퇴하시겠습니까?');">회원탈퇴</a>
						<a href="<c:url value="/logout" /> ">로그아웃</a> 
					</c:if>
				</div>
			</section>
			<section class="logo">
			<a href="<c:url value="/" /> ">로고 부분</a>
			</section>
		</header>
	</jsp:attribute>
	
	<jsp:attribute name="footer">
		<footer>
			<div class="footer">
				 &copy; footer...
			</div>
		</footer>
	</jsp:attribute>
	
	<jsp:body>
		<main>
			<jsp:doBody />
		</main>
	</jsp:body>
	
</layout:common>