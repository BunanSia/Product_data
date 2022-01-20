<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Welcome to Admin login system</title>
</head>
<body>
	<div align="center">
		<h1>Login form</h1>
		<form action="<%=request.getContextPath()%>/index"method="post">
		 <table style="with:80%">
		 <tr>
		 <td>Username</td><td><input type="text" name="username"/></td>
		 </tr>
		 <tr>
		 <td>Passwords</td>
		 <td><input type="password" name="password"/></td>
		 </tr>
		 </table>
		 <input type="submit" name="Submit"/>
		 </form>
		 <p>Don't have an account?<a href="register" style="font-size: 17px;">Register now</a></p>
		 </div>
</body>
</html>