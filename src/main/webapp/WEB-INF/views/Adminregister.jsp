<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>User register</title>
</head>
<body>
	<div align="center">
		<h1>Employee register form</h1>
		<form action="<%=request.getContextPath()%>/register"method="post">
		 <table style="with:80%">
		 <tr>
		 <td>First name</td>
		 <td><input type="text" name="firstname"/></td>
		 </tr>
		 <tr>
		 <td>Last name</td>
		 <td><input type="text" name="lastname"/></td>
		 </tr>
		 <tr>
		 <td>Username</td>
		 <td><input type="text" name="username"/></td>
		 </tr>
		 <tr>
		 <td>Passwords</td>
		 <td><input type="text" name="password"/></td>
		 </tr>
		 <tr>
		 <td>Address</td>
		 <td><input type="text" name="address"/></td>
		 </tr>
		 <tr>
		 <td>Contact No</td>
		 <td><input type="text" name="contact"/></td>
		 </tr>
		 </table>
		 <input type="submit"name="Submit"/>
		</form>
		</div>

</body>
</html>