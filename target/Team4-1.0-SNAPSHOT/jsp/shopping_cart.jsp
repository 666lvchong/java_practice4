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
            $.ajax({
                        type : "POST",
                        url : "DelShoppingCartServlet?id="+id,
//                        date : text:
                    }

            )
            if(confirm("你确定要取消此订单？")){
                var path="DelShoppingCartServlet?id="+id;
                window.document.location.href=path;
            }
        }
    </script>
</head>
<body >
<div id="dialog">
    <div class="maninlogo">
        <a href="findByItemInfo.do" title="首页"><img src="img/lv_logo.png" width="198px" height="114px"; /></a>
        <a href="findByItemInfo.do" title="回到首页">首页</a>
        > <a href="OrderQuiryServlet" title="返回订单信息">订单信息</a>
        > <span class="orangered" >购物车</span >
        <span class="moneySum orangered">
            订单总金额：${money} 元
            <c:if test="${money!=0}">
            <a href="CreateOrderServlet?money=${money}" onclick="return confirm('确定购买')">购买</a>
                <%--<a  onclick="pay(${money})" href="#">购买</a>--%>
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
                <select >
                    <c:if test="${index==0}"><option value="0">未设置收货地址</option></c:if>
                    <c:if test="${index!=0}">
                        <c:forEach items="${listAddress}" var="address" varStatus="i">
                            <option value="${address.address}" <c:if test="${address.isDefault==true}">SELECTED="selected" </c:if> >${address.address}</option>
                        </c:forEach>
                    </c:if>
                </select>
                <a href="AddressServlet.do">收货地址详情</a>
            </span>
        </form></div>
    </c:if>
    <hr>
    <div>
        <c:forEach items="${list}" var="list" varStatus="i">
            <table class="orderInfoTable">
                <tr>
                    <td rowspan="2"><img src="img/hu.jpg" width="120px"></td>
                    <td colspan="2">${listName.get(Integer.valueOf(i.count-1))}</td>
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
