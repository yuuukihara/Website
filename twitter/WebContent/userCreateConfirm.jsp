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

<h2>こちらで登録しますか?</h2>

<s:form action="LoginCompleteAction">
	<table>
		<tr class="box">
			<th scope="row"><s:label value="ログインId"/></th>
			<td><s:property value="loginId"/></td>
		</tr>
		<tr class="box">
			<th scope="row"><s:label value="ユーザー名"/></th>
			<td><s:property value="userName"/></td>
		</tr>
		<tr class="box">
			<th scope="row"><s:label value="パスワード"/></th>
			<td><s:property value="password"/></td>
		</tr>
	</table>
	<s:submit value="登録"/>
</s:form>

</body>
</html>