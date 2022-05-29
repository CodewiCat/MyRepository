<%--
  Created by IntelliJ IDEA.
  User: 小新
  Date: 2022/4/4
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>

    <form action="./filedownload" method="post" enctype="multipart/form-data">
       <p><input type="file" name="file" id="fileId"></p>
        <p><input type="submit">|<input type="reset"></p>

    </form>


</body>
</html>
