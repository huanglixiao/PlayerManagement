<%--
  Created by IntelliJ IDEA.
  User: russ
  Date: 2018/9/2
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<h3 align="center">高级搜索</h3>
<form action="<c:url value='/PlayerServlet'/>"method="get">
    <input type="hidden" name="method" value="query">
    <table border="0" align="center" width="40%" style="...">
        <tr>
            <td width="100px">球员名称</td>
            <td width="40%">
                <input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td>球队</td>
            <td>
                <input type="text" name="team"/>
            </td>
        </tr>
        <tr>
            <td>位置</td>
            <td>
                <input type="text" name="team"/>
            </td>
        </tr>
        <tr>
            <td>年龄</td>
            <td>
                <input type="text" name="team"/>
            </td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>
                <input type="submit" value="搜索"/>
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
