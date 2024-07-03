<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body><div>
<h1>Result page</h1>
<form action="Newlogout">
<table border="">
<tr>
<th>tamil</th>
<th>English</th>
<th>Result</th>
</tr>
<tr>
<td>
<%
    HttpSession hs=request.getSession();
    out.println(hs.getAttribute("m1"));
 %>  
 </td>
<td>
    <%
    HttpSession hs1=request.getSession();
    out.println(hs1.getAttribute("m2"));
    
  %>
    </td>
<td>
    <% 
    HttpSession hs2=request.getSession();
    out.println(hs2.getAttribute("result"));
    %>
 </td>
    
</tr>

</table>
<br>

<a href="Login.html">logout</a>
    
</div>
</body>
<style>

body{
background-image:url("pexels-padrinan-255379.jpg");
background-attachment:fixed;
background-size: cover;
background-position: center center;
 margin-left: 650px;
 margin-top: 250px;
}
a{
   margin-left: 50px;
}
</style>

</html>