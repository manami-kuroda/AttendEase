<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// リクエストスコープに保存されたerrorMsgを取得
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者ログイン</title>
<link href="css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>管理者ログイン</h1>
	<div class="center">
		<%
		if (errorMsg != null) {
		%>
		<p class="errorMsg"><%=errorMsg%></p>
		<%
		}
		%>
		<form action="MasterLoginS" method="post">
			ユーザーID：<input type="text" name="userId"><br>
			パスワード：<input type="password" name="pass"><br><br>
			<input type="submit" value="ログイン"><br><br>
		</form>
	</div>
	<div class="right">
		<a href="index.jsp">戻る</a>
	</div>
</body>
</html>