<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>

<layout:main>

<form target="ifrmProcess" action="<c:url value="/mypage" /> " method="post" >
아이디 <input type="text" disabled value="${member.id }" name="id" >
현재 비밀번호 <input type="password" name="pw" >
비밀번호 변경 <input type="password" name="repw" >
비밀번호 변경 확인 <input type="password" name="repwRe" >
이름 변경 <input type="text" value="${member.name }" name="nameRe" >
이메일 변경 <input type="text" value="${member.email }" name="emailRe" > 
핸드폰 번호 변경 <input type="number" value="${member.mobile }" name="mobileRe" >
주소 변경 <input type="text" value="${member.address }" name="addressRe" >

<button>완료</button>
</form>

</layout:main>