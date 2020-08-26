<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:include page="WEB-INF/layout/head.jsp" flush="true">
<jsp:param name="title" value="ページが見つかりません" />
</jsp:include>
<body>
<jsp:include page="WEB-INF/layout/header.jsp" flush="true" />
<br />
<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-8">
		<p class="h2 text-center">404 Not Found</p><br />
		<p class="text-center">指定されたページが見つかりませんでした。ホームリンクよりお戻り下さい。</p><br />
	</div>
	<div class="col-md-2"></div>
</div>
<br />
<jsp:include page="WEB-INF/layout/footer.jsp" flush="true" />
</body>
</html>