<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts/sellertag" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="<c:url value="/static/css/seller/myProduct.css" />" />
	<%
		String thispage= request.getParameter("status");
	%>
	<c:set value="<%=thispage %>" var="status" />
<layout:seller>
	<div class="background"></div>
	<div class="box">

	<h1>
		<c:choose>
			<c:when test="${status == 'req' }">
				승인 대기중 목록
			</c:when>
			
			<c:when test="${status == 'true' }">
				승인된 목록
			</c:when>
			
			
			<c:when test="${status == 'false' }">
				거부된 목록
			</c:when>
		</c:choose>
	</h1>
	<!-- abnum, seller, serialnum, name, price, kategorie, company, img, status -->
	<table>
		<thead>
			<tr>
				<td>요청 번호</td>
				<td>serialnum</td>
				<td>name</td>
				<td>price</td>
				<td>kategorie</td>
				<td>publisher</td>
				<td></td>
			</tr>
		</thead>
		<tbody>
		<!-- '28', NULL, 'MK1H3KH/A', 'Apple 2021 맥북프로 16', '4710000', '/가전제품/노트북/MacOs', 'Apple', '스크린샷 2022-08-26 시간: 02.31.12.png', 'req'
 -->
 		<c:forEach var="product" items="${list }">
 			<tr>
 				
				<td>${product.abnum }</td>
				<td>${product.serialnum }</td>
				<td>${product.name }</td>
				<td>${product.price }</td>
				<td>${product.kategorie }</td>
				<td>${product.publisher }</td>
				<td><a href="<c:url value="/seller/ReqRemove?abnum=${product.abnum}" />" >삭제</a></td>
			</tr>
 		
 		</c:forEach>
	
		</tbody>
		
	</table>
	

	
	</div>
	
		<util:pagination paginationCount="3" pageCount="${empty param.num ? 1:param.num}" link="/seller/myproduct?status=${param.status }&" total="${totalPage }"/>
	
</layout:seller>