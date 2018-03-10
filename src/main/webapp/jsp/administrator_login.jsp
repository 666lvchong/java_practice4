<%@ page language="java" import="java.sql.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="common.jsp"></jsp:include>
    <meta charset=UTF-8>
    <meta http-equiv="param" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keywprd3">
    <meta http-equiv="description" content="ajax方式">
    <title>管理员登录</title>
    <%--<link rel="stylesheet" href="../css/administrator_login.css">--%>
    <link rel="stylesheet" href="../css/administrator_login.css">
</head>
<body>
<div class="formLogin">
    <div id="auto">
        <form action="../taobaoAccount!denLu.do" name="administrator_Login_Form" id="administrator_Login_Form" method="post">
            <div id="margin_top"> 登录 </div>
            <div class="username_div">
                <img class="float_left" src="../img/user_img.jpg"/>
                <div class="float_left emm">用户名：</div>
                <input  type="text" class="float_left username_div_input" name="taobaoAccount.personnelAccount" placeholder="请输入帐户名或手机号" value=""/>
            </div>
            <div class="username_div">
                <img class="float_left" src="../img/lock.png"/>
                <div class="float_left emm">密&nbsp;&nbsp;&nbsp;码：</div>
                <input type="password" class="username_div_input float_left" name="taobaoAccount.password" placeholder="请输入密码" value=""/>
            </div>
            <button type="submit" form="administrator_Login_Form" id="DL" class="administrator_Login_Form_submit">登录</button>
            <a href="en_roll.jsp"><button type="button" form="administrator_Login_Form" id="ZC" class="administrator_Login_Form_submit">注册</button></a>
        </form>
    </div>
</div>
</body>
</html>