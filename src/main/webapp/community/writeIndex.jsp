<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>

<layout:main title="글쓰기">
	<form action="<c:url value="/writeIndex" /> " method="post"
		target="ifrmProcess" autocomplete="off">
		<h1>커뮤니티</h1>
		<select name="type">
			<optgroup label="======선택======">
				<option value="freeTalk">자유게시판</option>
				<option value="workOutSkill">운동 노하우</option>
			</optgroup>
		</select>

		<dl>
			<dt>글쓴이</dt>
			<dd>
				<input type="text" name="poster">
			</dd>
		</dl>

		<dl>
			<dt>제목</dt>
			<dd>
				<input type="text" name="subject">
			</dd>
		</dl>

		<dl>
			<dt>내용</dt>
			<dd>
				<textarea name="content" id="content"></textarea>
			</dd>
		</dl>

		<dl>
			<dt>댓글 사용</dt>
			<dd>
				<input type="radio" name="comment" value="1" id="comment_1"
					checked="checked"> <label for="comment_1">사용</label> <input
					type="radio" name="comment" value="0" id="comment_0"> <label
					for="comment_0">미사용</label>
			</dd>
		</dl>

		<dl>
			<dt>이미지 첨부</dt>
			<dd>
				<button id="image_Only">이미지 첨부</button>
				<ul id="image_Only">
					
				</ul>
			</dd>
		</dl>
		
		<dl>
			<dt>파일첨부</dt>
			<dd>
				<button id="attach_file">파일 첨부</button>
				<ul id="attached_files">

				</ul>
			</dd>
		</dl>

		<div class="btn-grp">
			<button>작성하기</button>
			<button>취소하기</button>
			<button type="button">
				<a href="<c:url value="/index.jsp" /> "> 처음으로 돌아가기 
			</button>
		</div>
	</form>
</layout:main>