<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/26
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.sql.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理商品</title>
    <meta charset=UTF-8>
    <meta http-equiv="param" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keywprd3">
    <meta http-equiv="description" content="ajax方式">

    <link rel="stylesheet" href="/Team4/css/seller_center.css" type="text/css">
    <script type="text/javascript">
        function toRegister() {
            $.ajax({
                type:"post",//方法类型
                dataType:"json",//预期服务器返回的数据类型
                url:"/Team4/SellerRegisterServlet",//设置后台servlet的url

                data:$('#seller_Register_Form').serialize(),
                success:function(result){
                    console.log(result);//打印服务端返回的数据（调试用）
                    if(result.resultCode == 200){
                        alert("成功");
                    }
                    ;
                },
                error:function(){
                    alert("错误");
                }
            });
        }
    </script>
</head>
<%--卖家中心div--%>
<body>
<%--卖家中心页眉导航div,职能为导航--%>
<jsp:include page="dao_hang_lan.jsp"></jsp:include>
<%--头部div--%>
<div id="seller-center-header">
    <div  class="seller-layout-header" data-spm="header">
        <div class="content">
            <a class="logo" href="home_page.jsp" target="_blank">
                <img src="/Team4/img/lv_logo.png" alt="logo" class="logo-img" width:="50%";>
            </a>
            <ul class="links">
                <li class="home">
                    <a href="home_page.jsp" target="_top">首页</a>
                </li>
                <li class="setting">
                    <a href="" target="_top">基础设置</a>
                </li>
                <li>
                    <span class="logo-span">更多</span>
                </li>
            </ul>
        </div>
    </div>
</div>
<%--页面--%>
<div id="seller-center-page">
    <div class="layout">
        <div class="col-main">
            <div class="main-wrap" id="main">
                <div>

                    <hr>
                    <table class="commodityInfoTable">
                        <tr >
                            <th>序号</th>
                            <th> | </th>
                            <th>商品名字</th>
                            <th> | </th>
                            <th>商品编号</th>
                            <th> | </th>
                            <th>金额（元）</th>
                            <th> | </th>
                            <th>数量</th>
                            <th></th>
                        </tr>
                        <c:forEach items="${list}"  var="list" varStatus="i">
                            <tr>
                                <td class="orangered"> ${i.count} </td>
                                <td class="orangered"> | </td>
                                <td>${list.name}</td>
                                <td class="orangered"> | </td>
                                <td>${list.number}</td>
                                <td class="orangered"> | </td>
                                <td>${list.price}</td>
                                <td class="orangered"> | </td>
                                <td>${list.inventory}</td>
                                <td>
                                    <c:if test="${list.tradingTime.toString()!=null}">${list.tradingTime.toString().substring(0,19)}</c:if>
                                    <c:if test="${list.tradingTime.toString()==null}">暂无记录</c:if>
                                </td>
                                <td>
                                  <%--<button name="putaway"--%>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>



                </div>
            </div>
        </div>
        <div class="col-sub">
            <div data-reactroot="" class="seller-sidebar">
                <div class="category-wrapper" data-spm="category">
                    <div class="category first">
                        <div>
                            <img src="/Team4/img/shop_management_icon.png" srcset="" class="category-img">
                            <span class="title">店铺管理</span>
                        </div>
                        <ul class="list">
                            <li>
                                <a target="_blank" href="seller_center.jsp" data-spm="d57">我要开店</a>
                            </li>
                        </ul>
                    </div>
                    <div class="category">
                        <div>
                            <img src="/Team4/img/transaction_%20management_icon.png" srcset="" class="category-img">
                            <span class="title">交易管理</span>
                        </div>
                        <ul class="list">
                            <li>
                                <a target="_blank" href="" data-spm="d28">
                                    已卖出的宝贝</a>
                            </li>
                        </ul>
                    </div>
                    <div class="category">
                        <div>
                            <img src="/Team4/img/logisitics_management_icon.png" srcset="" class="category-img">
                            <span class="title">物流管理</span>
                        </div>
                        <ul class="list">
                            <li>
                                <a target="_blank" href="shipments.jsp" data-spm="d28">
                                    订单处理</a>
                            </li>
                            <li>
                                <a target="_blank" href="shipments.jsp" data-spm="d28">
                                    新增快递</a>
                            </li>
                        </ul>
                    </div>
                    <div class="category">
                        <div>
                            <img src="/Team4/img/commodity_management_icon.png" srcset="" class="category-img"><span class="title">宝贝管理</span>
                        </div>
                        <ul class="list">
                            <li>
                                <a target="_blank" href="publish_commodity.jsp" data-spm="d48">发布商品</a>
                            </li>
                            <li>
                                <a target="_blank" href="manage_commodity.jsp" data-spm="d45">管理商品</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
