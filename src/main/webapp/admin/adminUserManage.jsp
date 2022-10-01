<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts/admintag"%>
<layout:admin>
	<form method="get" action="<c:url value="/admin/user" />"
		autocomplete="off">
		<select id="select" name="select">
			<option ${(param.name == "name") ? "name" : "" } value="name">성명</option>
			<option ${(param.fakeName == "fakeName") ? "fakeName" : "" } value="fakeName">별명</option>
			<option ${(param.sex == "sex") ? "sex" : "" } value="sex">성별</option>
			<option ${(param.id == "id") ? "id" : "" } value="id">아이디</option>
			<option ${(param.userType == "userType") ? "userType" : "" } value="userType">유저타입</option>
		</select> <input type="text" name="str" placeholder="검색할 단어를 입력해주세요."
			value="${param.str}">
		<button type="submit">검색</button>

		<div class="list_title">
			<ul class="list_wrap">
				<li class="list_sub">
					<div>
						<h2>유저 번호</h2>
					</div>
					<div>
						<h2>아이디</h2>
					</div>
					<div>
						<h2>이름</h2>
					</div>
					<div>
						<h2>닉네임</h2>
					</div>
					<div>
						<h2>이메일</h2>
					</div>
					<div>
						<h2>전화번호</h2>
					</div>
					<div>
						<h2>주소</h2>
					</div>
					<div>
						<h2>생년월일</h2>
					</div>
					<div>
						<h2>성별</h2>
					</div>
					<div>
						<h2>유저 타입</h2>
					</div>
				</li>
				<c:forEach var="userList" items="${userList}">
					<li class="list_sub">
						<div>
							<h4>${userList.num}</h4>
						</div>
						<div>
							<h4>${userList.id}</h4>
						</div>
						<div>
							<h4>${userList.name}</h4>
						</div>
						<div>
							<h4>${userList.fakeName}</h4>
						</div>
						<div>
							<h4>${userList.email}</h4>
						</div>
						<div>
							<h4>${userList.mobile}</h4>
						</div>
						<div>
							<h4>${userList.address}</h4>
						</div>
						<div>
							<h4>${userList.birthDay}</h4>
						</div>
						<div>
							<h4>${userList.sex}</h4>
						</div>
						<div>
							<h4>${userList.userType}</h4>
						</div>
					</li>
				</c:forEach>
				<c:if test="${total == 0}">
					<li class="list_sub">
						<div>
							<h4>검색한 데이터가 없습니다.</h4>
						</div>
					</li>
				</c:if>
			</ul>
		</div>
	</form>
</layout:admin>