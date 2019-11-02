<%--
  Created by IntelliJ IDEA.
  User: YanYuHang
  Date: 2019/11/2
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${msg}
<form action="login" method="post">
    <p>用户名:<input type="text" name="username"></p>
    <p>密码:<input type="text" name="password"></p>
    <p><input type="submit" value="login"></p>
</form>
</body>
</html>
