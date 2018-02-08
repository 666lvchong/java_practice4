package wechat_business.entity;

import java.sql.Date;
public class TaobaoAccount {

    /**
     * id 主键
     */
    private Long id;

    /**
     * personnel_account 人员账户
     */
    private String personnelAccount;

    /**
     * password 密码
     */
    private String password;

    /**
     * gradeId 等级权限id
     */
    private Grade grade;

    /**
     * is_frozen 是否冻结 0 -否 1 -是
     */
    private Byte isFrozen;

    /**
     * is_cancellation 是否注销 0-否 1-是
     */
    private Byte isCancellation;

    /**
     * is_delete 是否删除 0-否 1-是
     */
    private Byte isDelete;

    /**
     * people_info_id 人员信息
     */
    private PeopleInfo peopleInfo;

    /**
     * addTime 添加时间(yyyy-MM-dd)
     */
    private Date addTime;

    /**
     * updateTime 更新时间(yyyy-MM-dd)
     */
    private Date updateTime;


    /**
     * @Title: Person
     * @Description: 构造函数
     * @author huangpai
     * @date 2018/1/16
     */
    public TaobaoAccount() {

    }



    /**
     * get 和 set 方法
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonnelAccount() {
        return personnelAccount;
    }

    public void setPersonnelAccount(String personnelAccount) {
        this.personnelAccount = personnelAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Byte getIsFrozen() {
        return isFrozen;
    }

    public void setIsFrozen(Byte isFrozen) {
        this.isFrozen = isFrozen;
    }

    public Byte getIsCancellation() {
        return isCancellation;
    }

    public void setIsCancellation(Byte isCancellation) {
        this.isCancellation = isCancellation;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public PeopleInfo getPeopleInfo() {
        return peopleInfo;
    }

    public void setPeopleInfo(PeopleInfo peopleInfo) {
        this.peopleInfo = peopleInfo;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setGrade(String grade) {
    }

    public void setPeopleInfo(String pathInfo) {
    }
}


