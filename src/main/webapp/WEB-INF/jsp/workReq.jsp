<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// セッションスコープからuserIdを取得
String login = (String) session.getAttribute("userId");

// リクエストスコープに保存されたsuccessMsgを取得
String successMsg = (String) request.getAttribute("successMsg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>申請</title>
<link href="css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header>
		<div class="right">
			<a href="Main">打刻画面</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="MonthRecord">打刻一覧</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="Logout">ログアウト</a>
		</div>
	</header>
	<main>
		<h1>申請</h1>		
		<%
		if (successMsg != null) {
		%>
		<p class="successMsg center"><%=successMsg%></p>
		<%
		}
		%>
		<P class="center"><%= login %>さん</p>
		<div class="center">
			<form action="WorkReqListS" method="post">
				<input type="hidden" name="name" value="<%= login %>">
				<table class="gcSilver">
					<tbody>
						<tr>
							<td>日時</td>
							<td><input type="datetime-local" name="workReqDate" required></td>
						</tr>
						<tr>
							<td></td>
							<td>※休み希望の場合は時間は00:00にする事</td>
						</tr>
						<tr>
							<td>勤務</td>
							<td>
								<select name="workReqWork" required>
									<option value="出勤" selected>出勤</option>
									<option value="休入">休入</option>
									<option value="休終">休終</option>
									<option value="退勤">退勤</option>
									<option value="退勤">休み希望</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>理由</td>
							<td>
								<select name="workReqReason" required>
									<option value="打刻忘れ" selected>打刻忘れ</option>
									<option value="休み希望">休み希望</option>
									<option value="その他">その他</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>理由詳細</td>
							<td>
								<input type="text" name="workReqNote" size="34" placeholder="上記理由でその他を選択した場合のみ記入">
							</td>
						</tr>
					</tbody>
				</table>
				<input type="submit" value="送信" class="right">
			</form>
		</div>
		<br>
	</main>
</body>
</html>