<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<layout:main>
<form action="<c:url value="/withdrawal" /> " method="post" >
탈퇴하시려 하는 이유를 적어주세요.<input type="text" >

<button>탈퇴</button>
</form>
</layout:main>