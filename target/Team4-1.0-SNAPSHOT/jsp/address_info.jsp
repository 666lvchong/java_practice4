<%--
  Created by IntelliJ IDEA.
  User: 龚平
  Date: 2018/3/4
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>收货地址</title>
    <link rel="stylesheet" type="text/css" href="css/order.css" />
    <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
    <script type="text/javascript">
        function delAddress(id){
            if(confirm("你确定要取消此订单？")){
                var path="AddressServlet.do?edit=del&id="+id;
                $.ajax({
                            type : "POST",
                            url : path,
                            success:alert("删除成功")
                        }

                )
            }
        }
        function updateAddress(id){
            var path="AddressServlet.do?edit=update&id="+id;
            $.ajax({
                        type : "POST",
                        url : path

                    }
            )
        }
        function isAddress(id){
            var path="AddressServlet.do?edit=is&id="+id;
            $.ajax({
                        type : "POST",
                        url : path
                    }
            )
        }
        function saveAddress(id){
            if(confirm("你确定修改此地址？")){
                var path;
                if(id==0){
                    path="AddressServlet.do?edit=save";
                }else{
                    path="AddressServlet.do?edit=saveId";
                }
                $.ajax({
                            type : "POST",
                            dataType:'json',
                            url : path,
                            data:{addres:$('#addres').val(),name:$('#name').val(),tel:$('#tel').val(),id:id}
                        }
                )
            }
        }
    </script>
</head>
<body>
    <div class="maninlogo">
        <div class="maninlogo">
            <a href="findByItemInfo.do" title="首页"><img src="img/lv_logo.png" width="198px" height="114px"; /></a>
            <a href="findByItemInfo.do" title="回到首页">首页</a>
            > <a href="OrderQuiryServlet" title="返回订单信息">订单信息</a>
            > <a href="ShoppingCartServlet"  title="我的购物车">购物车</a >
            > <span class="orangered" >地址管理</span >
        </div>
        <hr>
        <div>
            <form >
                <table class="orderInfoTable" >
                    <tr>
                        <td><span class="orangered">收货地址管理</span></td>
                        <td class="tdleft">邮政编码选填，其余均为必填项</td>
                    </tr>
                    <tr>
                        <td>收货地址<span class="orangered">*</span></td>
                        <td class="tdleft"><input type="text" name="addres" id="addres"  size="40" value="${address.address}" /></td>
                    </tr>
                    <tr>
                        <td>邮政编码</td>
                        <td class="tdleft"><input type="text"  size="40" /></td>
                    </tr>
                    <tr>
                        <td>收货人姓名<span class="orangered">*</span></td>
                        <td class="tdleft"><input type="text" name="name" id="name"  size="40" value="${address.linkmanContacts}" /></td>
                    </tr>
                    <td>联系电话<span class="orangered">*</span></td>
                    <td class="tdleft"><input type="text" name="tel" id="tel"  size="40" value="${address.telephone}" /></td>
                    </tr>
                    </tr>
                    <c:if test="${indexAddress==true}">
                        <td><button type="submit" onclick="saveAddress(${address.id})" >保存</button></td>
                    </c:if>
                    <c:if test="${indexAddress==false}">
                        <td><button type="submit" onclick="saveAddress(0)" >保存</button></td>
                    </c:if>
                    <td class="tdleft"></td>
                    </tr>
                </table>
            </form>
            <div>
                <c:if test="${index==0}">
                    <div class="shoppingCartNull">暂无收货地址记录，快去添加你的收货地址！</div>
                </c:if>
                <c:if test="${index!=0}">
                    <table class="orderInfoTable">
                        <tr >
                            <th>序号</th>
                            <th> | </th>
                            <th>收货地址</th>
                            <th>收货人</th>
                            <th>联系电话</th>
                            <th>操作</th>
                            <th></th>
                        </tr>
                        <c:forEach items="${list}"  var="list" varStatus="i">
                            <tr >
                                <td class="orangered"> ${i.count} </td>
                                <td class="orangered"> | </td>
                                <td>${list.address}</td>
                                <td>${list.linkmanContacts}</td>
                                <td>${list.telephone}</td>
                                <td>
                                    <a href="AddressServlet.do?edit=update&id=${list.id}" >修改</a>
                                    <%--<a href="" onclick="updateAddress(${list.id}})" >修改</a>--%>
                                    / <a href="" onclick="delAddress(${list.id})">删除</a> </th>
                                <td>
                                    <c:if test="${list.isDefault==true}"><span class="save">默认地址</span></c:if>
                                    <c:if test="${list.isDefault==false}"><a href="" onclick="isAddress(${list.id})">设置为默认地址</a></c:if>
                                    </td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
            </div>
        </div>
    </div>
</body>
</html>
