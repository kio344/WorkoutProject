<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>
<link rel="stylesheet" href="<c:url value="/static/css/member/join.css" />"/>

<layout:main title="회원가입">
	<div class="content">
		<form target="ifrmProcess" action="<c:url value="/join" />" method="post">
			<div class="join">
			
				<div class="text">아이디</div><input class="joinInput" type="text" name="id" > <br>
				<div class="text">비밀번호</div><input class="joinInput" type="password" name="pw" > <br>
				<div class="text">비밀번호 확인</div><input class="joinInput" type="password" name="pwre" > <br>
				<div class="text">이메일</div><input class="joinInput" type="text" name="email" > <br>
				<div class="text">이름</div><input class="joinInput" type="text" name="name" > <br>
				<div class="text">사용할 별명</div><input class="joinInput" type="text" name="fakeName" > <br>
				<div class="text">핸드폰 번호</div><input class="joinInput" type="number" name="mobile" ><br>
				<div class="text">주소</div><input class="joinInput" type="text" name="address" > <br>
				<div class="text">생년월일</div><div class="joinInput" class="flex"><util:selectBirth /></div>
				
				<div class="text">성별</div>
					<div class="gender" class="joinInput">
						<div class="manBtn">
							<label for="man" class="man">남자</label>
							<input class="pointer" type="radio" name="sex" value="남자" >
						</div>
						<div class="womanBtn">
							<label for="woman" class="man">여자</label>
							<input class="pointer" type="radio" name="sex" value="여자">
						</div>
					</div>
				
				<div class="joinbox"><button class="joinBtn">회원가입</button></div>
			</div>
		</form>
	</div>
</layout:main>
