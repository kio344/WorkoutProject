<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout"  tagdir="/WEB-INF/tags/layouts/"  %>
<%@ taglib prefix="community"  tagdir="/WEB-INF/tags/layouts/community/"  %>


<layout:main>
<community:nav/>
<div class="center">
	<div class="outer">
		<div class="board">
			<div>
				<h3>공지사항</h3>	<a href="<c:url value="/board/list?boardId=notice" />">전체보기</a>
			</div>
			<div class="boardEl">	
			<ul>
				<c:forEach items="${notice }" var="board">
		
					<li> 
					
						<a href="<c:url value="/board/view?gid=${board.gid }" />"><span>${board.id }</span>	<span>${board.subject }</span><span>${board.poster }</span></a>
					
					</li> 
		
				</c:forEach>
			</ul>
			</div>
			
		</div>
		
		
		<div class="board">
			<div>
				<h3>최근 게시물</h3>	
			</div>
			<div class="boardEl">
			<ul>
			<!-- <li> 
					
				<a><span>게시물 번호</span>	<span>게시글</span><span>작성자</span></a>
						
			</li>  -->
		 	<c:forEach  items="${recent}" var="board">
		 	
					<li> 
					
						<a href="<c:url value="/board/view?gid=${board.gid }" />"><span>${board.id }</span>	<span>${board.subject }</span><span>${board.poster }</span></a>
					
					</li> 
						
			</c:forEach> 
			</ul>
			</div>
		</div>
		
		
	</div>
	<div class="outer">
		<div class="board">
			<div>
				<h3>자유게시판</h3>	<a href="<c:url value="/board/list?boardId=free" />">전체보기</a>
			</div>
			<div class="boardEl">
			<ul>
				<c:forEach items="${free }" var="board">
		
					<li> 
					
						<a href="<c:url value="/board/view?gid=${board.gid }" />"><span>${board.id }</span>	<span>${board.subject }</span><span>${board.poster }</span></a>
					
					</li> 
		
				</c:forEach>
			</ul>
			</div>
			
		</div>
		
		
		<div class="board">
			<div>
				<h3>테스트 게시판</h3>	<a href="<c:url value="/board/list?boardId=free" />">전체보기</a>
			</div>
			<div class="boardEl">
			<ul>
			<!-- <li> 
					
				<a><span>게시물 번호</span>	<span>게시글</span><span>작성자</span></a>
						
			</li>  -->
		 	<c:forEach  items="${test}" var="board">
		 	
					<li> 
					
						<a href="<c:url value="/board/view?gid=${board.gid }" />"><span>${board.id }</span>	<span>${board.subject }</span><span>${board.poster }</span></a>
					
					</li> 
						
			</c:forEach> 
			</ul>
			</div>
		</div>
		
		
	</div>
</div>


</layout:main>

