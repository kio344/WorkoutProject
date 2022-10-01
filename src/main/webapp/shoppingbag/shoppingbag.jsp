<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>
<link rel="stylesheet" href="<c:url value="/static/css/bookshop/bookMain.css" />"/>

<layout:main title="장바구니">
	<form action="<c:url value="/shoppingbag" />" method="get" class="shoppingbag">
		<div class="order_day">
			주문날짜 <util:selectBirth /> ~ <util:selectBirth /> <!-- 대충 이런 기능을 넣는다는 의미 -->
		</div>
		
		<div class="baglist">
		
		</div>
		
	</form>
</layout:main>