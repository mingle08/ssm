<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String  baseUrl = request.getScheme()+"://"
                        +request.getServerName()+":"
                        +request.getServerPort()
                        +request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"></head>
<body>
<h2>Hello World!</h2>
<a href = "<%=baseUrl %>emp/list">query</a>
</body>
</html>
