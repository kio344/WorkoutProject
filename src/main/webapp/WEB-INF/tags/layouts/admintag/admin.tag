<%@ tag body-content="scriptless" pageEncoding="utf-8"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts/admintag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<layout:adcommon>
	<jsp:attribute name="header">
		<header>
			<div class="join-menu">
				<div class="logo ml">
					<button id="btn">
						<i class="xi-bars"></i>
					</button>
					<a href="<c:url value="/admin" /> ">관리자 페이지</a>
				</div>
				</div>
		</header>
	</jsp:attribute>
	<jsp:attribute name="menu">
		<nav id="slide_menu">
			<div class="layout_width">
				<a href="<c:url value="/admin/user" />">유저 관리</a>
				<a href="<c:url value="/admin/product" />">판매 신청 목록</a>
				<a href="<c:url value="/admin/board" />">게시판 관리</a>
			</div>
		</nav>
	<div id="layer" class="dn"></div>
	</jsp:attribute>
	<jsp:body>
		<jsp:doBody />
	</jsp:body>
</layout:adcommon>