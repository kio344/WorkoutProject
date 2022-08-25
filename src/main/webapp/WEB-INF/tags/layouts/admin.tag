<%@ tag body-content="scriptless" pageEncoding="utf-8"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts/"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setAttribute("addCss", new String[] {"admin/style"});
	request.setAttribute("addJs", new String[] {"admin/common"});
%>
<layout:common>
	
	<jsp:attribute name="header">
		<header>
			<div class="header-wrap">
				<h1>관리자 페이지</h1>
			</div>
		</header>
	</jsp:attribute>
	<jsp:attribute name="menu">
		<nav>
			<div>
				<a href="">판매 신청 목록</a>
				<a href="">QnA 목록</a>
				<a href="">????</a>
			</div>
		</nav>
	</jsp:attribute>
	<jsp:body>
		<jsp:doBody />
	</jsp:body>
</layout:common>