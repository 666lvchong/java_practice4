
<%--
  Created by IntelliJ IDEA.
  User: hehongju
  Date: 2018/1/29
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单信息</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/order.css" />
</head>
<body >
    <div>
        <div class="maninlogo">
            <a href="findByItemInfo.do" title="首页"><img src="img/lv_logo.png" width="198px" height="114px"; /></a>
            <a href="findByItemInfo.do" title="回到首页">首页</a>
            > <span class="orangered" title="我的订单信息">订单信息</span ><a href="ShoppingCartServlet">
            <span class="shoppingCart" title="我的购物车">购物车</span></a>
        </div>
        <hr>
        <c:if test="${index==0}">
            <div class="shoppingCartNull">你的订单空空如也，快去<a>购物</a>！</div>
        </c:if>
        <c:if test="${index!=0}">
            <table class="orderInfoTable">
                <tr >
                    <th>序号</th>
                    <th> | </th>
                    <th>订单编号</th>
                    <th>买家(收货人)</th>
                    <th>金额（元）</th>
                    <th>创建订单时间</th>
                    <th>是否交易成功</th>
                    <th>交易成功时间</th>
                    <th></th>
                </tr>
                <c:forEach items="${list}"  var="list" varStatus="i">
                    <tr>
                        <td class="orangered"> ${i.count} </td>
                        <td class="orangered"> | </td>
                        <td>${list.orderNum}</td>
                        <td>${buyer}</td>
                        <td>${list.orderTotalAmount}</td>
                        <td>${list.creationTime.toString().substring(0,19)}</td>
                        <td>
                            <c:if test="${list.isSuccess}">交易成功</c:if>
                            <c:if test="${!list.isSuccess}">未交易成功</c:if>
                        </td>
                        <td>
                            <c:if test="${list.tradingTime.toString()!=null}">${list.tradingTime.toString().substring(0,19)}</c:if>
                            <c:if test="${list.tradingTime.toString()==null}">暂无记录</c:if>
                        </td>
                        <td>
                            <a href="OrderDetailServlet?id=${list.id}" >订单详情</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</body>
</html>
