package wechat_business.service;/********************************************************************
 /**
 * @Project: java_practice
 * @Package wechat_business.service
 * @author caixing
 * @date 2018/1/29 9:51
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import wechat_business.entity.PaypalInfo;

/**
 * @author caixing
 * @ClassName paypalInfoService
 * @Description 类描述 支付宝业务
 * @date 2018/1/29
 */
public interface PaypalInfoService {
    /**
     * @Title: pay
     * @Description: 方法描述 支付
     * @author caixing
     * @param: number支付金额
     * @date 2018/1/29
     */

    void pay(PaypalInfo paypalInfo,Double number);

    /**
     * @Title: recharge
     * @Description: 方法描述 充值
     * @author caixing
     * @date 2018/1/29
     * @param: number充值金额
     */

    void recharge(Double number);
}
