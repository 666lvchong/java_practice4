<%--
  Created by IntelliJ IDEA.
  User: hl1027
  Date: 2018/2/5
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@page import="wechat_business.entity.ItemInfo" %>
<%ItemInfo itemInfo = (ItemInfo)request.getAttribute("item");%>
<html>
<head>
    <title></title>
<style type="text/css">
    ul .li{
        margin-right: 20px;
        width: 100px;
        color: #7E7E81;
        float: right;
        list-style-type: none;
        line-height: 40px;
    }
    ul .li:hover{
        color: #ee3400;
    }
    #gouwuc{
        margin-right: 50px;
    }
    .ft_left{
        float: left;
        color: #7E7E81;
        list-style-type: none;
        line-height: 40px;
    }
    #danghanglan{
        width: 100%;
        background-color: #EEEEEE;
        height:40px;
    }
    .left {
        float: left;
        width: 100%;
        height: 500px;
        background-color: #7E7E81;
        margin-right: -300px;
    }
</style>

</head>
<body>
<iframe src="jsp/dao_hang_lan.jsp" width="100%" height="40" frameborder="0"></iframe>
<div id="danghanglan">
    <ul>
        <li class="ft_left">嘿嘿 欢迎来到WechatBusiness</li>
        <a href="#"><li class="li" id="gouwuc">购物车</li></a>
        <a href="#"><li class="li">卖家中心</li></a>
        <a href="#"><li class="li">订单信息</li></a>
    </ul>
    <div class="left">
    <div style="width:100px;height:100px;float:bottom;"><img src="/Team4/img/11.webp" alt=""/></div>
    <div style=" width:900px;height:200px;float:right;">
        <p class="tb-subtitle">优质进口 丨 全场顺丰包邮 丨 8天无理由退换货 丨 支持买一送一</p>
        <h1 class="tb-main-title" data-title="极品零食，欢乐一下">
       真皮衣 假一赔十
        </h1>
        <p style=" width: 200px;height: 50px"> <%=itemInfo.getName()%></p>
        <p style=" width: 200px;height: 50px">单价： </p>
        <p style=" width: 200px;height: 50px">数量：</p>
        <a href=";" title="加入购物车" class="J_LinkAdd" shortcut-key="a" shortcut-label="加入购物车" shortcut-effect="click" data-spm-click="gostr=/tbdetail;locaid=d2">
            <i class="tb-iconfont">&#365;</i>加入
            <input type="button" value="购物" onclick=""/>
        </a>
        <p style=" width: 200px;height: 50px" class="num_box"><a class="J_jia">+</a>
         <label><input type="text" class="num" value=""/></label><a class="J_jian">-</a></p>
        <script type="text/javascript">
            $(document).ready(function(){
                var add,reduce,num,num_txt;
                add=$(".J_jia");//添加数量
                reduce=$(".J_jian");//减少数量
                num="";//数量初始值
                num_txt=$(".num");//接受数量的文本框
                //var num_val=num_txt.val();//给文本框附上初始值

                /*添加数量的方法*/
                add.click(function(){
                    num = $(".num").val();
                    num++;
                    num_txt.val(num);
                    //ajax代码可以放这里传递到数据库实时改变总价
                });

                /*减少数量的方法*/
                reduce.click(function(){
                    //如果文本框的值大于0才执行减去方法
                    num = $(".num").val();
                    if(num >0){
                        //并且当文本框的值为1的时候，减去后文本框直接清空值，不显示0
                        if(num==1)
                        { num--;
                            num_txt.val("");
                        }
                        //否则就执行减减方法
                        else
                        {
                            num--;
                            num_txt.val(num);
                        }
                    }
                });
            })
        </script>
        <p style="background-color: sienna;width: 60px"><button>购买</button></p>
    </div>
    <div style="clear:both;"></div>
</div>
</div>
</body>
</html>
