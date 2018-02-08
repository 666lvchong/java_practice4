package wechat_business.entity;/********************************************************************
 /**
 * @Project: java_wechat_business
 * @Package main.java.entity
 * @author dengchao
 * @date 2018/1/21 20:46
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import java.sql.Date;

/**
 * @author dengchao
 * @ClassName PeopleInfo
 * @Description 人员信息
 * @date 2018/1/16
 */
public class PeopleInfo {

    /**
     * id 主键id
     */
    private Long id;

    /**
     * name 姓名
     */
    private String name;

    /**
     * sex 性别 0-女，1-男
     */
    private Byte sex;

    /**
     * age 年龄
     */
    private Integer age;

    /**
     * nation 民族
     */
    private String nation;

    /**
     * birthdate 出生日期 yyyy-MM-dd
     */
    private Date birthdate;

    /**
     * idNumber 身份证号
     */
    private String idNumber;


    /**
     * mobilePhone 手机
     */
    private String mobilePhone;

    /**
     * nativePlace 籍贯
     */
    private String nativePlace;

    /**
     * mailBox 邮箱
     */
    private String mailBox;

    /**
     * permanentAdress 常住地址
     */
    private String permanentAdress;

    /**
     * profession 职业
     */
    private String profession;

    /**
     * workUnit 工作单位
     */
    private String workUnit;

    /**
     * createTime 创建时间 yyyy-MM-dd HH:mm:ss
     */
    private Date createTime;

    /**
     * updateTime 更新时间 yyyy-MM-dd HH:mm:ss
     */
    private Date updateTime;

    /**
     * @Title: PeopleInfo
     * @Description: 构造函数
     * @author dengchao
     * @date 2018-1-13
     */

    public PeopleInfo(String name) {
        this.name = name;
    }

    public PeopleInfo(Long id, String name, Byte sex, Integer age, String mobilePhone, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.mobilePhone = mobilePhone;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public PeopleInfo(){

    }

    /**
     * @Title: get/set
     * @Description: 封装
     * @author dengchao
     * @date 2018-1-13
     */
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

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getMailBox() {
        return mailBox;
    }

    public void setMailBox(String mailBox) {
        this.mailBox = mailBox;
    }

    public String getPermanentAdress() {
        return permanentAdress;
    }

    public void setPermanentAdress(String permanentAdress) {
        this.permanentAdress = permanentAdress;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
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


}