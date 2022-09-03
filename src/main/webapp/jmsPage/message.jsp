<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts/sellertag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<layout:seller>
	<div class="background"></div>
	<div class="outerbox">
		<form target="ifrmProcess" action="<c:url value="" />" method="post">
	
		<ul>
			<li class="box"><a
				href="<c:url value="/seller/message?see=false" />"><span>미확인
						메세지<span>●</span>
				</span></a></li>
			<li class="box"><a
				href="<c:url value="/seller/message?see=true" />"><span>확인한
						메세지<span>●</span>
				</span></a></li>
			<li class="box"><a href="<c:url value="/seller/message" />"><span>모든메세지<span>●</span></span></a></li>
		</ul>
		<div class="box">
			<h3>
				<c:if test="${param.see==true }">
				확인한 메세지
			</c:if>
				<c:if test="${param.see==false }">
				확인 안한 메세지
			</c:if>
				<c:if test="${param.see==null }">
				모든 메세지
			</c:if>
			</h3>
			<table>
				<thead>
					<td>Num</td>
					<td>content</td>
					<td>read</td>
				</thead>
				<tbody>
					<c:forEach varStatus="no"  items="${list }" var="message">
						<c:if test="${param.see==true&&message.see==true }">
							<tr>
								<td>
								<input type="checkbox" name="num" value="${message.num }">
								${no.index }
								</td>
								<td>${message.message }</td>
								<c:if test="${message.see==true }">
									<td>확인</td>
								</c:if>
								<c:if test="${message.see==false }">
									<td>미확인</td>
								</c:if>
								
							</tr>
						</c:if>
						
						<c:if test="${param.see==false&&message.see==false }">
							<tr>
								<td>
								<input type="checkbox" name="num" value="${message.num }">
								${no.index }
								</td>
								<td>${message.message }</td>
								<c:if test="${message.see==true }">
									<td>확인</td>
								</c:if>
								<c:if test="${message.see==false }">
									<td>미확인</td>
								</c:if>
								
							</tr>
						</c:if>
						
						<c:if test="${param.see==null }">
						<tr>
								<td>
								<input type="checkbox" name="num" value="${message.num }">
								${no.index }
								</td>
								<td>${message.message }</td>
								<c:if test="${message.see==true }">
									<td>확인</td>
								</c:if>
								<c:if test="${message.see==false }">
									<td>미확인</td>
								</c:if>
								
							</tr>
						
						</c:if>
						
					</c:forEach>
				</tbody>
			</table>
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