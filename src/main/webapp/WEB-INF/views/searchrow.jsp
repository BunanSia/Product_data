<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Product" %>
<%@ page import="dao.Systemdao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Search rows</title>
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
	<div align="center">
	<form action="<%=request.getContextPath()%>/searchrow"method="post">
	<table style="with:80%">
	<tr><td>Item</td><td><input type="text" name="iteminput"/></td></tr>
	</table>
	<input type="submit"name="Submit"/>
	</form>
	</div>
<%
	try
{      
		ArrayList<Product> std=(ArrayList<Product>)session.getAttribute("list");
        int i=-1;
        if(std==null)
        {
            out.println("No Records in the table");
        }
        else
        {%>	

       <div align="center">
        <table border="1">
        <tr><th>Item</th><th>Price</th><th>Amount</th><th>Color</th>          	
         <%
            do
            {i++;%>
           	
            <tr><td><%= std.get(i).getItem()%></td><td><%= std.get(i).getPrice() %></td><td><%=std.get(i).getAmount()%></td><td><%=std.get(i).getColor()%></td></tr>         
            <%}while(i!=std.size());
        }      
}
catch(Exception e)
{
    System.out.println(e.getMessage());
    e.getStackTrace();
}
%>
</table>
</div>
</body>
</html>