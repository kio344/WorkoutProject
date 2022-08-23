<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts/sellertag" %>
<%
	request.setAttribute("addCss", new String[]{"/seller/index"});
	request.setAttribute("addJs", new String[]{"/seller/index"});


%>
<layout:seller>
	 <div class="center">
		<div class="myinfo">
			<span class="xi-user-o userlogo"></span>
			<div class="usermenu">
				<ul>
					<a href=""><li>메세지</li></a>
					<a href=""><li>판매 물품 추가 요청</li></a>
					<a href=""><li>판매 물품</li></a>
				</ul>			
			</div>
		</div>
	</div> 
</layout:seller>