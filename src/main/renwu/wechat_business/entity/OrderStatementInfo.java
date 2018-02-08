package wechat_business.entity;
/**
 * @Project: java_practice
 * @Package wechat_business.entity
 * @author lvchong
 * @date 2018/1/20 17:55
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.sql.Date;

/**
 * @author lvchong
 * @ClassName OrderStatementInfo
 * @Description 类描述
 * @date 2018/1/20
 */
public class OrderStatementInfo {
    /**
     * 主键
     */
    private Long id;
    /**
     * 流水编号
     */
    private String serialNumber;
    /**
     * 订单信息id
     */
    private Long orderInfoId;
    /**
     * 支付宝信息id
     */
    private Long paypalInfoId;
    /**
     * 流水记录类型 1-收入，2--支出
     */
    private byte flowRecordType;
    /**
     * 支付状态 1—-支付成功，2--支付失败
     */
    private byte isPayStatus;
    /**
     * 交易金额
     */
    private Double amounts;
    /**
     * 创建交易时间
     */
    private Date launchTime;
    /**
     * 交易完成时间
     */
    private Date finshTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Long getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    public Long getPaypalInfoId() {
        return paypalInfoId;
    }

    public void setPaypalInfoId(Long paypalInfoId) {
        this.paypalInfoId = paypalInfoId;
    }

    public byte getFlowRecordType() {
        return flowRecordType;
    }

    public void setFlowRecordType(byte flowRecordType) {
        this.flowRecordType = flowRecordType;
    }

    public byte getIsPayStatus() {
        return isPayStatus;
    }

    public void setIsPayStatus(byte isPayStatus) {
        this.isPayStatus = isPayStatus;
    }

    public Double getAmounts() {
        return amounts;
    }

    public void setAmounts(Double amounts) {
        this.amounts = amounts;
    }

    public Date getLaunchTime() {
        return launchTime;
    }

    public void setLaunchTime(Date launchTime) {
        this.launchTime = launchTime;
    }

    public Date getFinshTime() {
        return finshTime;
    }

    public void setFinshTime(Date finshTime) {
        this.finshTime = finshTime;
    }

    public OrderStatementInfo(){}

    @Override
    public String toString() {
        return "OrderStatementInfo{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", orderInfoId=" + orderInfoId +
                ", paypalInfoId=" + paypalInfoId +
                ", flowRecordType=" + flowRecordType +
                ", isPayStatus=" + isPayStatus +
                ", amounts=" + amounts +
                ", launchTime=" + launchTime +
                ", finshTime=" + finshTime +
                '}';
    }
}
