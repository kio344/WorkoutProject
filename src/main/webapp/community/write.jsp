<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<layout:main>
	<h1>글쓰기</h1>
	<form action="<c:url value="/board/write" />" method="post">

		<input name="boardId" type="text" value="${param.boardId }">

		<dl>
			<dt>제목</dt>
			<dd>
				<input name="subject" type="text">
			</dd>
		</dl>

		<dl>
			<dt>내용</dt>
			<dd>
				<textarea name="content" id="content"></textarea>
			</dd>
		</dl>

		<div class="btn-grp">
			<button>작성하기</button>
		</div>
	<button id="imageuploadbtn" type="button">이미지첨부</button>
		<iframe src="<c:url value="/board/fileupload?imageOnly=1" />"></iframe>
		<button id="fileuploadbtn" type="button">파일첨부</button>

		<ul id="files">

		</ul>

		<script id="tmp" type="text/html">
`		<li id="file">
			<a target="ifrmProcess" href="<c:url value="/file/download?&num=#_num_" />
">#_fileName_</a>
			<a target="ifrmProcess" href="<c:url value="/file/delete?&num=#_num_" />">
			[X]
			</a>
	</li>
	</script>

		<div class="center dn">
			<iframe id="fileuploadiframe" scrolling="no" class=""
				src="<c:url value="/board/fileupload" />"></iframe>
		</div>
	</form>
</layout:main>