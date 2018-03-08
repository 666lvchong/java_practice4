<%--
  Created by IntelliJ IDEA.
  User: wangjunjie
  Date: 2018/1/31
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.sql.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <title>发货</title>

    <%--<link rel="stylesheet" href="https://g.alicdn.com/cnmui/consign/1.0.0/??mytaobao_bc.css,item_list_v2.1.css,tbsp.css">--%>

    <!--吊顶初始化assets-->


    <%--<link href="//g.alicdn.com/tb/seller-global/1.0.0/css/global.css" rel="stylesheet"/>--%>

    <!--layout样式-->

    <!--[if lt IE 9]>
    <![endif]-->
    <link rel="stylesheet" href="/Team4/css/shipments.css" type="text/css">

</head>
<body    >
<%--导航栏--%>
        <jsp:include page="dao_hang_lan.jsp"></jsp:include>
<!--页面结构-->
<%--头部div--%>
<div id="shipments-header">
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
<div id="shipments-page">
    <div class="layout">
        <div class="col-main">
            <div class="main-wrap" id="main">

                <span class="mytaobao-rc-tp"><span></span></span>

                <!-- 导航开始 -->
                <div class="navigation">
                <!-- 导航结束 -->
                <!-- 主体内容开始 -->
                    <div> <div id="main-content">
                        <div class="tab">
                            <span>寄件</span>
                        </div>
                        <ul class="step">
                            <li class="step-ing step-2">1.填写寄件人/收件人地址</li>
                        </ul>
                        <div class="kd-msg">
                            <i class="i-tip"></i>本系统适合寄5公斤以下，非中华人民共和国国家邮政局规定禁限寄物品。
                        </div>
                        <form name="postInfo" method="post">
                            <div class="module j_module">
                                <div class="module-head">
                                    寄件人地址
                                </div>
                                <div class="module-body">
                                    <table class="senderInfo">
                                        <tr>
                                            <td class="t-all"><span class="c-red">*</span>&nbsp;寄件人：</td>
                                            <td><input type="text" name="r_name" value="" />    </td>
                                        </tr>
                                        <tr>
                                            <td class="t-all"><span class="c-red">*</span>&nbsp;地址：</td>
                                            <td><input type="text" class="addressText" name="r_address" value=""/>  </td>
                                        </tr>
                                        <tr>
                                            <td class="t-all">手机：</td>
                                            <td><input type="text" class="mobile" name="r_mobile" value="" />&nbsp;&nbsp;
                                            </td>
                                        </tr>
                                    </table>
                                    <div class="senderAddress">
                                        <ul class="addSelector j_senderList">
                                            <li>
                                                <input type="radio" name="receiver" value="buyer_7394076595|王俊杰|510106|驷马桥街道 驷马桥街道 四川省金牛区马鞍东路11号规划院64栋一单元3楼五号|610036|18328073991|||" />王俊杰 18328073991 四川省 成都市 金牛区 驷马桥街道 驷马桥街道 四川省金牛区马鞍东路11号规划院64栋一单元3楼五号
                                            </li>
                                            <li>
                                                <input type="radio" name="receiver" value="buyer_6027280639|王俊杰|510114|新都镇 西南石油大学|610500|18328073991|||" />王俊杰 18328073991 四川省 成都市 新都区 新都镇 西南石油大学
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="module j_module">
                                <div class="module-head">
                                    收件人地址
                                </div>
                                <div class="module-body">
                                    <table class="senderInfo">
                                        <tr>
                                            <td class="t-all"><span class="c-red">*</span>&nbsp;收件人：</td>
                                            <td><input type="text" name="r_name" value="" />    </td>
                                        </tr>
                                        <tr>
                                            <td class="t-all"><span class="c-red">*</span>&nbsp;地址：</td>
                                            <td><input type="text" class="addressText" name="r_address" value=""/>  </td>
                                        </tr>
                                        <tr>
                                            <td class="t-all">手机：</td>
                                            <td><input type="text" class="mobile" name="r_mobile" value="" />&nbsp;&nbsp;
                                            </td>
                                        </tr>
                                    </table>
                                    <div class="senderAddress">
                                        <ul class="addSelector j_senderList">
                                            <li>
                                                <input type="radio" name="receiver" value="buyer_7394076595|王俊杰|510106|驷马桥街道 驷马桥街道 四川省金牛区马鞍东路11号规划院64栋一单元3楼五号|610036|18328073991|||" />王俊杰 18328073991 四川省 成都市 金牛区 驷马桥街道 驷马桥街道 四川省金牛区马鞍东路11号规划院64栋一单元3楼五号
                                            </li>
                                            <li>
                                                <input type="radio" name="receiver" value="buyer_6027280639|王俊杰|510114|新都镇 西南石油大学|610500|18328073991|||" />王俊杰 18328073991 四川省 成都市 新都区 新都镇 西南石油大学
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="kd-btn">
                                        <b class="b-blue-b" id="J_submit">提交</b>
                                    </div>
                                </div>
                            </div>
                        </form>


                    </div>
                    </div>

                <!-- 主体内容结束 -->
            </div>
        </div>
        <div class="col-sub">
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
        <script src="//g.alicdn.com/cnmui/consign/1.0.0/tml.js"></script>
        <script src="//g.alicdn.com/ccc/address-select/1.0.2/index.js" charset="utf-8"></script>
        <script type="text/javascript" src="//g.alicdn.com/tm/wuliu-kuaidi/1.0.9/??md5.js,kuaidi/address.js,kuaidi/kuaidi.js?t=20130711"></script>
    </div>

<!--底部footer-->

<!--初始化脚本-->



</div>
</body>
</html>
