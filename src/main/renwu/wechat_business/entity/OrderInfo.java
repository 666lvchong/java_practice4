package wechat_business.entity;/********************************************************************
 /**
 * @Project: java_practice
 * @Package com.wechat_business.entity
 * @author hehongju
 * @date 2018/1/22 5:48
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.util.Date;

/**
 * @author hehongju
 * @ClassName OrderInfo
 * @Description 订单信息
 * @date 2018/1/22
 */
public class OrderInfo {
    /**
     * id 主键ID
     */
    private Long id;
    /**
     * orderNum 订单编号
     */
    private String orderNum;
    /**
     * taobaoAccountId 淘宝账户信息
     */
    private Long taobaoAccountId;
    /**
     * orderTotalAmount 订单总金额
     */
    private Double orderTotalAmount;
    /**
     * creationTime 创建订单时间 yyyy-MM-dd HH：mm：ss
     */
    private Date creationTime;
    /**
     * tradingTime 交易成功时间 yyyy-MM-dd HH：mm：ss
     */
    private Date tradingTime;
    /**
     * isSuccess 是否交易成功 true-成功 false-不成功
     */
    private Boolean isSuccess;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Long getTaobaoAccountId() {
        return taobaoAccountId;
    }

    public void setTaobaoAccountId(Long taobaoAccountId) {
        this.taobaoAccountId = taobaoAccountId;
    }

    public Double getOrderTotalAmount() {
        return orderTotalAmount;
    }

    public void setOrderTotalAmount(Double orderTotalAmount) {
        this.orderTotalAmount = orderTotalAmount;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getTradingTime() {
        return tradingTime;
    }

    public void setTradingTime(Date tradingTime) {
        this.tradingTime = tradingTime;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}