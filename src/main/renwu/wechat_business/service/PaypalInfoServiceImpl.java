package wechat_business.service;/********************************************************************
 /**
 * @Project: Team4
 * @Package wechat_business.service
 * @author caixing
 * @date 2018/3/5 17:27
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import org.springframework.stereotype.Service;
import wechat_business.dao.PaypalInfoDao;
import wechat_business.entity.PaypalInfo;

import java.sql.SQLException;

/**
 * @author caixing
 * @ClassName PaypalInfoServiceImpl
 * @Description 类描述 支付业务
 * @date 2018/3/5
 */
@Service("PaypalInfoService")
public class PaypalInfoServiceImpl extends  ServiceUtil<PaypalInfoDao,PaypalInfo>{
    /**
     * @Title: pay
     * @Description: 方法描述 支付
     * @author caixing
     * @param: number支付金额
     * @date 2018/1/29
     */

    public void pay( PaypalInfo paypalInfo,Double number) {
        paypalInfo.setBalance(paypalInfo.getBalance().doubleValue()-number.doubleValue());
        try {
            new PaypalInfoDao().update(paypalInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Title: recharge
     * @Description: 方法描述 充值
     * @author caixing
     * @date 2018/1/29
     * @param: number充值金额
     */
    public void recharge(Double number) {

    }



}
