package wechat_business.entity;/********************************************************************
 /**
 * @Project: java_practice
 * @Package com.wechat_business.entity
 * @author hehongju
 * @date 2018/1/22 5:49
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import wechat_business.util.FormatUtils;

import java.util.Date;

/**
 * @author hehongju
 * @ClassName OrderDetail
 * @Description 类描述
 * @date 2018/1/22
 */
public class OrderDetail {
    /**
     * id 主键ID
     */
    private Long id;
    /**
     * orderInfoId 订单信息
     */
    private Long orderInfoId;
    /**
     * taobaoAccountId 淘宝账户信息
     */
    private Long taobaoAccountId;
    /**
     * emInfoIdit 商品信息
     */
    private Long itemInfoId;
    /**
     * goodsNumber 购买商品数量
     */
    private Double itemNumber;
    /**
     * amount 金额（单位：元）
     */
    private Double amount;
    /**
     * orderStatus 订单状态 1-订单开始  2-付款成功 3-已发货 4-已收货 5-订单失败 6-订单成功
     */
    private Byte orderStatus;
    /**
     * isSent 发货状态 true--发货 false--未发货
     */
    private Boolean isSent;
    /**
     * isReceived 收货状态 true--收货 false--未收货
     */
    private Boolean isReceived;
    /**
     * isReturned 退货状态 true--退货 false--未退货
     */
    private Boolean isReturned;
    /**
     * sentTime 发货时间 yyyy-MM-dd HH：mm：ss
     */
    private Date sentTime;
    /**
     * receivedTime 收货时间 yyyy-MM-dd HH：mm：ss
     */
    private Date receivedTime;
    /**
     * returnedTime 退货时间 yyyy-MM-dd HH：mm：ss
     */
    private Date returnedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    public Long getItemInfoId() {
        return itemInfoId;
    }

    public void setItemInfoId(Long itemInfoId) {
        this.itemInfoId = itemInfoId;
    }

    public Double getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(Double itemNumber) {
        this.itemNumber = itemNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Boolean getIsSent() {
        return isSent;
    }

    public void setIsSent(Boolean isSent) {
        this.isSent = isSent;
    }

    public Boolean getIsReceived() {
        return isReceived;
    }

    public void setIsReceived(Boolean isReceived) {
        this.isReceived = isReceived;
    }

    public Boolean getIsReturned() {
        return isReturned;
    }

    public void setIsReturned(Boolean isReturned) {
        this.isReturned = isReturned;
    }

    public Date getSentTime() {
        return sentTime;
    }

    public void setSentTime(Date sentTime) {
        this.sentTime = sentTime;
    }

    public Date getReceivedTime() {
        return receivedTime;
    }

    public void setReceivedTime(Date receivedTime) {
        this.receivedTime = receivedTime;
    }

    public Date getReturnedTime() {
        return returnedTime;
    }

    public void setReturnedTime(Date returnedTime) {
        this.returnedTime = returnedTime;
    }

    public Long getTaobaoAccountId() {
        return taobaoAccountId;
    }

    public void setTaobaoAccountId(Long taobaoAccountId) {
        this.taobaoAccountId = taobaoAccountId;
    }
}