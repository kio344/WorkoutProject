<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<layout:main>
	<h1>글쓰기</h1>
	<form action="<c:url value="/board/write" />" method="post">
	
	<input name="boardId" type="text" value="${param.boardId }">
	
	<dl>
		<dt>제목</dt>
		<dd><input name="subject" type="text"></dd>
	</dl>
	
	<dl>
		<dt>내용</dt>
		<dd><textarea name="content" id="content"></textarea></dd>
	</dl>
	
	<div class="btn-grp">
		<button>작성하기</button>
	</div>
	
	</form>
</layout:main>