<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<layout:main title="신체정보 변경">
<form method="post" action="<c:url value="/mypage/physical" />" target="ifrmProcess">
키<input type="number" name="heightRe" value="${member.height}">
몸무게<input type="number" name="weightRe" value="${member.weight}">
나이 <input type="number" name="ageRe" value="${member.age}">

<c:if test="${member.sex eq '남자'}">
<div>
	<label for="man">남자</label>
	<input type="radio" name="sexRe" value="남자" checked="checked">
	<label for="woman">여자</label>
	<input type="radio" name="sexRe" value="여자">
</div>
</c:if>

<c:if test="${member.sex eq '여자'}">
<div>
	<label for="man">남자</label>
	<input type="radio" name="sexRe" value="남자" >
	<label for="woman">여자</label>
	<input type="radio" name="sexRe" value="여자" checked="checked">
</div>
</c:if>

<button type="reset">다시 입력</button>
<button type="submit">변경 하기</button>
<button ><a href="<c:url value="/member/mypage/mypage.jsp"/>">돌아가기</a></button>
</form>
</layout:main>