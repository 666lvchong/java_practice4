<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="wechat_business.entity.TaobaoAccount" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="common.jsp"></jsp:include>
    <meta charset=UTF-8>
    <meta http-equiv="param" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keywprd3">
    <meta http-equiv="description" content="ajax方式">
    <title>账户管理</title>
    <link rel="stylesheet" type="text/css" href="/Team4/css/user_info.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
    <script type="text/javascript">
        //添加button点击事件
        function doFind(){
            alert("马上就来！");
            $.ajax({
                type:"POST",//发送请求的方式为GET/POST
                //请求的后台servlet地址,（注：pageContext.request.contextPath为当前页面请求路径，后面直接跟servlet地址，不要再加工程名）
                url:"${pageContext.request.contextPath}/action/userInfo!doPost.do",
                //当前请求页面要传递的数据，如果要获取页面输入的值则使用$("#name".val())。username(password)为向后台传递的参数名
                data:{keyword:$("#keyword").val()},
                dataType:'json'//数据传输格式为json
            });
        }

    </script>
</head>
<body>
<%--<iframe src="jsp/dao_hang_lan.jsp" width="100%" height="40" frameborder="0"></iframe>--%>
<div id="danghanglan">
    <ul>
        <a href="/Team4/taobaoAccount!zhuYe.do"><li class="ft_left">${taobaoAccount.personnelAccount} 欢迎来到WechatBusiness</li></a>
        <a href="/Team4/shoppingCartAction!open.do"><li id="gouwuc">购物车</li></a>
        <a href="/Team4/jsp/seller_center.jsp"><li >卖家中心</li></a>
        <a href="/Team4/orderQuiryAction!open.do"><li >订单信息</li></a>
        <a href="/Team4/BillFlowServlet.do"><li >流水记录</li></a>
    </ul>
</div>
<div class="diaplay_box">
    <img id="logo" class="float_left" src="/Team4/img/lv_logo.png" alt="logo">
    <div class="search_box">
        <div class="taobaoAccount"><input type="text" id="keyword" placeholder="请输入淘宝账号" value=""/>
            <button type="button" id="submit" onclick="doFind()" value="搜索">搜索</button>
        </div>
    </div>
    <div class="display_table">
        <table >
            <thead>
            <tr>
                <th>编号</th>
                <th>淘宝账号</th>
                <th>姓名</th>
                <th>注册时间</th>
                <th>等级</th>
                <th>操作</th>
            </tr>
            </thead>
            <c:forEach items="${listResult}" var="taobao" varStatus="index">
            <tbody id="table_body_id">
                <tr id="trId">
                        <td id="taobaoId">${taobao.getId()}</td>
                        <td><a href="#" title=" " id="taobaoAccount" class="taobaoAccount">${taobao.getPersonnelAccount()}</a></td>
                        <td><a title=""  id="peopleName" class="peopleName">${taobao.getPeopleInfo().getName()}</a></td>
                        <td>${taobao.getAddTime()}</td>
                        <td>${taobao.getGrade().getGradeName()}</td>
                        <td><a title="" id="del_click" href="${pageContext.request.contextPath}/action/userInfo!del.do?method=del&id=${taobao.getId()}">删除</a></td>
                </tr>
            </tbody>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>