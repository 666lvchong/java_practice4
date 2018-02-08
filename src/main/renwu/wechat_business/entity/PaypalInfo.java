package wechat_business.entity;/********************************************************************
 /**
 * @Project: java_practice
 * @Package entry
 * @author caixing
 * @date 2018/1/20 16:08
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.util.Date;

/**
 * @author caixing
 * @ClassName PaypalInfo
 * @Description 类描述 支付宝信息
 * @date 2018/1/20
 */
public class PaypalInfo {
    /**
     * 支付宝主键ID
     */
    private Long id;
    /**
     *支付宝账号
     */
    private String account;
    /**
     *支付宝密码
     */
    private String password;
    /**
     *支付宝余额
     */
    private Double balance;
    /**
     *注册日期 yyyy-MM-dd HH:mm:ss
     */
    private Date registerDate;
    /**
     *支付密码
     */
    private Integer payPassword;
    /**
     *是否冻结 1--是 0--否
     */
    private Byte isFreezen;
    /**
     *是否注销 1--是 0--否
     */
    private Byte isCancel;
    /**
     *是否删除 1--是 0---否
     */
    private Byte isDelete;
    /**
     * 淘宝账号
     */
    private Long taobaoAccountId;
    /**
     *无参构造
     */
    public PaypalInfo() {
    }
    /**
     *get()/set()方法
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Integer getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(Integer payPassword) {
        this.payPassword = payPassword;
    }

    public Byte getIsFreezen() {
        return isFreezen;
    }

    public void setIsFreezen(Byte isFreezen) {
        this.isFreezen = isFreezen;
    }

    public Byte getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(Byte isCancel) {
        this.isCancel = isCancel;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Long getTaobaoAccountId() {
        return taobaoAccountId;
    }

    public void setTaobaoAccountId(Long taobaoAccountId) {
        this.taobaoAccountId = taobaoAccountId;
    }

    /**
     * @Title: toString
    * @Description: 方法描述 输出对象信息
     * @author caixing
     * @date 2018/1/29
     */

    @Override
    public String toString() {
        return "PaypalInfo{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", registerDate=" + registerDate +
                ", payPassword=" + payPassword +
                ", isFreezen=" + isFreezen +
                ", isCancel=" + isCancel +
                ", isDelete=" + isDelete +
                ", taobaoAccountId=" + taobaoAccountId +
                '}';
    }
}
