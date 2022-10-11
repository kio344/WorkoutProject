<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>

<layout:main>
	<div class="content1">
		<div>
			<h1 class="QnA">Q&A</h1>
		</div>
		<div>
			<div class="Q">
				<div class="flex">
					<h1  class="Qtext">Q</h1>
					<h2>${question.subject}</h2>
				</div>
				<div>${question.subject}</div>
				<h4>${question.memId}</h4>
			</div>

			<c:if test="${member.userType eq 'admin' }">
				<c:if test="${question.answer == null }">
					<form method="post" action="<c:url value="/Q&A/view" />"
						target="ifrmProcess" autocomplete="off">
						<input type="hidden" name="id" value="${question.id}">
						<h3>답변</h3>
						<textarea rows="20" cols="150" name="answer"></textarea>
						<div>
							<button type="reset">다시 작성</button>
							<button type="submit">답변 완료</button>
						</div>
					</form>
				</c:if>
				<form action="<c:url value="/Q&A/delete"/>" method="post"
					target="ifrmProcess" autocomplete="off">
					<input type="hidden" name="id" value="${question.id}">
					<button type="submit" onclick="return confirm('정말 삭제하시겠습니까?');">게시글
						삭제</button>
				</form>
			</c:if>
		</div>
	</div>
			<div class="content2">
			<div>
				<div class="A">
					<c:if test="${question.answer != null}">
						<div class="flex"><h1 class="Atext">A</h1><h2>답변</h2></div>
						<div>${question.question}</div>
						<br>
						<div>${question.answer}</div>
					</c:if>
				</div>
			</div>
			</div>
</layout:main>