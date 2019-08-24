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
<title>书籍分类列表</title>

<body>
<h2>书籍分类列表</h2>
<table border="1">
                <tr>
                    <td>类别</td>
                    <td>书名</td>
                    <td>价格</td>
                </tr>

                <c:forEach items="${bookCategoryList}" var="bookCategory">
                    <tr>
                        <td>${bookCategory.categoryName}</td>
                        <td></td>
                        <td></td>
                        <td><a href = "<%=baseUrl %>bookCategory/${bookCategory.id}">详情</a></td>
                    </tr>
                </c:forEach>
            </table>

</body>
</html>