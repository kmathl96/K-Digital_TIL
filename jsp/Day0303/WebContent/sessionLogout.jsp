<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% session.removeAttribute("id"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Logout</title>
</head>
<body>
	<h3>로그아웃 되었습니다.</h3>
	<a href="sessionLogin.jsp">로그인</a>
</body>
</html>