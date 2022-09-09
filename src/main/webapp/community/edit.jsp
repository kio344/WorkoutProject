<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="gid" value="${gid }" />

<layout:main>

	<form id="writearea" action="<c:url value="/board/edit" />"	method="post">
		<h1>${param.boardId }글수정</h1>
		<input name="boardId" type="text" value="${param.boardId }">
		<input name="gid" type="text" value="${param.gid }">
		<dl>
			<dt>제목</dt>
			<dd>
				<input name="subject" type="text" value="${board.subject }">
			</dd>
		</dl>
		<div class="upload-grp">
			<button id="fileuploadbtn" type="button">파일첨부</button>
			<button id="imageuploadbtn" type="button">이미지첨부</button>

		</div>


		<ul id="files">
			<c:forEach var="file" items="${fileList }">
				<li id="file"><a target="ifrmProcess"
					href="<c:url value="/file/download?&num=${file.id }" />
">${file.fileName }</a><a class="filedelete" target="ifrmProcess" href="<c:url value="/board/filedelete?&num=${file.id }" />">
			[X]
			</a>
				
			</c:forEach>
		</ul>
		<dl>
			<dt>내용</dt>
			<dd id="drop_content">
				<textarea name="content" id="content">
				${board.content }
				</textarea>
			</dd>
		</dl>

		<div class="btn-grp">
			<button>작성하기</button>
		</div>

		<script id="tmp" type="text/html">
`		<li id="file">
			<a target="ifrmProcess" href="<c:url value="/file/download?&num=#_num_" />
">#_fileName_</a>
			<a target="ifrmProcess" href="<c:url value="/board/filedelete?&num=#_num_" />">
			[X]
			</a>
	</li>
	</script>

		<div class="center dn" id="fileuploadEl">
			<iframe id="fileuploadiframe" scrolling="no" class=""
				src="<c:url value="/board/fileupload?gid=${param.gid }" />"></iframe>
		</div>
		<div class="center dn" id="imageuploadEl">
			<iframe scrolling="no" id="imageuploadiframe"
				src="<c:url value="/board/fileupload?imageOnly=1&gid=${param.gid }" />"></iframe>
			<div class="center dn">
	</form>
</layout:main>