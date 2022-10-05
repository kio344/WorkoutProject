<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts/admintag" %>

<layout:admin>
	<div class="pt-50 content">
		<div class="admin_main">
			<div class="QnA">
				<h1>현재 QnA 미답변 개수 : </h1>
				<h1>${QnA}</h1>
			</div>
			<div class="product_count">
				<h1>현재 판매 미승인 상품 개수 : </h1>
				<h1>${product}</h1>
			</div>
		</div>
	</div>
</layout:admin>