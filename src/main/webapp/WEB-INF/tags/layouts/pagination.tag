<%@tag import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@tag import="java.util.Collections"%>
<%@tag import="java.util.ArrayList"%>
<%@ tag description="jms 페이지네이션" body-content="empty"
	pageEncoding="utf-8"%>
<%@ attribute name="paginationCount" type="java.lang.Integer"
	required="true"%>
<!-- 페이지네이션 갯수 : 현제 페이지 앞뒤에 생기는 개수-->
<%@ attribute name="pageCount" type="java.lang.Integer" required="true"%>
<!-- 현제 페이지 -->
<%@ attribute name="total" type="java.lang.Integer" required="true"%>
<!--  페이지 총 갯수 -->

<%@ attribute name="link" required="true"%>
<!-- 주소값 넣어주면 됨 (내부에서 c:url 처리해줌) -->


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="pagination">
<!-- 페이지네이션 설정 -->
	<%
	ArrayList<Integer> pageList = new ArrayList();

	pageList.add(pageCount);

	for (int i = 0; i < paginationCount; i++) {

		int max = Collections.max(pageList);
		int min = Collections.min(pageList);

		if (max < total) {
			pageList.add(++max);

		} else {
			if (min - 1 >= 1) {
				pageList.add(--min);

			}
		}

		if (min - 1 >= 1) {
			pageList.add(--min);

		} else {
			if (max < total) {
				pageList.add(++max);
	
			}
		}
	}

	Collections.sort(pageList);
	%>

<%
int max = Collections.max(pageList);
int min = Collections.min(pageList);
System.out.println(pageList);
%>

<!-- 페이지네이션 생성 -->

<%
if(min>1){
%>
	
	
	<div class="">
		<a href="<c:url value="${link }" />num=1">1</a>
	</div>
	
	<div>
	<a>◀</a>
	</div>
	<%
}
%>

<%
for(int num:pageList){
%>
	<div class="<%out.print(num == pageCount ? "nowPage" : "");%>">
		<a href="<c:url value="${link }" />num=<%=num %>"><%=num%></a>
	</div>
<%
}
%>

<%
if(max<total){
	%>
	<div>
	<a>▶</a>
	</div>
	
	<div class="">
		<a href="<c:url value="${link }" />num=<%=total %>"><%=total%></a>
	</div>
	
	<%
}
%>


	<%-- 
	<%
	int _paginationCount = Integer.parseInt(paginationCount);
	for (int i = 0; i < _paginationCount; i++) {
		int num = Integer.parseInt(pageCount) + i - (Integer.parseInt(paginationCount) - 1) / 2;
		int pageTotal = Integer.parseInt(total);
		if (num > 0) {
			
			if (num <= pageTotal) {
				%>
					<div class="<%out.print(num == Integer.parseInt(pageCount) ? "nowPage" : "");%>">
						<a href="<c:url value="${link }" />num=<%=num %>"><%=num%></a>
					</div>

				<%
				}
				
			} else {
			_paginationCount++;
		}
	}
	%>
 --%>
</div>
