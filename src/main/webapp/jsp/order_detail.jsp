<%--
  Created by IntelliJ IDEA.
  User: 龚平
  Date: 2018/1/30
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单详情</title>
    <link rel="stylesheet" type="text/css" href="css/order.css" />
    <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
    <script type="text/javascript">
        function pay(orderInfoId){
            var pwd=prompt("此次您应付"+""+"元,请输入密码支付订单：");
            if(pwd==null){
                alert("支付取消")
            }else{
                var path="PayServlet?orderInfoId="+orderInfoId+"&pwd="+pwd;
                window.document.location.href=path;
            }
        }
    </script>
</head>
<body>

<div>
    <div class="maninlogo">
        <a href="findByItemInfo.do" title="首页"><img src="img/lv_logo.png" width="198px" height="114px"; /></a>
        <a href="findByItemInfo.do" title="回到首页">首页</a>
        > <a href="OrderQuiryServlet" title="返回订单信息">订单信息</a>
        > <span class="orangered" >订单详情</span >
        <span class="moneySum orangered">订单总金额：${money} 元</span>
        <%--<c:if test="${pay==1}"><a href="PayServlet?orderInfoId=${orderInfoId}">去付款</a></c:if>--%>
        <c:if test="${pay==1}"><a onclick="pay(${orderInfoId})" href="#">去付款</a></c:if>
    </div>
    <hr>
    <div>
        <c:forEach items="${list}" var="list" varStatus="i">
            <table class="orderInfoTable">
                <tr>
                    <td rowspan="3" ><img src="img/hu.jpg" width="120px"></td>
                    <td colspan="3" >${listName.get(Integer.valueOf(i.count-1))}</td>
                </tr>
                <tr>
                    <td><span >发货状态：</span>
                        <c:if test="${list.isSent}">已发货</c:if>
                        <c:if test="${!list.isSent}">未发货</c:if>
                    </td>
                    <td><span>收货状态：</span>
                        <c:if test="${list.isReceived}">已收货</c:if>
                        <c:if test="${!list.isReceived}">未收货</c:if>
                    </td>
                    <td><span>退货状态：</span>
                        <c:if test="${list.isReturned}">已退货</c:if>
                        <c:if test="${!list.isReturned}">未退货</c:if>
                    </td>
                </tr>
                <tr>
                    <td><span>发货时间：</span><br>
                        <c:if test="${list.sentTime!=null}">
                            ${list.sentTime.toString().substring(0,19)}
                        </c:if>
                        <c:if test="${list.sentTime==null}">无</c:if>
                    </td>
                    <td><span>收货时间：</span><br>
                        <c:if test="${list.getReceivedTime()!=null}">
                            ${list.getReceivedTime().toString().substring(0,19)}
                        </c:if>
                        <c:if test="${list.getReceivedTime()==null}">无</c:if>
                    </td>
                    <td><span>退货时间：</span><br>
                        <c:if test="${list.returnedTime!=null}">
                            ${list.returnedTime.toString().substring(0,19)}
                        </c:if>
                        <c:if test="${list.returnedTime==null}">无</c:if>
                    </td>
                </tr>
                <tr>
                    <td><span>状态：</span>
                        <c:choose>
                            <c:when test="${list.orderStatus==1}">订单开始</c:when>
                            <c:when test="${list.orderStatus==2}">付款成功</c:when>
                            <c:when test="${list.orderStatus==3}">已发货</c:when>
                            <c:when test="${list.orderStatus==4}">已收货</c:when>
                            <c:when test="${list.orderStatus==5}">交易失败</c:when>
                            <c:when test="${list.orderStatus==6}">交易成功</c:when>
                        </c:choose>
                    </td>
                    <td><span>商品购买数量：</span>${list.itemNumber}</td>
                    <td ><span> 价格：</span>${list.amount}<span> 元 </span></td>
                    <%--<c:if test="${list.orderStatus!=5}">--%>
                        <%--<td ><a>申请退货</a></td>--%>
                    <%--</c:if>--%>
                </tr>
            </table>
            <hr>
        </c:forEach>
    </div>
</div>
</body>
</html>
