package wechat_business.service;/********************************************************************
 /**
 * @Project: java_practice
 * @Package wechat_business.service
 * @author caixing
 * @date 2018/1/29 9:56
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import wechat_business.dao.PaypalInfoDaoImpl;
import wechat_business.entity.PaypalInfo;

import java.sql.SQLException;

/**
 * @author caixing
 * @ClassName paypalInfoServiceImpl
 * @Description 类描述 支付宝业务实现类
 * @date 2018/1/29
 */
public class paypalInfoServiceImpl implements  paypalInfoService{
    /**
     * @Title: pay
     * @Description: 方法描述 支付
     * @author caixing
     * @param: number支付金额
     * @date 2018/1/29
     */
    @Override
    public void pay( PaypalInfo paypalInfo,Double number) {
       paypalInfo.setBalance(paypalInfo.getBalance().doubleValue()-number.doubleValue());
        try {
            new PaypalInfoDaoImpl().saveOrUpdate(paypalInfo);
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
    @Override
    public void recharge(Double number) {

    }
}
