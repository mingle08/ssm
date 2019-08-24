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
<title>员工列表</title>

<body>
<h2>员工列表</h2>
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
<a href = "<%=baseUrl %>emp/add">add</a>
            <table>
                <tr>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>卡号</td>
                </tr>
                <tr>
                    <td>${studentDTO.name}&nbsp;&nbsp;</td>
                    <td>${studentDTO.sex}</td>
                    <td>${studentDTO.code}</td>
                </tr>
            </table>
</body>
</html>