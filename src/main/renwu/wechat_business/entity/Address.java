package wechat_business.entity;/********************************************************************
 /**
 * @Project: Team4
 * @Package wechat_business.entity
 * @author hehongju
 * @date 2018/3/1 18:11
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.util.Date;
import java.util.function.LongPredicate;

/**
 * @author hehongju
 * @ClassName Address
 * @Description 地址类
 * @date 2018/3/1
 */
public class Address {
    /**
     *id 地址主键ID
     */
    private Long id;
    /**
     *taobaoAccountId 淘宝账户id
     */
    private Long taobaoAccountId;
    /**
     *addressType 地址类型 1-收货地址，2-发货地址 3-运输地址
     */
    private Byte addressType;
    /**
     *address 地址
     */
    private String address;
    /**
     *linkmanContacts 联系人
     */
    private String linkmanContacts;
    /**
     *telephone 联系电话
     */
    private String telephone;
    /**
     *createTime 创建时间
     */
    private Date createTime;
    /**
     *updateTime 更新时间
     */
    private Date updateTime;
    /**
     *isDefault 是否默认地址 1-是 0--否
     */
    private Boolean isDefault;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaobaoAccountId() {
        return taobaoAccountId;
    }

    public void setTaobaoAccountId(Long taobaoAccountID) {
        this.taobaoAccountId = taobaoAccountID;
    }

    public Byte getAddressType() {
        return addressType;
    }

    public void setAddressType(Byte addressType) {
        this.addressType = addressType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLinkmanContacts() {
        return linkmanContacts;
    }

    public void setLinkmanContacts(String linkmanContacts) {
        this.linkmanContacts = linkmanContacts;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }
}