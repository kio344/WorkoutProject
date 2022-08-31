<%@tag import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ tag description="페이지 네이션" pageEncoding="utf-8" %>
<%@ tag body-content="empty" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ tag import="commons.Pagination" %>
<%@ attribute name="page" type="java.lang.Integer" %>
<%@ attribute name="total" type="java.lang.Integer" required="true" %>
<%@ attribute name="pageCnt" type="java.lang.Integer" %>
<%@ attribute name="url" type="java.lang.String" required="true" %>
<%@ attribute name="limit" type="java.lang.Integer" %>
<%
	pageCnt = pageCnt == null ? 10 : pageCnt;
	url = request.getContextPath() + "/" + url;
	if(url.indexOf("?") == -1) {
		url += "?page=";
	} else {
		url += "&page=";
	}
	
	Pagination pagination = new Pagination(page, total, pageCnt, limit);
	
	out.print("<div class='pagination'>");
	if(!pagination.isFirstCnt()) {
		String prevUrl = url + pagination.getPrev();
		String firstUrl = url + 1;
		out.println("<a href='" + firstUrl + "' class='first'>First</a>");
		out.println("<a href='" + prevUrl + "' class='prev'>Prev</a>");
	}
	for(int p : pagination.getPages()) {
		String pageUrl = url + p;
		StringBuffer sb = new StringBuffer("<a href='");
		sb.append(pageUrl);
		sb.append("' class='page");
		if(page == p) {
			sb.append(" on");
		}
		sb.append("'>");
		sb.append("" + p);
		sb.append("</a>");
		out.println(sb.toString());
	}
	if(!pagination.isLastCnt()) {
		String nextUrl = url + pagination.getNext();
		String lastUrl = url + pagination.getLastPage();
		out.println("<a href='" + nextUrl + "' class='next'>Next</a>");
		out.println("<a href='" + lastUrl + "' class='last'>Last</a>");
	}
	out.println("</div>");
	
%>








<!-- 
	1. 현재 페이지 번호
	2. 전체 게시글 수
	3. 페이지 구간 수
 -->