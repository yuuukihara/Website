<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<style type="text/css">

	.contentForm{
		height:auto;
	}

	.mainForm {
		border-radius: 20px;
	   	height: auto;
	   	padding:20px;
	   	background-color: #F2F2F2;
	   	width: 95%;
	   	margin:10px auto;
	}

	.box {
		width: 100%;
	}

	.inputForm {
		width: 98%;
		height: 30px;
		border-radius: 20px;
		box-shadow: 0 0 8px steelblue;
		margin: 10px;
		margin-bottom: 20px;
	}

	</style>
</head>

<body>
<div class="contentForm">
	<div class="mainForm">
	<s:form action="LoginConfirmAction">
		<div class="box">

			<div class="title">ログインId</div>
			<s:textfield name="loginId" class="inputForm"/>

			<div class="pass">パスワード</div>
			<s:password name="password" class="inputForm"/>

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