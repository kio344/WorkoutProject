<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>

<layout:main title="글쓰기">
<form action="<c:url value="/writeIndex" /> " method="post" target="ifrmProcess" autocomplete="off">
	<dl>	
		<dt>글쓴이</dt>
		<dd><input type="text" name="poster" ></dd>
	</dl>
	
	<dl>
		<dt>제목</dt>
		<dd><input type="text" name="subject" ></dd>
	</dl>
	
	<dl>
		<dt>내용</dt>
		<dd>
			<textarea name="content" id="content"></textarea>
		</dd>
	</dl>
	
	<div class="btn-grp">
	<button>작성하기</button>
	<button>취소하기</button>
	</div>
</form>
</layout:main>