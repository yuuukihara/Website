<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<link rel="stylesheet" href="./css/login.css">
</head>
<body>

<div class="contentForm">
	<div class="mainForm">
		<s:form action="CreateUserConfirmAction">
			<div class="box">
				<p>ログインId</p>
				<s:textfield name="loginId" class="inputForm"/>
			</div>
			<div class="box">
				<p>ユーザー名</p>
				<s:textfield name="userName" class="inputForm"/>
			</div>
			<div class="box">
				<p>パスワード</p>
				<s:password name="password" class="inputForm"/>
			</div>
			<div class="box">
				<div class="btn">
					<s:submit value="登録" class="inputForm"/>
				</div>
			</div>
		</s:form>
	</div>
</div>
</body>
</html>