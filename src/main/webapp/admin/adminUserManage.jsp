<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts/admintag"%>

<layout:admin>
	<div class="pt-50 content">
		<h1>회원 검색</h1>

		<form method="get" action="<c:url value="/admin/user" />"
			autocomplete="off">
			<select id="select" name="select">
				<option ${(param.select == "name") ? "selected" : "" } value="name">성명</option>
				<option ${(param.select == "fakeName") ? "selected" : "" }
					value="fakeName">별명</option>
				<option ${(param.select == "sex") ? "selected" : "" } value="sex">성별</option>
				<option ${(param.select == "id") ? "selected" : "" } value="id">아이디</option>
				<option ${(param.select == "userType") ? "selected" : "" }
					value="userType">유저타입</option>
			</select> <input type="text" name="str" placeholder="검색할 단어를 입력해주세요."
				value="${param.str}">
			<button type="submit">검색</button>

		</form>
	
	<h1>회원 관리</h1>
	<form method="post" action="<c:url value="/admin/user" />"
		target="ifrmProcess" autocomplete="off">
		<div class="list_title">
			<ul class="list_wrap">
				<li class="list_sub">
					<div>
						<h2>
							<input type="checkbox" class="allCheck"
								data-target-name="boardId">
						</h2>
					</div>

					<div>
						<h2>회원 아이디</h2>
					</div>

					<div>
						<h2>회원 이름</h2>
					</div>

					<div>
						<h2>회원 성별</h2>
					</div>

					<div>
						<h2>회원 타입</h2>
					</div>
				</li>

				<c:forEach var="userInfo" items="${userInfoList}">
					<li class="list_sub">
						<div>
							<h4>
								<input type="checkbox" name="userNo"
									value="${userInfo.num}">
							</h4>
						</div>
						<div>
							<h4>${userInfo.id}</h4>
						</div>
						<div>
							<h4>${userInfo.name}</h4>
						</div>
						<div>
							<h4>${userInfo.sex}</h4>
						</div>
						<div>

							<select name="userType_${userInfo.num}">
								<option value="member">member</option>
								<option value="admin">admin</option>
								<option value="seller">seller</option>
							</select>
							
						</div>

					</li>
				</c:forEach>

			</ul>
		</div>
		<div>
			선택한 회원을 <select name="mode">
				<option value="update">수정</option>
				<option value="delete">삭제</option>
			</select>
			<button type="submit" onclick="return confirm('정말 처리하시겠습니까?');">처리하기</button>
		</div>
	</form>
</div>
</layout:admin>