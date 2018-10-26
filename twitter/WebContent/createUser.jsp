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

<s:form action="CreateUserConfirmAction">
	id:<s:textfield name="loginId"/><br>
	pass:<s:textfield name="password"/><br>
	name:<s:textfield name="userName"/><br>
	<s:submit value="登録"/>
</s:form>

</body>
</html>