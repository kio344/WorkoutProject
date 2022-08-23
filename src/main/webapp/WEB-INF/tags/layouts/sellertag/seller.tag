<%@ tag body-content="scriptless" pageEncoding="utf-8"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts/"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<layout:common>
	
	<jsp:attribute name="header">
		<script src="<c:url value="/static/js/seller/common.js" />" ></script>
		<link rel="stylesheet" href="<c:url value="/static/css/seller/common.css" />" ></link>
		<header>
			
				<div>
					<a class="xi-library" id="menubtn"></a>
				</div>
				<div>
					<input id="search"><button id="searchbtn">검색</button>
				</div>
		
		</header>
		
		<nav class="menu dn">
			<ul >
				<a href="<c:url value="/seller" />"><li>메인페이지</li></a>
				<a><li>메세지</li></a>
				<a href="<c:url value="/seller/addProductReq" />"><li>제품 판매 신청</li></a>
				<a><li>신청 목록</li></a>
				<a><li>판매 목록</li></a>
			</ul>

		</nav>
		<div class="background dn">
		
		</div>
	</jsp:attribute>
	
	
	
	<jsp:body>
		<jsp:doBody />
	</jsp:body>
</layout:common>