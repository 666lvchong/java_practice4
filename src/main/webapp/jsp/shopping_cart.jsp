<%--
  Created by IntelliJ IDEA.
  User: hehongju
  Date: 2018/1/29
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>购物车</title>
    <link rel="stylesheet" type="text/css" href="css/order.css" />
    <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
    <script type="text/javascript">
        function delOrder(id){
            if(confirm("你确定要取消此订单？")){
                var path="shoppingCartAction!del.do";
                $.ajax({
                            type : "POST",
                            url : path,
                            dataType:'json',
                            data:{strId:id,taoBaoId:${taobaoId}}
                        }
                )
            }
        }
        function buys(money){
            if(confirm("你确定要购买此订单？")){
                var path="shoppingCartAction!buy.do";
                $.ajax({
                            type : "POST",
                            url : path,
                            dataType:'json',
                            data:{moneys:money,addressId:$('#addressId option:selected') .val(),taoBaoId:${taobaoId}}
                        }
                )
            }
        }
    </script>
</head>
<body >
<div id="dialog">
    <div class="maninlogo">
        <a href="/Team4/taobaoAccount!zhuYe.do" title="首页"><img src="img/lv_logo.png" width="198px" height="114px"; /></a>
        <a href="/Team4/taobaoAccount!zhuYe.do" title="回到首页">首页</a>
        > <a href="orderQuiryAction!open.do?taoBaoId=${taoBaoId}" title="返回订单信息">订单信息</a>
        > <span class="orangered" >购物车</span >
        <span class="moneySum orangered">
            订单总金额：${money} 元
            <c:if test="${money!=0}">
            <a href="" onclick="buys(${money})">购买</a>
            </c:if>
        </span>
    </div>
    <hr>
    <c:if test="${money==0}">
        <div class="shoppingCartNull">你的购物车空空如也，快去<a>购物</a>！</div>
    </c:if>
    <c:if test="${money!=0}">
        <div ><form>
            <span class="moneySum orangered">
                <select id="addressId" >
                    <c:if test="${index==0}"><option value="0">未设置收货地址</option></c:if>
                    <c:if test="${index!=0}">
                        <c:forEach items="${listAddress}" var="address" varStatus="i">
                            <option value="${address.id}" <c:if test="${address.isDefault==true}">SELECTED="selected" </c:if> ><span class="orangered"><地址：</span>${address.address}   <span class="orangered">><联系人：</span>${address.linkmanContacts}> <span class="orangered"><电话：</span>${address.telephone}></option>
                        </c:forEach>
                    </c:if>
                </select>
                <a href="addressAction!open.do?taoBaoId=${taoBaoId}">收货地址详情</a>
            </span>
        </form></div>
    </c:if>
    <hr>
    <div>
        <c:forEach items="${list}" var="list" varStatus="i">
            <table class="orderInfoTable">
                <tr>
                    <td rowspan="2"><img src="img/hu.jpg" width="120px"></td>
                    <td colspan="2"><span >商品名称：</span>${listNames.get(Integer.valueOf(i.count-1))}</td>
                    <td><a onclick="delOrder(${list.id})" href="#" >取消订单</a></td>
                </tr>
                <tr>
                    <td ><span>价格：</span> ${list.amount} <span> 元 </span></td>
                    <td><span>商品购买数量：</span></td>
                    <td >${list.itemNumber}</td>
                </tr>
            </table>
            <hr width="1180px">
        </c:forEach>
    </div>
</div>
</body>
</html>
