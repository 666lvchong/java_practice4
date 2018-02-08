package wechat_business.entity;/********************************************************************
 /**
 * @Project: src
 * @Package wechat_business.entity
 * @author dengchao
 * @date 2018/1/29 17:00
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author dengchao
 * @ClassName Grade
 * @Description 管理员
 * @date 2018/1/29
 */
public class Grade {

    /**
     * id 主键id
     */
    private Long id;

    /**
     * gradeNumber 等级编号
     */
    private Byte gradeNumber;

    /**
     * gradeName 等级名称
     */
    private String gradeName;

    /**
     * @Title: get/set
     * @Description: 封装
     * @author dengchao
     * @date 2018/1/29
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getGradeNumber() {
        return gradeNumber;
    }

    public void setGradeNumber(Byte gradeNumber) {
        this.gradeNumber = gradeNumber;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }
}