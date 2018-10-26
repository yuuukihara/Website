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

<h2>こちらで登録しますか?</h2>
<s:form action="LoginCompleteAction">
	ログインId:<s:property value="loginId"/><br>
	ユーザー名:<s:property value="userName"/><br>
	パスワード:<s:property value="password"/><br>
	<s:submit value="登録"/>
</s:form>


</body>
</html>