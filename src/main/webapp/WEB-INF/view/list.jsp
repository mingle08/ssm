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
<title>首页</title>
        <base href="<%=baseUrl %>">
<body>
<h2>消息查询</h2>
<table border="1">
                <tr>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>年龄</td>
                    <td>地址</td>
                    <td>邮箱</td>
                </tr>
                <c:forEach items="${empList}" var="emp">
                    <tr>
                        
                        <td>${emp.name}&nbsp;&nbsp;</td>
                        <td>${emp.sex}</td>
                        <td>${emp.age}</td>
                        <td>${emp.address}</td>
                        <td>${emp.email}</td>
                    </tr>
                </c:forEach>
            </table>
<a href = "http://localhost:8082/mvcmybatis/emp/add">add</a>
</body>
</html>