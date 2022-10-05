<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts/admintag"%>
<layout:admin>
<div class="pt-50 content">
		<form method="get" action="<c:url value="/admin/user" />" autocomplete="off">
			<select id="select" name="select">
				<option ${(param.select == "name") ? "selected" : "" } value="name">성명</option>
				<option ${(param.select == "fakeName") ? "selected" : "" } value="fakeName">별명</option>
				<option ${(param.select == "sex") ? "selected" : "" } value="sex">성별</option>
				<option ${(param.select == "id") ? "selected" : "" } value="id">아이디</option>
				<option ${(param.select == "userType") ? "selected" : "" } value="userType">유저타입</option>
			</select>
			<input type="text" name="str" placeholder="검색할 단어를 입력해주세요." value="${param.str}">
			<button type="submit">검색</button>
		</form>
</div>
</layout:admin>