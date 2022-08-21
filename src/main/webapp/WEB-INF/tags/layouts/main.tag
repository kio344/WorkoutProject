<%@ tag description="메인 공통 레이아웃" pageEncoding="utf-8"%>
<%@ tag body-content="scriptless"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ attribute name="title" type="java.lang.String"%>

<layout:common title="${title}">
	<jsp:attribute name="header">
		<header>
			<section class="join-menu">
				<div class="layout_width">
					<a href="<c:url value="/member/join.jsp" /> "> 회원가입 </a>
					<a href="<c:url value="/member/login.jsp" /> " class="mr"> 로그인 </a>
				</div>
				
			</section>
			<section class="logo">로고 부분</section>
		</header>
		
		<div class="recore-minjae">
         <a href="<c:url value="/member_minjae_minseo/workoutrecord" />">운동추가
                  </a>
                  <a href="<c:url value="/member_minjae_minseo/dietrecord" />">식단기록
                  </a>
         </div>
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