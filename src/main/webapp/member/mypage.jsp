<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<layout:main title="마이페이지">
<form method="post" action="<c:url value="/mypage" />" target="ifrmProcess">

아이디 <input type="text" disabled name="id" value="${member.id}">
	<input type="hidden" name="pw" value="${member.password}">
이름 <input type="text" name="name" value="${member.name}">
이메일 <input type="email" name="email" value="${member.email}">
전화번호 <input type="text" name="mobile" value="${member.mobile}">
주소 <input type="text" name="address" value="${member.address}">
키 <input type="text" name="height" value="${member.height}">
몸무게 <input type="text" name="weight" value="${member.weight}">
나이 <input type="text" name="age" value="${member.age}">
성별 <input type="text" name="sex" value="${member.sex}">

</form>
</layout:main>