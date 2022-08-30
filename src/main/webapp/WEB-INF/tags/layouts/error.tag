<%@ tag description="에러페이지 레이아웃" pageEncoding="UTF-8" body-content="scriptless" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ attribute name="title" type="java.lang.String" %>
<layout:main title="${title }">
	<jsp:doBody />
</layout:main>