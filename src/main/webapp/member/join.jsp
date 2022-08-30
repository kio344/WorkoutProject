<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>

<layout:main title="회원가입">

<form target="ifrmProcess" action="<c:url value="/join" />" method="post">
<div class="join_kmh">

	아이디 : <input type="text" name="id" > <br>
	비밀번호 : <input type="password" name="pw" > <br>
	비밀번호 확인 : <input type="password" name="pwre" > <br>
	이메일 : <input type="text" name="email" > <br>
	이름 : <input type="text" name="name" > <br>
	사용할 별명 : <input type="text" name="fakeName" > <br>
	핸드폰 번호 : <input type="number" name="mobile" ><br>
	주소 : <input type="text" name="address" > <br>
	<div>
	성별 : <br>
		<label for="man">남자</label>
		<input type="radio" name="sex" value="남자" >
		<label for="woman">여자</label>
		<input type="radio" name="sex" value="여자">
	</div>
	<button>회원가입</button>
	
</div>
</form>


</layout:main>
