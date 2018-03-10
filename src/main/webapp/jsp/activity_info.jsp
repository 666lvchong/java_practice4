<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="common.jsp"></jsp:include>
    <meta charset=UTF-8>
    <title>活动信息发布</title>
    <link rel="stylesheet" type="text/css" href="/Team4/css/activity_info.css">
</head>
<body>
<iframe src="jsp/dao_hang_lan.jsp" width="100%" height="40" frameborder="0"></iframe>
<div id="danghanglan">
    <ul>
        <a href="/Team4/taobaoAccount!zhuYe.do"><li class="ft_left">${taobaoAccount.personnelAccount} 欢迎来到WechatBusiness</li></a>
        <a href="/Team4/shoppingCartAction!open.do"><li id="gouwuc">购物车</li></a>
        <a href="/Team4/jsp/seller_center.jsp"><li >卖家中心</li></a>
        <a href="/Team4/orderQuiryAction!open.do"><li >订单信息</li></a>
        <a href="/Team4/BillFlowServlet.do"><li >流水记录</li></a>
    </ul>
</div>
    <div class="activity_box">
        <img id="logo" class="float_left" src="/Team4/img/lv_logo.png" alt="logo">
        <h1 class="activity_title">活动信息发布</h1>
        <div class="search_box">
            <form class="search_form" id="search_form" action="${pageContext.request.contextPath}/activity!findInfo.do" method="post">
                <div class="activitySearch_box"><input type="text" name="keyword" placeholder="请输入活动名称" value=""/>
                    <button type="submit" id="submit" onclick="doFind()" value="搜索">搜索</button></div>
            </form>
        </div>
        <c:forEach items="${listActivityRelation}" var="activityRelation">
            <div class="activityShow_box">
                <label class="activityName_title">活动名称：${activityRelation.getActivityInfoId().getActivityName()}</label>
                <label class="discount_info">打折：${activityRelation.getActivityInfoId().getDiscount()}</label>
                <label class="date_info">活动时间：<fmt:formatDate value="${activityRelation.getActivityInfoId().getActivityStartTime()}" pattern="yyyy-MM-dd HH:mm:ss"/> 至<fmt:formatDate value="${activityRelation.getActivityInfoId().getActivityEndTime()}" pattern="yyyy-MM-dd HH:mm:ss"/></label>
                <div class="activityItem_box">
                    <ul id="activity_detail">
                        <li id="shop_info"><label>参与商铺：</label><a class="shopName" href="/Team4/ItemInfoServlet.do">${activityRelation.getItemRelationId().getSellerInfo().getShopName()}</a></li>
                        <li id="item_info"><label>活动商品：</label><a class="itemName" href="/Team4/ItemInfoServlet.do">${activityRelation.getItemRelationId().getItemInfo().getName()}</a></li>
                    </ul>
                </div>
            </div>
        </c:forEach>
    </div>
</body>
</html>