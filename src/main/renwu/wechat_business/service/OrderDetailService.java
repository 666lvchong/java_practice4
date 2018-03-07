package wechat_business.service;/********************************************************************
 /**
 * @Project: java_practice
 * @Package com.wechat_business.sercvice
 * @author hehongju
 * @date 2018/1/22 5:49
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import wechat_business.entity.OrderDetail;

/**
 * @author hehongju
 * @InterfaceName OrderDetailService
 * @Description 订单详情业务接口
 * @date 2018/1/22
 */
public interface OrderDetailService {
    /**
     * @Title: crateOrder
     * @Description: 创建订单详情
     * @author hehongju
     * @date 2018-01-23
     * @param taobaoAccountId 淘宝账户编号
     * @param itemInfoId 商品信息编号
     * @param itemNumber 购买商品数量
     * @param amout 商品价格
     */
    public OrderDetail crateOrderDetail(Long taobaoAccountId, Long itemInfoId, Double itemNumber, Double amout);
}