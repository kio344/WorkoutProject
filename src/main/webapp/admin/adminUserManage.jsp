<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts/admintag"%>
<layout:admin>
	<div class="pt-50 content">
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
		<div class="list_title">
			<ul class="list_wrap">
				<li class="list_sub">
					<div>
						<h2>회원 아이디</h2>
					</div>
					<div>
						<h2>회원 이름</h2>
					</div>
					<div>
						<h2>회원 별명</h2>
					</div>
					<div>
						<h2>회원 이메일</h2>
					</div>
					<div>
						<h2>회원 전화번호</h2>
					</div>
					<div>
						<h2>회원 주소</h2>
					</div>
					<div>
						<h2>생년월일</h2>
					</div>
					<div>
						<h2>성별</h2>
					</div>
					<div>
						<h2>회원 타입</h2>
					</div>
				</li>
				<c:forEach var="userInfo" items="${userInfoList}">
					<li class="list_sub">
						<div>
							<h4>${userInfo.id}</h4>
						</div>
						<div>
							<h4>${userInfo.name}</h4>
						</div>
						<div>
							<h4>${userInfo.fakeName}</h4>
						</div>
						<div>
							<h4>${userInfo.email}</h4>
						</div>
						<div>
							<h4>${userInfo.mobile}</h4>
						</div>
						<div>
							<h4>${userInfo.address}</h4>
						</div>
						<div>
							<h4>${userInfo.birthDay}</h4>
						</div>
						<div>
							<h4>${userInfo.sex}</h4>
						</div>
						<div>
							<h4>${userInfo.userType}</h4>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</layout:admin>