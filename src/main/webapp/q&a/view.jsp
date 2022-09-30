<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<link rel="stylesheet" href="<c:url value="/static/css/qAnda/style.css" />"/>

<layout:main>
	<div class="content">
		<div>
			<h1>Q&A</h1>
		</div>
		<div>
			<h3>${question.memId}</h3>
			<h4>${question.subject}</h4>
			<div>${question.question}</div>
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
				<form action="<c:url value="/Q&A/delete"/>" method="post" target="ifrmProcess" autocomplete="off">
					<input type="hidden" name="id" value="${question.id}">
					<button type="submit" onclick="return confirm('정말 삭제하시겠습니까?');">게시글 삭제</button>
				</form>
			</c:if>
			<c:if test="${question.answer != null}">
				<h3>답변</h3>
				<div>
					${question.answer}
				</div>
			</c:if>
		</div>
	</div>
</layout:main>