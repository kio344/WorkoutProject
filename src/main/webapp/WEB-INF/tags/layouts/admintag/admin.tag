<%@ tag body-content="scriptless" pageEncoding="utf-8"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts/admintag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<layout:adcommon>
	<jsp:attribute name="header">
		<header>
			<div class="header-wrap">
				<a href="<c:url value="/admin" />">
					<h1>관리자 페이지</h1>
				</a>
			</div>
		</header>
	</jsp:attribute>
	<jsp:attribute name="menu">
		<nav>
			<div>
				<a href="<c:url value="/admin/product" />">판매 신청 목록</a>
				<a href="">QnA 목록</a>
				<a href="">게시판 관리</a>
			</div>
		</nav>
	</jsp:attribute>
	<jsp:body>
		<jsp:doBody />
	</jsp:body>
</layout:adcommon>