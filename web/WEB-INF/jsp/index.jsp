<%--
  Created by IntelliJ IDEA.
  User: YanYuHang
  Date: 2019/11/2
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>这是主页</h1>
  当前用户是:${USERS_SESSION.username}
  <a href="/logout">退出登录</a>
  </body>
</html>
