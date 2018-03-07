package wechat_business.service;/********************************************************************
 /**
 * @Project: java_practice
 * @Package com.wechat_business.sercvice
 * @author hehongju
 * @date 2018/1/22 6:27
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import org.springframework.stereotype.Service;
import wechat_business.dao.OrderInfoDao;
import wechat_business.entity.OrderInfo;

import java.util.Date;

/**
 * @author hehongju
 * @ClassName OrderInfoServiceImpl
 * @Description 订单信息业务类
 * @date 2018/1/22
 */
@Service("orderInfoService")
public class OrderInfoServiceImpl extends ServiceUtil<OrderInfoDao,OrderInfo> implements OrderInfoService {
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
    public OrderInfo crateOrderInfo(String orderNumber, Long taobaoAccountId, Double orderTotalAmount) {
        OrderInfo orderInfo=new OrderInfo();
        orderInfo.setOrderNum(orderNumber);
        orderInfo.setTaobaoAccountId(taobaoAccountId);
        orderInfo.setOrderTotalAmount(orderTotalAmount);
        orderInfo.setCreationTime(new Date());
        orderInfo.setIsSuccess(false);
        return orderInfo;
    }
}