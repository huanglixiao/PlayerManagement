<%--
  Created by IntelliJ IDEA.
  User: russ
  Date: 2018/9/2
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3 align="center">添加球员</h3>
<form action="<c:url value= '/PlayerServlet' />" method="post">
    <input type="hidden" name="method" value="add"/>
    <input type="hidden" name="id" value="${player.id}"/>
    <table border="0" align="center" width="40%" style="...">
        <tr>
            <td width="100px">球员名称</td>
            <td width="40%">
                <input type="text" name="name" value="${player.name}"/>
            </td>
            <td align="left">
                <label id="nameError" class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td>球队</td>
            <td>
                <input type="text" name="team" id="team" value="${player.team}"/>
            </td>
            <td>
                <label id="teamError" class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td>位置</td>
            <td>
                <input type="text" name="position" id="position" value="${player.position}"/>
            </td>
            <td>
                <label id="positionError" class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td>年龄</td>
            <td>
                <input type="text" name="age" id="age" value="${player.age}"/>
            </td>
            <td>
                <label id="ageError" class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td>描述</td>
            <td>
                <textarea rows="5" cols="30" name="description" value="${player.description}"></textarea>
            </td>
            <td>
                <label id="descriptionError" class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" name="submit" value="编辑球员"/>
                <input type="reset" name="reset"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
