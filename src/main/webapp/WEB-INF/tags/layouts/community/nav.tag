<%@ tag body-content="empty" %>
<%@ tag pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="community_nav">
	<ul>
	<li><a href="<c:url value="/board/list?boardId=notice" />">공지사항</a></li>
	<li><a href="<c:url value="/board/list?boardId=notice" />">책소개</a></li>
		<ul>
			<li><a>이달의 책</a>  </li>
			<li><a>베스트셀러</a> </li>
			<li><a>최근 소식</a></li>
		</ul>
		
	<li><a href="<c:url value="/board/list?boardId=notice" />">커뮤니티</a></li>
		<ul>
			<li><a href="<c:url value="/board/list?boardId=free" />">자유 게시판</a></li>
			<li><a>토론 게시판</a></li>
			<li><a>정보 게시판</a></li>
		</ul>
	
	<li><a href="<c:url value="/board/list?boardId=notice" />">홍보</a></li>
	
	<li><a href="<c:url value="/board/list?boardId=notice" />">공모전</a></li>
	</ul>
</nav>