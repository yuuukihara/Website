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

<s:iterator value="#session.uidtoList">
	<table>
	<tr>
		<td><s:property value="userName"/></td>
	</tr>
	</table><br>
</s:iterator>

</body>
</html>