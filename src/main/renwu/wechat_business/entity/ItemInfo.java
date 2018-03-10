package wechat_business.entity;/********************************************************************
 /**
 * @Project: java_practice
 * @Package entity
 * @author HL
 * @date 2018/1/20 15:56
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.sql.Date;

/**
 * @author haunglei
 * @ClassName ItemInfo
 * @Description 类描述
 * @date 2018/1/20
 */
public class ItemInfo  {

    /**
     * 主键ID
     */
    private Long id;
    /**
     * 商品名
     */
    private String name;
    /**
     * 商品编号
     */
    private String number;
    /**
     * 类型
     */
    private ItemType itemType;
    /**
     * 添加时间
     */
    private Date inTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 生产商
     */
    private String maker;
    /**
     * 生产地
     */
    private String addr;
    /**
     * 生产日期yyyy-MM-dd
     */
    private Date makeTime;
    /**
     * 保质期yyyy-MM-dd
     */
    private Date expiration;
    /**P
     * 原产地
     */
    private String origin;
    /**
     * 商品描述
     */
    private String description;
    /**
     * 折扣
     */
    private Float discount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Date getMakeTime() {
        return makeTime;
    }

    public void setMakeTime(Date makeTime) {
        this.makeTime = makeTime;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }
}
