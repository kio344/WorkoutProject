<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<layout:main>
	<div class="userInfo">
		<h2>신체 정보를 입력해주세요.</h2>
		<form method="post" action="<c:url value="/purpose" />" target="ifrmProcess" autocomplete="off">
			<label for="height">키</label>
			<input type="number" id="height" name="height" placeholder="키를 입력하세요." step="0.1" value="${member.height}">
			<label for="weight">몸무게</label>
			<input type="number" id="weight" name="weight" placeholder="몸무게를 입력하세요." step="0.1" value="${member.weight}">
			<label for="age">나이</label>
			<input type="number" name="age" id="age" placeholder="나이를 입력하세요." value="${member.age}">
			<h4>성별</h4>
			<label for="man">남자</label>
			<input type="radio" name="sex" id="man"${member.sex eq "man" ? " checked" : "" } value="man">
			<label for="woman">여자</label>
			<input type="radio" name="sex" id="woman"${member.sex eq "woman" ? " checked" : "" } value="woman">
			<button type="submit" id="btn">검사하기</button>
		</form>
	</div>
	<div class="bmi_info">
	<div>
		<h3>당신의 기초대사량은 ${bmiInfo.base} 입니다.</h3>
	</div>
	<div>
		<h3>당신의 bmi 수치는 ${bmiInfo.bmi}으로 ${bmiInfo.bmiWe} 상태입니다. </h3>
	</div>
</div>
</layout:main>