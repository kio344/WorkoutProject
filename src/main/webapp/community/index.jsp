<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<layout:main title="커뮤니티">
	<h1>커뮤니티</h1>
		<select name="type">
			<optgroup label="======선택======">
				<option value="freeTalk">자유게시판</option>
				<option value="workOutSkill">운동 노하우</option>
			</optgroup> 
		</select>
	
	<dl>
	
	<dt>게시판 이름</dt>
		<dd><input type="text" name="boardName"></dd>
	</dl>
	
	<dl>
		<dt>댓글 사용</dt>
		<dd>
			<input type="radio" name="comment" value="1" id="comment_1" checked="checked">
			<label for="comment_1">사용</label>
			<input type="radio" name="comment" value="0" id="comment_0">
			<label for="comment_0">미사용</label>
		</dd>
	</dl>
	
</layout:main>
