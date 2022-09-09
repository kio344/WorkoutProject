<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts/admintag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<layout:admin>
	<h1>게시판 작성</h1>
	<div>
		<form method="post" action="<c:url value="/admin/board" />"
			target="ifrmProcess" autocomplete="off">
			<dl>
				<dt>게시판 아이디</dt>
				<dd>
					<input type="text" name="boardId">
				</dd>
			</dl>
			<dl>
				<dt>게시판 이름</dt>
				<dd>
					<input type="text" name="boardName">
				</dd>
			</dl>
			<dl>
				<dt>1페이지 게시글수</dt>
				<dd>
					<input type="number" name="noOfRows">
				</dd>
			</dl>
			<dl>
				<dt>게시판 사용 여부</dt>
				<dd>
					<input type="radio" name="isUse" id="isUse_1" value="1"> <label
						for="isUse_1">사용</label> <input type="radio" name="isUse"
						id="isUse_0" value="0" checked> <label for="isUse_0">미
						사용</label>
				</dd>
			</dl>
			<dl>
				<dt>회원 전용 여부</dt>
				<dd>
					<input type="radio" name="isMemberOnly" id="isMemberOnly_1"
						value="1"> <label for="isMemberOnly_1">적용</label> <input
						type="radio" name="isMemberOnly" id="isMemberOnly_0" value="0"
						checked> <label for="isMemberOnly_0">미 적용</label>
				</dd>
			</dl>
			<dl>
				<dt>댓글 사용 여부</dt>
				<dd>
					<input type="radio" name="useComment" id="useComment_1" value="1"
						checked> <label for="useComment_1">사용</label> <input
						type="radio" name="useComment" id="useComment_0" value="0">
					<label for="useComment_0">미 사용</label>
				</dd>
			</dl>
			<div class="btn-grp">
				<button type="reset">다시 작성</button>
				<button type="submit">등록 하기</button>
			</div>
		</form>
	</div>
	<h1>게시판 수정/삭제</h1>
	<form method="post" action="<c:url value="/admin/boards" />"
		target="ifrmProcess" autocomplete="off">
		<div class="list_title">
			<ul class="list_wrap">
				<li class="list_sub">
					<div>
						<h2>
							<input type="checkbox" class="allCheck" data-target-name="boardId">
						</h2>
					</div>
					<div>
						<h2>게시판 아이디</h2>
					</div>
					<div>
						<h2>게시판 이름</h2>
					</div>
					<div>
						<h2>페이지 당 게시글 수</h2>
					</div>
					<div>
						<h2>게시판 사용 여부</h2>
					</div>
					<div>
						<h2>회원 전용 여부</h2>
					</div>
					<div>
						<h2>댓글 사용 여부</h2>
					</div>
					<div>
						<h2>게시판 생성 날짜</h2>
					</div>
					<div>
						<h2>게시판 수정 날짜</h2>
					</div>
					<div>
						<h2>게시판 으로 이동</h2>
					</div>
				</li>
				<c:forEach var="list" items="${list}">
					<li class="list_sub">
						<div>
							<h4>
								<input type="checkbox" name="boardId" value="${list.boardId}">
							</h4>
						</div>
						<div>
							<h4>${list.boardId}</h4>
						</div>
						<div>
							<h4>
								<input type="text" name="boardName_${list.boardId}" value="${list.boardName}">
							</h4>
						</div>
						<div>
							<h4>
								<input type="number" name="noOfRows_${list.boardId}" value="${list.noOfRows}">
							</h4>
						</div>
						<div>
							<h4>
								<select name="isUse_${list.boardId}">
								<option value="1"${list.isUse == 1 ? " selected" : ""}>사용</option>
								<option value="0"${list.isUse == 1 ? "" : " selected"}>미사용</option>
								</select>
							</h4>
						</div>
						<div>
							<h4>
								<select name="isMemberOnly_${list.boardId}">
									<option value="1"${list.isMemberOnly == 1 ? " selected" : ""}>적용</option>
									<option value="0"${list.isMemberOnly == 1 ? "" : " selected"}>미적용</option>
								</select>
							</h4>
						</div>
						<div>
							<h4>
								<select name="useComment_${list.boardId}">
									<option value="1"${list.useComment == 1 ? " selected" : ""}>사용</option>
									<option value="0"${list.useComment == 1 ? "" : " selected"}>미사용</option>
								</select>
							</h4>
						</div>
						<div>
							<h4>${list.regDt}</h4>
						</div>
						<div>
							<h4>${list.modDt}</h4>
						</div>
						<div>
							<h4>
								<a href="<c:url value="/board/write?boardId=${list.boardId}" />">글쓰기</a>
								<a href="<c:url value="/board/list?boardId=${list.boardId}" />">글목록</a>
							</h4>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div>
			선택한 게시판 설정을 <select name="mode">
				<option value="update">수정</option>
				<option value="delete">삭제</option>
			</select>
			<button type="submit" onclick="return confirm('정말 처리하시겠습니까?');">처리하기</button>
		</div>
	</form>
</layout:admin>