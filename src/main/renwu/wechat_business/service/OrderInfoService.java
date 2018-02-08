package wechat_business.service;/********************************************************************
 /**
 * @Project: java_practice
 * @Package com.wechat_business.sercvice
 * @author hehongju
 * @date 2018/1/22 5:50
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author hehongju
 * @InterfaceName OrderInfoService
 * @Description 订单信息业务接口
 * @date 2018/1/22
 */
public interface OrderInfoService {
    /**
     * @Title: crateOrderInfo
     * @Description: 创建订单信息
     * @author hehongju
     * @date 2018-01-23
     * @param orderNumber 订单编号
     * @param taobaoAccountId 淘宝账户编号
     * @param orderTotalAmount 订单总金额
     */
    public OrderInfoServiceImpl crateOrderInfo(String orderNumber, Long taobaoAccountId, Double orderTotalAmount);
}