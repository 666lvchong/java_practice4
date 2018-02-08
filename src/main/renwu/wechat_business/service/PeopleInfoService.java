package wechat_business.service;/********************************************************************
 /**
 * @Project: java_wechat_business
 * @Package main.java.service
 * @author dengchao
 * @date 2018/1/21 20:57
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import wechat_business.entity.PeopleInfo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author dengchao
 * @ClassName PeopleInfoService
 * @Description 类描述
 * @date 2018/1/22
 */
public interface PeopleInfoService {
    /**
     * @Title: deleteById
     * @Description: 根据Id删除数据
     * @author dengchao
     * @date 2018/1/22
     */
    public abstract Integer deleteById(Long id) throws SQLException;

    /**
     * @Title: deleteByIds
     * @Description: 根据Id删除多个
     * @author dengchao
     * @date 2018/1/22
     */
    public abstract Integer deleteByIds(Long[] ids) throws SQLException;
    /**
     * @Title: saveOrUpdate
     * @Description: 添加或者修改
     * @author dengchao
     * @date 2018/1/22
     */
    public abstract Integer saveOrUpdate(PeopleInfo people) throws SQLException;
    /**
     * @Title: findById
     * @Description: 根据id查询数据
     * @author dengchao
     * @date 2018/1/22
     */
    public abstract PeopleInfo findById(Long id) throws SQLException;
    /**
     * @Title: findByCondtion
     * @Description: 条件查询数据
     * @author dengchao
     * @date 2018/1/22
     */
    public abstract List<PeopleInfo> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException;
    /**
     * @Title: findByCondtionForPage
     * @Description: 根据条件分页查询数据
     * @author dengchao
     * @date 2018/1/22
     */
    public abstract List<PeopleInfo> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException;
}