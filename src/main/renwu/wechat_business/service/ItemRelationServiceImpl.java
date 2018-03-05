package wechat_business.service;
/**
 * @Project: java_practice
 * @Package wechat_business.service
 * @author lvchong
 * @date 2018/1/22 9:03
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wechat_business.dao.ItemRelationDao;
import wechat_business.entity.ItemRelation;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author lvchong
 * @ClassName OrderStatementInfoServiceImp
 * @Description 交易流水操作类
 * @date 2018/1/22
 */
@Service("itemRelationServiceImpl")
public class ItemRelationServiceImpl extends ServiceUtil<ItemRelationDao,ItemRelation>{
    /*
    @Autowired
    private ItemRelationDao dao;
  @Override
    *//**
     * @Title: deleteById
     * @Description: 删除一个交易流水
     * @author lvchong
     * @params  * @param id
     * @date 2018-01-29
     * @throw YnCorpSysException
     *//*
    public Integer deleteById(Long id) throws SQLException {
        return dao.deleteById(id);

    }

    @Override
    *//**
     * @Title: deleteByIds
     * @Description: 删除多个交易流水
     * @author lvchong
     * @params  * @param ids
     * @date 2018-01-29
     * @throw YnCorpSysException
     *//*

    public Integer deleteByIds(Long[] ids) throws SQLException {
        return dao.deleteByIds(ids);

    }

    @Override
    *//**
     * @Title: saveOrUpdate
     * @Description: 修改或者删除交易流水
     * @author lvchong
     * @params  * @param test
     * @date 2018-01-29
     * @throw YnCorpSysException
     *//*

    public Integer saveOrUpdate(ItemRelation test) throws SQLException {
        return dao.saveOrUpdate(test);

    }

    @Override
    *//**
     * @Title: findById
     * @Description: 根据ID查询
     * @author lvchong
     * @params  * @param id
     * @date 2018-01-29
     * @throw YnCorpSysException
     *//*

    public ItemRelation findById(Long id) throws SQLException {
        dao.getConnection();
        return dao.findById(id);

    }

    @Override
    *//**
     * @Title: findByCondtion
     * @Description: 条件查询
     * @author lvchong
     * @params  * @param stringObjectMap
     * @date 2018-01-29
     * @throw YnCorpSysException
     *//*

    public List<ItemRelation> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException {
        return dao.findByCondtion(stringObjectMap);

    }

    @Override
    *//**
     * @Title: findByCondtionForPage
     * @Description: 分页条件查询
     * @author lvchong
     * @params  * @param stringObjectMap
     * @param startRows
     * @param size
     * @date 2018-01-29
     * @throw YnCorpSysException
     *//*

    public List<ItemRelation> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException {
        return dao.findByCondtionForPage(stringObjectMap, startRows, size);

    }

    *//**
     * @Title: rollback
     * @Description: 回滚
     * @author lvchong
     * @params * @param null
     * @date 2018-01-29
     * @throw YnCorpSysException
     *//*

    public void rollback() throws SQLException {
        dao.rollback();
    }
    *//**
     * @Title: release
     * @Description: 释放资源
     * @author lvchong
     * @date 2018-02-01
     * @throw YnCorpSysException
     *//*
    public void release(){
        dao.release();
    }*/
}
