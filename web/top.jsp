<%--
  Created by IntelliJ IDEA.
  User: russ
  Date: 2018/9/2
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <base target="main">
    <title>My JSP 'top.jsp' starting page</title>
</head>
<body style="...">
<h1>球员管理系统</h1>
<a href="<c:url value='/add.jsp'/>">添加球员</a>
<a href="<c:url value='/PlayerServlet?method=findAll'/>">查询球员</a>
<a href="<c:url value='/query.jsp'/>">高级搜索</a>
</body>
</html>
