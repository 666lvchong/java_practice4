<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 蔡幸
  Date: 2018/1/29
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title></title>
    <link href="css/billFlow.css" rel="stylesheet" charset="utf-8">
</head>
<body>
<div id="danghanglan">
    <ul>
        <li class="ft_left">嘿嘿 欢迎来到WechatBusiness</li>
        <a href="#"><li class="li" id="gouwuc">购物车</li></a>
        <a href="#"><li class="li">卖家中心</li></a>
        <a href="#"><li class="li">订单信息</li></a>
    </ul>
</div>
<div class="table_he">
    <div class="table_bt">
        <table   class="bt" >
            <caption>支付流水信息表</caption>
            <tr >
                <th width="130px">流水编号</th>
                <th width="300px">交易日期</th>
                <th width="130px" >交易金额</th>
                <th width="80px" >交易状态</th>

            </tr>
        </table >
    </div >
    <div class="table_nr">
        <table >
            <c:forEach items="${list1}" var="list">
            <tr >
                <td  width="130px">${list.serialNumber}</td>
                <td width="300px">创建交易时间：${list.launchTime}<br/>交易完成时间：${list.finshTime}</td>
                <td width="130px">
                    <c:if test="${list.flowRecordType==1}">+</c:if>
                    <c:if test="${list.flowRecordType==2}">-</c:if>
                    ${list.amounts}</td>
                <td width="80px">
                    <c:if test="${list.isPayStatus==1}">支付成功</c:if>
                    <c:if test="${list.isPayStatus==2}">支付失败</c:if>
                    <br/><a href="${pageContext.request.contextPath}/OrderDetailServlet?id=${list.orderInfoId}">订单信息<br/></a></td>
            </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>

