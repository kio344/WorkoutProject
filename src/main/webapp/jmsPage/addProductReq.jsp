<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts/sellertag" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<layout:seller>
	<link rel="stylesheet" href="<c:url value="/static/css/seller/addProductReq.css" />" />
	
	<h1>제품 추가 요청페이지 </h1>
	<form action="<c:url value="/seller/addProductReq" />" method="post" >
	
		<label for="serialnum">제품코드</label>
		 	<input type="text" id="serialnum" name="serialnum" class="">
		
		<label for="name">제품명</label>
			<input type="text" id="name" name="name" class="">
				
		<label for="price">제품가격</label>
			<input type="text" id="price" name="price" class="">
		
		<label for="kategorie">카테고리</label>
			<input type="text" id="kategorie" name="kategorie" class="">
		
		<label for="company">브랜드</label>
			<input type="text" id="company" name="company" class="">
				
		<label for="img">이미지</label>
			<input type="file" id="img" name="img" class="" >
		<div class="btn-grp">
			<button>추가하기</button>
		</div>
		
	</form>
</layout:seller>
