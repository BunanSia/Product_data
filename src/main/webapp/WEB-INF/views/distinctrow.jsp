<%@page import="dao.Systemdao"%>
<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="dao.Systemdao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Distinct item</title>
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
	<%
try
{      
		Systemdao systemdao=new Systemdao();
		ArrayList<String> list= systemdao.distinct();
        int i=-1;
        if(list==null)
        {
            out.println("No Records in the table");
        }
        else
        {%>
       <div align=center>
        <table border="1">
        <tr><th>Item</th></tr>
        <%
            do
            {i++;%>
           	
            <tr><td><%= list.get(i)%></td></tr>
           
            <%}while(i!=list.size());
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