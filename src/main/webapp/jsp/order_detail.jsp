<%--
  Created by IntelliJ IDEA.
  User: 龚平
  Date: 2018/1/30
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>订单详情</title>
    <link rel="stylesheet" type="text/css" href="css/order.css" />
    <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
    <script type="text/javascript">
        function pays(){
            var pwd=prompt("此次您应付"+""+"元,请输入密码支付订单：");
            <%--var orderInfoId=${orderInfoId};--%>
            <%--var money=${money}--%>
            if(pwd==null){
                alert("支付取消")
            }else{
//                var path="orderDetailAction!pay.do?&pwd="+pwd;
//                window.document.location.href=path;
                var path="orderDetailAction!pay.do";
                $.ajax({
                            type : "POST",
                            url : path,
                            dataType:'json',
                            data:{pwd:pwd,moneys:${money},taoBaoId:${taobaoId}}
                        }
                )
            }
        }
        function receivings(id){
            var path="orderDetailAction!receiving.do";
            $.ajax({
                        type : "POST",
                        url : path,
                        dataType:'json',
                        data:{strId:id,taoBaoId:${taobaoId}}
                    }
            )
        }
        function returnings(id){
            var path="orderDetailAction!returning.do";
            $.ajax({
                        type : "POST",
                        url : path,
                        dataType:'json',
                        data:{strId:id,taoBaoId:${taobaoId}}
                    }
            )
        }
        function returneds(id){
            var path="orderDetailAction!returned.do";
            $.ajax({
                        type : "POST",
                        url : path,
                        dataType:'json',
                        data:{strId:id,taoBaoId:${taobaoId}}
                    }
            )
        }
    </script>
</head>
<body>

<div>
    <div class="maninlogo">
        <a href="/Team4/taobaoAccount!zhuYe.do" title="首页"><img src="img/lv_logo.png" width="198px" height="114px"; /></a>
        <a href="/Team4/taobaoAccount!zhuYe.do" title="回到首页">首页</a>
        > <a href="/Team4/orderQuiryAction!open.do?taoBaoId=${taoBaoId}" title="返回订单信息">订单信息</a>
        > <span class="orangered" >订单详情</span >
        <span class="moneySum orangered">订单总金额：${money} 元</span>
        <%--<c:if test="${pay==1}"><a href="PayServlet?orderInfoId=${orderInfoId}">去付款</a></c:if>--%>
        <c:if test="${pay==1}"><a onclick="pays()" href="">去付款</a></c:if>
    </div>
    <hr>
    <div class="maninlogo"><span class="orangered">收货地址：</span>${address.address}   --<span class="orangered"> 联系人：</span>${address.linkmanContacts} --<span class="orangered"> 电话：</span>${address.telephone}</div>
    <hr>
    <div>
        <c:forEach items="${list}" var="list" varStatus="i">
            <table class="orderInfoTable">
                <tr>
                    <td rowspan="3" ><img src="img/hu.jpg" width="120px"></td>
                    <td  ><span >商品名称：</span>${listNames.get(Integer.valueOf(i.count-1))}</td>
                    <td colspan="2"><span >发货地址：</span>${addresss.get(Integer.valueOf(i.count-1))}</td>
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
                            <fmt:formatDate value="${list.sentTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </c:if>
                        <c:if test="${list.sentTime==null}">无</c:if>
                    </td>
                    <td><span>收货时间：</span><br>
                        <c:if test="${list.receivedTime!=null}">
                            <fmt:formatDate value="${list.receivedTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </c:if>
                        <c:if test="${list.receivedTime==null}">无</c:if>
                    </td>
                    <td><span>退货时间：</span><br>
                        <c:if test="${list.returnedTime!=null}">
                            <fmt:formatDate value="${list.returnedTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </c:if>
                        <c:if test="${list.returnedTime==null}">无</c:if>
                    </td>
                </tr>
                <tr>
                    <td><span>状态：</span>
                        <c:choose>
                            <c:when test="${list.orderStatus==1}">待付款</c:when>
                            <c:when test="${list.orderStatus==2}">待发货</c:when>
                            <c:when test="${list.orderStatus==3}">运输中</c:when>
                            <c:when test="${list.orderStatus==4}">待收货</c:when>
                            <c:when test="${list.orderStatus==5}">已收货</c:when>
                            <c:when test="${list.orderStatus==6}">申请退货</c:when>
                            <c:when test="${list.orderStatus==7}">已退货</c:when>
                            <c:when test="${list.orderStatus==8}">交易失败</c:when>
                        </c:choose>
                    </td>
                    <td><span>商品购买数量：</span>${list.itemNumber}</td>
                    <td ><span> 价格：</span>${list.amount}<span> 元 </span></td>
                    <c:if test="${list.orderStatus==4 || list.orderStatus==3 || list.orderStatus==2 || list.orderStatus==5 }">
                        <td ><a href="" onclick="returnings(${list.id})">申请退货</a><c:if test="${list.orderStatus==4}"></c:if> / <a href="" onclick="receivings(${list.id})">确认收货</a></td>
                    </c:if>
                    <c:if test="${list.orderStatus==6}">
                        <td ><a href="" onclick="returneds(${list.id})">确认退货</a></td>
                    </c:if>
                    <c:if test="${list.orderStatus==8}">
                        <td ><a>如有疑问，请咨询客服</a></td>
                    </c:if>
                </tr>
            </table>
            <hr>
        </c:forEach>
    </div>
</div>
</body>
</html>
