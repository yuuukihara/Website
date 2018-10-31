<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link rel="stylesheet" href="./css/login.css">
</head>

<body>
<div class="contentForm">
	<div class="mainForm">
	<s:if test="%{checkMassage != null}">
		<s:property value="checkMassage"/><br>
	</s:if>
		<s:form action="LoginConfirmAction">
			<div class="box">
				<div class="title">ログインId</div>
				<s:textfield name="loginId" class="inputForm"/>
			</div>
			<div class="box">
				<div class="pass">パスワード</div>
				<s:password name="password" class="inputForm"/>
			</div>
			<div class="box">
				<div class="btn">
					<s:submit value="ログイン" class="inputForm"/>
				</div>
			</div>
		</s:form>
	</div>
</div>
<body>
</body>
</html>