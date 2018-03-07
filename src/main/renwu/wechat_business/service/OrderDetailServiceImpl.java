package wechat_business.service;/********************************************************************
 /**
 * @Project: java_practice
 * @Package com.wechat_business.sercvice
 * @author hehongju
 * @date 2018/1/22 5:50
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import org.springframework.stereotype.Service;
import wechat_business.dao.OrderDetailDao;
import wechat_business.entity.OrderDetail;

/**
 * @author hehongju
 * @ClassName OrderDetailServiceImpl
 * @Description 订单详情业务类
 * @date 2018/1/22
 */
@Service("orderDetailService")
public class OrderDetailServiceImpl extends ServiceUtil<OrderDetailDao,OrderDetail> implements OrderDetailService{

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
    public OrderDetail crateOrderDetail(Long taobaoAccountId, Long itemInfoId, Double itemNumber, Double amout) {
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setOrderInfoId(0l);
        orderDetail.setTaobaoAccountId(taobaoAccountId);
        orderDetail.setItemInfoId(itemInfoId.longValue());
        orderDetail.setItemNumber(itemNumber.doubleValue());
        orderDetail.setAmount(amout.doubleValue());
        orderDetail.setOrderStatus((byte) 1);
        orderDetail.setIsSent(false);
        orderDetail.setIsReceived(false);
        orderDetail.setIsReturned(false);
        return orderDetail;
    }
}