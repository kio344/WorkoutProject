<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String[] addCss={"upload.css"};
	String[] addJs={"upload.js"};
	request.setAttribute("addCss", addCss);
	request.setAttribute("addJs", addJs);

%>
<link rel="stylesheet" href="<c:url value="/static/css/file/upload.css" />" />
<script src="<c:url value="/static/js/file/upload.js" />"  type="text/javascript"> </script>

	<div id="drop" data-gid="123">
		<h1>파일을 드래그 해주세요</h1>
	</div>
	<ul id="files">
	
	</ul>

	<script id="tmp" type="text/html">
`		<li id="file">
			<a target="ifrmProcess" href="<c:url value="/file/download?&num=#_num_" />
">#_fileName_</a>
			<a target="ifrmProcess" href="<c:url value="/file/delete?&num=#_num_" />">
			[X]
			</a>
	</li>
	</script>
	
	<iframe name="ifrmProcess" width="0" height="0px" class="dn"></iframe>
