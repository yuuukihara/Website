<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/Style.css">
	<title>けいさん</title>
</head>

<body>
<div class="header"></div>

<div class="continer">
	<h2 class="top" >でんたく</h2>
	<form action="Keisan" method="post">
		<input type="text" name="keisan" class="input"><br>
		<div class="rei"><span>スペースで区切って</span>数字を入力してください</div>
		<p><select name="way" class="pull">
			<option value="1">＋</option>
			<option value="2">－</option>
			<option value="3">×</option>
			<option value="4">÷</option>
			<option value="5">平均(入力した値の平均)</option>
			<option value="6">円の面積(半径を入力)</option>
			<option value="7">乱数取得</option>
			<option value="8">おつりの計算(1,商品の値段,2支払い金額)</option>
		</select></p>
		<input type="submit" value="計算" class ="sub">
	</form><br>
</div>

<div class="footer"></div>

</body>
</html>