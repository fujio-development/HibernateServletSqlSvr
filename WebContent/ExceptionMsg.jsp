<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="java.lang.String" %>
<!DOCTYPE html>
<html>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:include page="WEB-INF/layout/head.jsp" flush="true">
<jsp:param name="title" value="例外が発生しました" />
</jsp:include>
<body>
<% String title = (String)request.getAttribute("title"); %>
<% String uri = (String)request.getAttribute("uri"); %>
<% String code = (String)request.getAttribute("code"); %>
<% String message = (String)request.getAttribute("msg"); %>
<% String trace = (String)request.getAttribute("trace"); %>
<jsp:include page="WEB-INF/layout/header.jsp" flush="true" />
<br />
<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-8">
		<p class="h2 text-center">アプリケーションで例外が発生しました。</p><br />
		<table class="table table-sm table-dark">
			<tr class="table-primary">
				<th style="width:30%">題名</th>
				<th style="width:70%">内容</th>
			</tr>
			<tr class="table-light">
				<td>例外クラス</td>
				<td><%= title %></td>
			</tr>
			<tr class="table-light">
				<td>例外発生URI</td>
				<td><%= uri %></td>
			</tr>
			<tr class="table-light">
				<td>HTTPステータスコード</td>
				<td><%= code %></td>
			</tr>
			<tr class="table-light">
				<td>例外メッセージ</td>
				<td><%= message %></td>
			</tr>
			<tr class="table-light">
				<td>スタックトレース</td>
				<td><%= trace %></td>
			</tr>
		</table>
	</div>
	<div class="col-md-2"></div>
</div>
<br />
<jsp:include page="WEB-INF/layout/footer.jsp" flush="true" />
</body>
</html>