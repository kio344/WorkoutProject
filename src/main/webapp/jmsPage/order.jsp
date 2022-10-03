<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts/sellertag"%>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/layouts"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<layout:seller>
	<div class="background"></div>
	<div class="outerbox">
		<form target="ifrmProcess" action="<c:url value="" />" method="post">

		<ul>
			<li class="box"><a
				href="<c:url value="/seller/order?progress=PAYMENT&num=1" />">
				<span>받은 주문<span>  ●</span>
				</span></a></li>
			<li class="box"><a
				href="<c:url value="/seller/order?progress=SHIPPING&num=1" />">
				<span>배송중인 주문<span>  ●</span></span>
				</a>
			</li>
			<li class="box"><a href="<c:url value="/seller/order?progress=COMPLETED&num=1" />">
				<span>수취 완료된 주문<span>  ●</span></span>
				</a></li>
			<li class="box"><a href="<c:url value="/seller/order?progress=cancel&num=1" />">
				<span>취소한 주문<span>  ●</span></span>
				</a></li>
		</ul>
		<div class="box">
			<h3>${param.progress }</h3>
			<table>
				<thead>
					<td>선택</td>
					<td>주문자</td>
					<td>제품번호</td>
					<td>제품이름</td>
					<td>수량</td>
					<td>주소</td>
				</thead>
				<tbody>
					<c:forEach varStatus="no"  items="${list }" var="payment">
						<tr>
							<td>
								<input type="checkbox" name="abnum" value="${payment.num }" >
							</td>
							<td>
								${payment.userId }
							</td>
							<td>
								${payment.productNum }
							</td>
							<td>
								${payment.name }
							</td>
							<td>
								${payment.count }
							</td>
							<td>
								${payment.destination }
							</td>
						</tr>
						
					</c:forEach>
				</tbody>
			</table>
				

		</div>
		<nav class="">
			<ul>
				<li class="box">
					<select name="mode">
						<option value="SHIPPING">배송중</option>
						<option value="cancel">취소</option>
						 <option value="PAYMENT">결제됨 </option>
					</select>
				</li>
				<li class="box">
				
				<button id="execute">처리하기</button>
				
				</li>
			</ul>
		</nav>
		
		 
<util:pagination link='/seller/order?progress=${param.progress }&' paginationCount="5" pageCount="${empty param.num ? 1:param.num }"  total="${totalPage}"/>

 
 
 </form>
	</div>
</layout:seller>
