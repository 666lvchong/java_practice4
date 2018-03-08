<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: hl1027
  Date: 2018/1/30
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="index-min.css">
</head>
<body data-spm="1" class="tab-active-index-0 tb-detail">
<iframe src="jsp/dao_hang_lan.jsp" width="100%" height="40" frameborder="0"></iframe>
<div id="danghanglan">
    <ul>
        <li class="ft_left">嘿嘿 欢迎来到WechatBusiness</li>
        <a href="#"><li class="li" id="gouwuc">购物车</li></a>
        <a href="#"><li class="li">卖家中心</li></a>
        <a href="#"><li class="li">订单信息</li></a>
    </ul>
</div>
<input type="hidden" id="J_TokenField" name="tb_token" value="">
<div id="page">
    <div id="content">
        <p id="J_dcpg" class="design-page" style="display:none;"></p>
        <div class="J_AsyncDC" data-type="css"></div><div id="J_DcHead" class="J_AsyncDC tb-async-head tb-shop" data-type="head"></div>
        <div id="bd">
            <div id="detail">
                <div class="tb-detail-bd tb-clear">
                    <div class="tb-summary tb-clear">
                        <div class="tb-item-info tb-clear">
                            <div class="tb-item-info-l">
                                <div class="tb-gallery">
                                    <div class="tb-booth tb-pic tb-main-pic">
                                        <div class="zoom-icon hidden tb-iconfont" id="J_ZoomIcon">&#337;</div>
                                    </div>
                                </div>
                                <div id="J_Social" data-spm="20140010" class="tb-social tb-clearfix">
                                    </ul>
                                </div>
                            </div>
                            <div class="tb-item-info-r" data-spm="iteminfo"> <div class="tb-property tb-property-x">
                                <link rel="stylesheet" href="//g.alicdn.com/??kg/global-util/1.0.5/index-min.css,kg/tb-gnav/1.0.5/index-min.css">
                                <link rel="stylesheet" href="//g.alicdn.com/tb/??item-detail/7.19.2/index-min.css"/>
                                <div class="tb-wrap tb-wrap-newshop">
                                    <div id="J_Title" class="tb-title" shortcut-key="t" shortcut-label="查看宝贝标题" shortcut-effect="focus">
                                        <h3 class="tb-main-title" data-title="大衣">
                                            ${item.name}
                                        </h3>
                                        <p class="tb-subtitle">优质进口 丨 全场顺丰包邮 丨 8天无理由退换货 丨 支持买一送一</p>
                                        <div id="J_TEditItem" class="tb-editor-menu"></div>
                                    </div>
                                    <div id="J_Banner" class="tb-banner"></div>
                                    <ul class="tb-meta">
                                        <li id="J_StrPriceModBox" class="tb-detail-price tb-clear" shortcut-key="p" shortcut-label="查看价格" shortcut-effect="focus">
                                            <span class="tb-property-type">价格</span>
                                            <div class="tb-property-cont">
                                                <strong id="J_StrPrice"><em class="tb-rmb">&yen;</em><em class="tb-rmb-num">8900.00</em></strong>
                                            </div>
                                        </li><li id="J_PromoPrice" class="tb-detail-price tb-promo-price tb-clear tb-hidden">
                                        <span class="tb-property-type">淘宝价</span>
                                        <div class="tb-property-cont">
                                            <div id="J_Promo" class="tb-promo-mod">
                                                <div id="J_PromoHd" class="tb-promo-hd tb-promo-item"></div>
                                                <div id="J_PromoBd" class="tb-promo-bd"></div>
                                            </div>
                                        </div>
                                    </li>
                                        <li id="J_Duty"></li>
                                        <li id="J_ActivityPrice"></li>
                                        <li id="J_OtherDiscount" class="tb-clear tb-hidden">
                                            <span class="tb-property-type">优惠</span>
                                            <div class="tb-other-discount">
                                            </div>
                                        </li>
                                    </ul>
                                    <div id="J_StepPrice"></div>
                                    <div id="J_logistic"></div>
                                    <div id="J_SepLine" class="sep-line"></div>
                                    <div id="J_isku" class="tb-key tb-key-sku" shortcut-key="i" shortcut-label="挑选宝贝" shortcut-effect="focus">
                                        <div class="tb-skin">
                                            <dl class="J_Prop J_TMySizeProp tb-prop tb-clear  J_Prop_measurement ">
                                            <dl class="tb-amount tb-clear">
                                                <dt class="tb-property-type">数量</dt>
                                                <dd>
        <span class="tb-stock" id="J_Stock">
            <a href="javascript:void(0);" title="减1" hidefocus class="tb-reduce J_Reduce tb-iconfont">&#411;</a>
            <input id="J_IptAmount" type="text" class="tb-text" value="1"   maxlength="8" title="请输入购买量"/>
            <a href="javascript:void(0);" hidefocus class="tb-increase J_Increase tb-iconfont" title="加1">&#410;</a>件
        </span>
                                                    <em>(库存<span id="J_SpanStock" class="tb-count">2</span>件)</em>
                                                </dd>
                                            </dl>
                                            <div id="J_SureSKU" class="tb-sure">
                                                <p class="tb-choice">请勾选您要的商品信息</p>
                                                <p class="tb-sure-continue">
                                                    <a id="J_SureContinue" href="javascript:;">确定</a>
                                                </p>
                                                <span class="close J_Close tb-iconfont">&#223;</span>
                                            </div>
                                            <div id="J_juValid" class="tb-action tb-clearfix ">
                                                <div class="tb-btn-buy">
                                                    <a  href="javascript:;" title="点击此按钮，到下一步确认购买信息" class="J_LinkBuy" shortcut-key="b" shortcut-label="立即购买" shortcut-effect="click" data-addFastBuy="true" data-spm-click="gostr=/tbdetail;locaid=d1">
                                                        立即购买
                                                    </a>
                                                </div>
                                                <div class="tb-btn-add">
                                                    <a href="javascript:;" title="加入购物车" class="J_LinkAdd" shortcut-key="a" shortcut-label="加入购物车" shortcut-effect="click" data-spm-click="gostr=/tbdetail;locaid=d2">
                                                        <i class="tb-iconfont">&#365;</i>加入
                                                        <input type="button" value="购物" onclick="window.location.href='';"/>
                                                    </a>
                                                </div>
                                            </div>
                                                </dl>
                                        </div>
                                        <div class="tb-extra" id="J_tbExtra">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </div>
                        </div>
                        <div class="tb-tabbar-inner-wrap">
                            <ul id="J_TabBar" class="tb-tabbar tb-clear"> <li class="tb-first selected">
                                <a class="tb-tab-anchor" href="javascript:void(0);" hidefocus="true" shortcut-key="g d" shortcut-label="查看宝贝详情" shortcut-effect="click" data-index="0" data-spm-click="gostr=/tbdetail;locaid=d1">宝贝详情</a>
                                <div class="tb-selected-indicator"></div>
                            </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="layout grid-s5m0 tb-main-layout">
                    <div class="col-main clearfix">
                        <div class="main-wrap  J_TRegion" id="J_MainWrap">
                            <div class="sub-wrap" id="J_SubWrap">
                                <div id="attributes" class="attributes">
                                    <!-- attributes div start -->
                                    <ul class="attributes-list">
                                        <li title="绵羊皮">材质成分:&nbsp;绵羊皮</li>

                                        <li title="常规">衣长:&nbsp;常规</li>

                                        <li title="1568/6807">货号:&nbsp;1568/6807</li>

                                        <li title="直筒">版型:&nbsp;直筒</li>

                                        <li title="免烫处理">材质工艺:&nbsp;免烫处理</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
</body>
</html>









