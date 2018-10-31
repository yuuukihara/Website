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

<h1>つぶやく</h1>
	<s:property value="#session.errorMassage"/>
<s:form action="TweetConfirmAction">
	<s:textfield name="title"/>
	<s:textfield name="text"/>
	<s:submit value="ツイート"/>
</s:form>

</body>
</html>