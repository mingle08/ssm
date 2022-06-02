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
<title>学生信息详情</title>

<body>
<h2>学生信息详情</h2>

     姓名：<input name="name" value="${studentDTO.name}"><br/>
     性别：<input name="sex" value="${studentDTO.sex}"><br/>
     卡号：<input name="code" value="${studentDTO.code}"><br/>

</body>
</html>