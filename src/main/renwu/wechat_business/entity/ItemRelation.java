package wechat_business.entity;
/**
 * @Project: Team4
 * @Package wechat_business.entity
 * @author lvchong
 * @date 2018/1/31 10:44
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author lvchong
 * @ClassName ItemRelation
 * @Description 类描述
 * @date 2018/1/31
 */
public class ItemRelation {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 卖家信息
     */
    private SellerInfo sellerInfo;
    /**
     * 商品信息
     */
    private ItemInfo itemInfo;
    /**
     * 库存
     */
    private Double inventory;
    /**
     * 单价
     */
    private Double price;
    /**
     * 图片地址
     */
    private String imgAddr;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SellerInfo getSellerInfo() {
        return sellerInfo;
    }

    public void setSellerInfo(SellerInfo sellerInfo) {
        this.sellerInfo = sellerInfo;
    }

    public ItemInfo getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(ItemInfo itemInfo) {
        this.itemInfo = itemInfo;
    }

    public Double getInventory() {
        return inventory;
    }

    public void setInventory(Double inventory) {
        this.inventory = inventory;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgAddr() {
        return imgAddr;
    }

    public void setImgAddr(String imgAddr) {
        this.imgAddr = imgAddr;
    }
}
