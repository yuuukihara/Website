<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<style type="text/css">
	.main{
		height:auto;
		padding:5% 5%;
		background-color:hotpink;
	}
	.main-form{
		width:100%;
		background-color:aliceblue;
		padding:10px;
	}
	.right{
		float:right;
		width:30%;
		border:solid 2px black;
		padding-top:20px;
		font-size:20px;
	}
	.left{
		float:clear;
		background-color:royalblue;
		width:68%;
		border:solid 2px black;
		text-align:center;
	}
	.tweetbox{
		display:inline-block;
		margin:10px;
		background-color:white;
		border-radius:20px;
		border:solid 2px black;
		width:90%;
	}
 	.title{
	 	text-align:left;
		background-color:red;
		border-bottom:solid 2px black;
	}
	.text{
		text-align:left;
		background-color:green;
	}
	.userName{
		text-align:right;
		background-color:pink;
		font-size:15px;
		border-top:solid 1px black;
	}

	</style>
</head>
<body>
<div class="main">
	<div class="main-form">
		<div class="right">
			<!-- ログインしている時ログアウトを表示、逆も然り -->
			<s:if test="!#session.logined==0">
				<a href="<s:url action="LogoutAction"/>">ログアウト</a>
			</s:if>
			<s:else>
				<a href="<s:url action="LoginAction"/>">ログイン</a>
			</s:else>

			<p><a href="<s:url action="TweetAction"/>">つぶやく</a></p>
			<p><a href="<s:url action="CreateUserAction"/>">新規</a></p>
			<p><a href="<s:url action="SeeUserInfoAction"/>">ユーザー一覧</a></p>
			<p><s:property value="#session.userName"/><br><s:if test="#session.logined==1">でログイン中</s:if></p>
		</div>

		<div class="left">
			<s:iterator value="#session.tweetDTOList">
				<div class="tweetbox">
					<p class="title">件名:<s:property value="title"/></p>
					<p class="text"><s:property value="text"/></p>
					<p class="userName">by <s:property value="userName"/></p>
				</div>
			</s:iterator>
		</div>
	</div>

</div>
</body>
</html>