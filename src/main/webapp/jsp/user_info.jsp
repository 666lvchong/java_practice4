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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"/>
    <script type="text/javascript">
        function doFind(){
            $.ajax({
                type: "POST",
                url:"${pageContext.request.contextPath}/userInfo!doPost.do",
                data:{keyword:$("#keyword").val()},
                dataType:"json",
                success: function(data) {
//                    var outTaobaoId=data.obj.outTaobaoId.toString();
//                    var outTaobaoAccount=data.obj.outTaobaoAccount.toString();
//                    var outPeopleName=data.obj.outPeopleName.toString();
//                    var outAddTime=data.obj.outAddTime.toString();
//                    var outGradeName=data.obj.outGradeName.toString();
//                    $("#taobaoId").append(outTaobaoId);
//                    $("#taobaoAccount").append(outTaobaoAccount);
//                    $("#peopleName").append(outPeopleName);
                    alert("请求成功！");
                },
                error: function(request) {
                    alert("发送请求失败！");
                }
            });
        }
    </script>
</head>
<body>
<iframe src="jsp/dao_hang_lan.jsp" width="100%" height="40" frameborder="0"></iframe>
<div id="ajaxDiv"></div>
<div class="diaplay_box">
    <img id="logo" class="float_left" src="/Team4/img/lv_logo.png" alt="logo">
    <div class="search_box">
        <form class="search_form" id="search_form"  action="${pageContext.request.contextPath}/userInfo!doPost.do" method="post">
            <div class="taobaoAccount"><input type="text" id="keyword" name="keyword" placeholder="请输入淘宝账号" value=""/>
                <button type="submit" id="submit" onclick="doFind()" value="搜索">搜索</button></div>
        </form>
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
                        <td><a title="" id="del_click" href="${pageContext.request.contextPath}/userInfo!doPost.do?method=del&id=${taobao.getId()}">删除</a></td>
                </tr>
            </tbody>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>