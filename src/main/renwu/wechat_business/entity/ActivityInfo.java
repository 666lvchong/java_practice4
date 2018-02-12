package wechat_business.entity;/********************************************************************
 /**
 * @Project: Team4
 * @Package wechat_business.entity
 * @author dengchao
 * @date 2018/2/9 15:12
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.util.Date;

/**
 * @author dengchao
 * @ClassName ActivityInfo
 * @Description 活动信息表
 * @date 2018/2/9
 */
public class ActivityInfo {
    /**
     * id 主键id
     */
    private Long id;

    /**
     * discount 折扣
     */
    private Double discount;

    /**
     * activityName 活动名称
     */
    private String activityName;

    /**
     * activityStartTime 活动开始时间 yyyy-MM-dd HH:mm:ss
     */
    private Date activityStartTime;

    /**
     * activityEndTime 活动结束时间 yyyy-MM-dd HH:mm:ss
     */
    private Date activityEndTime;

    /**
     * @Title: ActivityInfo
     * @Description: 构造器
     * @author dengchao
     * @date 2018/2/9
     */
    public ActivityInfo(){

    }
    public ActivityInfo(Long id, Double discount, String activityName, Date activityStartTime, Date activityEndTime) {
        this.id = id;
        this.discount = discount;
        this.activityName = activityName;
        this.activityStartTime = activityStartTime;
        this.activityEndTime = activityEndTime;
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

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Date getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(Date activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    public Date getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(Date activityEndTime) {
        this.activityEndTime = activityEndTime;
    }
}