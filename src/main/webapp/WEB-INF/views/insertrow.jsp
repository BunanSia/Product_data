<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert row</title>
</head>
<body>
	<div class="menu" align=center>
	  <a href="deleterow">Delete row</a>
	  <a href="insertrow">Insert row</a>
	  <a href="updaterow">Update row</a>
	  <a href="viewrow">View row</a>
	  <a href="searchrow">Search row</a>
	  <a href="truncaterow">Truncate table</a>
	  <a href="distinctrow">Distinct item</a>
	  <button onclick="window.location.href='index'">Logout</button>
	</div>
			 <form action="<%=request.getContextPath()%>/insertrow"method="post">
			 <div align=center>
			 <table style="with:80%">
			 <tr><td>Enter item</td><td><input type="text" name="item"/></td></tr>
			 <tr><td>Enter price</td><td><input type="text" name="price"/></td></tr>
			 <tr><td>Enter amount</td><td><input type="text" name="amount"/></td></tr>
			 <tr><td>Enter color</td><td><input type="text" name="color"/></td></tr>
 
			 </table>
			 <input type="submit" value="Insert" onClick="status()"/>
			 </div>
			 				 <% String data=(String)request.getAttribute("data");
				 	  out.write("<script type='text/javascript'>\n"); 
				 	  out.write("alert('" + data+"')");
				 	  out.write("</script>\n");%>
</body>
</html>