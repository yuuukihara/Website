<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>

登録
<s:form action="UserCreateConfirmAction">
	<p>ログインId</p>
	<s:textfield name="loginId"/>
	<p>ユーザー名</p>
	<s:textfield name="userName"/>
	<p>パスワード</p>
	<s:password name="password"/>
	<s:submit value="登録"/>
</s:form>

</body>
</html>