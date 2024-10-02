<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Record"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%
    // セッションから月ごとの記録を取得
    List<Record> monthRecord = (List<Record>) request.getAttribute("monthRecord");
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>打刻一覧</title>
<link href="css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header>
		<div id="top" class="right">
			<a href="Main">打刻画面</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="WorkReqS">申請</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="Logout">ログアウト</a>
		</div>
	</header>
	<main>
		<h1>勤怠記録一覧</h1>
		<div class="center">
		<% if (monthRecord != null && !monthRecord.isEmpty()) { %>
		<table  border="1">
			<colgroup>
				<col class="width120">
				<col span="4" class="width70">
			</colgroup>
			<thead>
				<tr>
					<th>日付</th>
					<th>出勤時間</th>
					<th>休入時間</th>
					<th>休終時間</th>
					<th>退勤時間</th>
				</tr>
			</thead>
			<tbody>
				<% for (Record record : monthRecord) { %>
				<tr>
					<td><%= record.getWorkDate().format(dateFormatter) %></td>
					<td><%= record.getWorkIn().format(timeFormatter) %></td>
					<td><%= (record.getBreakIn() != null) ? record.getBreakIn().format(timeFormatter) : "" %></td>
					<td><%= (record.getBreakOut() != null) ? record.getBreakOut().format(timeFormatter) : "" %></td>
					<td><%= record.getWorkOut().format(timeFormatter) %></td>
				</tr>
				<% } %>
			</tbody>
		</table>
		<% } else { %>
		<p>記録はありません。</p>
		<% } %>
		</div>
		<br>
		<div id="page_top">
			<a href="#top">ページトップへ</a>
		</div>
	</main>
	<footer>
		<div class="right">
			<a href="Main">打刻画面</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="WorkReqS">申請</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="Logout">ログアウト</a>
		</div>
	</footer>
</body>
</html>
