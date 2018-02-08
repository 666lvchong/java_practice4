package wechat_business.service;/********************************************************************
 /**
 * @Project: java_practice
 * @Package com.wechat_business.sercvice
 * @author hehongju
 * @date 2018/1/22 5:50
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import wechat_business.entity.OrderDetail;

/**
 * @author hehongju
 * @ClassName OrderDetailServiceImpl
 * @Description 订单详情业务类
 * @date 2018/1/22
 */
public class OrderDetailServiceImpl extends OrderDetail implements OrderDetailService {

    /**
     * @Title: crateOrder
     * @Description: 创建订单详情
     * @author hehongju
     * @date 2018-01-23
     * @param itemInfoId 商品信息编号
     * @param itemNumber 购买商品数量
     * @param amout 商品价格
     */
    @Override
    public OrderDetailServiceImpl crateOrderDetail(Long taobaoAccountId, Long itemInfoId, Double itemNumber, Double amout) {
        this.setOrderInfoId(0l);
        this.setTaobaoAccountId(taobaoAccountId);
        this.setItemInfoId(itemInfoId.longValue());
        this.setItemNumber(itemNumber.doubleValue());
        this.setAmount(amout.doubleValue());
        this.setOrderStatus((byte)1);
        this.setIsSent(false);
        this.setIsReceived(false);
        this.setIsReturned(false);
        return this;
    }
}