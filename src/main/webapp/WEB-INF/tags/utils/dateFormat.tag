<%@ tag description="날짜시간변환(LocalDateTime)" pageEncoding="utf-8"%>
<%@ tag body-content="empty"%>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ tag import="java.time.format.DateTimeFormatter, java.time.temporal.TemporalAccessor" %>
<%@ attribute name="value" type="java.time.temporal.TemporalAccessor" required="true" %>
<%@ attribute name="pattern" type="java.lang.String" %>

<%
	if(pattern == null || pattern.trim().isEmpty()) {
		pattern = "yyyy-MM-dd HH:mm:ss";
	}

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
	
%>
<%=(value == null) ? "" : formatter.format(value)%>