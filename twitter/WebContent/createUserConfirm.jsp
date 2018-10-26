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

<s:form action="CreateUserCompleteAction">
	id:<s:property value="#session.loginId"/><br>
	password:<s:property value="#session.password"/><br>
	userName:<s:property value="#session.userName"/><br>
	<s:submit value="確認して登録"/>
</s:form>

登録しないでホームへ<a href="<s:url action="EnterAction"/>">戻る</a>

</body>
</html>