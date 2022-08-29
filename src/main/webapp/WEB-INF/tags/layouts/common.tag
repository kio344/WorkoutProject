<%@ tag description="공통 레이아웃" pageEncoding="UTF-8"%>
<%@  tag body-content="scriptless"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="header" fragment="true"%>
<%@ attribute name="footer" fragment="true"%>
<%@ attribute name="menu" fragment="true"%>
<%@ attribute name="title" type="java.lang.String"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
<link rel="stylesheet" type="text/css"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/css/common.css" />">

<c:if test="${!empty addCss }">
	<c:forEach var="css" items="${addCss }">
		<link rel="stylesheet" type="text/css"
			href="<c:url value="/static/css/" />${css}.css ">
	</c:forEach>
</c:if>

<script src="<c:url value="/static/js/common.js" />" ></script>
<c:if test="${!empty addJs}">
	<c:forEach var="js" items="${addJs}">
		<script src="<c:url value="/static/js/" />${js}.js"></script>
	</c:forEach>
</c:if>
<title>${empty title ? "WorkOut" : title}</title>

</head>
	<body>
	<jsp:invoke fragment="header" />
	
	<jsp:invoke fragment="menu" />
	
	<jsp:doBody />
	
	<jsp:invoke fragment="footer" />
	</body>
	
	<iframe name="ifrmProcess" width="100%" height="0px" class="dn"></iframe>
	
</html>