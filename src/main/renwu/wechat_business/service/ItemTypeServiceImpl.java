package wechat_business.service;
/**
 * @Project: java_practice
 * @Package wechat_business.service
 * @author lvchong
 * @date 2018/1/22 9:03
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import wechat_business.dao.ItemTypeDao;
import wechat_business.entity.ItemType;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author lvchong
 * @ClassName OrderStatementInfoServiceImp
 * @Description 交易流水操作类
 * @date 2018/1/22
 */
public class ItemTypeServiceImpl extends ServiceUtil<ItemTypeDao,ItemType>  {
  /*
  private ItemTypeDao itemTypeDao =  new ItemTypeDao();
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
        return itemTypeDao.deleteById(id);

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
        return itemTypeDao.deleteByIds(ids);

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

    public Integer saveOrUpdate(ItemType test) throws SQLException {
        return itemTypeDao.saveOrUpdate(test);

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

    public ItemType findById(Long id) throws SQLException {
        return itemTypeDao.findById(id);

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

    public List<ItemType> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException {
        return itemTypeDao.findByCondtion(stringObjectMap);

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

    public List<ItemType> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException {
        return itemTypeDao.findByCondtionForPage(stringObjectMap,startRows,size);

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
        itemTypeDao.rollback();
    }
    *//**
     * @Title: release
     * @Description: 释放资源
     * @author lvchong
     * @date 2018-02-01
     * @throw YnCorpSysException
     *//*
    public void release(){
        itemTypeDao.release();
    }*/
}
