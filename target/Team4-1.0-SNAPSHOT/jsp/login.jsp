<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/1/29
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>
<body bgcolor="white">
<div style="width: 100%;height: 100%">
    <div style="margin: auto auto">
<form action="login.jsp" method="post">
    <table>
        <caption>用户登录</caption>
        <tr>
            <td align="center">用户名：</td>
            <td><input type="text" name="username" size="20"/> </td>
        </tr>
        <tr>
            <td align="center">密码：</td>
            <td><input type="password" name="pwd" size="21"/> </td>
        </tr>
        <tr>
            <td ><input input type="submit" value="登录"/> </td><td><input type="reset" value="重置"/> </td>
        </tr>
    </table>
</form>
</div>
</div>
如果你还没注册，请点击<a href="enroll.jsp">这里</a>注册！

</body>
</html>
