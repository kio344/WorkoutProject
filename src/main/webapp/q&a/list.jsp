<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils"%>

<layout:main>
	<div>
		<h1>Q&A 게시판</h1>
		<a href="<c:url value="/Q&A/write" />">글쓰기</a>
	</div>
	<div class="list_title">
		<ul class="list_wrap">
			<li class="list_sub">
				<div>
					<h4>게시글 번호</h4>
				</div>
				<div>
					<h4>게시글 제목</h4>
				</div>
				<div>
					<h4>답변 상태</h4>
				</div>
				<div>
					<h4>게시글 등록시간</h4>
				</div>
			</li>
			<c:forEach var="lists" items="${list}">
				<li class="list_sub">
					<div>
						<h4>${lists.id}</h4>
					</div>
					<div>
						<h4><a href="Q&A/view?id=${lists.id}">${lists.subject}</a></h4>
					</div>
					<div>
						<h4>${lists.isAnswer == 0 ? "미답변" : "답변완료"}</h4>
					</div>
					<div>
						<h4>${lists.regDt}</h4>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
	<util:pagination url="Q&A" total="${total}" pageCnt="5" page="${page}" limit="${limit}" />
</layout:main>