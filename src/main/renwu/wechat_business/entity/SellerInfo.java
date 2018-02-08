package wechat_business.entity;

import java.util.Date;

/********************************************************************
 /**
 * @Project: wechat_business
 * @Package entity
 * @author wangjunjie
 * @date 2018/1/20 16:49
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */
public class SellerInfo {
    /**
     * id 卖家表ID
     */
    private Long id;
    /**
     * shopName 商铺名字
     */
    private String shopName;
    /**
     * shopNumber 商铺编号
     */
    private String shopNumber;
    /**
     * shopType 商铺类型 0-企业商铺，1-个人商铺
     */
    private String shopType;
    /**
     * taobaoAccountId 所属那个淘宝账户
     */
    private Long taobaoAccountId;
    /**
     * registrationTime 注册时间
     */
    private String registrationTime;
    /**
     * address 地址
     */
    private String address;
    /**
     * email 邮箱
     */
    private String email;
    /**
     * email 关联公司名
     */
    private String affiltaedCompany;
    /**
     * commercialRegistrationNum 工商注册号
     */
    private String commercialRegistrationNum;
    /**
     * updateTime 更新时间
     */
    private String updateTime;
    /**
     * deposit 押金
     */
    private Double deposit;
    /**
     * creditworthiness 信誉度
     */
    private Long creditworthiness;
 /**
  * @Title:
  * @Description: 构造函数
  * @author wangjunjie
  * @date 2018/1/21

  */
public SellerInfo(){

}



    /**
      * @Title:
      * @Description: get与set方法
      * @author wangjunjie
      * @date 2018/1/21
      */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopNumber() {
        return shopNumber;
    }

    public void setShopNumber(String shopNumber) {
        this.shopNumber = shopNumber;
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }

    public Long getTaobaoAccountId() {
        return taobaoAccountId;
    }

    public void setTaobaoAccountId(Long taobaoAccountId) {
        this.taobaoAccountId = taobaoAccountId;
    }

    public String getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(String registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAffiltaedCompany() {
        return affiltaedCompany;
    }

    public void setAffiltaedCompany(String affiltaedCompany) {
        this.affiltaedCompany = affiltaedCompany;
    }

    public String getCommercialRegistrationNum() {
        return commercialRegistrationNum;
    }

    public void setCommercialRegistrationNum(String commercialRegistrationNum) {
        this.commercialRegistrationNum = commercialRegistrationNum;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Long getCreditworthiness() {
        return creditworthiness;
    }

    public void setCreditworthiness(Long creditworthiness) {
        this.creditworthiness = creditworthiness;
    }





    @Override
    public String toString() {
        return "SellerInfo{" +
                "id=" + id +
                ", shopName='" + shopName + '\'' +
                ", shopNumber='" + shopNumber + '\'' +
                ", shopType='" + shopType + '\'' +
                ", taobaoAccountId=" + taobaoAccountId +
                ", registrationTime='" + registrationTime + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", affiltaedCompany='" + affiltaedCompany + '\'' +
                ", commercialRegistrationNum='" + commercialRegistrationNum + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", deposit=" + deposit +
                ", creditworthiness=" + creditworthiness +
                '}';
    }
}
