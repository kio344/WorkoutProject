<%@ tag body-content="empty" pageEncoding="utf-8"%>
<%@ attribute name="paginationCount" required="true"%>
<!-- 페이지네이션 최대 갯수 -->
<%@ attribute name="pageCount" required="true"%>
<!-- 현제 페이지 -->
<%@ attribute name="total" required="true"%>
<!--  페이지 총 갯수 -->

<%@ attribute name="link" required="true" %>
<!-- 주소값 넣어주면 됨 (내부에서 c:url 처리해줌) --> 


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="pagination">
	<%
	int _paginationCount = Integer.parseInt(paginationCount);
	for (int i = 0; i < _paginationCount ; i++) {
		int num=Integer.parseInt(pageCount) + i-(Integer.parseInt(paginationCount)-1)/2;
		int pageTotal=Integer.parseInt(total);
		if(num>0){
			if(num<=pageTotal){
	%>
	<div class="<%out.print(num==Integer.parseInt(pageCount)? "nowPage":"");%>" >
		<a href="<c:url value="${link }" />num=<%=num %>" ><%=num %></a>
	</div>
	
	<%
			}
		}else{
			_paginationCount++;
		}
	}
	%>

	<!-- ${ pageCount + i-(paginationCount-1)/2 } -->

	<!--
		 3 = 5 - 2 
		 4 = 5 - 1
		 5 = 5 - 0
		 6 = 5 + 1
		 7 = 5 + 2
		 -->


</div>
