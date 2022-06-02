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
<title>学生列表</title>

<body>
<h2>学生列表</h2>
<table border="1">
                <tr>
                    <td>姓名</td>
                    <td>性别</td>

                </tr>

                <c:forEach items="${studentDTOList}" var="studentDTO">
                    <tr>
                        <td>${studentDTO.name}&nbsp;&nbsp;</td>
                        <td>${studentDTO.sex}</td>
                        <td>${studentDTO.code}</td>
                        <td><a href = "<%=baseUrl %>student/${studentDTO.id}">详情</a></td>
                    </tr>
                </c:forEach>
            </table>

</body>
</html>