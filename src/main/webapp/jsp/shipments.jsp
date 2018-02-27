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
                    <div class="crumbs">
                        <a href="//mai.taobao.com/seller_admin.htm">我是卖家</a>
                        <span>&gt;</span>
                        <a href="#200">物流管理</a>
                        <span>&gt;</span>
                </div>
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
                            <input name='_tb_token_' type='hidden' value='ee3388e6636e9'>
                            <input type="hidden" name="action" value="kuaidi/address_save_action"/>
                            <input type="hidden" name="event_submit_do_save_address" value="anything"/>
                            <div class="module j_module">
                                <div class="module-head">寄件人地址</div>
                                <div class="module-body poster" data-spm-anchor-id="0.0.0.i2.74bf73476dacPi">   		    <b class="b-blue-s j_addAddress" data-spm-anchor-id="0.0.0.i0.74bf73476dacPi">用新地址</b>
                                    <input type="hidden" name="sender_addr_id" value="">
                                    <table class="senderInfo" id="J_posterSenderInfo" style="display: none;">

                                        <tbody><tr>
                                            <td class="t-all"><span class="c-red">*</span>&nbsp;寄件人：</td><td data-spm-anchor-id="0.0.0.i1.74bf73476dacPi"><input type="text" name="s_name" value="">    </td>
                                        </tr>
                                        <tr>
                                            <td class="t-all"><span class="c-red">*</span>&nbsp;地址：</td>
                                            <td>
                                                <div class="address" id="s_address_container"><select name="province" class="J_AddressCN"><option value="">请选择省/直辖市</option><option value="110000">北京</option><option value="120000">天津</option><option value="130000">河北省</option><option value="140000">山西省</option><option value="150000">内蒙古自治区</option><option value="210000">辽宁省</option><option value="220000">吉林省</option><option value="230000">黑龙江省</option><option value="310000">上海</option><option value="320000">江苏省</option><option value="330000">浙江省</option><option value="340000">安徽省</option><option value="350000">福建省</option><option value="360000">江西省</option><option value="370000">山东省</option><option value="410000">河南省</option><option value="420000">湖北省</option><option value="430000">湖南省</option><option value="440000">广东省</option><option value="450000">广西壮族自治区</option><option value="460000">海南省</option><option value="500000">重庆</option><option value="510000">四川省</option><option value="520000">贵州省</option><option value="530000">云南省</option><option value="540000">西藏自治区</option><option value="610000">陕西省</option><option value="620000">甘肃省</option><option value="630000">青海省</option><option value="640000">宁夏回族自治区</option><option value="650000">新疆维吾尔自治区</option><option value="710000">台湾</option><option value="810000">香港特别行政区</option><option value="820000">澳门特别行政区</option><option value="990000">海外</option></select></div>
                                                <input type="hidden" id="s_prov_value" name="s_prov" value="">
                                                <input type="hidden" id="s_city_value" name="s_city" value="">
                                                <input type="hidden" id="s_dist_value" name="s_dist" value="">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td><input type="text" class="addressText" name="s_address" value="">    </td>
                                        </tr>
                                        <tr>
                                            <td class="t-all"><span class="c-red">*</span>&nbsp;邮编：</td>
                                            <td><input type="text" name="s_zip_code" value="">    </td>
                                        </tr>
                                        <tr>
                                            <td class="t-all">手机：</td>
                                            <td><input type="text" class="mobile" name="s_mobile" value="">&nbsp;&nbsp;
                                            </td>
                                        </tr>
                                        </tbody></table>

                                    <ul class="addSelector">
                                        <li><a href="javascript:;" class="b-addSelector j_addSelector">展开查看更多常用收货地址<i></i></a></li>
                                    </ul>

                                    <div class="senderAddress j_posterAddress">
                                        <ul class="addSelector">
                                            <li>
                                                <input type="radio" name="sender" value="buyer_7394076595|王俊杰|510106|驷马桥街道 驷马桥街道 四川省金牛区马鞍东路11号规划院64栋一单元3楼五号|610036|18328073991|||">王俊杰 18328073991 四川省 成都市 金牛区 驷马桥街道 驷马桥街道 四川省金牛区马鞍东路11号规划院64栋一单元3楼五号
                                            </li>
                                            <li>
                                                <input type="radio" name="sender" value="buyer_6027280639|王俊杰|510114|新都镇 西南石油大学|610500|18328073991|||">王俊杰 18328073991 四川省 成都市 新都区 新都镇 西南石油大学
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
                                    <input type="hidden" name="receiv_addr_id" value="" />
                                    <table class="senderInfo">
                                        <tr>
                                            <td class="t-all"><span class="c-red">*</span>&nbsp;收件人：</td>
                                            <td><input type="text" name="r_name" value="" />    </td>
                                        </tr>
                                        <tr>
                                            <td class="t-all"><span class="c-red">*</span>&nbsp;地址：</td>
                                            <td>
                                                <div class="address" id="r_address_container">
                                                </div>
                                                <input type="hidden" id="r_prov_value" name="r_prov" value="" />
                                                <input type="hidden" id="r_city_value" name="r_city" value="" />
                                                <input type="hidden" id="r_dist_value" name="r_dist" value="" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td><input type="text" class="addressText" name="r_address" value=""/>    </td>
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
                                        <a href="" class="b-addSelector j_sender">展开查看更多常用收货地址<i></i></a>
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
                                    发货</a>
                            </li>
                        </ul>
                    </div>
                    <div class="category">
                        <div>
                            <img src="/Team4/img/commodity_management_icon.png" srcset="" class="category-img"><span class="title">宝贝管理</span>
                        </div>
                        <ul class="list">
                            <li>
                                <a target="_blank" href="" data-spm="d48">发布宝贝</a>
                            </li>
                            <li>
                                <a target="_blank" href="" data-spm="d45">出售中的宝贝</a>
                            </li>
                            <li>
                                <a target="_blank" href="" data-spm="d44">仓库中的宝贝</a>
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
