<%@ tag body-content="scriptless" pageEncoding="utf-8"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts/"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<layout:common>
	
	<jsp:attribute name="header">
		<script src="<c:url value="/static/js/seller/common.js" />" ></script>
		<link rel="stylesheet" href="<c:url value="/static/css/seller/common.css" />" ></link>
		<header>
			<nav class="header_nav" >
			<ul>
				<c:if test="${!empty member }">

					<a href="<c:url value="/seller" />">
						<li>
							<div class="xi-profile-o header_icon" ></div>
							<div class="info">${member.name } </div>
						</li>
					</a>
				</c:if>
				<c:if test="${empty member }">

					<a href="<c:url value="/seller/login" />">
						<li>
							<div class="xi-profile-o header_icon" ></div>
							<div class="info">로그인 </div>
						</li>
					</a>
				</c:if>
				
					<a href="<c:url value="/seller/order?progress=PAYMENT&num=1" />">
						<li>
							<div class="xi-download header_icon" >
							<c:if test="${orderCount !=0 }">
							<span class="msgCount">${orderCount }</span>
							</c:if>
							</div>
							<div class="info">주문관리</div>
						</li>
					</a>
				
					<a href="<c:url value="/seller/message" />">
						<li>
							<div class="xi-message-o header_icon" >
							<c:if test="${readNotMsg !=0 }">
							<span class="msgCount">${readNotMsg }</span>
							</c:if>
							</div>
							<div class="info">메세지</div>
						</li>
					</a>

					<a href="<c:url value="/seller/addProductReq" />" >
						<li>
							<div class="xi-cart-add header_icon" /></div>
							<div class="info">상품 추가 요청</div>
						</li>
					</a>
					
					<a href="<c:url value="/seller/myproduct?status=req" />" >
						<li>
							<div class="xi-projector header_icon" /></div>
							<div class="info">승인 대기중 상품</div>
						</li>
					</a>
					
					<a href="<c:url value="/seller/myproduct?status=false" />" >
						<li>
							<div class="xi-lightning header_icon" /></div>
							<div class="info">거절된 상품</div>
						</li>
					</a>
					

					<a href="<c:url value="/seller/myproduct?status=true" />">
						<li>
							<div class="xi-shop header_icon" /></div>
							<div class="info">승인된 상품</div>
						</li>
					</a>
					
					<c:if test="${!empty member }">

					<a href="<c:url value="/seller/logout" />">
						<li>
							<div class="xi-log-out header_icon" ></div>
							<div class="info">로그아웃 </div>
						</li>
					</a>
				</c:if>
				
					<c:if test="${empty member }">

					<a href="<c:url value="/seller" />">
						<li>
							<div class="xi-log-out header_icon dn" ></div>
							<div class="info dn">로그아웃 </div>
						</li>
					</a>
				</c:if>

				</ul>
			</nav>
		</header>
				 <div class="blur dn"></div>
		
		
		
		
	
	</jsp:attribute>
	
	
	
	<jsp:body>
		 <div class="layout">
			<jsp:doBody />
		 </div> 
	</jsp:body>
</layout:common>