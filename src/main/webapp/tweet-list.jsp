<%@page import="model.entity.TweetBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<TweetBean> tweetList = (List) request.getAttribute("tweetList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tweet一覧</title>
</head>
<body>
	<h1>tweet一覧</h1>
	<a href="tweet-register">tweet登録</a>
	<a href="top.jsp">トップ画面</a>
	<table>
		<thead>
			<tr>
				<th>名前</th>
				<th>メッセージ</th>
				<th>更新日</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<%
			for (TweetBean tweet : tweetList) {
			%>
			<tr>
				<td><%=tweet.getName()%></td>
				<td><%=tweet.getMessage()%></td>
				<td><%=tweet.getUpdateDate()%></td>
				<td><a href="tweet-edit?id=<%=tweet.getId()%>">編集</a></td>
				<td><a href="tweet-delete?id=<%=tweet.getId()%>">削除</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>
