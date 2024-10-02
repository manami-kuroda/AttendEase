<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Login"%>
<%@ page import="java.time.LocalDateTime"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%
// セッションスコープからuserIdを取得
String login = (String) session.getAttribute("userId");
// セッションスコープからそれぞれの時間を取得
LocalDateTime workIn = (LocalDateTime) session.getAttribute("workIn");
LocalDateTime breakIn = (LocalDateTime) session.getAttribute("breakIn");
LocalDateTime breakOut = (LocalDateTime) session.getAttribute("breakOut");
LocalDateTime workOut = (LocalDateTime) session.getAttribute("workOut");
// 本日の日付を取得
LocalDateTime now = LocalDateTime.now();
// 各フォーマットを作成
DateTimeFormatter topDate = DateTimeFormatter.ofPattern("yyyy年MM月dd日 (E)");
DateTimeFormatter topTime = DateTimeFormatter.ofPattern("HH：mm");
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd HH:mm");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>打刻</title>
<link href="css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header>
		<div class="right">
			<a href="MonthRecord">打刻一覧</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="WorkReqS">申請</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="Logout">ログアウト</a>
		</div>
	</header>
	<main>
		<h1><%=login%>さん</h1>
		<p class="center"><%=now.format(topDate)%></p>
		<p class="center font20"><%=now.format(topTime)%></p>
		<div class="center">
			<form action="TimeStamping" method="post">
				<input type="submit" name="action" value="出勤">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" name="action" value="休入"
					<c:if test="${empty sessionScope.workIn}">disabled</c:if> /> <br><br> 
				<input type="submit" name="action" value="退勤"
    				<c:if test="${empty sessionScope.workIn || (not empty sessionScope.breakIn && empty sessionScope.breakOut)}">disabled</c:if> />&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" name="action" value="休終"
					<c:if test="${empty sessionScope.breakIn}">disabled</c:if> />
			</form>
		</div>
		<br>
		<div class="center">
			<p>----------打刻時間----------</p>
			<table>
			<tbody>
				<tr>
					<td>出勤時間：</td>
					<td><%=workIn != null ? workIn.format(formatter) : ""%></td>
				</tr>
				<tr>
					<td>休入時間：</td>
					<td><%=breakIn != null ? breakIn.format(formatter) : ""%></td>
				</tr>
				<tr>
					<td>休終時間：</td>
					<td><%=breakOut != null ? breakOut.format(formatter) : ""%></td>
				</tr>
				<tr>
					<td>退勤時間：</td>
					<td><%=workOut != null ? workOut.format(formatter) : ""%></td>
				</tr>
			</tbody>
			</table>
		</div>
	</main>
</body>
</html>
