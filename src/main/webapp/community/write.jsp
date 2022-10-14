<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Long gid=System.currentTimeMillis();
 %>
 <c:set var="gid" value="<%=gid %>" />

<layout:main>

	<form  id="writearea" action="<c:url value="/board/write" />" method="post">
		<h1>${param.boardId } 글쓰기</h1>
		<input name="boardId" type="hidden" value="${param.boardId }">
		<input name="gid" type="hidden" value="${gid }">
		<dl>
			<dt>제목</dt>
			<dd style="padding: 10px;width:100%;" >
				<input style="width:100%;" name="subject" type="text">
			</dd>
		</dl>
		<div class="upload-grp">
		<button id="fileuploadbtn" type="button">파일첨부</button>
		<button id="imageuploadbtn" type="button">이미지첨부</button>
		
		</div>
		

		<ul id="files">

		</ul>
		<dl>
			
			<dd id="drop_content">
				<textarea name="content" id="content"></textarea>
			</dd>
		</dl>

		<div style="margin-top: 50px;" class="btn-grp">
			<button>작성하기</button>
		</div>
		
		<script id="tmp" type="text/html">
`		<li id="file">
			<a target="ifrmProcess" href="<c:url value="/file/download?&num=#_num_" />
">#_fileName_</a>
			<a id="filedelete" target="ifrmProcess" href="<c:url value="/board/filedelete?&num=#_num_" />">
			[X]
			</a>
	</li>
	</script>

		<div class="center dn" id="fileuploadEl">
			<iframe id="fileuploadiframe" scrolling="no" class=""
				src="<c:url value="/board/fileupload?gid=${gid }" />"></iframe>
		</div>
		<div class="center dn" id="imageuploadEl">
			<iframe scrolling="no" id="imageuploadiframe" src="<c:url value="/board/fileupload?imageOnly=1&gid=${gid }" />"></iframe>
		<div class="center dn">
	</form>
</layout:main>