<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<link rel="stylesheet" href="./css/login.css">
	<style type="text/css">
	.goHome{
		float:right;
	}
	</style>
</head>
<body>

<div class="contentForm">
	<div class="mainForm">
		<s:form action="CreateUserCompleteAction">
			<table>
				<tr class="confirmBox">
					<th scope="row"><s:label value="ログインId"/>：</th>
					<td><s:property value="loginId"/></td>
				</tr>
				<tr class="confirmBox">
					<th scope="row"><s:label value="ユーザー名"/>：</th>
					<td><s:property value="userName"/></td>
				</tr>
				<tr class="confirmBox">
					<th scope="row"><s:label value="パスワード"/>：</th>
					<td><s:property value="password"/></td>
				</tr>
			</table>
			<div class="btn">
				<s:submit value="確認して登録" class="inputForm"/>
			</div>
		</s:form>
		<div class="goHome">ホームへ戻る場合は<a href="<s:url action="EnterAction"/>">こちら</a></div>
	</div>
</div>

</body>
</html>