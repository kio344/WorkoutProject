<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts/sellertag" %>
<%
	request.setAttribute("addCss", new String[]{"/seller/index"});
	request.setAttribute("addJs", new String[]{"/seller/index"});


%>
<layout:seller>
	<div class="background"></div>
		<div class="outerbox">
			<div class="box userinfo">
				<span class="xi-profile-o"></span>	
					
			</div>
			<div class="box">
				<span>이름 : ${member.name }</span>			
				<span>이메일 : ${member.email }</span>				
				<span>전화번호 : ${member.mobile }</span>				
			</div>
		</div>
		
		<div class="box productInfo">
			<div class="reqCount">
				<span>승인 대기중</span>
				<span>24개</span>
			
			</div>
			<div class="sellCount">
				<span>판매 중</span>
				<span>48개</span>
			 </div>
			 
			 <div class="sellCount">
				<span> 확인 안한 메세지</span>
				<span>4건</span>
			 </div>
		</div>
	

</layout:seller>