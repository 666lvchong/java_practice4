<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/31
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.sql.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>发布商品</title>
    <meta charset=UTF-8>
    <meta http-equiv="param" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keywprd3">
    <meta http-equiv="description" content="ajax方式">
 
    <link href="/Team4/css/publish_commodity.css" rel="stylesheet" type="text/css">
    <script type="text/javascript">
        function toPublish() {
            $.ajax({
                type:"post",//方法类型
                dataType:"json",//预期服务器返回的数据类型
                url:"/Team4/SellerPublishServlet",//设置后台servlet的url
                data:$('#J_publishForm').serialize(),
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
<body>
<jsp:include page="dao_hang_lan.jsp"></jsp:include>
    <div>
        <div style="margin:10px 0 20px";></div>
        <form id="J_publishForm" name="J_publishForm" action="/Team4/SellerPublishServlet" method="post">
            <fieldset>
                <div id="form-bd">
                    <div class="control-group ">
                        <label class="control-label" for="title">
                            <strong>商品名字</strong>
                        </label>
                        <div class="controls">
                            <div class="input-wrap">
                                <input id="title" type="text" class="input title" name="NAME" />
                            </div>
                        </div>
                    </div>
                    <div class="control-group ">
                    <label class="control-label" for="title">
                        <strong>数量</strong>
                    </label>
                    <div class="controls">
                        <div class="input-wrap">
                            <input id="INVENTORY" type="text" class="input title" name="INVENTORY" />
                        </div>
                    </div>
                </div>
                    <div class="control-group ">
                        <label class="control-label" for="title">
                            <strong>添加时间</strong>
                        </label>
                        <div class="controls">
                            <div class="input-wrap">
                                <input id="IN_TIME" type="text" class="input title" name="IN_TIME" />
                            </div>
                        </div>
                    </div>
                    <div class="control-group ">
                        <label class="control-label" for="title">
                            <strong>生产商</strong>
                        </label>
                        <div class="controls">
                            <div class="input-wrap">
                                <input id="MAKER" type="text" class="input title" name="MAKER" />
                            </div>
                        </div>
                    </div>
                    <div class="control-group ">
                        <label class="control-label" for="title">
                            <strong>生产地</strong>
                        </label>
                        <div class="controls">
                            <div class="input-wrap">
                                <input id="ADDR" type="text" class="input title" name="ADDR" />
                            </div>
                        </div>
                    </div>
                    <div class="control-group ">
                        <label class="control-label" for="title">
                            <strong>生产时间</strong>
                        </label>
                        <div class="controls">
                            <div class="input-wrap">
                                <input id="MAKE_TIME" type="text" class="input title" name="MAKE_TIME" />
                            </div>
                        </div>
                    </div>

                    <div id="J_Price">
                        <div class="control-group ">
                            <label class="control-label" for="price">
                                <strong>价格</strong>
                            </label>
                            <div class="controls">
                                <div class="input-wrap input-append">
                                    <input id="price" type="text" class="input J_PriceCheck" name="PRICE"  "/>
                                    <span class="add-on">元</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" >
                            <strong>上传图片</strong>
                        </label>
                        <div class="controls">
                            <%--<div id="J_UploadQueueContainer" data-url="//sell.2.taobao.com/publish/json/upPicSpace.htm?userId=2354197437&amp;_input_charset=utf-8&amp;_tb_token_=7ee38e847b3ee">--%>
                                <ul id="J_UploadQueue" class="upload-queue ks-uploader-queue imageUploader-queue">
                                </ul>
                            </div>
                            <div id="J_UploadPic" class="upload ">
                                <div class="upload-inner">
                                    <b></b>
                                    <ul class="operate">
                                        <li>

                                            <a href="javascript:void(0)" class="g-u ks-uploader-button imageUploader-button" style="position: relative;">
                                                <span class="btn-text">上传图片</span>
                                                <div class="file-input-wrapper" style="overflow: hidden;">
                                                    <input name="imgFile" hidefocus="true" class="file-input" type="file">
                                                </div>
                                                <div class="drop-wrapper" style="position: absolute; top: 0px; left: 0px; width: 100%; height: 100%; z-index: 1000;">

                                                </div>
                                            </a>
                                        </li>
                                    </ul>
                                </div>

                            </div>
                            <span class="upload-tip">最多可上传十张照片，图片每张最大5M</span>
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <input type="submit" name="event_submit_do_publish" onclick="toPublish()"  value="发布"/>
                            <span class="notradetype">
                        <span class="notradetype-icon"></span>
                        如果您有淘宝店铺，自1月27日起发布的闲置商品，在店铺中将不再展示。
                    </span>
                        </div>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>
</body>
</html>
