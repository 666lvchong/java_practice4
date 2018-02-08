package wechat_business.service;/********************************************************************
 /**
 * @Project: java_practice
 * @Package com.wechat_business.sercvice
 * @author hehongju
 * @date 2018/1/22 6:27
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import wechat_business.entity.OrderInfo;

import java.util.Date;

/**
 * @author hehongju
 * @ClassName OrderInfoServiceImpl
 * @Description 订单信息业务类
 * @date 2018/1/22
 */
public class OrderInfoServiceImpl extends OrderInfo implements OrderInfoService {
    /**
     * @Title: crateOrderInfo
     * @Description: 创建订单信息
     * @author hehongju
     * @date 2018-01-23
     * @param orderNumber 订单编号
     * @param taobaoAccountId 淘宝账户编号
     * @param orderTotalAmount 订单总金额
     */
    @Override
    public OrderInfoServiceImpl crateOrderInfo(String orderNumber, Long taobaoAccountId, Double orderTotalAmount) {
        this.setOrderNum(orderNumber);
        this.setTaobaoAccountId(taobaoAccountId);
        this.setOrderTotalAmount(orderTotalAmount);
        this.setCreationTime(new Date());
        this.setIsSuccess(false);
        return this;
    }
}