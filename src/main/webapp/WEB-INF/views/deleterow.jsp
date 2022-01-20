<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Delete row</title>
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
		 <form action="<%=request.getContextPath()%>/deleterow"method="post">
		 <div align=center><table><tr><td>Enter the id you want to delete</td><td><input type="text" name="id"/></td></tr></table> 
		 <input type="submit" name="Delete" onClick="status()"/></div>
		 </form>
		 				 <% String data=(String)request.getAttribute("data");
				 	  out.write("<script type='text/javascript'>\n"); 
				 	  out.write("alert('" + data+"')");
				 	  out.write("</script>\n");%>

</body>
</html>