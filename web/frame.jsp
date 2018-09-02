<%--
  Created by IntelliJ IDEA.
  User: russ
  Date: 2018/9/2
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主页</title>
</head>
<frameset rows="20%,*">
    <frame src="<c:url value="/top.jsp"/>" name="top"/>
    <frame src="<c:url value="/welcome.jsp"/> " name="main"/>
    <frame/>
</frameset>
</html>
