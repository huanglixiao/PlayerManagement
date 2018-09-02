<%--
  Created by IntelliJ IDEA.
  User: russ
  Date: 2018/9/2
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>球员列表</title>
</head>
<body>
    <h3 align="center">球员列表</h3>
    <table border="1" width="70%" align="center">
        <tr>
            <th>球员姓名</th>
            <th>球队</th>
            <th>位置</th>
            <th>年龄</th>
            <th>描述</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pageBean.beanList}" var="pm">
            <tr>
                <td>${pm.name}</td>
                <td>${pm.team}</td>
                <td>${pm.position}</td>
                <td>${pm.age}</td>
                <td>${pm.description}</td>
                <td>
                    <a href="<c:url value='/PlayerServlet?method=preEdit&id=${pm.id}'/> ">编辑</a>
                    <a href="<c:url value='/PlayerServlet?method=delete&id=${pm.id}'/> ">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
<br/>
<center>
    第${pageBean.pageCode}页/共${pageBean.totalPages}页
    <a href="${pageBean.url}&pageCode=1">首页</a>
    <c:if test="${pageBean.pageCode>1}">
        <a href="${pageBean.url}&pageCode=${pageBean.pageCode-1}">上一页</a>
    </c:if>
    <c:choose>
        <c:when test="${pageBean.totalPages<=10}">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="pageBean.totalPages"/>
        </c:when>
        <c:otherwise>
            <c:set var="begin" value="${pageBean.pageCode-5}"/>
            <c:set var="end" value="${pageBean.pageCode+4}"/>
            <c:if test="${begin<1}">
                <c:set var="begin" value="1"/>
                <c:set var="end" value="10"/>
            </c:if>
            <c:if test="${end>pageBean.totalPages}">
                <c:set var="begin" value="${pageBean.totalPages-9}"/>
                <c:set var="end" value="${pageBean.totalPages}"/>
            </c:if>
        </c:otherwise>
    </c:choose>
    <c:forEach var="i" begin="${begin}" end="${end}">
        <c:choose>
            <c:when test="${i eq pageBean.pageCode}">
                [${i}]
            </c:when>
            <c:otherwise>
                <a href="${pageBean.url}&pageCode=${i}">[${i}]</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <c:if test="${pageBean.pageCode<pageBean.totalPages}">
        <a href="${pageBean.url}&pageCode=${pageBean.pageCode+1}">下一页</a>
    </c:if>
    <a href="${pageBean.url}&pageCode=${pageBean.totalPages}">尾页</a>
</center>
</body>
</html>
