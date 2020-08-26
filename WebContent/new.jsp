<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:include page="WEB-INF/layout/head.jsp" flush="true">
<jsp:param name="title" value="商品リスト管理・商品登録" />
</jsp:include>
<body>
<jsp:include page="WEB-INF/layout/header.jsp" flush="true" />
<br />
<div class="row">
	<div class="col-xl-2"></div>
	<div class="col-xl-5">
	<p class="h2 text-center">商品登録</p><br />
	<form action="Insert" method="post">
		<label>商品番号</label>
		<input type="text" name="jnum" class="form-control form-control-sm" placeholder="" /><br />
		<label>商品名</label>
		<input type="text" name="jname" class="form-control form-control-sm" placeholder="" /><br />			
		<label>備考</label>
		<input type="text" name="jnote" class="form-control form-control-sm" placeholder="" /><br />
		<input class="btn btn-primary" type="submit" value="登録"><br />
	</form>
	</div>
	<div class="col-xl-5"></div>
</div>
<jsp:include page="WEB-INF/layout/footer.jsp" flush="true" />
</body>
</html>