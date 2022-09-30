<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<link rel="stylesheet" href="<c:url value="/static/css/member/login.css" />"/>

<layout:main title="로그인">

<form target="ifrmProcess" action="<c:url value="/login" />" method="post">
<div class="login_kmh">
	아이디 : <input type="text" name="id" > <br>
	비밀번호 : <input type="password" name="pw" > <br>
	<button>로그인</button>	

</div>
</form>
</layout:main>