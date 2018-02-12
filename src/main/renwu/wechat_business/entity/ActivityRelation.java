package wechat_business.entity;/********************************************************************
 /**
 * @Project: Team4
 * @Package wechat_business.entity
 * @author dengchao
 * @date 2018/2/9 15:19
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author dengchao
 * @ClassName ActivityRelation
 * @Description 活动关系表
 * @date 2018/2/9
 */
public class ActivityRelation {
    /**
     * id 主键id
     */
    private Long id;

    /**
     * itemRelationId 商品关系表外键
     */
    private ItemRelation itemRelationId;

    /**
     * activityInfoId 活动信息表外键
     */
    private ActivityInfo activityInfoId;

    /**
     * @Title: ActivityRelation
     * @Description: 构造器
     * @author dengchao
     * @date 2018/2/9
     */
    public ActivityRelation(){

    }
    public ActivityRelation(Long id, ItemRelation itemRelationId, ActivityInfo activityInfoId) {
        this.id = id;
        this.itemRelationId = itemRelationId;
        this.activityInfoId = activityInfoId;
    }

    /**
     * @Title: get/set
     * @Description: 封装
     * @author dengchao
     * @date 2018/2/9
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ItemRelation getItemRelationId() {
        return itemRelationId;
    }

    public void setItemRelationId(ItemRelation itemRelationId) {
        this.itemRelationId = itemRelationId;
    }

    public ActivityInfo getActivityInfoId() {
        return activityInfoId;
    }

    public void setActivityInfoId(ActivityInfo activityInfoId) {
        this.activityInfoId = activityInfoId;
    }
}