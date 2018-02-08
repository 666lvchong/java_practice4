<%--
  Created by IntelliJ IDEA.
  User: LVCHONG
  Date: 2018/1/30
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<% %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>WechatBusiness</title>
    <link href="/Team4/css/lvchong.css" type="text/css" rel="stylesheet">
    <link href="/Team4/css/dao_hang_lan.css" type="text/css" rel="stylesheet">
</head>
<body>
<div id="danghanglan">
    <ul>
        <a href="/Team4/findByItemInfo.do"><li class="ft_left">嘿嘿 欢迎来到WechatBusiness</li></a>
        <a href="../OrderQuiryServlet"><li id="gouwuc">购物车</li></a>
        <a href="/Team4/SellerRegisterServlet"><li >卖家中心</li></a>
        <a href="../ShoppingCartServlet"><li >订单信息</li></a>
        <a href="/Team4/BillFlowServlet.do"><li >流水记录</li></a>
    </ul>
</div>
<div id="lvc_border">
    <div id="conditional_column">
        <div class="_zhukuan">
            <img id="logo" class="float_left" src="/Team4/img/lv_logo.png" alt="logo">
            <div class="float_left _zhugao">
                <form action="findByItemInfo.do">
                    <div id="shoushuokuang" class="float_left"><input name="name" type="text"/></div>
                    <button type="submit" id="submit" class="float_left">搜索</button>
                </form>
            </div>
        </div>
    </div>
    <div id="commodity_display" class="_zhukuan">
        <c:forEach var="itemRelation" items="${list}">
            <div class="item_outside_ ">
                <div>
                    <a href="#" title="${itemRelation.getItemInfo().getName()}"><img src="${itemRelation.getImgAddr()}" class="item_outside_img"/></a>
                    <div class="item_outside_div"><a href="#" title="${itemRelation.getItemInfo().getName()}">${itemRelation.getItemInfo().getName()}</a></div>
                    <div class="item_outside_div"><a href="#">￥<em1>${itemRelation.getPrice()}</em1></a> <a href="#" class="adds">${itemRelation.getSellerInfo().getShopName()}</a></div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
