<%@ tag body-content="empty" pageEncoding="UTF-8" %>
<%@ tag import="java.time.LocalDateTime" %>
<%@ attribute name="year" type="java.lang.Integer" %>
<%@ attribute name="month" type="java.lang.Integer" %>
<%@ attribute name="day" type="java.lang.Integer" %>

<%
LocalDateTime date = LocalDateTime.now();
int syear = date.getYear() - 100;
int eyear = date.getYear();
%>

<select name="year">
<%
	for (int i = eyear; i >= syear; i--) {
		out.println("<option value='" + i + "'>" + i + "</option>");
	}
%>
</select>

<select name="month">
<%
	for (int i = 1; i <= 12; i++) {
		out.println("<option value='" + i + "'>" + i + "</option>");
	}
%>
</select>

<select name="day">
<%
	for (int i = 1; i <= 31; i++) {
		out.println("<option value='" + i + "'>" + i + "</option>");
	}
%>
</select>

<!-- <input type="date"> -->