<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils/" %>

<layout:main>
	
	<div class="center">
		<div id="info">
		<h1>${board.boardId } 게시판</h1>
		</div>
		
		<div id="boardInfo">
		<div class="split">
			<div class="subject">	
				<h2>${board.subject }</h2>
			</div>
			<div class="edit-grp">
				<a href="<c:url value="/board/edit?gid=${board.gid }" />" >게시글 수정</a>
				<a href="<c:url value="/board/delete?gid=${board.gid }" />" >게시글 삭제</a>
			</div>
		</div>
			<div>
			${board.poster }	/ ${board.regDt }
			</div>
		</div>
		
		<div>
			${board.content }
		</div>
		
		<div>
		<c:forEach var="file" items="${fileList }">
				<li id="file"><a target="ifrmProcess"
					href="<c:url value="/file/download?&num=${file.id }" />
">${file.fileName }</a>

			</c:forEach>
		</div>
		
		<div>
			<c:if test="${!empty comments}">
				<c:forEach var="comment" items="${comments}">
					<div>
						<div>
							<div>
								${comment.userName}
							</div>
							<div>
								<util:dateFormat value="${comment.regDt}"/>
							</div>
						</div>
						${comment.content}
					</div>
				</c:forEach>
			</c:if>
			<div>
				<form method="post" action="<c:url value="/board/comment" />" target="ifrmProcess" autocomplete="off">
				<input type="hidden" name="boardId" value="${board.boardId}">
				<input type="hidden" name="gid" value="${board.gid}">
				<input type="hidden" name="userName" value="${member.fakeName}">
					<textarea rows="5" cols="200" name="content"></textarea>
					<div>
						<button type="submit">댓글달기</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<%-- ${board } --%>
</layout:main>