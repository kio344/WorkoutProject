<%@ page contentType="text/html; charset=utf-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<c:set var="status" value="<%=response.getStatus()%>" />
<c:set var="method" value="<%=request.getMethod()%>" />
<c:set var="exception" value="<%=exception%>" />
<% if (exception != null ) exception.printStackTrace(); %>
<layout:error title="${empty status ? 500 : status }">
	<h1>${empty statusCode ? status : statusCode }</h1>
	<h2>${method} / ${requestURL }</h2>
		<h3>
			<c:if test="${ !empty exception }">
				${exception.message }
			</c:if>
			<c:if test="${ empty exception }">
				<c:choose>
					<c:when test="${ status == 404 }">
						없는 페이지 입니다.
					</c:when>
					<c:when test="${ status == 500 }">
						서버 오류 입니다.
					</c:when>
				<c:otherwise>
					<c:if test="${ empty errorMessage }" >
						에러 발생 했습니다.
					</c:if>
					<c:if test="${ !empty errorMessage}">
							${errorMessage}
					</c:if>
				</c:otherwise>
			</c:choose>
		</c:if>
	</h3>
</layout:error>
