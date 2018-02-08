package wechat_business.entity;
/**
 * @Project: Team4
 * @Package wechat_business.entity
 * @author lvchong
 * @date 2018/1/30 9:40
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author lvchong
 * @ClassName ItemType
 * @Description 商品类型
 * @date 2018/1/30
 */
public class ItemType {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 商品类型名称
     */
    private String name;
    /**
     * 商品类型描述
     */
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
