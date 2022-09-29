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
				href="<c:url value="/seller/message?see=false" />">
				<span>받은 주문<span>  ●</span>
				</span></a></li>
			<li class="box"><a
				href="<c:url value="/seller/message?see=true" />">
				<span>배송중인 주문<span>  ●</span></span>
				</a>
			</li>
			<li class="box"><a href="<c:url value="/seller/message" />">
				<span>수취 완료된 주문<span>  ●</span></span>
				</a></li>
		</ul>
		<div class="box">
			<h1>1232131231231231231231231231313132131231</h1>		
						<h1>1232131231231231231231231231313132131231</h1>			
						<h1>1232131231231231231231231231313132131231</h1>			
						<h1>1232131231231231231231231231313132131231</h1>			
				

		</div>
		<nav class="">
			<ul>
				<li class="box">
					<select name="mode">
						<option value="true">확인</option>
						<option value="false">미확인</option>
						<option value="delete">삭제 </option>
					</select>
				</li>
				<li class="box">
				
				<button id="execute">처리하기</button>
				
				</li>
			</ul>
		</nav>
		
		 

 
 
 </form>

		
	</div>
</layout:seller>