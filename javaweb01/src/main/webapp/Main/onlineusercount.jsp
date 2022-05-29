<%--
  Created by IntelliJ IDEA.
  User: 小新
  Date: 2022/4/3
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线用户数</title>
</head>
<body>
<h1>在线用户数:<span style="color: aqua"><%=this.getServletConfig().getServletContext().getAttribute("onlineUserCount")%></span></h1>

</body>
</html>
