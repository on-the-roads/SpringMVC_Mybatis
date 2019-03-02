<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>登录页面</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<h1>
			用户登录界面
		</h1>
		<c: if test="${errmsg!=null }">
			<font color="#ff0000">${errmsg }</font>
		</c:>
		<form action="${pageContext.request.contextPath}/user/login.action"
			method="post">
			用户名
			<input type="text" name="username">
			<br>
			密&nbsp;&nbsp;&nbsp;&nbsp;码
			<input type="password" name="password">
			<br><div align="left">
			<input type="submit" value="登录"> 
		</div></form>
	</body>
</html>
