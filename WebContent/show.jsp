<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="java.util.List" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="web.sample.ShohinMap" %>
<!DOCTYPE html>
<html>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:include page="WEB-INF/layout/head.jsp" flush="true">
<jsp:param name="title" value="商品リスト管理・商品一覧表" />
</jsp:include>
<body>
<% List<ShohinMap> list = (List<ShohinMap>) request.getAttribute("reqlist"); %>
<jsp:include page="WEB-INF/layout/header.jsp" flush="true" />
<br />
<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-8">
		<p class="h2 text-center">商品一覧表</p><br />
		<p class="text-center">Hibernate + サーブレット + SQLServerで読み書きするサンプル。</p><br />
		<table class="table table-sm table-dark">
			<tr class="table-primary">
				<th>商品ID</th>
				<th>商品番号</th>
				<th>商品名</th>
				<th>編集日付</th>
				<th>編集時刻</th>
				<th>備考</th>
				<th>--</th>
				<th>--</th>
			</tr>
			<% for (ShohinMap bean : list) { %>
			<tr class="table-light">
				<td><%= bean.getNumId() %></td>
				<td><%= bean.getShohinCode() %></td>
				<td><%= bean.getShohinName() %></td>
				<td><%= bean.getEditDate() %></td>
				<td><%= bean.getEditTime() %></td>
				<td><%= bean.getNote() %></td>
				<td><a href="Update?id=<%= bean.getNumId() %>" class="btn btn-primary">更新</a></td>
				<td><a href="Delete?id=<%= bean.getNumId() %>" class="btn btn-primary">削除</a></td>
			</tr>
			<% } %>
		</table>
		<br />
		<form action="Control" method="post">
			<div class="form-group">
			<label for="inputsm">HQL:</label>
			<input type="text" name="jhql" class="form-control form-control-sm" value="from web.sample.ShohinMap" />
			<input class="btn btn-primary" type="submit" value="検索" /><br />
			</div>
		</form>
	</div>
	<div class="col-md-2"></div>
</div>
<br />
<jsp:include page="WEB-INF/layout/footer.jsp" flush="true" />
</body>
</html>