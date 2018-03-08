<%--
  Created by IntelliJ IDEA.
  User: wangjunjie
  Date: 2018/1/29
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.sql.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%--%>
    <%--String contextPath = request.getContextPath();--%>
    <%--String basePath = request.getScheme()+"://"+request.getServerName()+":"+--%>
            <%--request.getServerPort()+contextPath+"/";--%>
<%--%>--%>
<html>
<head>
    <title>卖家中心</title>
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
                <div id="ice_page" data-company="false" data-current-page="ApplyShop"></div>
                    <div>
                        <div class="page-container">
                            <div class="first-title">
                        <h1>我要开店</h1>
                                <p>欢迎来到wechat_business卖家中心，请根据提示完善你的身份信息及店铺信息</p>
                        </div>
                            <form action="/Team4/SellerRegisterServlet" name="seller_Register_From" id="seller_Register_From" role="form" method="post" class="form-seller-register">
                                <table>
                                <tr width="100%" border="0" cellpadding="2" cellspacing="1" align="center" sstyle="100%">
                                    <tr>
                                         <td nowrap align="right" width="9%">姓&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
                                         <td width="43%">
                                            <input name="NAME" type="text" class="input" id="name"/>
                                            <span class="red">*</span>
                                         </td>
                                        <td nowrap align="right" width="9%">邮&nbsp;&nbsp;&nbsp;&nbsp;箱：</td>
                                        <td width="43%">
                                        <input name="EMAIL" type="text" class="input" id="EMAIL"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td nowrap align="right" width="9%">身份证号：</td>
                                        <td width="43%">
                                            <input name="ID_NUMBER" type="text" class="input" id="idNumber" />
                                            <span class="red">*</span>
                                        </td>
                                        <td nowrap align="right" width="9%">关联公司：</td>
                                        <td width="43%">
                                            <input name="AFFILIATED_COMPANY" type="text" class="input" id="AFFILIATED_COMPANY"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td nowrap align="right" width="9%">商铺名称：</td>
                                        <td width="43%">
                                            <input name="SHOP_NAME" type="text" class="input" id="shopName" />
                                            <span class="red">*</span>
                                        </td>
                                        <td nowrap align="right" width="9%">押&nbsp;&nbsp;&nbsp;&nbsp;金：</td>
                                        <td width="43%">
                                            <input name="DEPOSIT" type="text" class="input" id="DEPOSIT"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td nowrap align="right" width="9%">地&nbsp;&nbsp;&nbsp;&nbsp;址：</td>
                                        <td width="43%">
                                            <input name="ADDRESS" type="text" class="input" id="ADDRESS" />
                                            <span class="red">*</span>
                                        </td>
                                        <td nowrap align="right" width="9%">注册时间：</td>
                                        <td width="43%">
                                            <input name="REGISTRATION_TIME" type="text" class="input" id="REGISTRATION_TIME"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td nowrap align="right" width="9%">工商注册号：</td>
                                        <td width="43%">
                                            <input name="COMMERCIAL_REGISTRATION_NUM" type="text" class="input" id="COMMERCIAL_REGISTRATION_NUM" />
                                            <span class="red">*</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td nowrap align="right" width="70%">商铺类型：</td>
                                        <td width="43%">
                                            <input name="SHOP_TYPE" type="radio" value="1" checked> 个人商铺
                                            <input name="SHOP_TYPE" type="radio" value="0">企业商铺</td>
                                    </tr>

                                    <tr>
                                        <td colspan="2" align="right" height="50px">
                                            <input type="submit" name="提交" onclick="toRegister()" value="提交" class="seller_center_From_submit"/>&nbsp;&nbsp;&nbsp;
                                            <input type="reset" name="重置"  value="重置" class="seller_center_From_submit" />
                                        </td>
                                    </tr>
                                    </tr>
                                    </table>

                            </form>
                        </div>
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
