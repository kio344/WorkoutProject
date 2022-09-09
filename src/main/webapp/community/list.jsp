<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<layout:main>
	<div class="center">
	<div>
		<h1>${param.boardId } 게시판</h1> 
	</div>
	
	<div class="board_List_Area">
	<div class="boardEl">
			<a>num</a>
			<a> 제목</a>
			<a> 작성자 / 작성일 </a>
			
		</div>
	<c:forEach items="${list }" var="board">
		<div class="boardEl">
			<a> ${board.id }</a>
			<a href="<c:url value="/board/view?gid=${board.gid }" />"> ${board.subject }</a>
			<a> ${board.poster } / ${board.regDt }</a>
		
		</div>
	</c:forEach>
	</div>
	</div>
</layout:main>