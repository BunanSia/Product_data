<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Truncate table</title>
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
		 <div align=center>
		 <form action="<%=request.getContextPath()%>/truncaterow"method="post">

		 <input type="submit" name="Truncate" onClick="status()"/>	 
		 </form>
		 </div>
		 				 <% String data=(String)request.getAttribute("data");
				 	  out.write("<script type='text/javascript'>\n"); 
				 	  out.write("alert('" + data+"')");
				 	  out.write("</script>\n");%>
</body>
</html>