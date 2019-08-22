<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String  baseUrl = request.getScheme()+"://"
                        +request.getServerName()+":"
                        +request.getServerPort()
                        +request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
 <base href="<%=baseUrl %>">
<head>
<meta charset="UTF-8">
<title>新添</title>
</head>
<body>
<form action="<%=baseUrl %>emp/doAdd">
name: <input type="text" name="name"><br>
sex:  <input type="text" name="sex"><br>
age:  <input type="text" name="age"><br>
address: <input type="text" name="address"><br>
email:   <input type="text" name="email"><br>
<input type="submit" value="Submit">
</form>
</body>
</html>